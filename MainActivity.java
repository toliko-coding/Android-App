package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loginButton = findViewById(R.id.bigbut);
        loginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(new Account("a", "a", "1"));
        accounts.add(new Account("sagiBiran", "aaaaaa1!", "123456789"));
        accounts.add(new Account("toliKot1", "aaaaaa1z!", "123456788"));
        accounts.add(new Account("yakiOvadia", "aaaaaa1!", "123456787"));

        EditText user = findViewById(R.id.user);
        EditText pass = findViewById(R.id.pass);
        EditText id = findViewById(R.id.id);

        if (check_details(accounts, user, pass, id)) {
            Intent intent = new Intent(this, Home.class);
            startActivity(intent);
        }
//        else {
//            Intent intent = new Intent(this, MainActivity.class);
//            startActivity(intent);
//        }
    }

    @SuppressLint("SetTextI18n")
    public boolean check_details(ArrayList<Account> accounts, EditText user, EditText pass, EditText id) {

        TextView error = findViewById(R.id.error);
        String user_t = user.getText().toString();
        String pass_t = pass.getText().toString();
        String id_t = id.getText().toString();

        int i = 0;
        while (i < accounts.size()) {
            if (accounts.get(i).username.equals(user_t)) {
                if (accounts.get(i).password.equals(pass_t)) {
                    if (accounts.get(i).id_number.equals(id_t)) {
                        return true;
                    } else {
                        error.setText("Error , invalid user id were entered");
                        return false;
                    }
                } else {
                    error.setText("Error , invalid password were entered");
                    return false;
                }
            } else {
                i++;
            }
        }
        error.setText("Error , invalid username were entered");
        return false;
    }
}




