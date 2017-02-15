package abhishekagarwal371.thesrmapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.media.MediaCodecInfo;
import android.widget.Toast;

/**
 * Created by user on 28-12-2016.
 */

public class Datagh extends SQLiteOpenHelper {

    private static final int VER=1;
    private static final String nm="data.db";
    Context c;

    public Datagh(Context context){
        super(context,nm,null,VER);
        c=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+Stringss.TABLE_NAME+"("+"_id INTEGER PRIMARY KEY AUTOINCREMENT"+","+Stringss.ID+","+Stringss.Sub_Name+","+Stringss.Room_No+")");
       // Toast.makeText(c,"Inside 1 database",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
