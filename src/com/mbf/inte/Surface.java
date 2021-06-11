package com.mbf.inte;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;


public class Surface extends SurfaceView implements SurfaceHolder.Callback {
	
	private Bras brasJoueur;
	public Bras getBras() {
		return this.brasJoueur;
	}
	public void setBras(Bras pBras) {
		this.brasJoueur = pBras;
	}
	
	SurfaceHolder mSurfaceHolder;
	SurfaceThread mThread;
	Bitmap plant,perso,bouton,energie,brasJ,conteneur,compteur,eguit,brasa,bb,bh,mouv;
	float sns;
	int snb,rap,lev; 
	
	public Surface(Context context) {
		super(context);
		mSurfaceHolder = getHolder();
		mSurfaceHolder.addCallback(this);
		mThread = new SurfaceThread(); 
		bb = BitmapFactory.decodeResource(getResources(), R.drawable.bb);
		bh = BitmapFactory.decodeResource(getResources(), R.drawable.bh);
	
		brasJ=BitmapFactory.decodeResource(getResources(), R.drawable.brasj);
		brasa=BitmapFactory.decodeResource(getResources(), R.drawable.bras);
		bouton = BitmapFactory.decodeResource(getResources(), R.drawable.bouton);
		compteur = BitmapFactory.decodeResource(getResources(), R.drawable.compteur);
		mouv = BitmapFactory.decodeResource(getResources(), R.drawable.rotator);
		
		conteneur = BitmapFactory.decodeResource(getResources(), R.drawable.conteneur);
		eguit = BitmapFactory.decodeResource(getResources(), R.drawable.eguit);
		energie = BitmapFactory.decodeResource(getResources(), R.drawable.energie);
		perso = BitmapFactory.decodeResource(getResources(), R.drawable.persol1);
		plant = BitmapFactory.decodeResource(getResources(), R.drawable.plant);
	}

	
	@SuppressLint("DrawAllocation")
	protected void onDraw(Canvas pCanvas) {
		// Dessiner le fond de l'écran en premier
		if(brasJoueur.getForce()>1)
		{
			brasJoueur.setForce(brasJoueur.getForce()-1);
		}
		snb=brasJoueur.getForce();
		lev=brasJoueur.getLevel();
		Log.d("surface", "chargmeent des image level"+lev);
		switch(lev){
		case 1 :
			plant = Bitmap.createScaledBitmap (plant, pCanvas.getWidth(), pCanvas.getHeight(), false);
			conteneur = Bitmap.createScaledBitmap (conteneur, pCanvas.getWidth()/10, (pCanvas.getHeight()-42), false);
			bouton =  Bitmap.createScaledBitmap (bouton,conteneur.getWidth(),pCanvas.getHeight()-conteneur.getHeight(),false);
			energie = Bitmap.createScaledBitmap (energie, conteneur.getWidth(), brasJoueur.getForce(), false);
			perso = Bitmap.createScaledBitmap (perso, pCanvas.getWidth()-conteneur.getWidth(), pCanvas.getHeight()/2, false);
			bb = Bitmap.createScaledBitmap (bb, pCanvas.getWidth()-conteneur.getWidth(), pCanvas.getHeight()/2, false);
			bh = Bitmap.createScaledBitmap (bh, pCanvas.getWidth()-conteneur.getWidth(), pCanvas.getHeight()/2, false);
			compteur = Bitmap.createScaledBitmap (compteur, pCanvas.getWidth()-conteneur.getWidth(), pCanvas.getHeight()/4, false);
			mouv = Bitmap.createScaledBitmap (mouv, pCanvas.getWidth()-conteneur.getWidth(), pCanvas.getHeight()/4, false);
			eguit = Bitmap.createScaledBitmap (eguit, eguit.getWidth(), pCanvas.getHeight()/4, false);
			brasJ = Bitmap.createScaledBitmap (brasJ,brasa.getWidth()/2, brasa.getHeight()-30, false);
			brasa = Bitmap.createScaledBitmap (brasa, pCanvas.getWidth()-conteneur.getWidth(), pCanvas.getHeight()/2, false);
			sns=brasJoueur.getRotation();
			Log.d("draw", "valeur X = "+sns);
			break;
		case 2 :
			plant = Bitmap.createScaledBitmap (plant, pCanvas.getWidth(), pCanvas.getHeight(), false);
			conteneur = Bitmap.createScaledBitmap (conteneur, pCanvas.getWidth()/10, (pCanvas.getHeight()-42), false);
			bouton =  Bitmap.createScaledBitmap (bouton,conteneur.getWidth(),pCanvas.getHeight()-conteneur.getHeight(),false);
			energie = Bitmap.createScaledBitmap (energie, conteneur.getWidth(), brasJoueur.getForce(), false);
			perso = Bitmap.createScaledBitmap (perso, pCanvas.getWidth()-conteneur.getWidth(), pCanvas.getHeight()/2, false);
			bb = Bitmap.createScaledBitmap (bb, pCanvas.getWidth()-conteneur.getWidth(), pCanvas.getHeight()/2, false);
			bh = Bitmap.createScaledBitmap (bh, pCanvas.getWidth()-conteneur.getWidth(), pCanvas.getHeight()/2, false);
			compteur = Bitmap.createScaledBitmap (compteur, pCanvas.getWidth()-conteneur.getWidth(), pCanvas.getHeight()/4, false);
			mouv = Bitmap.createScaledBitmap (mouv, pCanvas.getWidth()-conteneur.getWidth(), pCanvas.getHeight()/4, false);
			eguit = Bitmap.createScaledBitmap (eguit, eguit.getWidth(), pCanvas.getHeight()/4, false);
			brasJ = Bitmap.createScaledBitmap (brasJ,pCanvas.getWidth()-conteneur.getWidth(), pCanvas.getHeight()/2, false);
			brasa = Bitmap.createScaledBitmap (brasa, pCanvas.getWidth()-conteneur.getWidth(), pCanvas.getHeight()/2, false);
			sns=brasJoueur.getRotation();
			Log.d("draw", "valeur X = "+sns);
			break;
		case 3 :
			plant = Bitmap.createScaledBitmap (plant, pCanvas.getWidth(), pCanvas.getHeight(), false);
			conteneur = Bitmap.createScaledBitmap (conteneur, pCanvas.getWidth()/10, (pCanvas.getHeight()-42), false);
			bouton =  Bitmap.createScaledBitmap (bouton,conteneur.getWidth(),pCanvas.getHeight()-conteneur.getHeight(),false);
			energie = Bitmap.createScaledBitmap (energie, conteneur.getWidth(), brasJoueur.getForce(), false);
			perso = Bitmap.createScaledBitmap (perso, pCanvas.getWidth()-conteneur.getWidth(), pCanvas.getHeight()/2, false);
			bb = Bitmap.createScaledBitmap (bb, pCanvas.getWidth()-conteneur.getWidth(), pCanvas.getHeight()/2, false);
			bh = Bitmap.createScaledBitmap (bh, pCanvas.getWidth()-conteneur.getWidth(), pCanvas.getHeight()/2, false);
			compteur = Bitmap.createScaledBitmap (compteur, pCanvas.getWidth()-conteneur.getWidth(), pCanvas.getHeight()/4, false);
			mouv = Bitmap.createScaledBitmap (mouv, pCanvas.getWidth()-conteneur.getWidth(), pCanvas.getHeight()/4, false);
			eguit = Bitmap.createScaledBitmap (eguit, eguit.getWidth(), pCanvas.getHeight()/4, false);
			brasJ = Bitmap.createScaledBitmap (brasJ,brasJ.getWidth(), pCanvas.getHeight()/2, false);
			brasa = Bitmap.createScaledBitmap (brasa, pCanvas.getWidth()-conteneur.getWidth(), pCanvas.getHeight()/2, false);
			sns=brasJoueur.getRotation();
			Log.d("draw", "valeur X = "+sns);
			break;
		case 4 :
			plant = Bitmap.createScaledBitmap (plant, pCanvas.getWidth(), pCanvas.getHeight(), false);
			conteneur = Bitmap.createScaledBitmap (conteneur, pCanvas.getWidth()/10, (pCanvas.getHeight()-42), false);
			bouton =  Bitmap.createScaledBitmap (bouton,conteneur.getWidth(),pCanvas.getHeight()-conteneur.getHeight(),false);
			energie = Bitmap.createScaledBitmap (energie, conteneur.getWidth(), brasJoueur.getForce(), false);
			perso = Bitmap.createScaledBitmap (perso, pCanvas.getWidth()-conteneur.getWidth(), pCanvas.getHeight()/2, false);
			bb = Bitmap.createScaledBitmap (bb, pCanvas.getWidth()-conteneur.getWidth(), pCanvas.getHeight()/2, false);
			bh = Bitmap.createScaledBitmap (bh, pCanvas.getWidth()-conteneur.getWidth(), pCanvas.getHeight()/2, false);
			compteur = Bitmap.createScaledBitmap (compteur, pCanvas.getWidth()-conteneur.getWidth(), pCanvas.getHeight()/4, false);
			mouv = Bitmap.createScaledBitmap (mouv, pCanvas.getWidth()-conteneur.getWidth(), pCanvas.getHeight()/4, false);
			eguit = Bitmap.createScaledBitmap (eguit, eguit.getWidth(), pCanvas.getHeight()/4, false);
			brasJ = Bitmap.createScaledBitmap (brasJ,brasJ.getWidth(), pCanvas.getHeight()/2, false);
			brasa = Bitmap.createScaledBitmap (brasa, pCanvas.getWidth()-conteneur.getWidth(), pCanvas.getHeight()/2, false);
			sns=brasJoueur.getRotation();
			Log.d("draw", "valeur X = "+sns);
			break;
		case 5 :
			plant = Bitmap.createScaledBitmap (plant, pCanvas.getWidth(), pCanvas.getHeight(), false);
			conteneur = Bitmap.createScaledBitmap (conteneur, pCanvas.getWidth()/10, (pCanvas.getHeight()-42), false);
			bouton =  Bitmap.createScaledBitmap (bouton,conteneur.getWidth(),pCanvas.getHeight()-conteneur.getHeight(),false);
			energie = Bitmap.createScaledBitmap (energie, conteneur.getWidth(), brasJoueur.getForce(), false);
			perso = Bitmap.createScaledBitmap (perso, pCanvas.getWidth()-conteneur.getWidth(), pCanvas.getHeight()/2, false);
			bb = Bitmap.createScaledBitmap (bb, pCanvas.getWidth()-conteneur.getWidth(), pCanvas.getHeight()/2, false);
			bh = Bitmap.createScaledBitmap (bh, pCanvas.getWidth()-conteneur.getWidth(), pCanvas.getHeight()/2, false);
			compteur = Bitmap.createScaledBitmap (compteur, pCanvas.getWidth()-conteneur.getWidth(), pCanvas.getHeight()/4, false);
			mouv = Bitmap.createScaledBitmap (mouv, pCanvas.getWidth()-conteneur.getWidth(), pCanvas.getHeight()/4, false);
			eguit = Bitmap.createScaledBitmap (eguit, eguit.getWidth(), pCanvas.getHeight()/4, false);
			brasJ = Bitmap.createScaledBitmap (brasJ,brasa.getWidth(), pCanvas.getHeight()/2, false);
			brasa = Bitmap.createScaledBitmap (brasa, pCanvas.getWidth()-conteneur.getWidth(), pCanvas.getHeight()/2, false);
			sns=brasJoueur.getRotation();
			Log.d("draw", "valeur X = "+sns);
			break;
		}
		pCanvas.drawARGB(255, 0, 0, 255);
		
		pCanvas.drawBitmap(plant, 0, 0, null);		
		
		pCanvas.drawBitmap(perso, ((pCanvas.getWidth()-perso.getWidth())/2)+20, (pCanvas.getHeight()-perso.getHeight()-20), null);
		pCanvas.drawBitmap(bb, ((pCanvas.getWidth()-perso.getWidth())/2)+20, (pCanvas.getHeight()-perso.getHeight()-20), null);
		pCanvas.drawBitmap(bh, ((pCanvas.getWidth()-perso.getWidth())/2)+20, (pCanvas.getHeight()-perso.getHeight()-20), null);
		
		pCanvas.drawBitmap(compteur,0 , 0, null);
		
		pCanvas.rotate((0+rap),(pCanvas.getWidth()/2), eguit.getHeight());		
		pCanvas.drawBitmap(mouv,0 , 0, null);
		pCanvas.rotate((0-rap),(pCanvas.getWidth()/2), eguit.getHeight());

		pCanvas.rotate((0+sns),(pCanvas.getWidth()/2), eguit.getHeight());
		pCanvas.drawBitmap(eguit,compteur.getWidth()/2 , compteur.getHeight()-eguit.getHeight(), null);
		pCanvas.rotate((0-sns),(pCanvas.getWidth()/2), eguit.getHeight());

		pCanvas.rotate((0+180),(pCanvas.getWidth()/2), pCanvas.getHeight()/2);

		pCanvas.drawBitmap(conteneur,0, bouton.getHeight(), null);
		pCanvas.drawBitmap(energie,0,bouton.getHeight(), null);
		
		pCanvas.rotate((0-180),(pCanvas.getWidth()/2), pCanvas.getHeight()/2);
		
		pCanvas.drawBitmap(bouton, pCanvas.getWidth()-bouton.getWidth(), pCanvas.getHeight()-bouton.getHeight(), null);
	
		pCanvas.rotate((360-brasJoueur.getForce()),(pCanvas.getWidth()/2), pCanvas.getHeight());
		pCanvas.drawBitmap(brasa,((pCanvas.getWidth()-perso.getWidth())/2),(pCanvas.getHeight()-perso.getHeight()-20), null);
		
		pCanvas.drawBitmap(brasJ,(pCanvas.getWidth()/2), pCanvas.getHeight() - brasJ.getHeight()+10 , null);	
		
		Log.d("image", "chargmeent des image");
	}
	
			
	@Override
	public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		mThread.miseEnMarche = true;
		mThread.start();
		Log.d("Surface", "Creation");
	}

	@Override	
	public void surfaceDestroyed(SurfaceHolder holder) {
		Log.d("Surface", "destruction");
		mThread.miseEnMarche = false;
		boolean retry = true;
		Log.d("processus", "destroy");
		while (retry) {
			try {
				mThread.join();
				retry = false;
			} catch (InterruptedException e) {}
		}
		
	}
	
	private class SurfaceThread extends Thread {
		boolean miseEnMarche = true;
		

		@Override
		public void run() {
			Log.d("Surface", "Run");
			Canvas canvas;
			while (miseEnMarche) {
				canvas = null;
				brasJoueur.setRapiditer(brasJoueur.getRapiditer());
				rap = brasJoueur.getRapiditer();
				try {
					
					Log.d("thread", "processus");
					canvas = mSurfaceHolder.lockCanvas();
					Log.d("thread", "blockCanvas");
					synchronized (mSurfaceHolder) {
						Log.d("thread", "drawCan");
						onDraw(canvas);
					}
				} finally {
					if (canvas != null)
						Log.d("thread", "unlook");
						mSurfaceHolder.unlockCanvasAndPost(canvas);
				}

				// Pour dessiner à 50 fps
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {}
			}
		}
	}
}
