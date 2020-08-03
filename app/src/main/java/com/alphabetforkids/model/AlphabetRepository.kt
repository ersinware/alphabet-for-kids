package com.alphabetforkids.model

import com.alphabetforkids.R
import com.alphabetforkids.view.appContext

object AlphabetRepository : BaseRepository {

    val capitalLetters: Array<String> =
        appContext.resources.getStringArray(
            R.array.aryCapitalLetters
        )

    val smallLetters: Array<String> =
        appContext.resources.getStringArray(
            R.array.arySmallLetters
        )

    val togetherLetters: Array<String> =
        appContext.resources.getStringArray(
            R.array.aryTogetherLetters
        )
}