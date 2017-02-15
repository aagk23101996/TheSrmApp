package abhishekagarwal371.thesrmapp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.customtabs.CustomTabsIntent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

public class RoutineActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener{
    TextView t;
    private String[] str={"DAY ORDER 1","DAY ORDER 2","DAY ORDER 3","DAY ORDER 4","DAY ORDER 5"};
    List<Subjects> sub = new ArrayList<>();
    Toolbar toolbars;
    private ImageButton imageButton;
    private NavigationView mnav;
    TabLayout l;
    CoordinatorLayout coordinatorLayout;
    DrawerLayout draw;
    NavigationView navigationView;
    ViewPager viewPager;
    View view;
    private SignInButton button;
    /* _________________________________________________________________________________________________*/
    private static final String TAG = MainActivity.class.getSimpleName();
    private static final int RC_SIGN_IN = 007;

    private GoogleApiClient mGoogleApiClient;
    private ProgressDialog mProgressDialog;

    private SignInButton btnSignIn;
    private Button btnSignOut, btnRevokeAccess;
    private LinearLayout llProfileLayout;
    private ImageView imgProfilePic;
    private MenuItem imenu;
    private TextView txtName, txtEmail;
    private TextView txtLogin;
    private Activity context;
    private  String personPhotoUrl;
    private String PRE="a";
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routine);
        toolbars=(Toolbar)findViewById(R.id.toolbars);
        setSupportActionBar(toolbars);
        mAdView = (AdView)findViewById(R.id.adView1);
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mAdView.loadAd(adRequest);
context=this;
        PreferenceManager.getDefaultSharedPreferences(this).edit().putInt(PRE,2).commit();
        navigationView=(NavigationView)findViewById(R.id.naigation);
        draw=(DrawerLayout)findViewById(R.id.drawerlayout);
        toolbars.setNavigationIcon(R.drawable.ic_action_namedc);
        toolbars.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                draw.openDrawer(GravityCompat.START);
            }
        });
        coordinatorLayout=(CoordinatorLayout)findViewById(R.id.coordinatorlayout);
        viewPager=(ViewPager)findViewById(R.id.viewpager);

        l=(TabLayout)findViewById(R.id.tablayout);
         view=navigationView.inflateHeaderView(R.layout.head);
       button=(SignInButton)findViewById(R.id.btn_sign_in);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signOut();
                revokeAccess();

                signIn();

            }
        });
        imageButton=(ImageButton)view.findViewById(R.id.imageb);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               draw.closeDrawer(GravityCompat.START);
              //  revokeAccess();
             //   FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
               // transaction.replace(R.id.viewpager,new GoogleFragment()).addToBackStack(null);
              //  transaction.commit();
                coordinatorLayout.setVisibility(View.INVISIBLE);
PreferenceManager.getDefaultSharedPreferences(RoutineActivity.this).edit().putInt(PRE,3).commit();
                button.setVisibility(View.VISIBLE);
                //signIn();
            }

        });
        initailise();

        FragmentManager manager=getSupportFragmentManager();
        viewPager.setAdapter(new FragmentStatePagerAdapter(manager) {
                                 @Override
                                 public Fragment getItem(int position) {
                                     return DisplayFragment.getInstance(position);
                                 }

                                 @Override
                                 public int getCount() {
                                     return 5;
                                 }

                                 @Override
                                 public CharSequence getPageTitle(int position) {
                                     return str[position];
                                 }
                             });
l.setupWithViewPager(viewPager);
viewPager.setCurrentItem(0);
mnav=(NavigationView)findViewById(R.id.naigation);
        mnav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                imenu=item;
                switch (item.getItemId()) {
                    case R.id.academia1:
                        item.setChecked(false);
                        draw.closeDrawer(GravityCompat.START);
                        String url = "https://academia.srmuniv.ac.in";
                        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                        CustomTabsIntent customTabsIntent = builder.build();

                        builder.setToolbarColor(ContextCompat.getColor(context, R.color.red));

                        builder.setStartAnimations(context, R.anim.slide_in_right, R.anim.slide_out_left);
                        builder.setExitAnimations(context, R.anim.slide_in_left, R.anim.slide_out_right);
                        customTabsIntent.launchUrl(context, Uri.parse(url));

                        break;

                   /* case R.id.srm_web:
                        draw.closeDrawer(GravityCompat.START);
                        String url1 = "www.srmuniv.ac.in";
                        CustomTabsIntent.Builder builder1 = new CustomTabsIntent.Builder();
                        CustomTabsIntent customTabsIntent1 = builder1.build();

                        builder1.setToolbarColor(ContextCompat.getColor(context, R.color.red));

                        builder1.setStartAnimations(context, R.anim.slide_in_right, R.anim.slide_out_left);
                        builder1.setExitAnimations(context, R.anim.slide_in_left, R.anim.slide_out_right);
                        customTabsIntent1.launchUrl(context, Uri.parse(url1));
                        item.setChecked(false);
                        break;*/
                    case R.id.edit_sub:

                        draw.closeDrawer(GravityCompat.START);
                        Intent intent = new Intent(context, MainActivity.class);
                        PreferenceManager.getDefaultSharedPreferences(context).edit().putInt(Stringss.Pre_edit,2).apply();
                        intent.putExtra(Stringss.Done_method, 1);
                        startActivity(intent);
                        item.setChecked(false);
                        break;
                    case R.id.sign_out:
                        signOut();
                        item.setChecked(false);
                        break;
                    case R.id.log_in_diff:

                        signOut();
                        revokeAccess();
                        signIn();
                        item.setChecked(false);
                        break;
                    case R.id.new_timetable:
                       new AlertDialog.Builder(context).setTitle("Are you Sure").setMessage("Adding a new timetable will remove the previous one entirely")
                               .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                                   @Override
                                   public void onClick(DialogInterface dialogInterface, int i) {
                                       draw.closeDrawer(GravityCompat.START);

                                       imenu.setChecked(false);
                                       PreferenceManager.getDefaultSharedPreferences(context).edit().putInt(Stringss.Pre_edit,2).apply();
                                       Intent gh=new Intent(context,MainActivity.class);
                                       gh.putExtra(Stringss.Done_method,2);
                                       startActivity(gh);
                                   }
                               }).setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialogInterface, int i) {
                               imenu.setChecked(false);
                               draw.closeDrawer(GravityCompat.START);
                           }
                       }).create().show();


                      /*  draw.closeDrawer(GravityCompat.START);

                        item.setChecked(false);
                        PreferenceManager.getDefaultSharedPreferences(context).edit().putInt(Stringss.Pre_edit,2).apply();
                        Intent gh=new Intent(context,MainActivity.class);
                        gh.putExtra(Stringss.Done_method,2);
                        startActivity(gh);*/
                        break;
                }


return true;

            }
        });


        /* t=(TextView)findViewById(R.id.textview);
        sub=SubjectLab.getInstance(this).getDayorderSubjectsList(1);
        String d="";
        for(Subjects s:sub){
             d=d+s.getSubject_name();
        }
        t.setText(d);

    }*/
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mAdView != null) {
            mAdView.resume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
    }
    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {

       // Toast.makeText(this, "OnBackCalled", Toast.LENGTH_LONG).show();
        if (PreferenceManager.getDefaultSharedPreferences(this).getInt(PRE, 0) == 3) {
            button.setVisibility(View.INVISIBLE);
            coordinatorLayout.setVisibility(View.VISIBLE);
            PreferenceManager.getDefaultSharedPreferences(this).edit().putInt(PRE, 2).commit();
        } else {
            RoutineActivity.super.onBackPressed();
        }
    }

    private void initailise() {
txtLogin=(TextView)view.findViewById(R.id.textlogin);
       // btnSignIn = (SignInButton) findViewById(R.id.btn_sign_in);
      //  btnSignOut = (Button) findViewById(R.id.btn_sign_out);
       // btnRevokeAccess = (Button) findViewById(R.id.btn_revoke_access);
       // llProfileLayout = (LinearLayout) findViewById(R.id.llProfile);

        txtName = (TextView) view.findViewById(R.id.txtName);
        txtEmail = (TextView) view.findViewById(R.id.txtEmail);

       // btnSignIn.setOnClickListener(this);
       // btnSignOut.setOnClickListener(this);
       // btnRevokeAccess.setOnClickListener(this);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

        // Customizing G+ button
       // button.setSize(SignInButton.SIZE_STANDARD);
     //   button.setScopes(gso.getScopeArray());
    }

    private void signIn() {

        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        //signInIntent.putExtra("Nm",1);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }


    private void signOut() {
        Auth.GoogleSignInApi.signOut(mGoogleApiClient).setResultCallback(
                new ResultCallback<Status>() {
                    @Override
                    public void onResult(Status status) {
                        updateUI(false);
                    }
                });
    }



    private void revokeAccess() {
        Auth.GoogleSignInApi.revokeAccess(mGoogleApiClient).setResultCallback(
                new ResultCallback<Status>() {
                    @Override
                    public void onResult(Status status) {
                        updateUI(false);
                    }
                });
    }

    private void handleSignInResult(GoogleSignInResult result) {
        Log.d(TAG, "handleSignInResult:" + result.isSuccess());
        if (result.isSuccess()) {
            // Signed in successfully, show authenticated UI.
            GoogleSignInAccount acct = result.getSignInAccount();

            Log.e(TAG, "display name: " + acct.getDisplayName());

            String personName = acct.getDisplayName();
            if(acct.getPhotoUrl()!=null){
                personPhotoUrl = acct.getPhotoUrl().toString();}
            String email = acct.getEmail();

            // Log.e(TAG, "Name: " + personName + ", email: " + email
            //       + ", Image: " + personPhotoUrl);

            txtName.setText(personName);
            txtEmail.setText(email);
            if(personPhotoUrl!=null) {
                Glide.with(getApplicationContext()).load(personPhotoUrl)
                        .bitmapTransform(new CropCircleTransformation(this))


                       //.diskCacheStrategy(DiskCacheStrategy.ALL
                .into(imageButton);


            }

            updateUI(true);
        } else {
            // Signed out, show unauthenticated UI.
            updateUI(false);
        }
    }

   /* @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.btn_sign_in:
                signIn();
                break;

            case R.id.btn_sign_out:
                signOut();
                break;

            case R.id.btn_revoke_access:
                revokeAccess();
                break;
        }
    }*/

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            draw.openDrawer(GravityCompat.START);
            handleSignInResult(result);
        }
    }

    @Override
    public void onStart() {
        super.onStart();

        OptionalPendingResult<GoogleSignInResult> opr = Auth.GoogleSignInApi.silentSignIn(mGoogleApiClient);
        if (opr.isDone()) {
            // If the user's cached credentials are valid, the OptionalPendingResult will be "done"
            // and the GoogleSignInResult will be available instantly.
            Log.d(TAG, "Got cached sign-in");
            GoogleSignInResult result = opr.get();
            handleSignInResult(result);
        } else {
            // If the user has not previously signed in on this device or the sign-in has expired,
            // this asynchronous branch will attempt to sign in the user silently.  Cross-device
            // single sign-on will occur in this branch.
            showProgressDialog();
            opr.setResultCallback(new ResultCallback<GoogleSignInResult>() {
                @Override
                public void onResult(GoogleSignInResult googleSignInResult) {
                    hideProgressDialog();
                    handleSignInResult(googleSignInResult);
                }
            });
        }
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        // An unresolvable error has occurred and Google APIs (including Sign-In) will not
        // be available.
        Log.d(TAG, "onConnectionFailed:" + connectionResult);
        Toast.makeText(this,"Please check your internet connection",Toast.LENGTH_LONG);
    }

    private void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setMessage(getString(R.string.loading));
            mProgressDialog.setIndeterminate(true);
        }

        mProgressDialog.show();
    }

    private void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.hide();
        }
    }

    private void updateUI(boolean isSignedIn) {
        if (isSignedIn) {
            //coordinatorLayout.setVisibility(View.VISIBLE);
           // button.setVisibility(View.INVISIBLE);
            txtName.setVisibility(View.VISIBLE);
            txtEmail.setVisibility(View.VISIBLE);
coordinatorLayout.setVisibility(View.VISIBLE);
            button.setVisibility(View.INVISIBLE);
           // draw.openDrawer(GravityCompat.START);
            txtLogin.setVisibility(View.INVISIBLE);
         //   draw.openDrawer(GravityCompat.START);

          //  btnSignIn.setVisibility(View.GONE);
           // btnSignOut.setVisibility(View.VISIBLE);
           // btnRevokeAccess.setVisibility(View.VISIBLE);
           // llProfileLayout.setVisibility(View.VISIBLE);
        } else {
            txtName.setVisibility(View.INVISIBLE);
            txtEmail.setVisibility(View.INVISIBLE);
            txtLogin.setVisibility(View.VISIBLE);
            imageButton.setImageResource(R.drawable.ic_person_black_24dp);
            imageButton.setColorFilter(ContextCompat.getColor(this,R.color.white));

        }
            //btnSignIn.setVisibility(View.VISIBLE);
            //btnSignOut.setVisibility(View.GONE);
           // btnRevokeAccess.setVisibility(View.GONE);
            //llProfileLayout.setVisibility(View.GONE);
        }
    }



