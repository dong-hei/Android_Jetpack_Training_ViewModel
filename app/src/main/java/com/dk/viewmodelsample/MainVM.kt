package com.dk.viewmodelsample

import android.util.Log
import androidx.lifecycle.ViewModel

/**
 * VM에서 저렇게 변수 하나만 만들어서 사용하진 않고 LiveData를 이용해 함께 씀
 */
class MainVM : ViewModel() {



    var countVal = 0

    fun plus(){
        countVal++
        Log.d("MainVM", countVal.toString())

    }

    fun minus(){
        countVal--
        Log.d("MainVM", countVal.toString())
    }

    fun getCntVal() : Int{
        return countVal
    }


}