package com.example.mywork;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class UpdateProfile extends AppCompatActivity {

    private EditText newName,newEmail,newPhone ;
    private Button save ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);


        newName = findViewById(R.id.NameUpdate) ;
        newEmail = findViewById(R.id.EmailUpdate) ;
        newPhone = findViewById(R.id.UpdatePhone) ;
        save = findViewById(R.id.btnSave) ;

    }
}
