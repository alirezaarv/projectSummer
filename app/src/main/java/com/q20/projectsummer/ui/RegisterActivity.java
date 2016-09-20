package com.q20.projectsummer.ui;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.q20.projectsummer.R;

public class RegisterActivity extends AppCompatActivity {

    Button logInButton;
    Button signInButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        logInButton = (Button)findViewById(R.id.log_in_button);
        signInButton = (Button)findViewById(R.id.sign_in_button);

        changeFragment(new SignInFragment());
    }

    public void onLogInClicked(View view){
        changeFragment(new LogInFragment());
    }

    public void onSignInClicked(View view){
        changeFragment(new SignInFragment());
    }

    private void changeFragment(Fragment fragment){

        //TODO change color of buttons when clicked
//        if (fragment instanceof SignInFragment){
//            logInButton.setBackgroundColor(Color.rgb( 243, 156, 18));
//            signInButton.setBackgroundColor(Color.rgb(241, 196, 15));
//        }else if (fragment instanceof LogInFragment){
//            signInButton.setBackgroundColor(Color.rgb( 243, 156, 18));
//            logInButton.setBackgroundColor(Color.rgb(241, 196, 15));
//        }
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.register_fragment_container, fragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.commit();
    }
}
