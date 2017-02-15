package abhishekagarwal371.thesrmapp;

import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by user on 30-12-2016.
 */

public class Cursorrepaeat {
    public static List<Subjects> list;
    public static void getsubllist(Cursor cursor,String b) {

        String string = cursor.getString(cursor.getColumnIndex(b));
        String[] components = string.split("/");
        String sub_name = components[0];
        String sub_id = components[1];
        String room_no = components[2];
        Subjects subjects = new Subjects(UUID.fromString(sub_id));
        subjects.setSubject_name(sub_name);
        subjects.setSubject_room(room_no);

        list.add(subjects);
    }
    public static List<Subjects> getllist(){
        return list;
    }
    public static void initialiselist(){
        list=new ArrayList<>();
    }





}
