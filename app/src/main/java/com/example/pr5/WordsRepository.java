package com.example.pr5;

import androidx.lifecycle.LiveData;

import com.example.pr5.Models.Words;

import java.util.List;

public class WordsRepository {
        public LiveData<List<Words>> getRandomData(){
            return WordsData.createRandomList();
        }
    }
