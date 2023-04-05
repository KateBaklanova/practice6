package com.example.pr5;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Fragment2 extends Fragment implements WordsAdapter.OnNoteListener  {

    public Fragment2() {
        super(R.layout.fragment2);
    }

        ArrayList<Words> words = new ArrayList<Words>();
        @Override

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);


            setInitialData();
            View contentView = inflater.inflate(R.layout.fragment2, container, false);
            RecyclerView recyclerView = contentView.findViewById(R.id.list);
            WordsAdapter adapter = new WordsAdapter(contentView.getContext(), words, this);
            recyclerView.setAdapter(adapter);

            return contentView;
        }

        private void setInitialData(){
            for (int i=0; i<=200; i++){
                words.add(new Words ("item"+i, R.drawable.dot));
            }
        }

        @Override
        public void onNoteClick(int position) {
            words.get(position);
        }

        public void onResume() {

            super.onResume();
            Button button1 = (Button) getView().findViewById(R.id.button21);
            button1.setOnClickListener(new View.OnClickListener()  {
                @Override
                public void onClick(View view) {
                    Navigation.findNavController(view).navigate(R.id.fragment1);}
            });

            Button button = (Button) getView().findViewById(R.id.button22);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Navigation.findNavController(view).navigate(R.id.fragment3);
                }
            });



}
}

