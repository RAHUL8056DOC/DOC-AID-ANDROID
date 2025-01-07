package com.rahulji.mobile.app.docaidrahul.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.rahulji.mobile.app.docaidrahul.R;

public class Dashboard extends Fragment {

    TextView drName;
    LottieAnimationView lottieDoctor;
    FloatingActionButton fabSchedule;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View dashboard= inflater.inflate(R.layout.fragment_dashboard, container, false);

        drName= dashboard.findViewById(R.id.drName);
        lottieDoctor= dashboard.findViewById(R.id.lottieDoctor);
        fabSchedule= dashboard.findViewById(R.id.fabSchedule);

        return dashboard;
    }
}