package com.example.data.mapper

import com.example.data.remote.model.DataUserRepo
import com.example.domain.model.DomainUserRepo

object RepoMapper {
    fun repoMapper(
        dataResponse: DataUserRepo?
    ): DomainUserRepo? {
        return if (dataResponse != null) {
            DomainUserRepo(
                name = dataResponse.name,
                id = dataResponse.id,
                date = dataResponse.date,
                url = dataResponse.url,
            )
        } else dataResponse
    }
}