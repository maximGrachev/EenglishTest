package ru.maxgrachev.englishtest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import ru.maxgrachev.englishtest.databinding.FragmentEndLoseBinding

class FragmentEndLose : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentEndLoseBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_end_lose, container, false
        )
        binding.tryAgainButton.setOnClickListener {
            it.findNavController().navigate(FragmentEndLoseDirections.actionFragmentEndLoseToFragmentTest())
        }
        return binding.root
    }

}