package ru.denfad.samsung_database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public SQLiteDatabase db;
    public TextView textView =  findViewById(R.id.textView);
    public EditText editName= findViewById(R.id.personName);
    public EditText editAge= findViewById(R.id.personAge);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         db = getBaseContext().openOrCreateDatabase("app.db", MODE_PRIVATE, null);
         db.execSQL("CREATE TABLE IF NOT EXISTS users (name TEXT, age INTEGER)");
    }

    public void onClick(View view){
        String name = editName.getText().toString();
        int age =Integer.valueOf(editAge.getText().toString());
        if(name!=null && age!=0){
            db.execSQL("INSERT INTO users VALUES (name,age);");
        }

        db.execSQL("INSERT INTO users VALUES ('Tom Smith', 23);");
        db.execSQL("INSERT INTO users VALUES ('John Dow', 31);");

        Cursor query = db.rawQuery("SELECT * FROM users;", null);

       
        query.close();
        db.close();
    }
}