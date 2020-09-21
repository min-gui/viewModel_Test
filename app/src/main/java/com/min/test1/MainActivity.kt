package com.min.test1

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.min.test1.databinding.ActivityMainBinding
import com.min.test1.databinding.FragmentMainBinding

class MainActivity : AppCompatActivity() {
    val TAG = javaClass.simpleName
    val mainFragment = MainFragment()
    val detailFragment =DetailFragment()
    lateinit var binding : ActivityMainBinding
    lateinit var mViewModel : MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        Log.e(TAG,"onCreate")
        binding =DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.setLifecycleOwner(this)

        mViewModel =ViewModelProviders.of(this).get(MainViewModel::class.java)
        //binding.mainViewModel=mViewModel
        var nameObserver: Observer<Int> =
            Observer {  newname -> //Toast.makeText(this,newname.toString(), Toast.LENGTH_SHORT).show()
                Log.e(TAG,newname.toString())
                Log.e(TAG,"돼냐")
                if (newname==0){
                    popUpFragment()
                }else if (newname==2){

                }else if(newname==4){
                    onBackPressed()
                }

            }

        mViewModel.getcounter().observe(this,nameObserver)

        //fragment rotation 시 viewmodel의 데이터가 초기화 되는것을 막기위해
        if (savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .add(R.id.frameLayout,mainFragment)
                .commit()

        }

    }

    fun popUpFragment(){
        supportFragmentManager.beginTransaction().add(R.id.frameLayout,detailFragment).commit()
    }
    override fun onStart() {
        super.onStart()
        Log.e(TAG,"onStart")
    }
    override fun onRestart() {
        super.onRestart()
        Log.e(TAG,"onRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.e(TAG,"onResume")
    }

    override fun onBackPressed() {

        var fragmentSize = supportFragmentManager.fragments.size
        if (fragmentSize>1){
            var fragment = supportFragmentManager.fragments.get(fragmentSize-1)
            supportFragmentManager.beginTransaction().remove(fragment).commit()
        }else{
            super.onBackPressed()
        }
        /*for (fragment : Fragment in supportFragmentManager.fragments){
            if (fragment.isVisible) {

                supportFragmentManager.beginTransaction().remove(fragment).commit()

            }else{
                super.onBackPressed()
            }
        }*/
        Log.e(TAG,supportFragmentManager.fragments.size.toString())
    }

    override fun onPause() {
        super.onPause()
        Log.e(TAG,"onPause")
    }
    override fun onStop() {
        super.onStop()
        Log.e(TAG,"onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG,"onDestroy")
    }
}