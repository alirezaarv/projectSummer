package com.q20.projectsummer.ui;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.q20.projectsummer.R;

public class RegisterPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);


        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.register_page_fragment_container, new RegisterSignInORLogInFragment());
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.commit();
    }

    private void switchFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.register_page_fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.commit();
    }

    public void onFirstSignInClicked(View view){
        switchFragment(new RegisterChooseProfileImageFragment());
    }

    public void onSecondSignInClicked(View view){
        // TODO a page with just username and password for logging in
    }

    public void onMaleRegisterProfileImageClicked(View view){
        ImageView imageView = (ImageView)findViewById(R.id.profile_image);
        imageView.setImageResource(R.drawable.char_m_40);
        imageView.setTag(R.drawable.char_m_40);
    }

    public void onFemaleRegisterProfileImageClicked(View view){
        ImageView imageView = (ImageView)findViewById(R.id.profile_image);
        imageView.setImageResource(R.drawable.char_f_15);
        imageView.setTag(R.drawable.char_f_15);
    }

    public void onChooseProfileNextPageClicked(View view){
        ImageView imageView = (ImageView)findViewById(R.id.profile_image);
        Bundle bundle = new Bundle();
        bundle.putInt("ID", (Integer) imageView.getTag());
        RegisterChooseUserNameFragment fragment = new RegisterChooseUserNameFragment();
        fragment.setArguments(bundle);
        switchFragment(fragment);
    }

    public void onChooseUsernameClicked(View view){
        EditText editText = (EditText)findViewById(R.id.register_username_page_edit_text);
        ImageView imageView = (ImageView)findViewById(R.id.register_username_profile_image);

        Bundle b = new Bundle();
        b.putInt("ID", (int) imageView.getTag());
        b.putString("USER_NAME", String.valueOf(editText.getText()));

        RegisterChoosePasswordFragment fragment = new RegisterChoosePasswordFragment();
        fragment.setArguments(b);
        switchFragment(fragment);
    }

    public void onChoosePasswordClicked(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
