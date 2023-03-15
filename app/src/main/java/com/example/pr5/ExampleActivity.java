package com.example.pr5;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class ExampleActivity extends AppCompatActivity {

    public ExampleActivity() {
        super(R.layout.activity);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragment_container_view, Fragment1.class, null)
                    .commit();
        }
    }

    public void fr2(View view){
        Fragment fragment2 = new Fragment2();

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.fragment_container_view, fragment2);
        transaction.commit();
    }

    public void fr3(View view){
        Fragment fragment3 = new Fragment3();

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.fragment_container_view, fragment3);
        transaction.commit();
    }


}
