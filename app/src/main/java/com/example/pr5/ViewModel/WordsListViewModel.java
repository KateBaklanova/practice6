package com.example.pr5.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.pr5.Models.Words;
import com.example.pr5.WordsRepository;

import java.util.ArrayList;
import java.util.List;
import com.example.pr5.WordsData;

public class WordsListViewModel extends ViewModel {
    public LiveData<List<Words>> words;

        public void init(){
            WordsRepository WordsRepository = new WordsRepository();
            words = WordsRepository.getRandomData();
        }

    public WordsListViewModel() {
            init();
        }
    }
