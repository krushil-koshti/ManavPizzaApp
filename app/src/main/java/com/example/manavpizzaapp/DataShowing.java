package com.example.manavpizzaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DataShowing extends AppCompatActivity {

    TextView txtTP,txtPS,txtPT,txtPM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datashowing);

        txtTP = findViewById(R.id.totalPrice);
        String totalPrice = this.getIntent().getStringExtra("Price");
        txtTP.setText("Total Bill Amount is "+totalPrice);

        txtPS = findViewById(R.id.SizeofPizza);
        String SizePizza = this.getIntent().getStringExtra("Size");
        txtPS.setText("Your Pizza Size is "+SizePizza);

        txtPT = findViewById(R.id.PizzaToppings);
        String PizzaToppings = this.getIntent().getStringExtra("Toppings");
        txtPT.setText("Your Toppings is "+PizzaToppings);

        txtPM = findViewById(R.id.PaymentMode);
        String Payment = this.getIntent().getStringExtra("Payment");
        txtPM.setText("You Selected "+Payment+" Mode");
    }
}