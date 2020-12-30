package com.example.jitters;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
	import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
	import android.widget.EditText;
	import android.widget.Toast;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import static com.example.jitters.R.layout.activity_main;

public class MainActivity extends AppCompatActivity {


    RatingBar ratingBar;
    Button button;
    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int level = intent.getIntExtra("level", 0);
            ProgressBar progress = findViewById(R.id.progressbar);
            progress.setProgress(level);
            TextView view = findViewById(R.id.textView1);
            view.setText("Battery level " + Integer.toString(level) + "%");

            ratingBar = findViewById(R.id.rating_bar);
            button = findViewById(R.id.button_ratingbar);
            button.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    float ratingValue = ratingBar.getRating();
                    Toast.makeText(getApplicationContext(), "Rating :" + ratingValue, Toast.LENGTH_SHORT).show();
                }
            });

        }
    };


    @SuppressLint("MissingSuperCall")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);

        registerReceiver(receiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("JITTERS");
        CharSequence title = "JITTERS";
        SpannableString s = new SpannableString(title);
        s.setSpan(new ForegroundColorSpan(Color.RED), 0, title.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        getSupportActionBar().setTitle(s);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.argb(128, 0, 0, 0)));


    }


    public void sendMessage(View view) {
        EditText message = (EditText) findViewById(R.id.message);
        Toast.makeText(this, "Sending message" + message.getText().toString(), Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, DisplayMessageActivity.class);
        intent.putExtra("MESSAGE", message.getText().toString());
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
        switch (item.getItemId()) {
            case R.id.about:
                startActivity(new Intent(this, music.class));
//
                return true;
            case R.id.signout:
//
                startActivity(new Intent(this, text.class));


            case R.id.email:

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("emailto:"));
                String to[] = {"buastuartjames@gmail.com", "jaspermars67@gmail.com", "mbabalihassan10@gmail.com"};
                intent.putExtra(Intent.EXTRA_EMAIL, to);
                intent.putExtra(Intent.EXTRA_SUBJECT, "Wassap dudes");
                intent.putExtra(Intent.EXTRA_TEXT, "What are you up to");
                intent.setType("message/rfc822");
                startActivity(intent);
                return true;

            case R.id.call:
                Intent intent2 = new Intent(Intent.ACTION_DIAL);
                intent2.setData(Uri.parse("tel:0780640428"));

                startActivity(intent2);
                return true;

            case R.id.list:
//
                startActivity(new Intent(this, ListViewActivity.class));
                return true;

            case R.id.recycler:
//
                startActivity(new Intent(this, ExampleSearchView.class));
                return true;

            case R.id.switch2:
//
                startActivity(new Intent(this, ExampleSwitch.class));
                return true;

            case R.id.storage:
//
                startActivity(new Intent(this, ExampleExternalStorage.class));
                return true;

            case R.id.maps:
//
                startActivity(new Intent(this, maps.class));
                return true;
            case R.id.database:
//
                startActivity(new Intent(this, database.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void startAlert(View view) {

        EditText text = (EditText) findViewById(R.id.editText);
        int x = Integer.parseInt(text.getText().toString());

        Intent intently = new Intent(this, BroadcastReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(), 0, intently, 0);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (x * 1000), pendingIntent);
        Toast.makeText(this, "Alarm set in" + x + "seconds", Toast.LENGTH_LONG).show();


    }
}


