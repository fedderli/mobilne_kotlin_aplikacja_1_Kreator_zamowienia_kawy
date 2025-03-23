package com.example.mobilne_kotlin_aplikacja_1_Kreator_zamowienia_kawy

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val radioGroup = findViewById<RadioGroup>(R.id.coffyRadioGroup)
        val sugarCheckBox = findViewById<CheckBox>(R.id.sugarCheckBox)
        val milkCheckBox = findViewById<CheckBox>(R.id.milkCheckBox)
        val seakBar = findViewById<SeekBar>(R.id.coffySeekBar)
        val seakBarValue = findViewById<TextView>(R.id.coffySeekBar_value)
        val orderButton = findViewById<Button>(R.id.orderButton)
        val coffyImageView = findViewById<ImageView>(R.id.coffyImigeView)


        var whichCoffee = ""



        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            val radioButton = findViewById<RadioButton>(checkedId)
            whichCoffee = "${radioButton.text}"
            when (checkedId) {
                R.id.latte_radiobutton -> coffyImageView.setImageResource(R.drawable.latte)
                R.id.espresso_radiobutton -> coffyImageView.setImageResource(R.drawable.espresso)
                R.id.cappuccino_radiobutton -> coffyImageView.setImageResource(R.drawable.capuccino)
            }
        }




        var milkChecked = ""
        var sugarChecked = ""

        sugarCheckBox.setOnCheckedChangeListener{_ , isChecked ->
            if (isChecked){
                sugarChecked = "Dodatkowy cukier"
            }
            else {
                sugarChecked = "Brak cukru"
            }
        }

        milkCheckBox.setOnCheckedChangeListener{_ , isChecked ->
            if (isChecked){
                milkChecked = "Dodatkowe mleko"
            }
            else {
                milkChecked = "Brak mleka"
            }
        }

        var coffyAmount = ""

        seakBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                seakBarValue.text = "Ilosc : $progress"
                coffyAmount = "$progress"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        orderButton.setOnClickListener{
            Toast.makeText(this, "zamówiono: $whichCoffee  $sugarChecked  $milkChecked w ilosci $coffyAmount" , Toast.LENGTH_SHORT).show()
        }

    }

}