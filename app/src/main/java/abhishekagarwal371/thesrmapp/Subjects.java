package abhishekagarwal371.thesrmapp;

import java.util.UUID;

/**
 * Created by user on 28-12-2016.
 */

public class Subjects {

    private String subject_name="";
    private int[] imgs={R.color.reddark,R.color.purple,R.color.indigo,R.color.deeporange,R.color.deeppurple};
    private int img=0;
    private UUID uid;
    private int r=0;
    private String subject_room="";
    public Subjects(){
        uid=UUID.randomUUID();
        r=(int)(Math.random()*((imgs.length-1)-0)+0);
        img=imgs[r];

    }


    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public String getSubject_room() {
        return subject_room;
    }

    public void setSubject_room(String subject_room) {
        this.subject_room = subject_room;
    }

    public UUID getUid() {
        return uid;
    }
    public Subjects(UUID g){
        uid=g;
        r=(int)(Math.random()*((imgs.length-1)-0)+0);
        img=imgs[r];

    }


    public int getImg() {
        return img;
    }
}
