package com.alphabetforkids.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.alphabetforkids.databinding.FragmentWelcomeBinding
import com.alphabetforkids.view.utils.animation.getFirstTransition
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class WelcomeFragment : Fragment() {

    private lateinit var binding: FragmentWelcomeBinding

    private lateinit var job: Job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupTransitions()
        initBinding()
        setupBinding()
        job = lifecycleScope.launch {
            delay(2000)
            goHomepage()
        }
    }

    private fun setupTransitions() {
        exitTransition = getFirstTransition(true)
    }

    private fun initBinding() {
        binding = FragmentWelcomeBinding
            .inflate(layoutInflater)
            .apply {
                lifecycleOwner = this@WelcomeFragment
            }
    }

    private fun setupBinding() =
        binding.run {
            imageUrl = "welcome.png"
        }

    private fun goHomepage() =
        findNavController().navigate(
            WelcomeFragmentDirections
                .actionWelcomeFragmentToHomepageFragment()
        )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = binding.root

    override fun onStart() {
        super.onStart()

        if (job.isCancelled)
            job = lifecycleScope.launch {
                delay(1000)
                goHomepage()
            }
    }

    override fun onStop() {
        super.onStop()

        job.run {
            if (!isCompleted) cancel()
        }
    }
}