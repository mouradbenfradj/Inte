package com.mbf.inte;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity {

	// Identifiant de la boîte de dialogue de victoire
	public static final int VICTORY_DIALOG = 0;
	// Identifiant de la boîte de dialogue de défaite
	public static final int DEFEAT_DIALOG = 1;

	  
	private Surface mView = null;
	private Detecteur mDetecteur = null;
	Bras b;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Log.d("Essai", "chargement mView");
		mView = new Surface(this);
		setContentView(mView);
		Log.d("Essai", "Chargement detecteur");
		
		mDetecteur = new Detecteur(this);
		
		
		
		Log.d("Essai", "chargement du bras");
		b = new Bras();
		Log.d("Essai", "chargement de la base");
		
		DatabaseHandler selec = new DatabaseHandler(MainActivity.this);
		Log.d("Essai", "ouverture de la base");
		selec.ouverture();
		Log.d("Essai", "set level");
		b.setLevel(selec.getLevel());
		Log.d("Essai", "fermeture de la base");
		selec.fermer();
		Log.d("Essai", "set du bras");
		mView.setBras(b);
		Log.d("Essai", "detect du bras");
		mDetecteur.setBras(b);
		mView.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				b.setRotation(b.getForce()+2);
				b.setForce(b.getForce()+2);
				
			}
			
		});
	}

	@Override
	protected void onResume() {
		super.onResume();
		mDetecteur.resume();
	} 

	@Override
	protected void onPause() {
		super.onStop();
		mDetecteur.stop();
	}
	
	
	@Override
	public Dialog onCreateDialog (int id) {
		
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		switch(id) {
		
		case VICTORY_DIALOG:
			Log.d("Essai",  "manche"+mDetecteur.getManche());
			builder.setCancelable(false)
			.setMessage("vous avez gagner")
			.setTitle(mDetecteur.getManche() +" monche")
			.setNeutralButton("Recommencer", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// L'utilisateur peut recommencer s'il le veut
					mDetecteur.reset();
					mDetecteur.resume();
				}
			});
			
			break;

		case DEFEAT_DIALOG:
			Log.d("Essai",  "manche"+mDetecteur.getManche());
			builder.setCancelable(false)
			.setMessage("vous avez perdu")
			.setTitle(mDetecteur.getManche() +" monche")
			.setNeutralButton("Recommencer", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					mDetecteur.reset();
					mDetecteur.setManche(mDetecteur.getManche()+1);
					mDetecteur.resume();
				}
			});
		}
		
		return builder.create();
	}

	@Override
	public void onPrepareDialog (int id, Dialog box) {
		// A chaque fois qu'une boîte de dialogue est lancée, on arrête le moteur physique
		mDetecteur.stop();
	}
}
