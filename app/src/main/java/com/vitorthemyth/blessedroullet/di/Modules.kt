package com.vitorthemyth.blessedroullet.di

import android.app.Application
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.vitorthemyth.blessedroullet.core.preferences.DefaultPreferences
import com.vitorthemyth.blessedroullet.core.preferences.Preferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
internal object Modules{
    @Provides
    @Singleton
    fun providesSharedPreferences(app: Application) : SharedPreferences{
        return app.getSharedPreferences("shared_pref",MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun providesPreferences(sharedPreferences: SharedPreferences) : Preferences{
        return DefaultPreferences(sharedPreferences)
    }
}