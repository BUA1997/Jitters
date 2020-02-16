package com.example.jitters;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

/*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }*/
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
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.about:
                Intent intent1 =new Intent(this,DisplayMessageActivity.class);
                EditText editText =(EditText) findViewById(R.id.about);
                startActivity(intent1);
                return  true;
            case R.id.signout:
                Intent intent2 =new Intent(this,DisplayMessageActivity.class);
                EditText editText1 =(EditText) findViewById(R.id.signout);
                startActivity(intent2);
                return  true;

                default: return super.onOptionsItemSelected(item);
        }

    }
}
