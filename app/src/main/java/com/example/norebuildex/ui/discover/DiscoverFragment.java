package com.example.norebuildex.ui.discover;
import android.util.Log;
import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.norebuildex.R;

import com.example.norebuildex.common.Constant;
import com.example.norebuildex.utilConfig.SetStatusBar;


public class DiscoverFragment extends Fragment {
    private DiscoverViewModel mViewModel;
    public static DiscoverFragment newInstance(String param1) {

        return new DiscoverFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
//        setStatusBar();
        Log.d(Constant.TAG, "22222222222222222222222222222222222222");

        return inflater.inflate(R.layout.discover_fragment, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(DiscoverViewModel.class);
        // TODO: Use the ViewModel
    }

//    private void setStatusBar() {
//        SetStatusBar.isUseFullScreenMode = false;
//        SetStatusBar.getStatusBarColor = R.color.colorPrimary;
//        SetStatusBar.isUseBlackFontWithStatusBar = true;
//        SetStatusBar.setStatusBar(getActivity());
//    }
}
