package com.mbf.inte;

import android.app.Service;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;

public class Detecteur {

	private SensorManager mManager = null;
	private Bras brasJoueur;
	private Sensor orientation = null;
	private MainActivity mSurface = null;
	public static float  sns,snb;
	private int manche ;

	public void setManche(int manch)
	{
		this.manche=manch;
	}
	public int getManche()
	{
		return this.manche;
	 }
	
	public void setBras(Bras bras)
	{
		this.brasJoueur = bras;
		Log.d("detecteur", "braSet");
	}
	
	public Bras getBras()
	{
		Log.d("detecteur", "braGet");
		return brasJoueur;
		
	}
	@SuppressWarnings("deprecation")
	public Detecteur(MainActivity pView) {
		mSurface = pView;
		mManager = (SensorManager) mSurface.getBaseContext().getSystemService(Service.SENSOR_SERVICE);
		orientation = mManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
		Log.d("detecteur", "chargement");
	}
	
	SensorEventListener mSensorEventListener = new SensorEventListener() {

		@SuppressWarnings("deprecation")
		@Override
		public void onSensorChanged(SensorEvent pEvent) {
			sns = pEvent.values[0];

			brasJoueur.setRotation(sns);
			if((brasJoueur.getForce()>=90)&&(sns<270)){
				mSurface.showDialog(MainActivity.DEFEAT_DIALOG);
			}else if(brasJoueur.getForce()==270){
				mSurface.showDialog(MainActivity.VICTORY_DIALOG);
			}
		}

		@Override
		public void onAccuracyChanged(Sensor pSensor, int pAccuracy) {

		}
	};
	
	// Remet à zéro l'emplacement de la boule
	public void reset() {
		brasJoueur.reset();
	}
	  
	
	// Arrête le capteur
	public void stop() {
		manche++;
		mManager.unregisterListener(mSensorEventListener, orientation);
	}

	// Redémarre le capteur
	public void resume() {
		manche++;
		mManager.registerListener(mSensorEventListener, orientation, SensorManager.SENSOR_DELAY_GAME);
	}


}
