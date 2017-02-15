package abhishekagarwal371.thesrmapp;


import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;


import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class DayOrderFragment extends Fragment implements View.OnClickListener {
    private static final String KEYSS = "Keyss";
    private int anInt;
    private String KEY1 = "a";
    private String KEY2 = "b";
    private int cnt = 0;
    private String KEY3 = "c";
    private String KEY4 = "d";
    private String KEY5 = "t";
    private String KEY6 = "e";
    private String KEY7 = "f";
    private String KEY8 = "g";
    private String KEY9 = "h";
    private String KEY10 = "i";
    private String[] strings;
    private ArrayList<String> arrayList = new ArrayList<>();
    private TextView t1;
    private Button b1;private Button free1;
    private String s1 = "Choose sub";
    private int i1 = 0;
    private TextView t2;
    private Button b2;private Button free2;
    private String s2 = "Choose sub";
    private int i2 = 0;
    private TextView t3;
    private Button b3;private Button free3;
    private String s3 = "Choose sub";
    private int i3 = 0;
    private TextView t4;
    private Button b4;private Button free4;
    private String s4 ="Choose sub";
    private int i4 = 0;
    private TextView t5;
    private Button b5;private Button free5;
    private String s5 = "Choose sub";
    private int i5 = 0;
    private TextView t6;
    private Button b6;private Button free6;
    private String s6 = "Choose sub";
    private int i6 = 0;
    private TextView t7;private Button free7;
    private Button b7;
    private String s7 = "Choose sub";
    private int i7 = 0;
    private Typeface typeface;
    private TextView t8;private Button free8;
    private Button b8;
    private String s8 = "Choose sub";
    private int i8 = 0;
    private TextView t9;private Button free9;
    private Button b9;
    private String s9 = "Choose sub";
    private int i9 = 0;
    private TextView t10;private Button free10;
    private Button b10;
    private String s10 = "Choose sub";
    private int i10 = 0;
    private List<Subjects> subjectss;
    private int hr_no;
    private Listener listener;
    Subjects freesubject=new Subjects();

    private int i = 0;
    private int is = 0;
    private int s = 0;
    private Drawable shape;
    private NestedScrollView scrollView;
    private Drawable shape1;
    private Button buttonclick;


    CollapsingToolbarLayout collapsingToolbarLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_day_order, container, false);
        anInt = getArguments().getInt(KEYSS);
        buttonclick=(Button)v.findViewById(R.id.buttonclicked);

        buttonclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.getstate(1);
            }
        });
       /// scrollView=(NestedScrollView)v.findViewById(R.id.nestedscroll);

        PreferenceManager.getDefaultSharedPreferences(getActivity()).edit().putInt(DayOrderSubChoooseActivity.Key1, anInt).apply();
        SubjectLab.getInstance(getActivity()).adddayorder(1);
        SubjectLab.getInstance(getActivity()).adddayorder(2);
        SubjectLab.getInstance(getActivity()).adddayorder(3);
        SubjectLab.getInstance(getActivity()).adddayorder(4);
        SubjectLab.getInstance(getActivity()).adddayorder(5);
        freesubject.setSubject_name("FREE");
        freesubject.setSubject_room("FREE");
        setRetainInstance(true);
        if (savedInstanceState != null) {
            s1 = savedInstanceState.getString(KEY1);
            s2 = savedInstanceState.getString(KEY2);
            s3 = savedInstanceState.getString(KEY3);
            s4 = savedInstanceState.getString(KEY4);
            s5 = savedInstanceState.getString(KEY5);
            s6 = savedInstanceState.getString(KEY6);
            s7 = savedInstanceState.getString(KEY7);
            s8 = savedInstanceState.getString(KEY8);
            s9 = savedInstanceState.getString(KEY9);
            s10 = savedInstanceState.getString(KEY10);
        }
        if (is != 0)
            is = 0;
        t1 = (TextView) v.findViewById(R.id.txt1);
        b1 = (Button) v.findViewById(R.id.button1);free1=(Button)v.findViewById(R.id.freebutton1);
        t2 = (TextView) v.findViewById(R.id.txt2);
        b2 = (Button) v.findViewById(R.id.button2);free2=(Button)v.findViewById(R.id.freebutton2);
        t3 = (TextView) v.findViewById(R.id.txt3);
        b3 = (Button) v.findViewById(R.id.button3);free3=(Button)v.findViewById(R.id.freebutton3);
        t4 = (TextView) v.findViewById(R.id.txt4);
        b4 = (Button) v.findViewById(R.id.button4);free4=(Button)v.findViewById(R.id.freebutton4);
        t5 = (TextView) v.findViewById(R.id.txt5);
        b5 = (Button) v.findViewById(R.id.button5);free5=(Button)v.findViewById(R.id.freebutton5);
        t6 = (TextView) v.findViewById(R.id.txt6);
        b6 = (Button) v.findViewById(R.id.button6);free6=(Button)v.findViewById(R.id.freebutton6);
        t7 = (TextView) v.findViewById(R.id.txt7);
        b7 = (Button) v.findViewById(R.id.button7);free7=(Button)v.findViewById(R.id.freebutton7);
        t8 = (TextView) v.findViewById(R.id.txt8);
        b8 = (Button) v.findViewById(R.id.button8);free8=(Button)v.findViewById(R.id.freebutton8);
        t9 = (TextView) v.findViewById(R.id.txt9);
        b9 = (Button) v.findViewById(R.id.button9);free9=(Button)v.findViewById(R.id.freebutton9);
        t10 = (TextView) v.findViewById(R.id.txt10);
        b10 = (Button) v.findViewById(R.id.button10);free10=(Button)v.findViewById(R.id.freebutton10);

        subjectss = SubjectLab.getInstance(getActivity()).getSublist();
        strings = new String[subjectss.size()];
        for (Subjects sd : subjectss) {
            strings[is] = sd.getSubject_name();
            is++;
            if (is == subjectss.size())
                break;
        }
        collapsingToolbarLayout = (CollapsingToolbarLayout) v.findViewById(R.id.collapsing);
        collapsingToolbarLayout.setTitle("Day Order " + anInt);
        t1.setText("Hour 1");
        t2.setText("Hour 2");
        t3.setText("Hour 3");
        t4.setText("Hour 4");
        t5.setText("Hour 5");
        t6.setText("Hour 6");
        t7.setText("Hour 7");
        t8.setText("Hour 8");
        t9.setText("Hour 9");
        t10.setText("Hour 10");
        b1.setOnClickListener(this);free1.setOnClickListener(this);
        b2.setOnClickListener(this);free2.setOnClickListener(this);
        b3.setOnClickListener(this);free3.setOnClickListener(this);
        b4.setOnClickListener(this);free4.setOnClickListener(this);
        b5.setOnClickListener(this);free5.setOnClickListener(this);
        b6.setOnClickListener(this);free6.setOnClickListener(this);
        b7.setOnClickListener(this);free7.setOnClickListener(this);
        b8.setOnClickListener(this);free8.setOnClickListener(this);
        b9.setOnClickListener(this);free9.setOnClickListener(this);
        b10.setOnClickListener(this);free10.setOnClickListener(this);


        return v;

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Resources resources=getResources();
         shape1=resources.getDrawable(R.drawable.shapes1,null);
         shape=resources.getDrawable(R.drawable.shape,null);

        typeface.createFromAsset(getActivity().getAssets(),"Roboto-Regular.ttf");
         listener = (Listener) context;
    }


    @Override
    public void onResume() {
        super.onResume();
        b1.setText(s1);
        b2.setText(s2);
        b3.setText(s3);
        b4.setText(s4);
        b5.setText(s5);
        b6.setText(s6);
        b7.setText(s7);
        b8.setText(s8);
        b9.setText(s9);
        b10.setText(s10);
    }

    public static DayOrderFragment newInstance(int i) {
        Bundle args = new Bundle();
        args.putInt(KEYSS, i);

        DayOrderFragment fragment = new DayOrderFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY1, s1);
        outState.putString(KEY2, s2);
        outState.putString(KEY3, s3);
        outState.putString(KEY4, s4);
        outState.putString(KEY5,s5);
        outState.putString(KEY6, s6);
        outState.putString(KEY7, s7);
        outState.putString(KEY8, s8);
        outState.putString(KEY9, s9);
        outState.putString(KEY10, s10);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.button1:
                s = 0;
                b1.setBackground(shape1);
                b1.setTypeface(typeface);
                free1.setBackground(shape);
                /*if(i1==0)
                {cnt++;
                    i1=1;} */
                break;
            case R.id.button2:
                s = 1;
                b2.setBackground(shape1);
                b2.setTypeface(typeface);
                free2.setBackground(shape);
             /*   if(i2==0)
                {cnt++;
                    i2=1;} */
                break;
            case R.id.button3:
                s = 2;
                b3.setBackground(shape1);
                b3.setTypeface(typeface);
                free3.setBackground(shape);
               /* if(i3==0)
                {cnt++;
                    i3=1;} */
                break;
            case R.id.button4:
                s = 3;
                b4.setBackground(shape1);
                b4.setTypeface(typeface);
                free4.setBackground(shape);
              /*  if(i4==0)
               {cnt++;
                    i4=1;} */
                break;
            case R.id.button5:
                s = 4;
                b5.setBackground(shape1);
                b5.setTypeface(typeface);
                free5.setBackground(shape);
              /*  if(i4==0)
               {cnt++;
                    i4=1;} */
                break;
            case R.id.button6:
                s = 5;
                b6.setBackground(shape1);
                b6.setTypeface(typeface);
                free6.setBackground(shape);
                /*if(i6==0)
                {cnt++;
                    i6=1;} */
                break;
            case R.id.button7:
                s = 6;
                b7.setBackground(shape1);
                b7.setTypeface(typeface);
                free7.setBackground(shape);
               /* if(i7==0)
                {cnt++;
                    i7=1;} */
                break;
            case R.id.button8:
                s = 7;
                b8.setBackground(shape1);
                b8.setTypeface(typeface);
                free8.setBackground(shape);
               /* if(i8==0)
                {cnt++;
                    i8=1;} */
                break;
            case R.id.button9:
                s = 8;
                b9.setBackground(shape1);
                b9.setTypeface(typeface);
                free9.setBackground(shape);
               /* if(i9==0)
                {cnt++;
                    i9=1;} */
                break;
            case R.id.button10:
                s = 9;
                b10.setBackground(shape1);
                b10.setTypeface(typeface);
                free10.setBackground(shape);
               /* if(i10==0)
                {cnt++;
                    i10=1;} */
                break;
            case R.id.freebutton1:
                s = 10;
                SubjectLab.getInstance(getActivity()).updateroutine(freesubject, anInt, 1);
                free1.setBackground(shape1);
                b1.setBackground(shape);
                b1.setText("Choose Sub");
                s1 = "Choose Sub";
                free1.setTypeface(typeface);
                break;
            case R.id.freebutton2:
                s = 10;
                SubjectLab.getInstance(getActivity()).updateroutine(freesubject, anInt, 2);
                free2.setBackground(shape1);
                b2.setBackground(shape);
                b2.setText("Choose Sub");
                s2 = "Choose Sub";
                free2.setTypeface(typeface);
                break;
            case R.id.freebutton3:
                s = 10;
                SubjectLab.getInstance(getActivity()).updateroutine(freesubject, anInt, 3);
                free3.setBackground(shape1);
                b3.setBackground(shape);
                b3.setText("Choose Sub");
                s3 = "Choose Sub";
                free3.setTypeface(typeface);
                break;
            case R.id.freebutton4:
                s = 10;
                SubjectLab.getInstance(getActivity()).updateroutine(freesubject, anInt, 4);
                free4.setBackground(shape1);
                b4.setText("Choose Sub");
                b4.setBackground(shape);
                s4 = "Choose Sub";
                free4.setTypeface(typeface);
                break;
            case R.id.freebutton5:
                s = 10;
                SubjectLab.getInstance(getActivity()).updateroutine(freesubject, anInt, 5);
                free5.setBackground(shape1);
                b5.setBackground(shape);
                b5.setText("Choose Sub");
                s5 = "Choose Sub";
                free5.setTypeface(typeface);
                break;
            case R.id.freebutton6:
                s = 10;
                SubjectLab.getInstance(getActivity()).updateroutine(freesubject, anInt, 6);
                free6.setBackground(shape1);
                b6.setBackground(shape);
                b6.setText("Choose Sub");
                free6.setTypeface(typeface);
                s6 = "Choose Sub";
                break;
            case R.id.freebutton7:
                s = 10;
                SubjectLab.getInstance(getActivity()).updateroutine(freesubject, anInt, 7);
                free7.setBackground(shape1);
                b7.setBackground(shape);
                b7.setText("Choose Sub");
                free7.setTypeface(typeface);
                s7 = "Choose Sub";
                break;
            case R.id.freebutton8:
                s = 10;
                SubjectLab.getInstance(getActivity()).updateroutine(freesubject, anInt, 8);
                free8.setBackground(shape1);
                b8.setBackground(shape);
                b8.setText("Choose Sub");
                free8.setTypeface(typeface);
                s8 = "Choose Sub";
                break;
            case R.id.freebutton9:
                s = 10;
                SubjectLab.getInstance(getActivity()).updateroutine(freesubject, anInt, 9);
                free9.setBackground(shape1);
                b9.setBackground(shape);
                b9.setText("Choose Sub");
                free9.setTypeface(typeface);
                s9 = "Choose Sub";
                break;
            case R.id.freebutton10:
                s = 10;
                SubjectLab.getInstance(getActivity()).updateroutine(freesubject, anInt, 10);
                free10.setBackground(shape1);
                b10.setBackground(shape);
                b10.setText("Choose Sub");
                free10.setTypeface(typeface);
                s10 = "Choose Sub";
                break;
        }

        if (s < 10) {
            new MaterialDialog.Builder(getActivity())
                    .title("Choose")
                    .items(strings)
                    .itemsCallbackSingleChoice(-1, new MaterialDialog.ListCallbackSingleChoice() {
                        @Override
                        public boolean onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                            switch (s) {
                                case 0:
                                    b1.setText(strings[which]);
                                    s1 = strings[which];
                                    SubjectLab.getInstance(getActivity()).updateroutine(subjectss.get(which), anInt, 1);

                                    break;
                                case 1:

                                    b2.setText(strings[which]);
                                    s2 = strings[which];
                                    SubjectLab.getInstance(getActivity()).updateroutine(subjectss.get(which), anInt, 2);
                                    break;
                                case 2:

                                    b3.setText(strings[which]);
                                    s3 = strings[which];
                                    SubjectLab.getInstance(getActivity()).updateroutine(subjectss.get(which), anInt, 3);
                                    break;
                                case 3:
                                    b4.setText(strings[which]);
                                    s4 = strings[which];
                                    SubjectLab.getInstance(getActivity()).updateroutine(subjectss.get(which), anInt, 4);
                                    break;
                                case 4:
                                    b5.setText(strings[which]);
                                    s5 = strings[which];
                                    SubjectLab.getInstance(getActivity()).updateroutine(subjectss.get(which), anInt, 5);

                                    break;
                                case 5:
                                    b6.setText(strings[which]);
                                    s6 = strings[which];
                                    SubjectLab.getInstance(getActivity()).updateroutine(subjectss.get(which), anInt, 6);
                                    break;
                                case 6:
                                    b7.setText(strings[which]);
                                    s7 = strings[which];
                                    SubjectLab.getInstance(getActivity()).updateroutine(subjectss.get(which), anInt, 7);
                                    break;
                                case 7:
                                    b8.setText(strings[which]);
                                    s8 = strings[which];
                                    SubjectLab.getInstance(getActivity()).updateroutine(subjectss.get(which), anInt, 8);
                                    break;
                                case 8:
                                    b9.setText(strings[which]);
                                    s9 = strings[which];
                                    SubjectLab.getInstance(getActivity()).updateroutine(subjectss.get(which), anInt, 9);
                                    break;
                                case 9:
                                    b10.setText(strings[which]);
                                    s10 = strings[which];
                                    SubjectLab.getInstance(getActivity()).updateroutine(subjectss.get(which), anInt, 10);
                                    break;
                            }

                            return true;
                        }
                    })

                    .show();
            // listener.getstate(cnt,9);

        }
    }
    static interface Listener{
        void getstate(int count);
    }




}
