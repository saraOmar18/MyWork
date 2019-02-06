package com.example.mywork;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UpdateProfileT extends AppCompatActivity {
    private EditText newName, newEmail, newPhone,newBio,newF,newLang,newP,newE;
    private Button savet;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_translator);


        newName = findViewById(R.id.NameUpdatet);
        newEmail = findViewById(R.id.EmailUpdatet);
        newPhone = findViewById(R.id.UpdatePhonet);
        savet = findViewById(R.id.btnSavet);
        newBio=findViewById(R.id.updateBio);
        newF=findViewById(R.id.updateField);
        newLang=findViewById(R.id.updateLang);
        newP=findViewById(R.id.updateProvide);
        newE=findViewById(R.id.updateEdu);



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();


        final DatabaseReference databaseReference = firebaseDatabase.getReference(firebaseAuth.getUid());

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Translator t = dataSnapshot.getValue(Translator.class);
                newName.setText(t.getName());
                newEmail.setText(t.getEmail());
                newPhone.setText(t.getPhone());
                newBio.setText(t.getBio());
                newF.setText(t.getField());
                newLang.setText(t.getLanguage());
                newE.setText(t.getEducation());
                newP.setText(t.getProvidedLanguage());

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(UpdateProfileT.this, databaseError.getCode(), Toast.LENGTH_SHORT).show();
            }
        });

        savet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = newName.getText().toString();
                String email = newEmail.getText().toString();
                String phone = newPhone.getText().toString();
                String bio=newBio.getText().toString();
                String language=newLang.getText().toString();
                String planguage=newP.getText().toString();
                String field=newF.getText().toString();
                String education=newE.getText().toString();




                Translator usert = new Translator(name,0,language,field,bio,education,planguage,email,phone);

                databaseReference.setValue(usert);
                finish();
            }


        });

    }



}
