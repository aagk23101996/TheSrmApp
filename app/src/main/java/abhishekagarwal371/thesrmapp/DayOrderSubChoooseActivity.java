package abhishekagarwal371.thesrmapp;

import android.content.Context;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class DayOrderSubChoooseActivity extends AppCompatActivity implements DayOrderFragment.Listener {
    public static final String Key1 = "Key1";
    Fragment f;
    private String TAG = DayOrderSubChoooseActivity.class.getSimpleName();
    //InterstitialAd mInterstitialAd;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_order_sub_chooose);
        context = this;
      /*  mInterstitialAd = new InterstitialAd(this);

        // set the ad unit ID
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_full_screen));

        AdRequest adRequest = new AdRequest.Builder()
                .build();

        // Load ads into Interstitial Ads
        mInterstitialAd.loadAd(adRequest);

        mInterstitialAd.setAdListener(new AdListener() {
            public void onAdLoaded() {
                showInterstitial();
            }
        });

*/
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        PreferenceManager.getDefaultSharedPreferences(this).edit().putInt(Key1, 1).apply();
        f = DayOrderFragment.newInstance(PreferenceManager.getDefaultSharedPreferences(this).getInt(Key1, 0));
        transaction.replace(R.id.fr, f);
        transaction.commit();
    }
  /*  private void showInterstitial() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }*/

        @Override
        public void getstate(int count){
            if (count == 1) {
                PreferenceManager.getDefaultSharedPreferences(context).edit().putInt(Key1, (PreferenceManager.getDefaultSharedPreferences(context).getInt(Key1, 0)) + 1).apply();
                if (PreferenceManager.getDefaultSharedPreferences(context).getInt(Key1, 0) < 6) {


                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    Fragment f1 = DayOrderFragment.newInstance(PreferenceManager.getDefaultSharedPreferences(context).getInt(Key1, 0));
                    transaction.replace(R.id.fr, f1);
                    transaction.addToBackStack("Hello");
                    transaction.commit();

                } else {
                    PreferenceManager.getDefaultSharedPreferences(context).edit().putInt(Stringss.Pre_edit,1).apply();
                    Intent t = new Intent(context, RoutineActivity.class);
                    startActivity(t);
                }
            }}}


