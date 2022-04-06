package com.example.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentResultBinding
import com.example.presentation.viewmodel.MainViewModel

class ResultFragment : BaseFragment<FragmentResultBinding>(R.layout.fragment_result) {

    private val mainViewModel by activityViewModels<MainViewModel>()

    override fun init() {
        binding.fragment = this
        initResult()
    }

    private fun initResult() {
        binding.userId.text = mainViewModel.apiInfoCallResult.userId
        binding.userFollower.text = mainViewModel.apiInfoCallResult.followers.toString()
        binding.userFollowing.text = mainViewModel.apiInfoCallResult.following.toString()
    }

    fun goMain(view: View) {
        this.findNavController().navigate(R.id.action_resultFragment_to_mainFragment)
    }
}