package com.example.simple_sqlite_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Update extends AppCompatActivity {
EditText id;
EditText name;
EditText price;
Button update;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        setTitle("Update product");

        id = findViewById(R.id.id);
        name = findViewById(R.id.updatename);
        price = findViewById(R.id.price);
        update = findViewById(R.id.Buttonupdate);
        DatabaseManager db=new DatabaseManager(getApplicationContext());
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (id != null || name != null || price != null){
                db.updateProduct(new Product(Integer.parseInt(id.getText().toString()),
                    name.getText().toString(),Integer.parseInt(price.getText().toString())));
                Toast.makeText(Update.this, "Update Product", Toast.LENGTH_SHORT).show();
                finish();}
                else {Toast.makeText(Update.this, "please Set Product", Toast.LENGTH_SHORT).show();}
            }});}
}
