package abhishekagarwal371.thesrmapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by user on 29-12-2016.
 */

public class Adapters{
    public class VH extends RecyclerView.ViewHolder{

        TextView t1;
        TextView t2;
        public VH(View itemView) {
            super(itemView);
            t1=(TextView)itemView.findViewById(R.id.txt1);
            t2=(TextView)itemView.findViewById(R.id.txt2);
        }
    }
    class adapter extends RecyclerView.Adapter<Adapters.VH>{


        List<Subjects> subs;
        Context c;
        public adapter(List<Subjects>s){
            subs=s;

        }
        @Override
        public Adapters.VH onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater=LayoutInflater.from(c);
            View v=inflater.inflate(R.layout.recyclerviewlayout,parent,false);
            return new Adapters.VH(v);
        }

        @Override
        public void onBindViewHolder(Adapters.VH holder, int position) {
            Subjects s=subs.get(position);
            holder.t1.setText(s.getSubject_name());
            holder.t2.setText(s.getSubject_room());
        }

        @Override
        public int getItemCount() {
            return subs.size();
        }
    }

}
