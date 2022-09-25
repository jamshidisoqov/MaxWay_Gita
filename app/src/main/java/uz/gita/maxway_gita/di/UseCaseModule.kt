package uz.gita.maxway_gita.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import uz.gita.maxway_gita.domain.AppUseCase
import uz.gita.maxway_gita.domain.impl.AppUseCaseImpl

// Created by Jamshid Isoqov an 9/25/2022
@Module
@InstallIn(ViewModelComponent::class)
interface UseCaseModule {
    @Binds
    fun bindAppUseCase(appUseCaseImpl: AppUseCaseImpl): AppUseCase
}