package com.android.linearlayoutusingthelayouteditor

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        done_button.setOnClickListener {
            clickHandlerFunction(it)
            addNickname(it)
        }
        nickname_text.setOnClickListener {
            updateNickname(it)
        }
    }

    private fun clickHandlerFunction(viewThatIsClicked: View) {
        viewThatIsClicked.visibility = View.GONE
    }

    private fun addNickname(view: View) {
        nickname_text.text = nickname_edit.text
        nickname_edit.visibility = View.GONE
        nickname_text.visibility = View.VISIBLE

        // hide the soft keyboard from screen
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun updateNickname(view: View) {
        nickname_edit.visibility = View.VISIBLE
        done_button.visibility = View.VISIBLE
        view.visibility = View.GONE

        // set focus to the edit text
        nickname_edit.requestFocus()

        // show the keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(nickname_edit, 0)
    }
}
