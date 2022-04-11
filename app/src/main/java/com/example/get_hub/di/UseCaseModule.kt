package com.example.get_hub.di

import com.example.domain.repository.InfoRepository
import com.example.domain.usecase.GithubInfoUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Provides
    @Singleton
    fun provideGithubInfoUseCase(repository: InfoRepository) = GithubInfoUseCase(repository)
}