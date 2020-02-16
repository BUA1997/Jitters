package com.example.jitters;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class music extends AppCompatActivity {


    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        mp =MediaPlayer.create(this,R.raw.aaaa);
    }
    public void start(View v)
    {
        mp.start();
    }
    public void stop(View v)
    {
        mp.stop();
    }
}
