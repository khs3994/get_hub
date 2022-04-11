package com.example.get_hub.di

import com.example.data.remote.api.GithubApi
import com.example.data.repository.remote.datasource.InfoDataSource
import com.example.data.repository.remote.datasourceImpl.InfoDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    @Provides
    @Singleton
    fun provideInfoDataSource (
        githubApi: GithubApi,
    ): InfoDataSource{
        return InfoDataSourceImpl(
            githubApi
        )
    }

}