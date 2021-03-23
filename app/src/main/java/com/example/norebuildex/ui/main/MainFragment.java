
package com.example.norebuildex.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import com.example.norebuildex.common.Constant;
import com.example.norebuildex.R;
import com.example.norebuildex.settingConfig.GeneralConst;


public class MainFragment extends Fragment {

    private MainViewModel mViewModel;

    public static com.example.norebuildex.ui.main.MainFragment newInstance() {
        return new com.example.norebuildex.ui.main.MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_activity, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        // TODO: Use the ViewModel
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(Constant.TAG, "OneFragment --- onAttach");

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(Constant.TAG, "OneFragment --- onCreate");

    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(Constant.TAG, "OneFragment --- onStart");

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(Constant.TAG, "OneFragment --- onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(Constant.TAG, "OneFragment --- onPause");

    }

    @Override
    public void onStop() {
        super.onStop();

        Log.d(GeneralConst.TAG, "OneFragment --- onStop");

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(GeneralConst.TAG, "OneFragment --- onDestroyView");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(GeneralConst.TAG, "OneFragment --- onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(Constant.TAG, "OneFragment --- onDetach");
    }
}

