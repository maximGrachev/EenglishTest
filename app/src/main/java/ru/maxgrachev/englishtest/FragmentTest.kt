package ru.maxgrachev.englishtest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_test.*
import ru.maxgrachev.englishtest.databinding.FragmentTestBinding

class FragmentTest : Fragment() {
    data class Question(val text: String, val answer: List<String>, val correctAns: Int = 1)

    private val questions = mutableListOf<Question>(
        Question(
            ".........?' No, she's out.",
            listOf(
                "Is at home your mother",
                "Does your mother at home",
                "Is your mother at home",
                "Are your mother at home"
            ),
            correctAns = 3
        ),
        Question(
            "These shoes are nice. .........",
            listOf(
                "How much are they?",
                "How many are they?",
                "How much they are?",
                "How much is they?"
            ),
            correctAns = 1
        ),
        Question(
            "Look, there's Sarah. ......... a brown coat.",
            listOf(
                "She wearing",
                "She has wearing",
                "She is wearing",
                "She has been wearing"
            ),
            correctAns = 3
        ),
        Question(
            "I don't understand this sentence. What .........?",
            listOf(
                "mean this word",
                "means this word",
                "does mean this word",
                "does this word mean"
            ),
            correctAns = 4
        ),
        Question(
            "Please be quiet. .........",
            listOf(
                "I working.",
                "I work.",
                "I'm working.",
                "I'm work."
            ),
            correctAns = 3
        ),
        Question(
            "'Are Laura and Paul here?' 'No, they......... .'",
            listOf(
                "don't arrive yet",
                "have already arrived",
                "haven't already arrived",
                "haven't arrived yet"
            ),
            correctAns = 4
        ),
        Question(
            "We ......... walk home last night. There were no buses.",
            listOf(
                "have to",
                "had to ",
                "must",
                "must have"
            ),
            correctAns = 2
        ),
        Question(
            "Write your name ......... the top of the page.",

            listOf(
                "at",
                "on",
                "in",
                "to"
            ),
            correctAns = 1
        )
    )

    lateinit var currentQuestion: String
    lateinit var answers: List<String>
    private var questionIndex = 0
    private var numQuestions = 3

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentTestBinding =
            DataBindingUtil.inflate<FragmentTestBinding>(
                inflater,
                R.layout.fragment_test,
                container,
                false
            )
        questions.shuffle()
        currentQuestion = questions[questionIndex].text
        answers = questions[questionIndex].answer
        binding.game = this

        binding.submitButton.setOnClickListener { v: View ->
             if (Answer1.isChecked && questions[questionIndex].correctAns == 1) {
                questionIndex++
                 if (questionIndex >= numQuestions) {
                     v.findNavController().navigate(
                         FragmentTestDirections.actionFragmentTestToFragmentEndWon(
                             numQuestions,
                             questionIndex
                         )
                     )
                 }
                currentQuestion = questions[questionIndex].text
                answers = questions[questionIndex].answer
                binding.invalidateAll()
            } else if (Answer2.isChecked && questions[questionIndex].correctAns == 2) {
                questionIndex++
                 if (questionIndex >= numQuestions) {
                     v.findNavController().navigate(
                         FragmentTestDirections.actionFragmentTestToFragmentEndWon(
                             numQuestions,
                             questionIndex
                         )
                     )
                 }
                currentQuestion = questions[questionIndex].text
                answers = questions[questionIndex].answer
                binding.invalidateAll()
            } else if (Answer3.isChecked && questions[questionIndex].correctAns == 3) {
                questionIndex++
                 if (questionIndex >= numQuestions) {
                     v.findNavController().navigate(
                         FragmentTestDirections.actionFragmentTestToFragmentEndWon(
                             numQuestions,
                             questionIndex
                         )
                     )
                 }
                currentQuestion = questions[questionIndex].text
                answers = questions[questionIndex].answer
                binding.invalidateAll()
            } else if (Answer4.isChecked && questions[questionIndex].correctAns == 4) {
                questionIndex++
                 if (questionIndex >= numQuestions) {
                     v.findNavController().navigate(
                         FragmentTestDirections.actionFragmentTestToFragmentEndWon(
                             numQuestions,
                             questionIndex
                         )
                     )
                 }
                currentQuestion = questions[questionIndex].text
                answers = questions[questionIndex].answer
                binding.invalidateAll()
            } else {
                v.findNavController()
                    .navigate(FragmentTestDirections.actionFragmentTestToFragmentEndLose())
            }
        }

        return binding.root
    }
}

