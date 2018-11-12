package dahei.me.xiaobai.mainpage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import dahei.me.alphatabview.TabIndicatorView;
import dahei.me.xiaobai.BaseActivity;
import dahei.me.xiaobai.R;

/**
 * created by yubosu
 * 2018年11月08日3:30 PM
 */
public class MainPageActivity extends BaseActivity {

    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.tabIndicatorView)
    TabIndicatorView tabIndicatorView;

    private ArrayList<Fragment> fragments = new ArrayList<>();
    private FragmentPagerAdapter fragmentPagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        initView();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    private void initView() {
        fragments.add(new ChatsFragment());
        fragments.add(new ContactsFragment());
        fragments.add(new DiscoverFragment());
        fragments.add(new MeFragment());
        fragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return fragments.size();
            }

            @Override
            public Fragment getItem(int i) {
                return fragments.get(i);
            }
        };
        viewPager.setAdapter(fragmentPagerAdapter);
        tabIndicatorView.setViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_chats:

                break;
            case R.id.action_contacts:

                break;
            case R.id.action_help_feed:

                break;
            case R.id.action_money:

                break;
            case R.id.action_scan:

                break;
            case R.id.action_search:

                break;
        }

        return super.onOptionsItemSelected(item);
    }

}
