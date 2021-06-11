package com.mbf.inte;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Bouton extends Activity {
	Button btn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);
	btn = (Button)findViewById(R.id.button1);
	btn.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			startActivity(new Intent("android.intent.action.ACTIVITY"));
		}
	});
	}
}
