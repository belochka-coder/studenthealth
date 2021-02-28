package com.example.project.ui.pitanie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PitanieViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PitanieViewModel() {

    }

    public LiveData<String> getText() {
        return mText;
    }
}