package com.example.socialmediaintegration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.login.LoginManager;
import com.facebook.login.widget.ProfilePictureView;
import com.google.firebase.auth.FirebaseAuth;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;

public class FacebookActivity extends AppCompatActivity {
    ImageButton b1;
    TextView tv1,tv2;
    ProfilePictureView profilePictureView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook);
        tv1=findViewById(R.id.nm);
        tv2=findViewById(R.id.mail);
        profilePictureView = (ProfilePictureView) findViewById(R.id.picture);
        Intent intent=getIntent();
        String uID=intent.getStringExtra("id");
        profilePictureView.setProfileId(uID);
        String name=intent.getStringExtra("name");
        tv1.setText(name);
        b1=findViewById(R.id.logout);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                LoginManager.getInstance().logOut();
                startActivity(new Intent(FacebookActivity.this,MainActivity.class));
                finish();
            }
        });
    }
}