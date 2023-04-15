package com.example.pr5.UI;

import static java.net.Proxy.Type.HTTP;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pr5.R;
import com.example.pr5.Models.Words;
import com.example.pr5.WordsAdapter;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pr5.Models.Words;
import com.example.pr5.R;
import com.example.pr5.WordsAdapter;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Fragment5 extends Fragment{

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    void handleSendText(Intent intent, String action, TextView t33) {
        String sharedText = intent.getStringExtra(Intent.EXTRA_TEXT);
        if (sharedText != null) {
            t33.setText(action);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View contentView = inflater.inflate(R.layout.fragment5, container, false);

        ArrayList<String> options = new ArrayList<String>();
        ListView listView = (ListView) contentView.findViewById(R.id.listView);

        TextView t333 = (TextView) contentView.findViewById(R.id.t333);
        Button button1 = (Button) contentView.findViewById(R.id.button5);


        Intent intent = getActivity().getIntent();
        String action = intent.getAction();
        String type = intent.getType();
        if (Intent.ACTION_SEND.equals(action) && type != null) {
            if ("text/plain".equals(type)) {
                t333.setText("Полученное сообщение - " + intent.getStringExtra(intent.EXTRA_TEXT));
            }
        }

        options.add("Видео");
        options.add("Карточки");
        options.add("Мини игры");
        ArrayAdapter<String> adapter1 = new ArrayAdapter(contentView.getContext(), android.R.layout.simple_list_item_1, options);
        listView.setAdapter(adapter1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(Intent.createChooser(shareIntent, "Share Via"));
                startActivity(sendIntent);
            }
        });
        return contentView;
    }
        public Fragment5() {
            super(R.layout.fragment5);
        }

        public void onResume() {
            super.onResume();
        }
    }
