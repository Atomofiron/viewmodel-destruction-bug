package com.atomofiron.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class MainModel extends ViewModel {

	public MutableLiveData<Float> data = new MutableLiveData<>();

	public MainModel() {
		float value = (float) Math.random();
		I.log("new MainModel " + value);
		data.setValue(value);
	}
}
