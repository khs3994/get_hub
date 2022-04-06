package com.example.data.repository.remote.datasourceImpl

import com.example.data.remote.api.GithubApi
import com.example.data.remote.model.DataUserRepo
import com.example.data.repository.remote.datasource.RepoDataSource
import com.example.data.utils.base.BaseDataSource
import com.example.domain.utils.RemoteErrorEmitter

class RepoDataSourceImpl constructor(
    private val githubApi: GithubApi
) : BaseDataSource(), RepoDataSource {
    override suspend fun githubRepo(
        remoteErrorEmitter: RemoteErrorEmitter,
        userid: String
    ): List<DataUserRepo>?{
        return safeApiCall(remoteErrorEmitter) {
            githubApi.getUserRepo(owner = userid)
        }?.body()
    }
}