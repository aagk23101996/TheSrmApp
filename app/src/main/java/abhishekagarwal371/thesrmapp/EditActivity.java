package abhishekagarwal371.thesrmapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;

import java.util.List;

public class EditActivity extends AppCompatActivity {
    public static final String Day_order = "A";
    public static final String Hr_no = "B";
    private int Day_Order;
    private List<Subjects> subjectss;
    private int Hr_No;
    private String[] strings;
    private Toolbar toolbar;
    private EditText edit;
    private EditText edit1;
    private int is = 0;
    private Button b;
    private TextView t1;
    private TextView t2;
    Subjects freesubject=new Subjects();
    Subjects editsubject=new Subjects();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        Intent i = getIntent();
        t1=(TextView)findViewById(R.id.day_order);
        t2=(TextView)findViewById(R.id.hr_no);
        toolbar=(Toolbar)findViewById(R.id.toolback);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        editsubject.setSubject_room("Room No");
        editsubject.setSubject_name("Sub Name");
        subjectss = SubjectLab.getInstance(this).getSublist();
        edit = (EditText) findViewById(R.id.edittext1);
        edit1=(EditText)findViewById(R.id.edittext2);
        edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.toString()!="") {
                    editsubject.setSubject_name(charSequence.toString());
                    SubjectLab.getInstance(EditActivity.this).updateroutine(editsubject, Day_Order, Hr_No);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        edit1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                /*if (charSequence.toString().isEmpty()==true)) {
                }
                else{
                    editsubject.setSubject_room(charSequence.toString());
                    SubjectLab.getInstance(EditActivity.this).updateroutine(editsubject, Day_Order, Hr_No);

                }*/
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        freesubject.setSubject_name("FREE");
        freesubject.setSubject_room("FREE");
        Day_Order = i.getExtras().getInt(Day_order);
        int hour = i.getExtras().getInt(Hr_no);
        t1.setText("Day Order "+Day_Order+"");

        b = (Button) findViewById(R.id.buttonclickme);
            Hr_No = hour + 1;

        t2.setText("Hour "+Hr_No+"");
        subjectss = SubjectLab.getInstance(this).getSublist();
        strings = new String[subjectss.size()];
        for (Subjects sd : subjectss) {
            strings[is] = sd.getSubject_name();
            is++;
            if (is == subjectss.size())
                break;
        }



    }

    public void clicked(View view) {
        switch (view.getId()) {

            case R.id.buttonclickme:

                new MaterialDialog.Builder(this)
                        .title("Choose")
                        .items(strings)
                        .itemsCallbackSingleChoice(-1, new MaterialDialog.ListCallbackSingleChoice() {
                            @Override
                            public boolean onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                                String abcd = strings[which];
                                b.setText(abcd);
                                SubjectLab.getInstance(EditActivity.this).updateroutine(freesubject, Day_Order, Hr_No);

                                SubjectLab.getInstance(EditActivity.this).updateroutine(subjectss.get(which), Day_Order, Hr_No);
                                return true;
                            }

                        }).show();

                break;

            case R.id.buttonclicked2:
                SubjectLab.getInstance(EditActivity.this).updateroutine(freesubject, Day_Order, Hr_No);
                break;
        }
    }
}
