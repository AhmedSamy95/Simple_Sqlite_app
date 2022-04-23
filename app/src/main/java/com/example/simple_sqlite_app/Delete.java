package com.example.simple_sqlite_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Delete extends AppCompatActivity {
    EditText id;
    Button delete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        setTitle("Delete product");

        id = findViewById(R.id.deleteid);
        delete = findViewById(R.id.deletebutton);
        DatabaseManager db=new DatabaseManager(getApplicationContext());
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (id!=null){db.delete(Integer.parseInt(id.getText().toString()));
                Toast.makeText(Delete.this, "Delete Product", Toast.LENGTH_SHORT).show();
                finish();}
                else {Toast.makeText(Delete.this, "please Set Product", Toast.LENGTH_SHORT).show();}}});
    }
}