package com.kunal.quiz_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;



public class UserData extends AppCompatActivity {

    public Button DetailsBt;
    public EditText FirstName, LastName, ModuleName, ModuleCode, PhoneNumber;
    public String NameInput, SurnameInput, MNameInput, MCodeInput, NumberInput;
    public FirebaseUser currentUser;
    public FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("users");


        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();



        DetailsBt = findViewById(R.id.details_bt);
        FirstName = findViewById(R.id.firstName);
        LastName = findViewById(R.id.lastName);
        ModuleCode = findViewById(R.id.moduleCode);
        ModuleName = findViewById(R.id.moduleName);
        PhoneNumber = findViewById(R.id.phoneNumber);

        DetailsBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NameInput = FirstName.getText().toString();
                SurnameInput = LastName.getText().toString();
                MCodeInput = ModuleCode.getText().toString();
                MNameInput = ModuleName.getText().toString();
                NumberInput = PhoneNumber.getText().toString();


                User u = new User(currentUser.getEmail().toString(), NameInput, SurnameInput, MCodeInput, MNameInput, NumberInput);



                myRef.setValue(u);
            }
        });
    }
}