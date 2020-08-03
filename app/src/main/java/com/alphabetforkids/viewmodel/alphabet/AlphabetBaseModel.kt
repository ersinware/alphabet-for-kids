package com.alphabetforkids.viewmodel.alphabet

import com.alphabetforkids.model.AlphabetRepository

interface AlphabetBaseModel {

    val repo: AlphabetRepository

    var data: Array<String>

    var letterMode: LetterMode

    fun onLetterModeChange() {
        data = getDataByLetterMode()
    }

    fun getDataByLetterMode() =
        when (letterMode) {
            LetterMode.MODE_CAPITAL -> repo.capitalLetters
            LetterMode.MODE_SMALL -> repo.smallLetters
            else -> repo.togetherLetters
        }
}