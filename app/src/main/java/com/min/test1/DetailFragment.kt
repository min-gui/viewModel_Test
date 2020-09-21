package com.min.test1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.min.test1.databinding.FragmentDetailBinding
import com.min.test1.databinding.FragmentMainBinding

class DetailFragment : Fragment() {
    val TAG = javaClass.simpleName
    lateinit var binding : FragmentDetailBinding
    lateinit var mViewModel : MainViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mViewModel = ViewModelProviders.of(activity!!).get(MainViewModel::class.java)
        //var view  = inflater.inflate(R.layout.fragment_detail, container,false)

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)

        binding.apply {
            mainViewModel=mViewModel
            lifecycleOwner=this@DetailFragment
        }
        return binding.root
    }


}