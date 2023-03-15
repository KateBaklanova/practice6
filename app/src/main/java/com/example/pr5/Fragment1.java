package com.example.pr5;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class Fragment1 extends Fragment {
    private static final String TAG = "MyApp";
    public Fragment1() {
        super(R.layout.fragment1);
    }

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Toast toast = Toast.makeText(getActivity().getApplicationContext(),
                "Тост 1", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void onResume() {

        super.onResume();
        Toast toast = Toast.makeText(getActivity().getApplicationContext(),
                "Тост 5", Toast.LENGTH_SHORT);

        Button button = (Button) getView().findViewById(R.id.button1);

    }


    public void Play(View view){

    }



}


