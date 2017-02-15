package abhishekagarwal371.thesrmapp;


import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class DisplayFragment extends Fragment {
    private static String KEYZZ="Keyee";
    private int pos;
    private RecyclerView recyclerView;
    private List<Subjects> sub;
    private int a=0;
    private String[] timings={"08:00-08:50","08:50-09:40","09:45-10:35","10:40-11:30","11:35-12:25","12:30-1:20","01:25-02:15","02:20-03:10",
    "03:15-04:05","04:05-04:55"    };
    private ad add;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_display, container, false);
        pos=getArguments().getInt(KEYZZ);

        recyclerView=(RecyclerView)v.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
       setupadapter();

        return v;
    }

    private void setupadapter() {
        sub=SubjectLab.getInstance(getActivity()).getDayorderSubjectsList(pos+1);
        if(add==null){
            add=new ad();
            recyclerView.setAdapter(add);
        }
        else add.notifyDataSetChanged();
    }


    public static DisplayFragment getInstance(int position){
        Bundle args=new Bundle();
        args.putInt(KEYZZ,position);
        DisplayFragment displayFragment=new DisplayFragment();
        displayFragment.setArguments(args);
        return displayFragment;

    }

    @Override
    public void onResume() {
        super.onResume();
       setupadapter();
    }

    public class VHolder extends RecyclerView.ViewHolder{

        FrameLayout i;
        TextView t1;
        TextView t2;
        TextView t3;
        TextView t4;
        ImageView imageView;
        public VHolder(View itemView) {
            super(itemView);
            //i=(FrameLayout) itemView.findViewById(R.id.imgg);
            t1=(TextView)itemView.findViewById(R.id.textinput1);
            t2=(TextView)itemView.findViewById(R.id.textinput2);
            t3=(TextView)itemView.findViewById(R.id.textinput3);
            t4=(TextView)itemView.findViewById(R.id.textinput4);
            imageView=(ImageView)itemView.findViewById(R.id.imgedit);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(getActivity(),EditActivity.class);
                    intent.putExtra(EditActivity.Day_order,pos+1);
                    intent.putExtra(EditActivity.Hr_no,getAdapterPosition());

                    Bundle bundle= null;
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                        bundle = ActivityOptions.makeSceneTransitionAnimation(getActivity()).toBundle();
                        startActivity(intent,bundle);
                    }
                    else {
                        startActivity(intent);
                    }

                }
            });
        }
    }
    public class ad extends RecyclerView.Adapter<VHolder>{

        @Override
        public VHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater=LayoutInflater.from(getActivity());
            View view=inflater.inflate(R.layout.finalrecyclerinflate,parent,false);
            return new VHolder(view);
        }

        @Override
        public void onBindViewHolder(VHolder holder, int position) {
        Subjects subjects=sub.get(position);
            a=position;

          //  holder.i.setBackgroundColor(ContextCompat.getColor(getActivity(),subjects.getImg()));
            //Glide.with(getActivity()).load(subjects.getImg()).centerCrop().into(holder.i);
            holder.t1.setText("Hour "+(a+1)+"");
            holder.t2.setText(subjects.getSubject_name());
            holder.t3.setText(subjects.getSubject_room());
            holder.t4.setText(timings[position]);
        }

        @Override
        public int getItemCount() {
            return sub.size();
        }
    }

}
