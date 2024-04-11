package com.dk.viewmodelsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

/**
 * ViewModel(VM)
 * 안드로이드의 생명 주기를 관리하기 쉽다 (= 상태가 변경 될 때 마다 데이터 관리가 편하다.)
 *
 * UI컨트롤러(Activity, Fragment)에서 모든 것을 다 하려고 하면 복잡해진다 -> VM을 사용하면 테스트,관리가 용이하다.
 *
 * 수명주기
 * OnCreate -> OnStart -> OnResume 등을 모두 VMScope에서 관리할수 있다.
 * 핸드폰 화면 회전 상황에서 수명주기가 초기화 된다 -> 이 상황에 대응하는 코드를 짜야한다.
 * -> 대응하는 코드 짜기 귀찮아 -> 이런것들을 VM에서 해결한다.
 */
class MainActivity : AppCompatActivity() {

//    vm사용전
//    private var countVal = 0

    lateinit var vm: MainVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vm = ViewModelProvider(this).get(MainVM::class.java)
        val plusBtn : Button = findViewById(R.id.plus)
        val minusBtn : Button = findViewById(R.id.minus)
        val resultArea : TextView = findViewById(R.id.result)

        //vm 초기화
        resultArea.text = vm.countVal.toString()

        plusBtn.setOnClickListener{
//            vm 사용전
//            countVal++
//            resultArea.text = countVal.toString()

            vm.plus()
            resultArea.text = vm.countVal.toString()

        }

        minusBtn.setOnClickListener{
//            vm 사용전
//            countVal--
//            resultArea.text = countVal.toString()
            resultArea.text = vm.countVal.toString()


            vm.minus()
        }

    }
}