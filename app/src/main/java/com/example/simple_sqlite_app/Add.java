package com.example.simple_sqlite_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Notification;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Add extends AppCompatActivity {
    EditText name;
    EditText price;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        setTitle("Add product");

        name = findViewById(R.id.name);
        price = findViewById(R.id.newprice);
        add = findViewById(R.id.newadd);
        DatabaseManager db=new DatabaseManager(getApplicationContext());
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name!=null || price!=null){
                    db.addProduct(new Product(name.getText().toString(),Integer.parseInt(price.getText().toString())));
                    Toast.makeText(Add.this, "Saved Product", Toast.LENGTH_SHORT).show();
                    finish();}
                else {Toast.makeText(Add.this, "please Set Product", Toast.LENGTH_SHORT).show();}
            }
        });

    }
}