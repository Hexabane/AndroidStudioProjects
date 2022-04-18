package learnprogramming.academy.quizappv2;

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

    //Button variable created to assign UI button
    public Button buttonDetails;

    //Edit Text related variables
    public EditText firstName, lastName, moduleName, moduleCode, phoneNumber;
    public String NameInput, SurnameInput, MNameInput, MCodeInput, NumberInput;

    //Firebase Auth
    public FirebaseUser currentUser;
    public FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data);

        //Firebase Database instance and setting reference
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("users");

        //Firebase Auth and User Auth
        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();

        //assigning button variable to UI button by ID
        buttonDetails = findViewById(R.id.buttonDetails);

        //assigning all text variables to UI edit text by ID
        firstName = findViewById(R.id.textEditFirstName);
        lastName = findViewById(R.id.textEditLastName);
        moduleCode = findViewById(R.id.textEditModuleCode);
        moduleName = findViewById(R.id.textEditModuleName);
        phoneNumber = findViewById(R.id.textEditPhoneNumber);

        //initializing string variables to text input
        NameInput = firstName.getText().toString();
        SurnameInput = lastName.getText().toString();
        MCodeInput = moduleCode.getText().toString();
        MNameInput = moduleName.getText().toString();
        NumberInput = phoneNumber.getText().toString();

        //storing data into firebase realtime database
        buttonDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                storeData(myRef);
            }
        });


    }


    //method that stores the data to firebase realtime database
    public void storeData(DatabaseReference myRef)
    {//start of storeData() method
        User u = new User(currentUser.getEmail().toString(), NameInput, SurnameInput, MCodeInput, MNameInput, NumberInput);
        myRef.setValue(u);

    }//end of storeData() method

}