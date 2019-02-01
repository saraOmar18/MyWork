package com.example.mywork;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Profile extends AppCompatActivity {

    private TextView profileName,profileEmail,profilePhone ;
    private Button btnEdit ;
    private FirebaseAuth firebaseAuth ;
    private FirebaseDatabase firebaseDatabase ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        profileName = findViewById(R.id.Name) ;
        profileEmail = findViewById(R.id.Email) ;
        profilePhone = findViewById(R.id.Phone) ;
        btnEdit = findViewById(R.id.Edit) ;

        firebaseAuth = FirebaseAuth.getInstance() ;
        firebaseDatabase = FirebaseDatabase.getInstance() ;

        DatabaseReference databaseReference = firebaseDatabase.getReference(firebaseAuth.getUid()) ;
        databaseReference.AddValueEventListener(new ValueEventListener()) {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot){
             Profile userprofile = dataSnapshot.getValue(Profile.class) ;
            }
            @Override
            public void onCancelled(DatabaseError databaseError){


            }



        }






    }
}
