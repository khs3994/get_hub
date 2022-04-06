package com.example.domain.usecase

import com.example.domain.repository.InfoRepository
import com.example.domain.utils.RemoteErrorEmitter
import javax.inject.Inject

class GithubInfoUseCase @Inject constructor(
    private val infoRepository: InfoRepository
) {
    suspend fun execute(remoteErrorEmitter: RemoteErrorEmitter, userId: String) =
        infoRepository.githubInfo(remoteErrorEmitter, userId)
}