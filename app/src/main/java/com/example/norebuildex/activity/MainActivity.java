package com.example.norebuildex.activity;
import android.os.Build;
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
import com.example.norebuildex.utilConfig.StatusBarUtil;


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
                if (currentTabIndex != checkedId) { // 切换了Fragment
                    FragmentTransaction trx = getSupportFragmentManager().beginTransaction();
                    trx.hide(mFragmentSparseArray.get(currentTabIndex)); // 隐藏原来的
                    if (!mFragmentSparseArray.get(checkedId).isAdded()) { // 如果当前的没有被添加到FragmentTransaction,添加之
                        trx.add(R.id.container, mFragmentSparseArray.get(checkedId));
                    }
                    trx.show(mFragmentSparseArray.get(checkedId)).commit(); // 添加事务,切换Fragment
                }
                // 具体的fragment切换逻辑可以根据应用调整，例如使用show()/hide()
//                getSupportFragmentManager().beginTransaction().replace(R.id.container,
//                        mFragmentSparseArray.get(checkedId)).commit();
                System.out.println();
                currentTabIndex = checkedId;
            }
        });
        mTabRadioGroup.setBackgroundResource(R.color.oliveGreen);
    }


    private void setStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (isUseFullScreenMode()) {
                StatusBarUtil.transparencyBar(this);
            } else {
                StatusBarUtil.setStatusBarColor(this, getStatusBarColor());
            }

            if (isUseBlackFontWithStatusBar()) {
                StatusBarUtil.setLightStatusBar(this, true, isUseFullScreenMode());
            }


       /* if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, homeFragment)
                    .add(R.id.container, discoverFragment)
                    .hide(discoverFragment)
                    .show(homeFragment)
                    .commit();

        }*/
    }
    }



    /**
     * 是否设置成透明状态栏，即就是全屏模式
     */
    protected boolean isUseFullScreenMode() {
        return true;
    }

    /**
     * 更改状态栏颜色，只有非全屏模式下有效
     */
    protected int getStatusBarColor() {
        return R.color.colorWhite;
    }

    /**
     * 是否改变状态栏文字颜色为黑色，默认为黑色
     */
    protected boolean isUseBlackFontWithStatusBar() {
        return true;
    }


    public void onTabClicked(View view) {
      /*  switch (view.getId()) {
            case R.id.mBtOneFragment:
                index = 0;
                break;
            case R.id.mBtTwoFragment:
                index = 1;
                break;

            case R.id.mBtThreeFragment:
                index = 2;
                break;
            case R.id.mBtFourFragment:
                index = 3;
                break;
        }
        if (currentTabIndex != index) { // 切换了Fragment
            FragmentTransaction trx = getSupportFragmentManager().beginTransaction();

            trx.hide(fragments[currentTabIndex]); // 隐藏原来的
            if (!fragments[index].isAdded()) { // 如果当前的没有被添加到FragmentTransaction,添加之
                trx.add(R.id.fragment_container, fragments[index]);
            }
            trx.show(fragments[index]).commit(); // 添加事务,切换Fragment
        }
        mTabs[currentTabIndex].setSelected(false);
        mTabs[index].setSelected(true);
        currentTabIndex = index;*/
    }

}
