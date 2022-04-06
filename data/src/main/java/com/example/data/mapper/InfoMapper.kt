package com.example.data.mapper

import com.example.data.remote.model.DataUserInfo
import com.example.domain.model.DomainUserInfo

object InfoMapper {
    fun infoMapper(
        dataResponse: DataUserInfo?
    ): DomainUserInfo? {
        return if (dataResponse != null) {
            DomainUserInfo(
                userId = dataResponse.userId,
                followers = dataResponse.followers,
                following = dataResponse.following,
            )
        } else dataResponse
    }
}