package com.example.domain.usecase

import com.example.domain.repository.RepoRepository
import com.example.domain.utils.RemoteErrorEmitter
import javax.inject.Inject

class GithubRepoUseCase @Inject constructor(
    private val repoRepository: RepoRepository
) {
    suspend fun execute(remoteErrorEmitter: RemoteErrorEmitter, userId: String) =
        repoRepository.githubRepo(remoteErrorEmitter, userId)
}