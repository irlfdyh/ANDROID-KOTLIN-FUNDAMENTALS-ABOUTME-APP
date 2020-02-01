package com.android.linearlayoutusingthelayouteditor

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.android.linearlayoutusingthelayouteditor.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val myName: MyName = MyName("Reflex Ketchup")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName

        binding.doneButton.setOnClickListener {
            clickHandlerFunction(it)
            addNickname(it)
        }

        binding.nicknameText.setOnClickListener {
            updateNickname()
        }
    }

    private fun clickHandlerFunction(viewThatIsClicked: View) {
        viewThatIsClicked.visibility = View.GONE
    }

    private fun addNickname(view: View) {
        binding.apply {
            //nicknameText.text = binding.nicknameEdit.text.toString()

            // setting data from edit text
            myName?.nickname = nicknameEdit.text.toString()

            // set nickname visibility
            nicknameEdit.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }

        // hide the soft keyboard from screen
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun updateNickname() {
        binding.apply {
            nicknameEdit.visibility = View.VISIBLE
            doneButton.visibility = View.VISIBLE
            nicknameText.visibility = View.GONE

            // set focus to the edit text
            nicknameEdit.requestFocus()
        }

        // show the keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(binding.nicknameEdit, 0)
    }
}
