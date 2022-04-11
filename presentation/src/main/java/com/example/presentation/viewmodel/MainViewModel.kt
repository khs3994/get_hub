package com.example.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.DomainUserInfo
import com.example.domain.usecase.GithubInfoUseCase
import com.example.domain.utils.ErrorType
import com.example.domain.utils.RemoteErrorEmitter
import com.example.domain.utils.ScreenState
import com.example.presentation.widget.utils.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val githubInfoUseCase: GithubInfoUseCase,
) : ViewModel(), RemoteErrorEmitter {

    val apiCallEvent: LiveData<ScreenState> get() = _apiCallEvent
    private val _apiCallEvent = SingleLiveEvent<ScreenState>()

    var apiInfoCallResult = DomainUserInfo("", 0, 0)

    //에러타입
    var apiErrorType = ErrorType.UNKNOWN
    //에러 메시지
    var apiErrorMsg = "none"

    //깃허브 유저 정보
    fun githubInfo(userId: String) = viewModelScope.launch {
        githubInfoUseCase.execute(this@MainViewModel, userId).let { response ->
            if (response != null) {
                apiInfoCallResult = response
                _apiCallEvent.postValue(ScreenState.LOADING)
            } else _apiCallEvent.postValue(ScreenState.ERROR)
        }
    }

    override fun onError(msg: String) {
        apiErrorMsg = msg
    }

    override fun onError(errorType: ErrorType) {
        apiErrorType = errorType
    }
}