package com.example.a87_gridlayouttablelayout

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var toolbarMain: Toolbar

    private lateinit var inputET: EditText
    private lateinit var resultTV: TextView

    private lateinit var divBTN: Button
    private lateinit var oneBTN: Button
    private lateinit var twoBTN: Button
    private lateinit var threeBTN: Button
    private lateinit var multBTN: Button
    private lateinit var fourBTN: Button
    private lateinit var fiveBTN: Button
    private lateinit var sixBTN: Button
    private lateinit var difBTN: Button
    private lateinit var sevenBTN: Button
    private lateinit var eightBTN: Button
    private lateinit var nineBTN: Button
    private lateinit var sumBTN: Button
    private lateinit var zeroBTN: Button
    private lateinit var equalsBTN: Button
    private lateinit var resetBTN: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        toolbarMain = findViewById(R.id.toolbarMain)
        setSupportActionBar(toolbarMain)

        inputET = findViewById(R.id.inputET)
        resultTV = findViewById(R.id.resultTV)
        divBTN = findViewById(R.id.divBTN)
        oneBTN = findViewById(R.id.oneBTN)
        twoBTN = findViewById(R.id.twoBTN)
        threeBTN = findViewById(R.id.threeBTN)
        multBTN = findViewById(R.id.multBTN)
        fourBTN = findViewById(R.id.fourBTN)
        fiveBTN = findViewById(R.id.fiveBTN)
        sixBTN = findViewById(R.id.sixBTN)
        difBTN = findViewById(R.id.difBTN)
        sevenBTN = findViewById(R.id.sevenBTN)
        eightBTN = findViewById(R.id.eightBTN)
        nineBTN = findViewById(R.id.nineBTN)
        sumBTN = findViewById(R.id.sumBTN)
        zeroBTN = findViewById(R.id.zeroBTN)
        equalsBTN = findViewById(R.id.equalsBTN)
        resetBTN = findViewById(R.id.resetBTN)

        inputET.isEnabled = false

        oneBTN.setOnClickListener (this)
        twoBTN.setOnClickListener(this)
        threeBTN.setOnClickListener(this)
        fourBTN.setOnClickListener(this)
        fiveBTN.setOnClickListener(this)
        sixBTN.setOnClickListener(this)
        sevenBTN.setOnClickListener(this)
        eightBTN.setOnClickListener(this)
        nineBTN.setOnClickListener(this)
        zeroBTN.setOnClickListener(this)
        divBTN.setOnClickListener(this)
        difBTN.setOnClickListener(this)
        sumBTN.setOnClickListener(this)
        multBTN.setOnClickListener(this)
        equalsBTN.setOnClickListener(this)
        resetBTN.setOnClickListener(this)
    }
    private var input = ""
    @SuppressLint("SetTextI18n")
    override fun onClick(v: View) {
        when (v.id) {
            R.id.oneBTN -> {
                input += "1"
            }
            R.id.twoBTN -> {
                input += "2"
            }
            R.id.threeBTN -> {
                input += "3"
            }
            R.id.fourBTN -> {
                input += "4"
            }
            R.id.fiveBTN -> {
                input += "5"
            }
            R.id.sixBTN -> {
                input += "6"
            }
            R.id.sevenBTN -> {
                input += "7"
            }
            R.id.eightBTN -> {
                input += "8"
            }
            R.id.nineBTN -> {
                input += "9"
            }
            R.id.zeroBTN -> {
                input += "0"
            }
            R.id.divBTN -> {
                input += " / "
            }
            R.id.difBTN -> {
                input += " - "
            }
            R.id.sumBTN -> {
                input += " + "
            }
            R.id.multBTN -> {
                input += " * "
            }
            R.id.resetBTN -> {
                input = ""
                resultTV.text = ""
            }
            R.id.equalsBTN -> {
                val firstOperand = inputET.text.toString().substringBefore(" ").toDouble()
                val secondOperand = inputET.text.toString().substringAfterLast(" ").toDouble()
                val operations = inputET.text.toString().substringBeforeLast(" ").substringAfter(" ")
                val result = when(operations){
                    "/" -> firstOperand / secondOperand
                    "*" -> firstOperand * secondOperand
                    "+" -> firstOperand + secondOperand
                    "-" -> firstOperand - secondOperand
                    else -> 0
                }
                resultTV.text = result.toString()
            }
        }
        inputET.setText(input)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.exitMenu -> finish()
        }
        return super.onOptionsItemSelected(item)
    }


}