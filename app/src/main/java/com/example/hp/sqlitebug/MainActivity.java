package com.example.hp.sqlitebug;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.hp.sqlitebug.database.Database;

public class MainActivity extends AppCompatActivity {

    Database database;
    public static String userPhone = "03342477874";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database = new Database(this);
        //Toast.makeText(this, "" + String.valueOf(database.insertUser("Shariq", "03342477874")), Toast.LENGTH_SHORT).show();
        //Toast.makeText(this, "" + String.valueOf(database.insertUser("Saqib", "03312408046")), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "" + String.valueOf(database.userExists(userPhone)), Toast.LENGTH_SHORT).show();
    }
}
