package learnprogramming.academy.quizappv2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    //Variables initialized for buttons, Text Edits and Firebase Authentication.
    public Button buttonLogin, buttonRegister;
    public EditText etUsername, etPassword;
    private FirebaseAuth mAuth;
    private FirebaseUser currentUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Getting current firebase instance
        mAuth = FirebaseAuth.getInstance();
//        currentUser = mAuth.getCurrentUser();

        //Setting Text Edit variables with the ones in the UI.
        etUsername = findViewById(R.id.textEditUsername);
        etPassword = findViewById(R.id.textEditPassword);


        //Setting login and register button with the ones in the UI.
        buttonLogin = findViewById(R.id.buttonLogin);
        buttonRegister = findViewById(R.id.buttonRegister);


        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login();
            }
        });

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Register();
            }
        });


    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();

    }

    public void Login() { //start of Login() Method

        //getting Text from edit text fields
        String email = etUsername.getText().toString();
        String password = etPassword.getText().toString();


        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    // Sign in success, update UI with the signed-in user's information
                    Toast.makeText(MainActivity.this, "Success",
                            Toast.LENGTH_SHORT).show();

                    currentUser = mAuth.getCurrentUser();
                    Intent i = new Intent(MainActivity.this, UserData.class);
                    startActivity(i);

                } else {
                    // If sign in fails, display a message to the user.
                    currentUser = null;
                    Toast.makeText(MainActivity.this, "Authentication failed.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

    }//end of Login() method


    public void Register() { //start of Register() Method

        String email = etUsername.getText().toString();
        String password = etPassword.getText().toString();

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "Success",
                    Toast.LENGTH_SHORT).show();
                    // Sign in success, update UI with the signed-in user's information
                    currentUser = mAuth.getCurrentUser();
                    Intent i = new Intent(MainActivity.this, UserData.class);
                    startActivity(i);
                } else {
                    // If sign in fails, display a message to the user.
                    currentUser = null;
                    Toast.makeText(MainActivity.this, "Authentication failed.",
                    Toast.LENGTH_SHORT).show();
                }
            }
        });

    } //end of Register() Method

}