package uz.gita.maxway_gita.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import uz.gita.maxway_gita.repository.Repository
import uz.gita.maxway_gita.repository.impl.RepositoryImpl

// Created by Jamshid Isoqov an 9/25/2022
@Module
@InstallIn
interface RepositoryModule {
    @Binds
    fun bindRepository(repositoryImpl: RepositoryImpl): Repository
}