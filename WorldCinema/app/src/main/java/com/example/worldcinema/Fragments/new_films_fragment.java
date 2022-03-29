package com.example.worldcinema.Fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.core.view.GestureDetectorCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

import com.example.worldcinema.MainScreen;
import com.example.worldcinema.Networking.GetFilms.FilmsMock;
import com.example.worldcinema.R;

import java.util.ArrayList;
import java.util.Arrays;


public class new_films_fragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private RecyclerView recycler;
    private FilmAdapter adapter;
    private ArrayList<Film> filmsList;

    public ArrayList<test> testArrayList;

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
        recycler = view.findViewById(R.id.recycle);

        LinearLayoutManager manager = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        recycler.setLayoutManager(manager);

        filmsList = new ArrayList<>();
        adapter = new FilmAdapter(filmsList, getContext());

        FilmsMock filmsMock = new FilmsMock();

        adapter.notifyDataSetChanged();

        recycler.setAdapter(adapter);
    }
}