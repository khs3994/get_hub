package com.example.presentation.view

import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.domain.utils.ErrorType
import com.example.domain.utils.ScreenState
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentSearchBinding
import com.example.presentation.viewmodel.MainViewModel

class SearchFragment : BaseFragment<FragmentSearchBinding>(R.layout.fragment_search) {
    private val mainViewModel by activityViewModels<MainViewModel>()


    override fun init() {
        binding.fragment = this
        observeViewModel()
    }

    fun goResult(view: View) {
        binding.progressBar.visibility = View.VISIBLE
        mainViewModel.githubInfo(binding.userIdEdittext.text.toString())
        mainViewModel.githubRepo(binding.userIdEdittext.text.toString())
        this.findNavController().navigate(R.id.action_searchFragment_to_resultFragment)
    }

    private fun observeViewModel(){
        mainViewModel.apiCallEvent.observe(this){
            binding.progressBar.visibility = View.INVISIBLE
            when(it){
                ScreenState.LOADING -> this.findNavController().navigate(R.id.action_searchFragment_to_resultFragment)
                ScreenState.ERROR -> toastErrMsg()
                else -> shortShowToast("알수없는 오류 발생")
            }
        }
    }

    private fun toastErrMsg(){
        when(mainViewModel.apiErrorType){
            ErrorType.NETWORK -> longShowToast("네트워크 오류가 발생했습니다")
            ErrorType.TIMEOUT -> longShowToast("호출 시간이 초과되었습니다")
            ErrorType.SESSION_EXPIRED -> longShowToast("세션이 만료되었습니다")
            ErrorType.UNKNOWN -> longShowToast("예기치 못한 오류가 발생했습니다")
        }
    }
}