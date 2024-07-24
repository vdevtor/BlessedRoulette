package com.vitorthemyth.blessedroullet.di

import com.vitorthemyth.blessedroullet.presenter.tracker.use_cases.Check13AndNeighbors
import com.vitorthemyth.blessedroullet.presenter.tracker.use_cases.Check14AndNeighbors
import com.vitorthemyth.blessedroullet.presenter.tracker.use_cases.Check16AndNeighbors
import com.vitorthemyth.blessedroullet.presenter.tracker.use_cases.Check17AndNeighbors
import com.vitorthemyth.blessedroullet.presenter.tracker.use_cases.Check20AndNeighbors
import com.vitorthemyth.blessedroullet.presenter.tracker.use_cases.Check21AndNeighbors
import com.vitorthemyth.blessedroullet.presenter.tracker.use_cases.Check22AndNeighbors
import com.vitorthemyth.blessedroullet.presenter.tracker.use_cases.Check23AndNeighbors
import com.vitorthemyth.blessedroullet.presenter.tracker.use_cases.Check24AndNeighbors
import com.vitorthemyth.blessedroullet.presenter.tracker.use_cases.Check26AndNeighbors
import com.vitorthemyth.blessedroullet.presenter.tracker.use_cases.Check27AndNeighbors
import com.vitorthemyth.blessedroullet.presenter.tracker.use_cases.Check30AndNeighbors
import com.vitorthemyth.blessedroullet.presenter.tracker.use_cases.Check33AndNeighbors
import com.vitorthemyth.blessedroullet.presenter.tracker.use_cases.Check35Combo
import com.vitorthemyth.blessedroullet.presenter.tracker.use_cases.Check3AndNeighbors
import com.vitorthemyth.blessedroullet.presenter.tracker.use_cases.Check5Combo
import com.vitorthemyth.blessedroullet.presenter.tracker.use_cases.Check9AndNeighbors
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
            checkBugattiStrategy = CheckBugattiStrategy(),
            check30AndNeighbors = Check30AndNeighbors(),
            check17AndNeighbors = Check17AndNeighbors(),
            check22AndNeighbors = Check22AndNeighbors(),
            check20AndNeighbors = Check20AndNeighbors(),
            check3AndNeighbors = Check3AndNeighbors(),
            check13AndNeighbors = Check13AndNeighbors(),
            check26AndNeighbors = Check26AndNeighbors(),
            check14AndNeighbors = Check14AndNeighbors(),
            check27AndNeighbors = Check27AndNeighbors(),
            check24AndNeighbors = Check24AndNeighbors(),
            check23AndNeighbors = Check23AndNeighbors(),
            check33AndNeighbors = Check33AndNeighbors(),
            check21AndNeighbors = Check21AndNeighbors(),
            check5Combo = Check5Combo(),
            check9AndNeighbors = Check9AndNeighbors(),
            check35Combo = Check35Combo(),
            check16AndNeighbors = Check16AndNeighbors()
        )
    }
}
