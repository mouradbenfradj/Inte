package com.mbf.inte;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHandler{
	
	private static final String NOMBASE = "armstong.db";
	private static final int VERTION = 1;
	
	private static final String NOMTABLE1 = "historique";
	private static final String COLTAB11 = "id";
	private static final String COLTAB12 = "victoir";
	private static final String COLTAB13 = "perte";
	private static final String COLTAB14 = "level";
	
	
	private static final String NOMTABLE2 = "level";
	private static final String COLTAB21 = "id_level";
	private static final String COLTAB22 = "personnage";
	private static final String COLTAB23 = "bras";
	private static final String COLTAB24 = "force";
	private static final String COLTAB25 = "endurance";
	private static final String COLTAB26 = "rapiditer";
	private static final String COLTAB27 = "technique";
	private static final String COLTAB28 = "psychologie";
	private static final String COLTAB29 = "charme";
	private static final String COLTAB210 = "nom";

	public static final String historique ="CREATE TABLE " +NOMTABLE1 +" (" +
			COLTAB11 +" INTEGER PRIMARY KEY, " +
			COLTAB12 +" INTEGER, " +
			COLTAB13 +" INTEGER, " +
			COLTAB14 +" INTEGER);";
	public static final String level ="CREATE TABLE " +NOMTABLE2 +" (" +
			COLTAB21 +" INTEGER PRIMARY KEY," +
			COLTAB22 +" TEXT," +
			COLTAB23 +" TEXT," +
			COLTAB24 +" INTEGER," +
			COLTAB25 +" INTEGER," +
			COLTAB26 +" INTEGER," +
			COLTAB27 +" INTEGER," +
			COLTAB28 +" INTEGER," +
			COLTAB29 +" INTEGER," +
			COLTAB210 +" TEXT);";
	
	public static final String supression = "DROP TABLE IF EXISTS "+NOMTABLE1;
	
	private Basedonnee base;
	private final Context contex;
	
	private SQLiteDatabase sqldb;
	public int lev;
	public class Basedonnee extends SQLiteOpenHelper {



		

		public Basedonnee(Context context) {
			super(context, NOMBASE, null, VERTION);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			Log.d("base", "creation");
			db.execSQL(historique);
			Log.d("base", "level");
			db.execSQL(level);
			Log.d("base", "INSERT INTO "+NOMTABLE2+" VALUES(1,'perso1','bras1',4,5,6,7,8,9,'bob texas')");
			db.execSQL("INSERT INTO "+NOMTABLE2+" VALUES(1,'perso1','bras1',4,5,6,7,8,9,'bob texas')");
			Log.d("base", "INSERT INTO "+NOMTABLE2+" VALUES(2,'perso2','bras2',4,5,6,7,8,9,' Raye')");
			db.execSQL("INSERT INTO "+NOMTABLE2+" VALUES(2,'perso2','bras2',4,5,6,7,8,9,' Raye')");
			Log.d("base", "INSERT INTO "+NOMTABLE2+" VALUES(3,'perso3','bras3',4,5,6,7,8,9,'saly')");
			db.execSQL("INSERT INTO "+NOMTABLE2+" VALUES(3,'perso3','bras3',4,5,6,7,8,9,'saly')");
			Log.d("base", "INSERT INTO "+NOMTABLE2+" VALUES(4,'perso4','bras4',4,5,6,7,8,9,'stella')");
			db.execSQL("INSERT INTO "+NOMTABLE2+" VALUES(4,'perso4','bras4',4,5,6,7,8,9,'stella')");
			Log.d("base", "INSERT INTO "+NOMTABLE2+" VALUES(5,'perso5','bras5',4,5,6,7,8,9,'khal')");
			db.execSQL("INSERT INTO "+NOMTABLE2+" VALUES(5,'perso5','bras5',4,5,6,7,8,9,'khal')");
			Log.d("base", "INSERT INTO "+NOMTABLE1+" VALUES(1,0,0,0)");
			db.execSQL("INSERT INTO "+NOMTABLE1+" VALUES(1,0,0,1)");
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			db.execSQL(supression);
			onCreate(db);		
		}
	
	}
	
	public DatabaseHandler(Context c){
		contex = c;
	}
	
	public DatabaseHandler ouverture(){
		base = new Basedonnee(contex);
		sqldb = base.getWritableDatabase();
		return this;
	}
	public void fermer(){
		base.close();
	}


	public int getLevel() {
		return 1;
		// TODO Auto-generated method stub
		
	}
}


