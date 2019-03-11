package com.example.mywork;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
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
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Profile extends AppCompatActivity {

    private TextView profileName,profileEmail,profilePhone ;
    private Button btnEdit ;
    FirebaseAuth firebaseAuth;
    String Id ;
    DatabaseReference databaseref ;




    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        profileName =(TextView)findViewById(R.id.Name) ;
        profileEmail = (TextView)findViewById(R.id.Email) ;
        profilePhone = (TextView)findViewById(R.id.Phone) ;
        btnEdit=(Button)findViewById(R.id.Edit) ;



        FirebaseApp.initializeApp(this) ;
        databaseref = FirebaseDatabase.getInstance().getReference("Customers");
       // FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
       // String id = user.getUid();//easy to refer




        databaseref.child("Customers").child("591ZDiaEyfUWM73I8EP7UoxqwSd2").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String fname = dataSnapshot.child("Name").getValue().toString();
                String cemail = dataSnapshot.child("email").getValue().toString();
                String cphone = dataSnapshot.child("phone").getValue().toString();

                profileName.setText(fname);
                profileEmail.setText(cemail);
                profilePhone.setText(cphone);



            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(Profile.this, "please make sure you are connected to firebase ", Toast.LENGTH_LONG).show();

            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Profile.this, UpdateProfile.class);
                startActivity(i);
            }


        });


    }


}
