package com.example.lovecalculator.di

import android.content.Context
import android.content.SharedPreferences
import com.example.lovecalculator.local.Pref
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PrefModule {
    @Provides
    @Singleton
    fun getPref(@ApplicationContext appContext: Context): Pref{
        return Pref(appContext)
    }
}