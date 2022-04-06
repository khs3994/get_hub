package com.example.domain.repository

import com.example.domain.model.DomainUserRepo
import com.example.domain.utils.RemoteErrorEmitter

interface RepoRepository {
    suspend fun githubRepo(
        remoteErrorEmitter: RemoteErrorEmitter,
        userid: String
    ): DomainUserRepo?
}