package com.example.data.repository.remote.datasource

import com.example.data.remote.model.DataUserInfo
import com.example.domain.utils.RemoteErrorEmitter

interface InfoDataSource {
    suspend fun githubInfo(
        remoteErrorEmitter: RemoteErrorEmitter,
        userid: String,
    ): DataUserInfo?
}