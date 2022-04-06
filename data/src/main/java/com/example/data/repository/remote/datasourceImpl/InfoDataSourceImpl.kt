package com.example.data.repository.remote.datasourceImpl

import com.example.data.remote.api.GithubApi
import com.example.data.remote.model.DataUserInfo
import com.example.data.repository.remote.datasource.InfoDataSource
import com.example.data.utils.base.BaseDataSource
import com.example.domain.utils.RemoteErrorEmitter

class InfoDataSourceImpl constructor(
    private val githubApi: GithubApi
) : BaseDataSource(), InfoDataSource {
    override suspend fun githubInfo(
        remoteErrorEmitter: RemoteErrorEmitter,
        userid: String
    ): DataUserInfo? {
        return safeApiCall(remoteErrorEmitter) {
            githubApi.getUserInfo(owner = userid)
        }?.body()
    }
}