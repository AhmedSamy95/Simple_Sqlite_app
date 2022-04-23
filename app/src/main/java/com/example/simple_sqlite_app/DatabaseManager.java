package com.example.simple_sqlite_app;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseManager extends SQLiteOpenHelper {
    SQLiteDatabase db = this.getWritableDatabase();
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE product(id INTEGER PRIMARY KEY AUTOINCREMENT , name TEXT , price INTEGER)"); }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {}

    public DatabaseManager(Context context){super(context,"company.db",null,1);}
    public  void addProduct(Product product){
        db.execSQL("INSERT INTO product (name ,price) VALUES('"+product.name+"','"+product.price+"')");
        db.close();}
    public void updateProduct(Product product){
        db.execSQL("UPDATE product SET name='"+product.name+"',price='"+product.price+"'WHERE id="+product.id);
        db.close();}
    public void delete(int id){
        db.execSQL("DELETE FROM product WHERE id="+id);
        db.close();}
    public void deleteall(){
        db.execSQL("DELETE FROM product");
        db.close();}
    public ArrayList<Product> getAll(){
        ArrayList<Product>products=new ArrayList<>();
        SQLiteDatabase db =this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM product",null);
        if (cursor.moveToFirst()){
            do {Product product=new Product(cursor.getInt(0),cursor.getString(1),cursor.getInt(2));
                products.add(product);
            }while (cursor.moveToNext());
        }
        return products;}
}
