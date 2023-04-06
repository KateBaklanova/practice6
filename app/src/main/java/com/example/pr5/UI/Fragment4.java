package com.example.pr5.UI;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pr5.R;

import java.util.ArrayList;


public class Fragment4 extends Fragment {


    public Fragment4() {
        super(R.layout.fragment4);
    }

    public void onResume() {

        super.onResume();

        Button button = (Button) getView().findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.fragment1);
            }
        });
    }
}