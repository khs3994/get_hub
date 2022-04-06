package com.example.domain.repository

import com.example.domain.model.DomainUserInfo
import com.example.domain.utils.RemoteErrorEmitter

interface InfoRepository {
    suspend fun githubInfo(
        remoteErrorEmitter: RemoteErrorEmitter,
        userid: String,
    ): DomainUserInfo?
}