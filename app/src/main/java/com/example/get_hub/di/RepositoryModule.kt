package com.example.get_hub.di

import com.example.data.repository.InfoRepositoryImpl
import com.example.data.repository.remote.datasource.InfoDataSource
import com.example.domain.repository.InfoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideInfoRepository(
        infoDataSource: InfoDataSource
    ): InfoRepository {
        return InfoRepositoryImpl(
            infoDataSource
        )
    }
}