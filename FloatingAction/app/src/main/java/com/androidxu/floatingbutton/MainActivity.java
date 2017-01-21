package com.androidxu.floatingbutton;

import android.support.design.widget.FloatingActionButton;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    FloatingActionButton fab_more,fab_settings,fab_share;
    Animation open, close, rotateclock,rotateanticlock;
    boolean isopen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // typecasting the buttons
        fab_more = (FloatingActionButton) findViewById(R.id.more);
        fab_settings = (FloatingActionButton) findViewById(R.id.settings);
        fab_share = (FloatingActionButton) findViewById(R.id.share);

        // loading the animation from xml file
        open = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_open);
        close = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_close);
        rotateclock = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_clock);
        rotateanticlock = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_anticlock);

        // setting up the onClickListener() method
        fab_more.setOnClickListener(this);
        fab_settings.setOnClickListener(this);
        fab_share.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.more:
                if(isopen){
                    // more button is already open
                    fab_settings.startAnimation(close);
                    fab_share.startAnimation(close);
                    fab_more.startAnimation(rotateanticlock);
                    fab_share.setClickable(false);
                    fab_settings.setClickable(false);
                    isopen = false;
                } else{
                    // more button is already close
                    fab_settings.startAnimation(open);
                    fab_share.startAnimation(open);
                    fab_more.startAnimation(rotateclock);
                    fab_share.setClickable(true);
                    fab_settings.setClickable(true);
                    isopen = true;
                }
                break;
            case R.id.settings:
                Toast.makeText(getApplicationContext(),"You clicked settings",Toast.LENGTH_LONG).show();
                break;
            case R.id.share:
                Toast.makeText(getApplicationContext(),"You clicked share",Toast.LENGTH_LONG).show();
                break;
        }
    }
}
