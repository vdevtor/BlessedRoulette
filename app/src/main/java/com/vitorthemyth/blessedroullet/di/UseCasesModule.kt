package com.vitorthemyth.blessedroullet.di

import com.vitorthemyth.blessedroullet.presenter.tracker.use_cases.CheckArcherStrategy
import com.vitorthemyth.blessedroullet.presenter.tracker.use_cases.CheckBugattiStrategy
import com.vitorthemyth.blessedroullet.presenter.tracker.use_cases.CheckEvenOddStrategy
import com.vitorthemyth.blessedroullet.presenter.tracker.use_cases.CheckExtremeStrategy
import com.vitorthemyth.blessedroullet.presenter.tracker.use_cases.CheckFerrariStrategy
import com.vitorthemyth.blessedroullet.presenter.tracker.use_cases.CheckMirrorStrategy
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
    fun providesTrackerUseCases(): TrackerUseCases {
        return TrackerUseCases(
            checkTicTacStrategy = CheckTicTacStrategy(),
            checkFerrariStrategy = CheckFerrariStrategy(),
            checkEvenOddStrategy = CheckEvenOddStrategy(),
            checkOneByOneStrategy = CheckOneByOneStrategy(),
            checkExtremeStrategy = CheckExtremeStrategy(),
            checkMirrorStrategy = CheckMirrorStrategy(),
            checkArcherStrategy = CheckArcherStrategy(),
            checkBugattiStrategy = CheckBugattiStrategy()
        )
    }
}
