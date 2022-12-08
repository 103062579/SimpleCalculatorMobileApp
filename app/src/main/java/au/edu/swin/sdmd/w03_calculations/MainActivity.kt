package au.edu.swin.sdmd.w03_calculations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    var operator = "plus"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val number1 = findViewById<EditText>(R.id.number1)
        val number2 = findViewById<EditText>(R.id.number2)
        var answer = findViewById<TextView>(R.id.answer)
        var radioGroup = findViewById<RadioGroup>(R.id.radioOp)

        val equals = findViewById<Button>(R.id.equals)
        equals.setOnClickListener {

            when (operator) {
                "plus" -> answer.text =
                    add(number1.text.toString(), number2.text.toString()).toString();
                "sub" -> answer.text =
                    substract(number1.text.toString(), number2.text.toString()).toString();
                "mult" -> answer.text =
                    mult(number1.text.toString(), number2.text.toString()).toString();
                else -> {
                    answer.text = "error";
                }
            }
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


    // adds two numbers together
    private fun add(number1: String, number2: String): Int = number1.toInt() + number2.toInt()
    // adds two numbers together
    private fun substract(number1: String, number2: String): Int = number1.toInt() - number2.toInt()
    // adds two numbers together
    private fun mult(number1: String, number2: String): Int = number1.toInt() * number2.toInt()
}