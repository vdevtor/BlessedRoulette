package com.vitorthemyth.blessedroullet.di

import com.vitorthemyth.blessedroullet.presenter.tracker.use_cases.CheckTicTacStrategy
import com.vitorthemyth.blessedroullet.presenter.tracker.use_cases.TrackerUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewScoped


@Module
@InstallIn(ViewModelComponent::class)
internal object UseCasesModule {
    @Provides
    @ViewScoped
    fun providesTrackerUseCases() : TrackerUseCases{
        return TrackerUseCases(
            checkTicTacStrategy = CheckTicTacStrategy()
        )
    }
}