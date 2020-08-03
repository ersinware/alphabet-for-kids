package com.alphabetforkids.view.utils

import androidx.core.view.get
import com.alphabetforkids.viewmodel.alphabet.AlphabetBaseModel
import com.alphabetforkids.viewmodel.alphabet.LetterModeHelper
import com.google.android.material.appbar.MaterialToolbar

interface LetterModeDispatcher {

    val model: AlphabetBaseModel

    fun changeLetterMode(itemId: Int) {
        val clickedMode =
            LetterModeHelper.findClickedMode(itemId)
        val newMode =
            LetterModeHelper.getLetterModeByClicked(clickedMode)

        if (newMode == model.letterMode)
            return

        model.letterMode = newMode
        LetterModeHelper.editLetterMode(clickedMode)
    }
}