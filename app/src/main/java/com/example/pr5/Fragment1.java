package com.example.pr5;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

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

        Button button = (Button) getView().findViewById(R.id.button11);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("example", "example");
                Navigation.findNavController(view).navigate(R.id.action_fragment1_to_fragment2, bundle);
            }
        });

    }

    public void onFragment1BackClick() {}


    public void Play(View view){

    }



}


