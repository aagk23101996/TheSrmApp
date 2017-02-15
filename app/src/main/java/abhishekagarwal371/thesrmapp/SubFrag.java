package abhishekagarwal371.thesrmapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.security.KeyStoreSpi;
import java.util.UUID;


/**
 * A simple {@link Fragment} subclass.
 */
public class SubFrag extends Fragment {
    private static final String Keyss="KEY";
    private EditText e1;
    private EditText e2;
    private UUID uuid;
    private Subjects s;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.fragment_sub, container, false);
        uuid=(UUID)getArguments().getSerializable(Keyss);
        s=SubjectLab.getInstance(getActivity()).getsubject(uuid);
        e1=(EditText)v.findViewById(R.id.edit1);
        e2=(EditText)v.findViewById(R.id.edit2);
    e1.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        s.setSubject_name(charSequence.toString());

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    });
        e2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
s.setSubject_room(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
return v;
    }
    public static SubFrag getInstance(UUID d){
        SubFrag subFrag=new SubFrag();
        Bundle bundle=new Bundle();
        bundle.putSerializable(Keyss,d);
        subFrag.setArguments(bundle);
        return subFrag;
    }

    @Override
    public void onPause() {
        super.onPause();
        SubjectLab.getInstance(getActivity()).updateSubject(s);

    }
}
