package com.atomofiron.viewmodel;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainFragment extends Fragment {
	private MainModel local;
	private MainModel global;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		local = ViewModelProviders.of(this).get(MainModel.class);
		local.data.observe(this, new Observer<Float>() {
			@Override
			public void onChanged(@Nullable Float aFloat) {
				I.log("MainFragment local: " + aFloat);
				((TextView) getView().findViewById(R.id.local)).setText("local: " + String.valueOf(aFloat));
			}
		});

		global = ViewModelProviders.of(getActivity()).get(MainModel.class);
		global.data.observe(this, new Observer<Float>() {
			@Override
			public void onChanged(@Nullable Float aFloat) {
				I.log("MainFragment global: " + aFloat);
				((TextView) getView().findViewById(R.id.global)).setText("global: " +String.valueOf(aFloat));
			}
		});
	}

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_main, container, false);
	}
}
