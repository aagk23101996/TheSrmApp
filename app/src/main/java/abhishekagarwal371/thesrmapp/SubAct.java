package abhishekagarwal371.thesrmapp;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import java.util.UUID;

public class SubAct extends AppCompatActivity {
    private Toolbar toolbar;
    private final String String_intent="hello";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        Intent f=getIntent();
         toolbar=(Toolbar)findViewById(R.id.tool2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        UUID uuid=(UUID)f.getExtras().getSerializable(String_intent);
        Fragment g=SubFrag.getInstance(uuid);
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frame,g);
        transaction.commit();
    }
}
