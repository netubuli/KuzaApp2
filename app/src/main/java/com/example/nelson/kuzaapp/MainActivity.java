package com.example.nelson.kuzaapp;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button registerButton=(Button)findViewById(R.id.buttonRegisterFarmer);
        Button farmerLoginButton=(Button)findViewById(R.id.buttonFarmerLogin);
        Button viewProductsButton=(Button)findViewById(R.id.buttonViewProducts);
        Button askExpertButton =(Button)findViewById(R.id.buttonAskExpert);
        Button youTubeButton=(Button)findViewById(R.id.buttonYoutube);
        Button likeFacebookButton = (Button) findViewById(R.id.buttonLikeFacebook);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
                //getOpenFacebookIntent(MainActivity.this);

            }
        });
        farmerLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FarmerLoginActivity.class);
                startActivity(intent);

            }
        });
        viewProductsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              /*  Intent intent = new Intent(getApplicationContext(), BuyerActivity.class);
                startActivity(intent);*/
                Intent intent = new Intent(getApplicationContext(), ViewSellersActivity.class);
                startActivity(intent);

            }
        });
        askExpertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AskExpertActivity.class);
                startActivity(intent);

            }
        });
        youTubeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                OpenYouTube();
            }
        });
        likeFacebookButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                OpenFacebook();
            }
        });

        boolean twitterInstalled = false;;
        try {
            PackageManager packman = getPackageManager();
            packman.getPackageInfo("com.twitter.android", 0);
            twitterInstalled = true;
        } catch (Exception ex) {
            //ex.printStackTrace();
            twitterInstalled = false;

        }
        //set up Twitter button
        Button btnFollow = (Button) findViewById(R.id.buttonFollowTwitter);
        btnFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // this is the intent you actually want.
                // grabbed this by hooking a debugger up to twitter and debugging into android framework source.
                // this let me inspect the contents of the intent.
                Intent i = new Intent();
                i.setClassName("com.twitter.android", "com.twitter.android.ProfileActivity");
                i.putExtra("screen_name", "B_smartlimited");
                try {
                    startActivity(i);
                }
                catch (Exception ex) {
                    // uh something failed
                    ex.printStackTrace();
                }
            }
        });
        //Log.d(LOG_TAG, "twiterinstalled: " + twitterInstalled);
       if (twitterInstalled){btnFollow.setVisibility(View.VISIBLE);} else{btnFollow.setVisibility(View.GONE);}

/*
      likeFacebookButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              //Intent intent = new Intent(getApplicationContext(), AskExpertActivity.class);
              //startActivity(intent);
              getOpenFacebookIntent(MainActivity.this);

          }
      });*/
    }
    public void OpenFacebook(){

        String url = "https://m.facebook.com/Bsmart-Limited-820080758134836/?refid=46&sld=eyJzZWFyY2hfc2lkIjoiYjU1YmI1OGYxNzk2ZGQ5ODkzMTZkZmQwYTM1OTE1NWQiLCJxdWVyeSI6ImJzbWFydCIsInNlYXJjaF90eXBlIjoiU2VhcmNoIiwic2VxdWVuY2VfaWQiOjY4ODUxNjc1MiwicGFnZV9udW1iZXIiOjEsImZpbHRlcl90eXBlIjoiU2VhcmNoIiwiZW50X2lkIjo4MjAwODA3NTgxMzQ4MzYsInBvc2l0aW9uIjowLCJyZXN1bHRfdHlwZSI6Mjc0fQ%3D%3D";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
    public void OpenYouTube(){
        String url = "https://www.youtube.com/channel/UCRtvsX8_2GNfGQ0vF7m2uxw";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
    public static Intent getOpenFacebookIntent(Context context) {

        try {
            context.getPackageManager().getPackageInfo("com.facebook.katana", 0);
            //return new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/<id_here>"));
            return new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/Tosby"));

        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/Tosby"));
        }
    }
}
