package com.example.simple_sqlite_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Switch;

import java.util.ArrayList;
import java.util.Set;

public class MainActivity extends AppCompatActivity {


    ListView listView;
    DatabaseManager db;
    ArrayAdapter<String> adapter;
    ArrayList<Product> products;
    ArrayList<String> values;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Sqlite_Starter");

        listView = findViewById(R.id.list);
        db = new DatabaseManager(MainActivity.this);


    }

    @Override
    protected void onResume() {
        super.onResume();

        products = db.getAll();
        update();
    }

    public void update() {
        if (products != null) {
            values = new ArrayList<>();
            for (int i = 0; i < products.size(); ++i) {
                values.add(products.get(i).id + "  " + products.get(i).name + "   " + products.get(i).price);
            }
        }
        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_expandable_list_item_1, values);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.addmenu:
                startActivity(new Intent(getApplicationContext(), Add.class));
                return true;
            case R.id.updatemenu:
                startActivity(new Intent(new Intent(getApplicationContext(), Update.class)));
                return true;
            case R.id.deletemenu:
                startActivity(new Intent(new Intent(getApplicationContext(), Delete.class)));
                return true;
            case R.id.deleteall:db.deleteall();
                onResume();
                return true;
               default:super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }

}