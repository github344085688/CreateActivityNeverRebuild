package com.example.norebuildex.activity;
import android.util.SparseArray;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.example.norebuildex.R;
import android.view.View;
import androidx.fragment.app.FragmentTransaction;
import com.example.norebuildex.ui.home.HomeFragment;
import com.example.norebuildex.ui.discover.DiscoverFragment;
import com.example.norebuildex.ui.messages.MessagesFragment;
import com.example.norebuildex.ui.account.AccountFragment;
import com.example.norebuildex.utilConfig.SetStatusBar;


public class MainActivity extends AppCompatActivity {
    private int index;
    // ======== 四个TAB
    private SparseArray<Fragment> mFragmentSparseArray;
    private RadioGroup mTabRadioGroup;
    private HomeFragment homeFragment;
    private DiscoverFragment discoverFragment;
    private int currentTabIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        setStatusBar();
//        StatusBar.setTransparentStatusBar(this);
//        StatusBar.addStatusBarView(this, Color.parseColor("#ffffff"));
        initView(savedInstanceState);

    }

    private void initView(Bundle savedInstanceState) {
        // 实例化Tab
        /*mainFragment = new MainFragment();

        mainFragment = new MainFragment();
        homeFragment = new HomeFragment();
        discoverFragment = new DiscoverFragment();
        messagesFragment = new MessagesFragment();
        accountFragment = new AccountFragment();*/

        /**
         *   一开始只把 第一个 和 第二个 Fragment添加到事务里面,(方便切换时有数据)
         *         然后默认展示第一个,第二个隐藏起来
         */


        currentTabIndex = R.id.today_tab;
        mFragmentSparseArray = new SparseArray<>();
        mFragmentSparseArray.append(R.id.today_tab, new HomeFragment().newInstance("今日"));
        mFragmentSparseArray.append(R.id.record_tab, new DiscoverFragment().newInstance("记录"));
        mFragmentSparseArray.append(R.id.contact_tab, new MessagesFragment().newInstance("通讯录"));
        mFragmentSparseArray.append(R.id.settings_tab, new AccountFragment().newInstance("设置"));

        getSupportFragmentManager().beginTransaction().add(R.id.container,
                mFragmentSparseArray.get(R.id.today_tab)).commit();


        mTabRadioGroup = findViewById(R.id.tabs_rg);
        mTabRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.today_tab){
                    setStatusBar();
                }else {
                    setStatusBarTrue();
                }
                if (currentTabIndex != checkedId) { // 切换了Fragment
                    FragmentTransaction trx = getSupportFragmentManager().beginTransaction();
                    trx.hide(mFragmentSparseArray.get(currentTabIndex)); // 隐藏原来的
                    if (!mFragmentSparseArray.get(checkedId).isAdded()) { // 如果当前的没有被添加到FragmentTransaction,添加之
                        trx.add(R.id.container, mFragmentSparseArray.get(checkedId));
                    }
                    trx.show(mFragmentSparseArray.get(checkedId)).commit(); // 添加事务,切换Fragment
                }
          /*       具体的fragment切换逻辑可以根据应用调整，例如使用show()/hide()
                getSupportFragmentManager().beginTransaction().replace(R.id.container,
                        mFragmentSparseArray.get(checkedId)).commit();*/
//                System.out.println();
                currentTabIndex = checkedId;
            }
        });
        mTabRadioGroup.setBackgroundResource(R.color.oliveGreen);
    }

    private void setStatusBar() {
        SetStatusBar.isUseFullScreenMode = true;
        SetStatusBar.setStatusBar(this);
    }
    private void setStatusBarTrue() {
        SetStatusBar.isUseFullScreenMode = false;
        SetStatusBar.getStatusBarColor = R.color.colorPrimary;
        SetStatusBar.isUseBlackFontWithStatusBar = true;
        SetStatusBar.setStatusBar(this);
    }

}
