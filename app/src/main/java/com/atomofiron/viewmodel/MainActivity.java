package com.atomofiron.viewmodel;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		MainModel global = ViewModelProviders.of(this).get(MainModel.class);
		global.data.observe(this, new Observer<Float>() {
			@Override
			public void onChanged(@Nullable Float aFloat) {
				I.log("MainActivity global: " + aFloat);
				((TextView) findViewById(R.id.global)).setText("global: " +String.valueOf(aFloat));
			}
		});

		if (getSupportFragmentManager().findFragmentById(R.id.container) == null) {
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.container, new MainFragment())
					.commitAllowingStateLoss();
		}
	}
}
