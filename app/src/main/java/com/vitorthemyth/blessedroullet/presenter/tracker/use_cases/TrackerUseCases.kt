package com.vitorthemyth.blessedroullet.presenter.tracker.use_cases

data class TrackerUseCases(
    val checkTicTacStrategy: CheckTicTacStrategy,
    val checkFerrariStrategy: CheckFerrariStrategy,
    val checkEvenOddStrategy: CheckEvenOddStrategy,
    val checkOneByOneStrategy: CheckOneByOneStrategy,
    val checkExtremeStrategy: CheckExtremeStrategy,
    val checkMirrorStrategy: CheckMirrorStrategy,
    val checkArcherStrategy: CheckArcherStrategy,
    val checkBugattiStrategy: CheckBugattiStrategy
)
