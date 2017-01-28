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

public class LoginActivity extends AppCompatActivity {
    public static final String PHONE_KEY="phone";
    public static final String FRAGMENT_KEY="fragment";
    public static final int PHONE_FRAGMENT=0;
    public static final int CODE_FRAGMENT=1;
    public static final int CREATING_USER_FRAGMENT=2;
    public static final int PATCHIN_FRAGMENT=3;

    private PhoneFragment phoneFragment;

    private int currentFragment;
    public FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        fragmentManager = getSupportFragmentManager();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
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
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
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
   private void sendPhone(){
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
