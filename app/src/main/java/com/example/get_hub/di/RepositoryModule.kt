package com.example.get_hub.di

import com.example.data.repository.InfoRepositoryImpl
import com.example.data.repository.RepoRepositoryImpl
import com.example.data.repository.remote.datasource.InfoDataSource
import com.example.data.repository.remote.datasource.RepoDataSource
import com.example.data.repository.remote.datasourceImpl.InfoDataSourceImpl
import com.example.domain.repository.InfoRepository
import com.example.domain.repository.RepoRepository
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

    @Provides
    @Singleton
    fun provideRepoRepository(
        repoDataSource: RepoDataSource
    ): RepoRepository {
        return RepoRepositoryImpl(
            repoDataSource
        )
    }
}