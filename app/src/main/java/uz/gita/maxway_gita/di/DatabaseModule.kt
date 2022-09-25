package uz.gita.maxway_gita.di

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import uz.gita.maxway_gita.data.prefs.MySharedPref
import javax.inject.Singleton

// Created by Jamshid Isoqov an 9/24/2022
@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {


    @[Provides Singleton]
    fun provideSharedPrefs(
        @ApplicationContext context: Context,
        sharedPreferences: SharedPreferences
    ): MySharedPref =
        MySharedPref(context, sharedPreferences)
}