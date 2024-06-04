package com.vitorthemyth.blessedroullet.di

import com.vitorthemyth.blessedroullet.presenter.tracker.use_cases.CheckEvenOddStrategy
import com.vitorthemyth.blessedroullet.presenter.tracker.use_cases.CheckFerrariStrategy
import com.vitorthemyth.blessedroullet.presenter.tracker.use_cases.CheckOneByOneStrategy
import com.vitorthemyth.blessedroullet.presenter.tracker.use_cases.CheckTicTacStrategy
import com.vitorthemyth.blessedroullet.presenter.tracker.use_cases.TrackerUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped


@Module
@InstallIn(ViewModelComponent::class)

internal object UseCasesModule {

    @Provides
    @ViewModelScoped
    fun providesTrackerUseCases() : TrackerUseCases{
        return TrackerUseCases(
            checkTicTacStrategy = CheckTicTacStrategy(),
            checkFerrariStrategy = CheckFerrariStrategy(),
            checkEvenOddStrategy = CheckEvenOddStrategy(),
            checkOneByOneStrategy = CheckOneByOneStrategy()
        )
    }
}