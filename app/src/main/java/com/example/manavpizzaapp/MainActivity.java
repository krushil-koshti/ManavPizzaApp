package com.example.manavpizzaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    //Button
    Button btnM,btnP,btnC,btnG,btnS,btnOrder;
    int mPrice,pPrice,cPrice,gPrice,sPrice,TotalPrice=0;
    //RadioButton
    RadioGroup rdgrp;
    RadioButton rdSizes;
    //Checkbox
    CheckBox chBC,chOr,chJl,chOl;
    String value="";
    //Dropdown
    Spinner spn;
    String [] paymentmode = {"ONLINE","OFFLINE","CARD"};
    String pay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Buttons
        btnM = findViewById(R.id.btnMargerita);
        btnP = findViewById(R.id.btnPaneer);
        btnC = findViewById(R.id.btnChessey);
        btnG = findViewById(R.id.btnGB);
        btnS = findViewById(R.id.btnSC);
        btnOrder = findViewById(R.id.btnOrder);

        btnM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPrice = 70;
                TotalPrice=mPrice+pPrice+cPrice+gPrice+sPrice;
                Toast.makeText(getApplicationContext(),"ADDED"+TotalPrice,Toast.LENGTH_LONG).show();
            }
        });
        btnP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pPrice = 80;
                TotalPrice=mPrice+pPrice+cPrice+gPrice+sPrice;
                Toast.makeText(getApplicationContext(),"ADDED"+TotalPrice,Toast.LENGTH_LONG).show();
            }
        });
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cPrice = 90;
                TotalPrice=mPrice+pPrice+cPrice+gPrice+sPrice;
                Toast.makeText(getApplicationContext(),"ADDED"+TotalPrice,Toast.LENGTH_LONG).show();
            }
        });
        btnG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gPrice = 100;
                TotalPrice=mPrice+pPrice+cPrice+gPrice+sPrice;
                Toast.makeText(getApplicationContext(),"ADDED"+TotalPrice,Toast.LENGTH_LONG).show();
            }
        });
        btnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sPrice = 80;
                TotalPrice=mPrice+pPrice+cPrice+gPrice+sPrice;
                Toast.makeText(getApplicationContext(),"ADDED"+TotalPrice,Toast.LENGTH_LONG).show();
            }
        });

        //RadioButtons
        rdgrp = findViewById(R.id.radioGroup);
        rdgrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                int SelectedId = rdgrp.getCheckedRadioButtonId();
                rdSizes = findViewById(SelectedId);
                Toast.makeText(getApplicationContext(),"Your Pizza Size is "+rdSizes.getText().toString(),Toast.LENGTH_LONG).show();
            }
        });

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Price Intent
                TotalPrice=mPrice+pPrice+cPrice+gPrice+sPrice;
                String tp = String.valueOf(TotalPrice);
                Intent Data = new Intent(getApplicationContext(),DataShowing.class);
                Data.putExtra("Price",tp);
                Data.putExtra("Size",rdSizes.getText().toString());
                Data.putExtra("Toppings",value);
                Data.putExtra("Payment",pay);
                startActivity(Data);
            }
        });

        chBC = findViewById(R.id.cbBabyCorn);
        chOr = findViewById(R.id.cbOraganoes);
        chJl = findViewById(R.id.cbJalepenoes);
        chOl = findViewById(R.id.cbOlives);

        chBC.setOnCheckedChangeListener(this);
        chOr.setOnCheckedChangeListener(this);
        chJl.setOnCheckedChangeListener(this);
        chOl.setOnCheckedChangeListener(this);

        //Dropdown
        spn = findViewById(R.id.MOP);
        ArrayAdapter<String> arr = new ArrayAdapter<>(getApplicationContext(), com.google.android.material.R.layout.support_simple_spinner_dropdown_item,paymentmode);
        spn.setAdapter(arr);

        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pay = spn.getSelectedItem().toString();
                Toast.makeText(getApplicationContext(),"You Selected "+pay+" Mode",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    //Checkbox
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (buttonView.isChecked()){
            value = value + buttonView.getText().toString();
            Toast.makeText(getApplicationContext(),"Your Selected Toppings is "+value,Toast.LENGTH_LONG).show();
        }
    }
}