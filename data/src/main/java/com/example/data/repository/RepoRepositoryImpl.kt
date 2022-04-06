package com.example.data.repository

import com.example.data.mapper.RepoMapper
import com.example.data.repository.remote.datasource.RepoDataSource
import com.example.domain.model.DomainUserRepo
import com.example.domain.repository.RepoRepository
import com.example.domain.utils.RemoteErrorEmitter
import javax.inject.Inject

class RepoRepositoryImpl @Inject constructor(
    private val repoDataSource: RepoDataSource
) : RepoRepository {
    override suspend fun githubRepo(
        remoteErrorEmitter: RemoteErrorEmitter,
        userid: String
    ): DomainUserRepo? {
        return RepoMapper.repoMapper(repoDataSource.githubRepo(remoteErrorEmitter, userid))
    }
}