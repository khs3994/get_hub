package com.example.data.repository

import com.example.data.mapper.InfoMapper
import com.example.data.repository.remote.datasource.InfoDataSource
import com.example.domain.model.DomainUserInfo
import com.example.domain.repository.InfoRepository
import com.example.domain.utils.RemoteErrorEmitter
import javax.inject.Inject

class InfoRepositoryImpl @Inject constructor(
    private val infoDataSource: InfoDataSource
) : InfoRepository {
    override suspend fun githubInfo(
        remoteErrorEmitter: RemoteErrorEmitter,
        userid: String
    ): DomainUserInfo? {
        return InfoMapper.infoMapper(infoDataSource.githubInfo(remoteErrorEmitter, userid))
    }
}