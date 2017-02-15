package abhishekagarwal371.thesrmapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by user on 30-12-2016.
 */

public class RoutineDatabase extends SQLiteOpenHelper{
    private static final int VER=1;
    private static final String nm="datab.db";
    Context c;

    public RoutineDatabase(Context context){
        super(context,nm,null,VER);
        c=context;
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+Stringss.TABLE_NAME_ROUTINE+"("+"_id INTEGER PRIMARY KEY AUTOINCREMENT"+","+Stringss.Day_Order+","+Stringss.Hour1+","+
                Stringss.Hour2+","+Stringss.Hour3+","+Stringss.Hour4+","+Stringss.Hour5+","+Stringss.Hour6+","+Stringss.Hour7+","+Stringss.Hour8+","+Stringss.Hour9+","+Stringss.Hour10+")");
//Toast.makeText(c,"@nd db created",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
