package com.example.pr5;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.pr5.Models.Words;

import java.util.ArrayList;
import java.util.List;

public class WordsData {

    public static MutableLiveData<List<Words>> createRandomList() {
        MutableLiveData<List<Words>> result = new MutableLiveData<>();
        ArrayList<Words> randomWords = new ArrayList<>();
        for (int i=0; i<=200; i++){
            randomWords.add(new Words ("item"+i, R.drawable.dot));
        }
        result.setValue(randomWords);
        return result;
    }
}
