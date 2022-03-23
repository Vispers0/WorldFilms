package com.example.worldcinema;

import android.app.Service;
import android.content.Context;
import android.media.Image;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import java.util.Arrays;


public class new_films_fragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private ImageSwitcher img_switcher;

    private final int[] images = {R.drawable.film_cover, R.drawable.logo, R.drawable.ic_launcher_background, R.drawable.btn_main};

    private GestureDetector detector;

    private static final int SWIPE_MIN_DISTANCE = 120;
    private static final int SWIPE_MAX_OFF_PATH = 250;
    private static final int SWIPE_THRESHOLD_VELOCITY = 100;

    private int position = 0;

    public new_films_fragment() {

    }

    public static new_films_fragment newInstance() {
        return new new_films_fragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_new_films_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
        img_switcher = getView().findViewById(R.id.img_switcher);
        buildImageSwitcher();
    }

    private void buildImageSwitcher(){
        Log.i("SWITCHER", img_switcher.toString());
        Log.i("IMAGES", Arrays.toString(images));

        Animation anim_in = new AlphaAnimation(0, 1);
        Animation anim_out = new AlphaAnimation(1, 0);
        anim_in.setDuration(800);
        anim_out.setDuration(800);

        img_switcher.setInAnimation(anim_in);
        img_switcher.setOutAnimation(anim_out);
        img_switcher.setFactory(new ImageFactory());

        img_switcher.setImageResource(images[0]);

        detector = new GestureDetector();
    }


    private class ImageFactory implements ViewSwitcher.ViewFactory{
        @Override
        public View makeView() {
            ImageView imageView = new ImageView(getContext());
            imageView.setBackgroundColor(0xFF000000);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setLayoutParams(
                    new FrameLayout.LayoutParams(
                            FrameLayout.LayoutParams.MATCH_PARENT,
                            FrameLayout.LayoutParams.WRAP_CONTENT
                    )
            );
            return imageView;
        }
    }

    private class GestureDetector extends android.view.GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        @Override
        public void onShowPress(MotionEvent motionEvent) {

        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e){
            return super.onSingleTapConfirmed(e);
        }

        @Override
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return false;
        }

        @Override
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
            return false;
        }

        @Override
        public void onLongPress(MotionEvent motionEvent) {

        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY){
            try{
                if (Math.abs(e1.getY()-e2.getY()) > SWIPE_MAX_OFF_PATH)
                    return false;

                if (e1.getX()-e2.getX()> SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                    setPositionNext();
                    img_switcher.setImageResource(images[position]);
                } else if (e2.getX()-e1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY){
                    setPositionPrev();
                    img_switcher.setImageResource(images[position]);
                }
            } catch (Exception e){
                e.printStackTrace();
                return true;
            }
            return true;
        }

        private void setPositionPrev() {
            position--;
            if (position < 0){
                position = images.length - 1;
            }
        }

        private void setPositionNext() {
            position++;
            if (position>images.length - 1){
                position = 0;
            }
        }
    }
}