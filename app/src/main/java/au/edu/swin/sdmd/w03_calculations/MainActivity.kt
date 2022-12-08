package au.edu.swin.sdmd.w03_calculations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    var operator = "plus"
    var opResult : Int = 0

    override fun onStart(){
        super.onStart()
        Log.i("LIFECYCLE", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("LIFECYCLE", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("LIFECYCLE", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("LIFECYCLE", "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("LIFECYCLE", "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("LIFECYCLE", "onDestroy")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val number1 = findViewById<EditText>(R.id.number1)
        val number2 = findViewById<EditText>(R.id.number2)
        var answer = findViewById<TextView>(R.id.answer)
        var radioGroup = findViewById<RadioGroup>(R.id.radioOp)

        savedInstanceState?.let {
            opResult = savedInstanceState.getInt("ANSWER")
            answer.text = opResult.toString()
        }

        Log.i("LIFECYCLE", "onCreate")

        val equals = findViewById<Button>(R.id.equals)
        equals.setOnClickListener {

            opResult  = when (operator) {
                "plus" ->
                    add(number1.text.toString(), number2.text.toString())
                "sub" ->
                    substract(number1.text.toString(), number2.text.toString())
                "mult" ->
                    mult(number1.text.toString(), number2.text.toString())
                else -> {
                   0;
                }
            }
            answer.text = opResult.toString()
        }
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            val rb = group.findViewById<RadioButton>(checkedId)
            when (rb.id) {
                R.id.radioSub -> {
                    operator = "sub"
                }
                R.id.radioMult -> {
                    operator = "mult"
                }
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("ANSWER", opResult)
        Log.i("LIFECYCLE", "saveInstanceState $opResult")
    }

    // adds two numbers together
    private fun add(number1: String, number2: String): Int = number1.toInt() + number2.toInt()

    // adds two numbers together
    private fun substract(number1: String, number2: String): Int = number1.toInt() - number2.toInt()

    // adds two numbers together
    private fun mult(number1: String, number2: String): Int = number1.toInt() * number2.toInt()
}