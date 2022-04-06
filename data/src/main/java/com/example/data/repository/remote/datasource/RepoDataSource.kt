package com.example.data.repository.remote.datasource

import com.example.data.remote.model.DataUserRepo
import com.example.domain.utils.RemoteErrorEmitter

interface RepoDataSource {
    suspend fun githubRepo(
        remoteErrorEmitter: RemoteErrorEmitter,
        userid: String
    ): List<DataUserRepo>?
}