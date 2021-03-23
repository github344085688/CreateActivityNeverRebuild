package com.example.norebuildex.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.example.norebuildex.R;
import androidx.lifecycle.ViewModelProviders;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.View;


import com.example.norebuildex.common.Constant;


public class HomeFragment extends Fragment {

    private HomeViewModel mViewModel;

    private View view;

    public static HomeFragment newInstance(String param1) {
            return new HomeFragment();
        }

        @Override
        public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                                  @Nullable Bundle savedInstanceState){
            Log.d(Constant.TAG, "11111111111111111111111111111111");
            view = inflater.inflate(R.layout.home_fragment, container, false);
            return view;

        }

        @Override
        public void onActivityCreated (@Nullable Bundle savedInstanceState){
            super.onActivityCreated(savedInstanceState);
            LinearLayout homeBgColor = view.findViewById(R.id.homeActivity);
            homeBgColor.setBackgroundResource(R.color.homeBg_color);
            RelativeLayout relativeLayout = view.findViewById(R.id.topBar);
            relativeLayout.setBackgroundResource(R.drawable.bg3);
            mViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
            // TODO: Use the ViewModel
        }


        @Override
        public void onAttach (Context context){
            super.onAttach(context);
            Log.d(Constant.TAG, "OneFragment --- onAttach");
        }

        @Override
        public void onCreate (@Nullable Bundle savedInstanceState){
            super.onCreate(savedInstanceState);

            Log.d(Constant.TAG, "OneFragment --- onCreate");
        }

        @Override
        public void onStart () {
            super.onStart();
            Log.d(Constant.TAG, "OneFragment --- onStart");
        }

        @Override
        public void onResume () {
            super.onResume();
            Log.d(Constant.TAG, "OneFragment --- onResume");
        }

        @Override
        public void onPause () {
            super.onPause();
            Log.d(Constant.TAG, "OneFragment --- onPause");
        }

        @Override
        public void onStop () {
            super.onStop();
            Log.d(Constant.TAG, "OneFragment --- onStop");
        }

        @Override
        public void onDestroyView () {
            super.onDestroyView();
            Log.d(Constant.TAG, "OneFragment --- onDestroyView");
        }

        @Override
        public void onDestroy () {
            super.onDestroy();
            Log.d(Constant.TAG, "OneFragment --- onDestroy");
        }

        @Override
        public void onDetach () {
            super.onDetach();
            Log.d(Constant.TAG, "OneFragment --- onDetach");
        }

    }