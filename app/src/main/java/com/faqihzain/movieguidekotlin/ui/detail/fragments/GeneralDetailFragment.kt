package com.faqihzain.movieguidekotlin.ui.detail.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.faqihzain.movieguidekotlin.databinding.FragmentGeneralDetailBinding
import com.faqihzain.movieguidekotlin.ui.detail.fragments.DetailFragmentViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

/**
 * A simple [Fragment] subclass.
 */
class GeneralDetailFragment : Fragment() {

    private lateinit var binding: FragmentGeneralDetailBinding
    private val viewModel: DetailFragmentViewModel by sharedViewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGeneralDetailBinding.inflate(inflater,container,false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        return binding.root
    }
}
