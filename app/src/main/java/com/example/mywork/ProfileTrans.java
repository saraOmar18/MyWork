package com.example.mywork;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mywork.R;
import com.example.mywork.UpdateProfile;
import com.example.mywork.UserProfile;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class ProfileTrans extends AppCompatActivity {

    private TextView profileNamet, profileEmailt, profilePhonet, profileBio, profileEdu, profileLang, provLang, profileF;
    private Button btnEditt;
    FirebaseAuth firebaseAuth;
    String Id;
    DatabaseReference databaseref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_translator);
        profileNamet = (TextView) findViewById(R.id.Namet);
        profileEmailt = (TextView) findViewById(R.id.Emailt);
        profilePhonet = (TextView) findViewById(R.id.Phonet);
        profileBio = (TextView) findViewById(R.id.bio);
        profileEdu = (TextView) findViewById(R.id.education);
        profileLang = (TextView) findViewById(R.id.lang);
        profileF = (TextView) findViewById(R.id.field);
        provLang = (TextView) findViewById(R.id.plang);
        btnEditt = (Button) findViewById(R.id.Editt);


        firebaseAuth = FirebaseAuth.getInstance();
        databaseref = FirebaseDatabase.getInstance().getReference();
       // FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
       // String id = user.getUid();//easy to refer


        databaseref.child("Translators").child("LWq_l8qkNYWxdy3htBT").addValueEventListener(new ValueEventListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String tbio = dataSnapshot.child("bio").getValue().toString();
                String tname = Objects.requireNonNull(dataSnapshot.child("name").getValue().toString());
                String temail = Objects.requireNonNull(dataSnapshot.child("email").getValue().toString());
                String tphone = Objects.requireNonNull(dataSnapshot.child("phone").getValue().toString());
                String edu = Objects.requireNonNull(dataSnapshot.child("education").getValue().toString());
                String field = Objects.requireNonNull(dataSnapshot.child("field").getValue().toString());
                String language = Objects.requireNonNull(dataSnapshot.child("language").getValue().toString());
                String prolang = Objects.requireNonNull(dataSnapshot.child("providedLanguage").getValue()).toString();


                profileNamet.setText(tname);
                profileEmailt.setText(temail);
                profilePhonet.setText(tphone);
                profileBio.setText(tbio);
                profileEdu.setText(edu);
                profileF.setText(field);
                profileLang.setText(language);
                provLang.setText(prolang);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(ProfileTrans.this, databaseError.getCode(), Toast.LENGTH_SHORT).show();
            }
        });


        btnEditt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ProfileTrans.this, UpdateProfile.class);
                startActivity(i);
            }
        });


    }
}