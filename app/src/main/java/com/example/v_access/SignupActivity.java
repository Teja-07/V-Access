package com.example.v_access;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.prefs.Preferences;

public class SignupActivity extends AppCompatActivity {
    public static final String PREFS_NAME = "MyPrefsFile";
    Button login,skip;
    EditText emailedit_text,passwordedittext;
    SharedPreferences sp;

    private  FirebaseDatabase db=FirebaseDatabase.getInstance();
    private DatabaseReference root=db.getReference();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_signup);
        login=findViewById(R.id.Loginbutton);
        emailedit_text=findViewById(R.id.emailedit_text);
        passwordedittext=findViewById(R.id.passwordedittext);
        SharedPreferences preferences=getSharedPreferences("checkbox",MODE_PRIVATE);
        String checkbox=preferences.getString("remember","");

        sp = getSharedPreferences("login",MODE_PRIVATE);

        if(sp.getBoolean("logged",false)){
            goToMainActivity();
        }
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail =emailedit_text.getText().toString();
               String password=passwordedittext.getText().toString();
               HashMap<String,String> usermap=new HashMap<>();
               usermap.put("mail",mail);
               usermap.put("password",password);
               root.push().setValue(usermap);

                sp.edit().putBoolean("logged",true).apply();

                 if (emailedit_text.getText().length() > 0 && passwordedittext.getText().length() > 0) {
                     goToMainActivity();
                        Toast.makeText(getApplicationContext(), "loading..", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(getApplicationContext(), "field is Empty", Toast.LENGTH_SHORT).show();
                    }
                }

        });

        }
    public void goToMainActivity(){
        Intent i = new Intent(SignupActivity.this,stepCount.class);
        startActivity(i);
        finish();
    }


}