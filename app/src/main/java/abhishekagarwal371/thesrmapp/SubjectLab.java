package abhishekagarwal371.thesrmapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by user on 28-12-2016.
 */

public class SubjectLab {
    private static SubjectLab subjectLab;
    private SQLiteDatabase db;
    private SQLiteDatabase dbs;
    private static UUID newuuid=UUID.randomUUID();
    String uuidstring=newuuid.toString();
    private int i=0;
    private int d=1;
    private List<Subjects> list;
    private SubjectLab(Context context){
        db=new Datagh(context).getWritableDatabase();
dbs=new RoutineDatabase(context).getWritableDatabase();
    }
    public static SubjectLab getInstance(Context context) {
        if (subjectLab == null) {
            subjectLab = new SubjectLab(context);

            return subjectLab;
        } else return subjectLab;
    }
    public void addSubject(Subjects subjects){
        ContentValues c=getContentValues(subjects);
        db.insert(Stringss.TABLE_NAME,null,c);
    }
    public void adddayorder(int day_order){
        ContentValues contentValues=new ContentValues();
        contentValues.put(Stringss.Day_Order,day_order+"");
        contentValues.put(Stringss.Hour1,"FREE"+"/"+newuuid+"/"+"FREE");
        contentValues.put(Stringss.Hour2,"FREE"+"/"+newuuid+"/"+"FREE");
        contentValues.put(Stringss.Hour3,"FREE"+"/"+newuuid+"/"+"FREE");
        contentValues.put(Stringss.Hour4,"FREE"+"/"+newuuid+"/"+"FREE");
        contentValues.put(Stringss.Hour5,"FREE"+"/"+newuuid+"/"+"FREE");
        contentValues.put(Stringss.Hour6,"FREE"+"/"+newuuid+"/"+"FREE");
        contentValues.put(Stringss.Hour7,"FREE"+"/"+newuuid+"/"+"FREE");
        contentValues.put(Stringss.Hour8,"FREE"+"/"+newuuid+"/"+"FREE");
        contentValues.put(Stringss.Hour9,"FREE"+"/"+newuuid+"/"+"FREE");
        contentValues.put(Stringss.Hour10,"FREE"+"/"+newuuid+"/"+"FREE");
        dbs.insert(Stringss.TABLE_NAME_ROUTINE,null,contentValues);

    }
    public void updateroutine(Subjects subjects,int day_order,int hr_no){

        ContentValues contentValues=new ContentValues();

        String hr_nos=hr_no+"";
        String finalhr_nos="Hour"+hr_nos;
        String data=subjects.getSubject_name()+"/"+subjects.getUid()+"/"+subjects.getSubject_room();
        contentValues.put(finalhr_nos,data);
        dbs.update(Stringss.TABLE_NAME_ROUTINE,contentValues,Stringss.Day_Order+"=?",new String[]{day_order+""});

    }
    public void deletesubject(UUID g){
        db.delete(Stringss.TABLE_NAME,Stringss.ID+"=?",new String[]{g.toString()});
    }



    public List<Subjects> getDayorderSubjectsList(int day_order){


        Cursor cursor=dbs.query(Stringss.TABLE_NAME_ROUTINE,null,Stringss.Day_Order+"=?",new String[]{day_order+""},null,null,null);
        cursor.moveToFirst();

Cursorrepaeat.initialiselist();
        Cursorrepaeat.getsubllist(cursor,Stringss.Hour1);
        Cursorrepaeat.getsubllist(cursor,Stringss.Hour2);
        Cursorrepaeat.getsubllist(cursor,Stringss.Hour3);
        Cursorrepaeat.getsubllist(cursor,Stringss.Hour4);
        Cursorrepaeat.getsubllist(cursor,Stringss.Hour5);
        Cursorrepaeat.getsubllist(cursor,Stringss.Hour6);
        Cursorrepaeat.getsubllist(cursor,Stringss.Hour7);
        Cursorrepaeat.getsubllist(cursor,Stringss.Hour8);
        Cursorrepaeat.getsubllist(cursor,Stringss.Hour9);
        Cursorrepaeat.getsubllist(cursor,Stringss.Hour10);




        return Cursorrepaeat.getllist();
    }






    public void updateSubject(Subjects subjects){
        ContentValues c=getContentValues(subjects);
        db.update(Stringss.TABLE_NAME,c,Stringss.ID+"=?",new String[]{subjects.getUid().toString()});
    }
    public List<Subjects>getSublist(){


            list = new ArrayList<>();
            Cursor cursor = getcursor(null, null);
            cursor.moveToFirst();
            while (cursor.isAfterLast() == false) {
                SubCursorWrapper g = new SubCursorWrapper(cursor);
                Subjects j = g.getsub();
                list.add(j);
                cursor.moveToNext();

            }

            cursor.close();

        return list;
    }

    private ContentValues getContentValues(Subjects subjects) {
        ContentValues cc=new ContentValues();
        cc.put(Stringss.ID,subjects.getUid().toString());
        cc.put(Stringss.Sub_Name,subjects.getSubject_name());
        cc.put(Stringss.Room_No,subjects.getSubject_room());
        return cc;
    }
    public Subjects getsubject(UUID g){
        Cursor cursor=getcursor(Stringss.ID+"=?",new String[]{g.toString()});
        cursor.moveToFirst();
        return new SubCursorWrapper(cursor).getsub();
    }

    private Cursor getcursor(String whereargs, String[] whereclause) {
        Cursor cursorss=db.query(Stringss.TABLE_NAME,null,whereargs,whereclause,null,null,null);
        return cursorss;

    }


}
