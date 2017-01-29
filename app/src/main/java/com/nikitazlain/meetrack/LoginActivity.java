package com.nikitazlain.meetrack;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


import com.example.nikitok.metrack.R;
import com.nikitazlain.meetrack.LoginFragments.CreatingUserFrament;
import com.nikitazlain.meetrack.LoginFragments.PhoneFragment;
import com.nikitazlain.meetrack.layoutBinder.Layout;
import com.nikitazlain.meetrack.routers.LoginRouter;
import com.nikitazlain.meetrack.ui.activity.BaseActivity;

import butterknife.BindView;

@Layout(id = R.layout.activity_login)
public class LoginActivity extends BaseActivity implements LoginRouter {
    public static final String PHONE_KEY="phone";
    public static final String FRAGMENT_KEY="fragment";
    public static final int PHONE_FRAGMENT=0;
    public static final int CODE_FRAGMENT=1;
    public static final int CREATING_USER_FRAGMENT=2;
    public static final int PATCHIN_FRAGMENT=3;

    @BindView(R.id.toolbar)
    private Toolbar toolbar;

    private PhoneFragment phoneFragment;

    private int currentFragment;
    public FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentManager = getSupportFragmentManager();
        setSupportActionBar(toolbar);
        phoneFragment = new PhoneFragment();
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (currentFragment){
                    case CODE_FRAGMENT:
                        fragmentManager.beginTransaction().replace(R.id.content_login,phoneFragment).commit();
                        currentFragment=CODE_FRAGMENT;
                        break;
                }
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.logn_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.next:
                switchFragment();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        switch (currentFragment){
            case CODE_FRAGMENT:
                fragmentManager.beginTransaction().replace(R.id.content_login,phoneFragment).commit();
                currentFragment=CODE_FRAGMENT;
                break;
            case PHONE_FRAGMENT:
               finishActivity(1);
                break;
        }
    }

    private void switchFragment(){
        switch (currentFragment){
            case PHONE_FRAGMENT:
                sendPhone();
                break;
            case CODE_FRAGMENT:
                fragmentManager.beginTransaction()
                        .setCustomAnimations(R.anim.in_left,R.anim.out_left)
                        .replace(R.id.content_login,new CreatingUserFrament())
                        .commit();
                currentFragment=CREATING_USER_FRAGMENT;


        }

    }
    @Override
    public void sendPhone(){
    }

    @Override
    public void auth() {

    }

    @Override
    public void register() {

    }

    @Override
    public void goBack() {

    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.d("mytags","OnStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("mytags", "activity destroyed");
    }
}
