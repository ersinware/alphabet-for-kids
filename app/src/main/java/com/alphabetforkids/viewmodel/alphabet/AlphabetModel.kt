package com.alphabetforkids.viewmodel.alphabet

import com.alphabetforkids.mediautils.Speaker
import com.alphabetforkids.model.AlphabetRepository
import com.alphabetforkids.viewmodel.BaseTeachingModel

class AlphabetModel : BaseTeachingModel<String>(), AlphabetBaseModel {

    override val repo = AlphabetRepository

    override var letterMode = LetterModeHelper.getLetterMode()
        set(value) {
            if (field == value)
                return

            field = value
            onLetterModeChange()
        }

    override var data = getDataByLetterMode()

    override fun speak(position: Int) {
        Speaker.getInstance().speak(
            data[position][0].toString()
        )
    }
}