package com.example.norebuildex.ui.messages;
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

public class MessagesFragment extends Fragment {

    private MessagesViewModel mViewModel;

    public static MessagesFragment newInstance(String param1) {

        return new MessagesFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        Log.d(Constant.TAG, "44444444444444");

        return inflater.inflate(R.layout.messages_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MessagesViewModel.class);
        // TODO: Use the ViewModel
    }

}
