package com.example.data.mapper

import com.example.data.remote.model.DataUserRepo
import com.example.domain.model.DomainUserRepo

object RepoMapper {
    fun repoMapper(
        dataResponse: List<DataUserRepo>?
    ): List<DomainUserRepo>? {
        return if (dataResponse != null) {
            List<DomainUserRepo>(
                name = dataResponse.name,
                id = dataResponse.id,
                date = dataResponse.date,
                url = dataResponse.url,
            )
        } else dataResponse
    }
}