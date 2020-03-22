package com.example.jitters;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

BroadcastReceiver receiver =new BroadcastReceiver(){
        @Override
        public void onReceive(Context context, Intent intent) {
            int x;
            x =intent.getIntExtra("Level",0);
            // ProgressBar progress=new ProgressBar();
            ProgressBar progress=findViewById(R.id.progressbar);
            progress.setProgress(x);

            TextView view=findViewById(R.id.textView1);
            view.setText("battery Level" + Integer.parseInt(String.valueOf(x)) + "%");
            // view.setText("Battery level" + Integer.toString(x) +"%");
        }
    };


    @SuppressLint("MissingSuperCall")
    protected  void onCreate (Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerReceiver(receiver,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
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
//
                return  true;
            case R.id.signout:
//
                startActivity(new Intent(this,text.class));


            case R.id.email:

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("emailto:"));
                String to[] = {"buastuartjames@gmail.com", "jaspermars67@gmail.com","mbabalihassan10@gmail.com"};
                intent.putExtra(Intent.EXTRA_EMAIL, to);
                intent.putExtra(Intent.EXTRA_SUBJECT, "hey girls");
                intent.putExtra(Intent.EXTRA_TEXT, "am around please");
                intent.setType("message/rfc822");
                startActivity(intent);
                return true;

            case R.id.call:
                Intent intent2 = new Intent(Intent.ACTION_DIAL);
                intent2.setData( Uri.parse("tel:0780640428"));

                startActivity(intent2);
                return true;

            case R.id.list:
//
                startActivity(new Intent(this,ListViewActivity.class));
                return  true;

                default: return super.onOptionsItemSelected(item);
        }

    }
    public void startAlert(View view) {

        EditText text= (EditText)findViewById(R.id.editText);
        int x=Integer.parseInt(text.getText().toString());

        Intent intently=new Intent(this, BroadcastReceiver.class);
        PendingIntent pendingIntent=PendingIntent.getBroadcast(this.getApplicationContext(),0,intently,0);

        AlarmManager alarmManager= (AlarmManager) getSystemService(ALARM_SERVICE);

        alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+(x * 1000),pendingIntent);
        Toast.makeText(this, "Alarm set in" +x+ "seconds", Toast.LENGTH_LONG).show();



    }
}

