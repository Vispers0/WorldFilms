package com.example.worldcinema;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageSwitcher;
import android.widget.RelativeLayout;

import com.example.worldcinema.Fragments.new_films_fragment;

public class MainScreen extends AppCompatActivity {

    private ImageSwitcher img_switcher;

    private GestureDetector detector;

    private View.OnTouchListener gestureListener;

    private int position = 0;
    private final int[] images = {R.drawable.film_cover, R.drawable.logo, R.drawable.ic_launcher_background, R.drawable.btn_main};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        getSupportActionBar().hide();

        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_new_films_fragment, null, false );

        img_switcher = view.findViewById(R.id.img_switcher);

        detector = new GestureDetector(this, new GD());
        gestureListener = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return detector.onTouchEvent(motionEvent);
            }
        };

        img_switcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        img_switcher.setOnTouchListener(gestureListener);

        setMainFragment();
    }

    public void setMainFragment(){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        new_films_fragment fragment = new_films_fragment.newInstance();
        ft.replace(R.id.fragment_dummy, fragment);
        ft.commit();
    }

    public class GD extends GestureDetector.SimpleOnGestureListener {
        private static final int SWIPE_MIN_DISTANCE = 120;
        private static final int SWIPE_MAX_OFF_PATH = 250;
        private static final int SWIPE_THRESHOLD_VELOCITY = 200;

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY){
            try {
                if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_OFF_PATH)
                    return false;
                if(e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                    pos_plus();
                    img_switcher.setImageResource(images[position]);
                } else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                    pos_minus();
                    img_switcher.setImageResource(images[position]);
                }
            } catch (Exception e) {
                // nothing
            }
            return false;
        }

        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        private void pos_plus(){
            position++;
            if (position > images.length - 1){
                position = 0;
            }
        }

        private void pos_minus(){
            position--;
            if (position < 0){
                position = images.length - 1;
            }
        }
    }
}