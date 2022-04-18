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

    public Button buttonDetails;

    public EditText firstName, lastName, moduleName, moduleCode, phoneNumber;
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

        buttonDetails = findViewById(R.id.buttonDetails);

        firstName = findViewById(R.id.textEditFirstName);
        lastName = findViewById(R.id.textEditLastName);
        moduleCode = findViewById(R.id.textEditModuleCode);
        moduleName = findViewById(R.id.textEditModuleName);
        phoneNumber = findViewById(R.id.textEditPhoneNumber);

        NameInput = firstName.getText().toString();
        SurnameInput = lastName.getText().toString();
        MCodeInput = moduleCode.getText().toString();
        MNameInput = moduleName.getText().toString();
        NumberInput = phoneNumber.getText().toString();

        buttonDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                storeData(myRef);
            }
        });


    }


    public void storeData(DatabaseReference myRef)
    {
        User u = new User(currentUser.getEmail().toString(), NameInput, SurnameInput, MCodeInput, MNameInput, NumberInput);
        myRef.setValue(u);

    }

}