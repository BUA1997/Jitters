package com.example.jitters;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    @SuppressLint("MissingSuperCall")
    protected  void onCreate (Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button list=(Button)findViewById(R.id.button3);
        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 =new Intent(MainActivity.this,ListViewActivity.class);
                startActivity(intent2);

            }
        });
        Button recycle=(Button)findViewById(R.id.button4);
        recycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 =new Intent(MainActivity.this,recycler.class);
                startActivity(intent3);
            }
        });

    }


    public void sendMessage(View view){
        EditText message=(EditText)findViewById(R.id.message);
        Toast.makeText(this,"Sending message" +message.getText().toString(),Toast.LENGTH_SHORT).show();

        Intent intent=new Intent(this,DisplayMessageActivity.class);
        intent.putExtra("MESSAGE",message.getText().toString());
        startActivity(intent);

        message.setText("");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       // MenuInflater inflater = getMenuInflater();
        getMenuInflater().inflate(R.menu.example_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.about:
                startActivity(new Intent(this,music.class));
//                Intent intent1 =new Intent(this,DisplayMessageActivity.class);
//                EditText editText =(EditText) findViewById(R.id.about);
//                startActivity(intent1);
                return  true;
            case R.id.signout:
//                Intent intent2 =new Intent(this,DisplayMessageActivity.class);
//                EditText editText1 =(EditText) findViewById(R.id.signout);
//                startActivity(intent2);
                startActivity(new Intent(this,text.class));
                return  true;

                default: return super.onOptionsItemSelected(item);
        }

    }
}
