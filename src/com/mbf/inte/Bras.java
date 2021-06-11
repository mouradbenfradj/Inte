package com.mbf.inte;

import android.app.Activity;
import android.util.Log;

public class Bras extends Activity {

	private int level,force,rapiditer;
	private float rotation ;

	boolean rot;
	
	public Bras(){
		force=1;
		rapiditer=1;
		rot=false;
		Log.d("bras", "force"+force);
	}
	
	// Remet la boule à sa position de départ
	public void reset() {
		rotation = 0 ;
		Log.d("rotation", "valeurs"+ rotation);
	}

	public int getRapiditer() {
		return this.rapiditer;
	}

	public void setRapiditer(int rapiditer) {
		Log.d("bra", "rapiditer");
		if(rot){
			this.rapiditer = rapiditer++;
			if(rapiditer>270){
				rot=false;
				}
		}
		else{ 
				this.rapiditer = rapiditer--;
				if(rapiditer<90) {
					rot=true;
				}
			}
				
		}
	
	public int getLevel() {
		return this.level;
	}

	public void setLevel(int level) {
		Log.d("bra", "level");
		this.level = level;
	}
	

	public float getRotation() {
		return this.rotation;
	}


	public void setRotation(float rotat) {
		Log.d("bra", "setrotation");
		this.rotation = rotat;
	}
	
	public int getForce() {
		return this.force;
	}


	public void setForce(int force) {
		Log.d("bra", "setforce");
		this.force = force;
	}

	

}
