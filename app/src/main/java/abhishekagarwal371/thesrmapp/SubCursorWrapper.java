package abhishekagarwal371.thesrmapp;

import android.database.Cursor;
import android.database.CursorWrapper;

import java.util.UUID;

/**
 * Created by user on 28-12-2016.
 */

public class SubCursorWrapper extends CursorWrapper {
    public SubCursorWrapper(Cursor cursor) {
        super(cursor);
    }
    public Subjects getsub(){
        String sub_name=getString(getColumnIndex(Stringss.Sub_Name));
        String sub_room=getString(getColumnIndex(Stringss.Room_No));
        UUID uid=UUID.fromString(getString(getColumnIndex(Stringss.ID)));
        Subjects subjects=new Subjects(uid);
        subjects.setSubject_name(sub_name);
        subjects.setSubject_room(sub_room);
        return subjects;
    }



}
