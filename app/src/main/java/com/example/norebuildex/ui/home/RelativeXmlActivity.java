package com.example.norebuildex.ui.home;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.fragment.app.FragmentActivity;
import com.example.norebuildex.R;
import com.example.norebuildex.utilConfig.SetStatusBar;

public class RelativeXmlActivity extends FragmentActivity {
    private View view;
    private Activity _this = this;

    public static RelativeXmlActivity newInstance(String param1) {
        return new RelativeXmlActivity();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_xml);
        SetStatusBar.closeStatusBar(this);
        Button botton = findViewById(R.id.btn_center);
        botton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(_this, Therry.class));
            }
        });
//        initData();
//        initListView();
//        mBar = (ProgressBar) findViewById(R.id.progressBar1);
//        mTvNull = (TextView) findViewById(R.id.tv_null);
//        findViewById(R.id.img_back).setOnClickListener(this);
//        findViewById(R.id.tv_clear).setOnClickListener(this);
    }


  /*  @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
       *//* LinearLayout homeBgColor = view.findViewById(R.id.homeActivity);
        homeBgColor.setBackgroundResource(R.color.homeBg_color);
        RelativeLayout relativeLayout = view.findViewById(R.id.topBar);
        relativeLayout.setBackgroundResource(R.drawable.bg3);
        mViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);

        Button botton = (Button) getActivity().findViewById(R.id.btn_relative_xml);
        botton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                    new Intent(getActivity()
//                            .getApplicationContext(), HomeXq_PageActivity.class);
                startActivity(new Intent(getActivity(), RelativeXmlActivity.class));
            }
        });*//*
        // TODO: Use the ViewModel
    }
*/

}
