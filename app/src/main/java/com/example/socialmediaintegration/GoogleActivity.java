package com.example.socialmediaintegration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Matrix;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

public class GoogleActivity extends AppCompatActivity {
    TextView nm,mail;
    ImageButton logOut;
    ImageView iv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google);
        nm=findViewById(R.id.nm);
        mail=findViewById(R.id.mail);
        logOut=findViewById(R.id.logout);
        iv1=findViewById(R.id.picture);
        GoogleSignInAccount signInAccount= GoogleSignIn.getLastSignedInAccount(this);
        if(signInAccount!=null){
            nm.setText(signInAccount.getDisplayName());
            mail.setText(signInAccount.getEmail());
            FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
            FirebaseUser account = firebaseAuth.getCurrentUser();
            String personImage = Objects.requireNonNull(account.getPhotoUrl()).toString();
            Glide.with(this).load(personImage).into(iv1);
        }
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }
}