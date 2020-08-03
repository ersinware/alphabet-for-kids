package com.alphabetforkids.view.teaching.alphabet

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.core.view.get
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.alphabetforkids.databinding.FragmentAlphabetBinding
import com.alphabetforkids.view.teaching.TeachingFragment
import com.alphabetforkids.view.utils.LetterModeDispatcher
import com.alphabetforkids.view.utils.ZoomOutTransformation
import com.alphabetforkids.viewmodel.alphabet.AlphabetModel
import com.alphabetforkids.viewmodel.alphabet.LetterModeHelper
import kotlinx.android.synthetic.main.fragment_alphabet.*

class AlphabetFragment : TeachingFragment<String>(), LetterModeDispatcher {

    override lateinit var binding: FragmentAlphabetBinding

    override lateinit var model: AlphabetModel

    override fun initBinding() {
        binding = FragmentAlphabetBinding
            .inflate(layoutInflater)
            .apply {
                lifecycleOwner = this@AlphabetFragment
            }
    }

    override fun initModel() {
        model = ViewModelProviders
            .of(this)
            .get(AlphabetModel::class.java)
    }

    override fun setupBinding() {
        binding.run {
            pagerAdapter = AlphabetPagerAdapter(model, ::onPagerClick)
            pageTransformer = ZoomOutTransformation()
            pagerListener = this@AlphabetFragment.getPagerListener()
            handler = this@AlphabetFragment
        }
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        model.letterMode = LetterModeHelper.getLetterMode()
        binding.pager.adapter?.notifyDataSetChanged()
        binding.toolbar
            .menu[LetterModeHelper.getSavedMode()]
            .isChecked = true
    }

    override fun handleMenuClick(item: MenuItem) {
        if (item.isCheckable) {
            if (item.isChecked) return

            item.isChecked = true
            changeLetterMode(item.itemId)
            return
        }

        findNavController().navigate(
            AlphabetFragmentDirections
                .actionAlphabetFragmentToAlphabetTestFragment()
        )
    }

    override fun changeLetterMode(itemId: Int) {
        super.changeLetterMode(itemId)
        pager.adapter!!.notifyDataSetChanged()
    }

}
