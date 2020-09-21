package com.min.test1

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.min.test1.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    val TAG = javaClass.simpleName
    lateinit var binding : FragmentMainBinding
    lateinit var mViewModel : MainViewModel

    //화면을 구성할때 호출되는 부분분
   override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var nameObserver: Observer<Int> =
            Observer {  newname -> Toast.makeText(context,newname.toString(),Toast.LENGTH_SHORT).show()
            }
        Log.e(TAG, "onCreateView")
        mViewModel = ViewModelProviders.of(activity!!).get(MainViewModel::class.java)
        mViewModel.getcounter().observe(this,nameObserver)

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)



        binding.apply {
            mainViewModel=mViewModel
            lifecycleOwner=this@MainFragment
        }


        return binding.root
    }

    //oncreateView 에서 view 를 리턴 받아 쓰는곳
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e(TAG, "onViewCreated")
        /*var nameObserver: Observer<Int> =
            Observer {  newname -> Toast.makeText(view.context,newname.toString(),Toast.LENGTH_SHORT).show()
            }
        Log.e(TAG, "onCreateView")
        mViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        mViewModel.getcounter().observe(this,nameObserver)

        binding.apply {
            mainViewModel=mViewModel
            lifecycleOwner=this@MainFragment
        }*/



    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.e(TAG, "onAttach")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.e(TAG, "onActivityCreated")
    }

    override fun onStart() {
        Log.e(TAG, "onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.e(TAG, "onResume")
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
        Log.e(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e(TAG, "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e(TAG, "onDestroyView")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, "onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.e(TAG, "onDetach")
    }

}