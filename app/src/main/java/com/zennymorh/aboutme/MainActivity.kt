package com.zennymorh.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.zennymorh.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
//declaring a variable binding from the ActivityMainBinding class
    private lateinit var binding: ActivityMainBinding
//creating an object of the data class
    private var myName: MyName = MyName("Zainab Jimoh")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//connecting the data class to my binding stuff
        binding.myName = myName

        binding.doneButton.setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view: View){

        binding.apply {
            myName?.nickname = nicknameEdit.text.toString()
            invalidateAll()
            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameText.visibility = View.GONE
        }
        //To hide the keyboard, even though we can just tap the screen but udacity is extra, so..
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
