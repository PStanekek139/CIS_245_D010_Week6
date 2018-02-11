package edu.rvc.student.week6

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import android.content.Context
import android.view.inputmethod.InputMethodManager
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.view.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var txtName = findViewById<EditText>(R.id.txtName)
        var txtEmail = findViewById<EditText>(R.id.txtEmail)
        val spMealtime = findViewById<Spinner>(R.id.spMealtime)
        val spChoice = findViewById<Spinner>(R.id.spChoice)
        val txtView = findViewById<TextView>(R.id.txtView)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)


        val listMealtime = arrayOf("Breakfast", "Lunch", "Dinner")
        val adaptadorMealtime = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listMealtime)
        spMealtime.adapter = adaptadorMealtime

        val listChoice = arrayOf("Chicken", "Fish", "Pork")
        val adaptadorChoice = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listChoice)
        spChoice.adapter = adaptadorChoice

        btnSubmit.setOnClickListener {
            var meal = spMealtime.selectedItem.toString()
            var choice = spChoice.selectedItem.toString()

            if ((meal.toString() == "Breakfast") && (choice.toString() == "Fish")){
                txtView.text = ("Thank you, " + txtName.text.toString() + ". For " + meal.toString() + " you will be served " +
                        choice.toString() + ".  Fish for breakfast?  You are brave, indeed." + " An email with your selection" +
                        " will be sent to " + txtEmail.text.toString() + ".")
            }
            else {
                txtView.text = ("Thank you, " + txtName.text.toString() + ". For " + meal.toString() + " you will be served " +
                        choice.toString()+ ".  An email with your selection will be sent to " + txtEmail.text.toString() + ".")
            }

            txtName.setText("")
            txtEmail.setText("")
            hideKeyboard()
        }
    }

    fun hideKeyboard(){
        try{
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        } catch (e: Exception){
            // TODO: handle exception
        }
    }



}
