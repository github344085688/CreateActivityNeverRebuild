package com.example.norebuildex.ui.home;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.example.norebuildex.R;
public class Therry extends FragmentActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_therry);
        findViewById(R.id.img_back).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_back:
                finish();
                break;
            default:
                break;
        }
    }
}
