package ru.maxgrachev.englishtest

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import ru.maxgrachev.englishtest.databinding.FragmentEndLoseBinding
import ru.maxgrachev.englishtest.databinding.FragmentEndWonBinding

class FragmentEndWon : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentEndWonBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_end_won, container, false
        )
        binding.tryAgainButton.setOnClickListener {
            it.findNavController()
                .navigate(FragmentEndWonDirections.actionFragmentEndWonToFragmentTest())
        }
        var args = FragmentEndWonArgs.fromBundle(arguments!!)
//        Toast.makeText(context, "NumCorrect: ${args.numCorrect}, NumQuestions: ${args.numQuestions}", Toast.LENGTH_LONG).show()
        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.winner_menu, menu)

        if (null == getShareIntent().resolveActivity(activity!!.packageManager)) {
            // hide the menu item if it doesn't resolve
            menu?.findItem(R.id.share)?.setVisible(false)
        }
    }

    private fun getShareIntent(): Intent {
        val args = arguments?.let { FragmentEndWonArgs.fromBundle(it) }
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain")
            .putExtra(
                Intent.EXTRA_TEXT,
                getString(R.string.share_success_text, args?.numCorrect, args?.numQuestions)
            )
        return shareIntent
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item!!.itemId) {
            R.id.share -> shareSuccess()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun shareSuccess() {
        startActivity(getShareIntent())
    }

}
