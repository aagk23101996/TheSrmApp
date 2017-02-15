package abhishekagarwal371.thesrmapp;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.customtabs.CustomTabsIntent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;


import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;

    private final String String_intent="hello";
    private CollapsingToolbarLayout layout;
    private DrawerLayout drawerLayout;
    private AdView mAdView;
   
    private SubjectLab subjectLab;
    private NavigationView navigationView;
    private RecyclerView recyclerView;
    private List<Subjects> list;
   
    private adapter a;
  
    private int i;
    private RelativeLayout relativeLayout;

    private Activity context;
    private VH hold;
    private static int nav_show=0;
    private int cl=0;
    private int hg=0;
    private Button doneb;
    private TextView empty_view;
    public int[] color={R.color.silver,R.color.red,R.color.blue,R.color.yellow,R.color.violet};
    @Override
    public void onCreate(Bundle g){
        super.onCreate(g);
        setContentView(R.layout.activity_main);
        if(PreferenceManager.getDefaultSharedPreferences(this).getInt(Stringss.Pre_edit,0)==1){
            Intent intent=new Intent(this,RoutineActivity.class);
            startActivity(intent);
            finish();
        }
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer);
        relativeLayout=(RelativeLayout)findViewById(R.id.relativej);
        i=PreferenceManager.getDefaultSharedPreferences(this).getInt(PrefernceUtils.KEY,0);
      /*  if(i!=0){
            Intent intent=new Intent(this,DayOrderSubChoooseActivity.class);
            startActivity(intent);

        } */
       /* <com.google.android.gms.ads.AdView
        android:id="@+id/adView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_alignParentBottom="true"
        android:layout_alignParentLeft="true"
        ads:adSize="BANNER"
        ads:adUnitId="@string/banner_ad_unit_id"/>*/
       // mAdView = (AdView) findViewById(R.id.adView);
      //  mAdView.setAdListener(new ToastAdListener(this));
      //  AdRequest adRequest = new AdRequest.Builder()
       //         .build();
     //   mAdView.loadAd(adRequest);
doneb=(Button)findViewById(R.id.donebutton23);
        mAdView = (AdView)findViewById(R.id.adView);

        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mAdView.loadAd(adRequest);

        subjectLab=SubjectLab.getInstance(this);
        list=subjectLab.getSublist();
        context=this;
        // webView = new WebView(this);
       


        navigationView=(NavigationView)findViewById(R.id.nav);
        View head=navigationView.inflateHeaderView(R.layout.head);
        TextView textView=(TextView)head.findViewById(R.id.textlogin);
        textView.setText("Hello");
        toolbar=(Toolbar)findViewById(R.id.tool);
        setSupportActionBar(toolbar);
        Intent gh=getIntent();
        if(gh.getExtras()!=null) {
            if (gh.getExtras().getInt(Stringss.Done_method) == 1) {

                nav_show=1;
                doneb.setVisibility(View.INVISIBLE);
                relativeLayout.removeView(mAdView);
                relativeLayout.removeView(doneb);
                RelativeLayout.LayoutParams rlparams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
                rlparams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM,1);

                relativeLayout.addView(mAdView,rlparams);
                drawerLayout.removeView(navigationView);

                toolbar.setNavigationIcon(null);
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            }
else if(gh.getExtras().getInt(Stringss.Done_method)==2){

                layout = (CollapsingToolbarLayout) findViewById(R.id.collapse);

                toolbar.setNavigationIcon(R.drawable.ic_action_navigation);

                toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        drawerLayout.openDrawer(GravityCompat.START);
                    }
                });
            }

        }
        else if(gh.getExtras()==null) {
            //Toast.makeText(this,nav_show+"",Toast.LENGTH_LONG).show();
            if(nav_show==1){
                doneb.setVisibility(View.INVISIBLE);
                relativeLayout.removeView(mAdView);
                relativeLayout.removeView(doneb);
                RelativeLayout.LayoutParams rlparams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
                rlparams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM,1);

                relativeLayout.addView(mAdView,rlparams);
                drawerLayout.removeView(navigationView);
                toolbar.setNavigationIcon(null);
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            }
            else {

                layout = (CollapsingToolbarLayout) findViewById(R.id.collapse);

                toolbar.setNavigationIcon(R.drawable.ic_action_navigation);

                toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        drawerLayout.openDrawer(GravityCompat.START);
                    }
                });
            }

        }


        recyclerView=(RecyclerView)findViewById(R.id.recycle);
        empty_view=(TextView)findViewById(R.id.empty_view);
        StaggeredGridLayoutManager manager=new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);

  //   int k[]=  manager.findLastCompletelyVisibleItemPositions(null);
    //   for(int i=0;i<k.length;i++){
      //     if(k[i]==(list.size()-1)){
        //       doneb.setVisibility(View.VISIBLE);
          // }
          // break;
      // }
        if(a==null) {
            a = new adapter(this);

            recyclerView.setAdapter(a);
        }
        else a.notifyDataSetChanged();


      //  imageView=(ImageView)findViewById(R.id.img);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.academia:drawerLayout.closeDrawer(GravityCompat.START);
                        String url="https://academia.srmuniv.ac.in";
                        CustomTabsIntent.Builder builder=new CustomTabsIntent.Builder();
                        CustomTabsIntent customTabsIntent=builder.build();

                        builder.setToolbarColor(ContextCompat.getColor(context,R.color.red));

                        builder.setStartAnimations(context,R.anim.slide_in_right,R.anim.slide_out_left);
                        builder.setExitAnimations(context,R.anim.slide_in_left,R.anim.slide_out_right);
                        customTabsIntent.launchUrl(context, Uri.parse(url));
                        item.setChecked(false);
                        break;
                }
                return true;

            }
        });
     //   Glide.with(this).load(R.drawable.androidwithbag).fitCenter().into(imageView);
        /*if(nav_show==0) {
            layout = (CollapsingToolbarLayout) findViewById(R.id.collapse);

            toolbar.setNavigationIcon(R.drawable.ic_action_navigation);

            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            });
        }
        else{
            toolbar.setNavigationIcon(null);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }*/
    }


    @Override
    protected void onResume() {
        super.onResume();
        /*if(hg==1){doneb.setVisibility(View.INVISIBLE);
            relativeLayout.removeView(mAdView);
            //   relativeLayout.removeView(doneb);
            RelativeLayout.LayoutParams rlparams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
            rlparams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM,1);

            relativeLayout.addView(mAdView,rlparams);
            drawerLayout.removeView(navigationView);
            nav_show=1;

        }*/
        if (mAdView != null) {
            mAdView.resume();
        }
        subjectLab=SubjectLab.getInstance(this);
        list=subjectLab.getSublist();
        a.notifyDataSetChanged();

        if(list.isEmpty()){
            recyclerView.setVisibility(View.INVISIBLE);
            empty_view.setVisibility(View.VISIBLE);
        }
        else{
            recyclerView.setVisibility(View.VISIBLE);
            empty_view.setVisibility(View.INVISIBLE);

        }

    }



    public void fab(View view){
        Subjects s=new Subjects();
        s.setSubject_name("Sub Name");
        s.setSubject_room("-");
        subjectLab.addSubject(s);
        Intent intent=new Intent(this,SubAct.class);
        intent.putExtra(String_intent,s.getUid());
        startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
    }

    public class VH extends RecyclerView.ViewHolder{
        ImageButton button;
        TextView t1;
        TextView t2;
        View v;

        public VH(View itemView) {
            super(itemView);
            v=itemView;
            t1=(TextView)itemView.findViewById(R.id.txt1);
            t2=(TextView)itemView.findViewById(R.id.txt2);
            button=(ImageButton)itemView.findViewById(R.id.imagebutton);

        }

    }

    class adapter extends RecyclerView.Adapter<VH>{



                Context c;
                public adapter(Context context){

                    c=context;
                }
                @Override
                public VH onCreateViewHolder(ViewGroup parent, int viewType) {
                    LayoutInflater inflater=LayoutInflater.from(c);
            View v=inflater.inflate(R.layout.recyclerviewlayout,parent,false);
            return new VH(v);
        }

        @Override
        public void onBindViewHolder(VH holder, int position) {
        hold=holder;

            if(cl==color.length)
                cl=0;
            Subjects s=list.get(position);
            holder.v.setBackgroundColor(color[cl]);
            if(position%3==0){
                holder.t1.setTextSize(50);
            }
            holder.t1.setText(s.getSubject_name());
            holder.t2.setText(s.getSubject_room());
            cl=cl+1;
            holder.button.setOnClickListener(new View.OnClickListener() {
                int y=hold.getAdapterPosition();
                Subjects deletedsub=list.get(y);
                @Override
                public void onClick(View view) {
                    list.remove(y);
                    notifyItemRemoved(y);
                    notifyItemRangeChanged(y,list.size());
                    SubjectLab.getInstance(new MainActivity()).deletesubject(deletedsub.getUid());
                    if(list.isEmpty()){
                        recyclerView.setVisibility(View.INVISIBLE);
                        empty_view.setVisibility(View.VISIBLE);
                    }
                    else{
                        recyclerView.setVisibility(View.VISIBLE);
                        empty_view.setVisibility(View.INVISIBLE);

                    }

                }
            });
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }


    public void DoneMethod(View view){
        PreferenceManager.getDefaultSharedPreferences(this).edit().putInt(PrefernceUtils.KEY,1).apply();
        
        Intent intent=new Intent(this,DayOrderSubChoooseActivity.class);
        startActivity(intent);
    }




    }


