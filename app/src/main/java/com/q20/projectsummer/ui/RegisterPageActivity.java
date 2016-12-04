package com.q20.projectsummer.ui;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Path;
import android.media.Image;
import android.os.Build;
import android.support.annotation.StringDef;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.q20.projectsummer.Custom.CustomActivity;
import com.q20.projectsummer.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.Writer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.LinkedList;

import Game.Player;

public class RegisterPageActivity extends CustomActivity {


    static private File userName;
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        RegisterSignInORLogInFragment fragment = new RegisterSignInORLogInFragment();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.register_page_fragment_container, fragment);
        fragment.setEnterTransition(setupWindowAnimations());
        fragmentTransaction.commit();

        //for initializing activity animation
        //setupWindowAnimations();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void switchFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.register_page_fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        //fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);

        //TODO destroy fragment after next fragment completely come
        fragment.setEnterTransition(setupWindowAnimations());
        fragmentTransaction.commit();
    }

    public void onFirstSignInClicked(View view){
        switchFragment(new RegisterChooseProfileImageFragment());
    }

    public void onSecondSignInClicked(View view){
        // TODO a page with just username and password for logging in
        Toast.makeText(getApplicationContext(), "This will be available in the future :|", Toast.LENGTH_SHORT).show();
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

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void onChooseProfileNextPageClicked(View view){
        ImageView imageView = (ImageView)findViewById(R.id.profile_image);
        Bundle bundle = new Bundle();
        bundle.putInt("ID", (Integer) imageView.getTag());
        RegisterChooseUserNameFragment fragment = new RegisterChooseUserNameFragment();
        fragment.setArguments(bundle);
        switchFragment(fragment);

//        ChangeBounds changeBounds = (ChangeBounds) TransitionInflater.from(this).inflateTransition(R.transition.change);
//        fragment.setEnterTransition(setupWindowAnimations());
//        fragment.setSharedElementEnterTransition(changeBounds);
//        getFragmentManager().beginTransaction()
//                .replace(R.id.register_page_fragment_container, fragment)
//                .addSharedElement(imageView, "transition")
//                .commit();
    }

    public void onChooseUsernameClicked(View view){
        EditText editText = (EditText)findViewById(R.id.register_username_page_edit_text);
        ImageView imageView = (ImageView)findViewById(R.id.register_username_profile_image);
        String username = String.valueOf(editText.getText());
        File cachDir = getCacheDir();

        userName = new File(cachDir, editText.getText()+".dat");
        Bundle b = new Bundle();
        b.putInt("ID", (int) imageView.getTag());
        b.putString("USER_NAME", username);
        b.putString("USER_NAME_FILE", username);

        RegisterChoosePasswordFragment fragment = new RegisterChoosePasswordFragment();
        fragment.setArguments(b);
        if (username.equals("")){
            Toast.makeText(this, "Please enter your username", Toast.LENGTH_SHORT).show();
        }else {
            switchFragment(fragment);
        }
    }

    public void onChoosePasswordClicked(View view){
        Intent intent = new Intent(this, MainActivity.class);
        ImageView imageView = (ImageView)findViewById(R.id.register_password_profile_image);
        TextView textView = (TextView)findViewById(R.id.register_password_page_username_text_view);
        EditText first_password = (EditText)findViewById(R.id.first_register_password);
        EditText second_password = (EditText)findViewById(R.id.second_register_password);

        if (String.valueOf(first_password.getText()).equals(String.valueOf(second_password.getText()))) {
            byte byteData[] = null;
            try {
                MessageDigest md5 = MessageDigest.getInstance("MD5");
                md5.update(String.valueOf(second_password.getText()).getBytes());

                byteData = md5.digest();
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                FileOutputStream outputStream = new FileOutputStream(userName);
                outputStream.write(byteData);
                outputStream.flush();
                outputStream.close();
            } catch (Exception e) {
            }


            intent.putExtra("ID", (int) imageView.getTag());
            intent.putExtra("USER_NAME", String.valueOf(textView.getText()));

            Player player = new Player();
            player.currentGame = null;
            player.coins = 100;
            player.username = String.valueOf(textView.getText());
            player.profileImageID = (Integer) imageView.getTag();

            MainActivity.player = player;
            MainActivity.playerSave(getCacheDir());

            startActivity(intent,
                    ActivityOptionsCompat.makeSceneTransitionAnimation(this, null).toBundle());
            finish();
        }else {
            Toast.makeText(getApplicationContext(), "your passwords isn't equal", Toast.LENGTH_SHORT);
        }
    }

    @TargetApi(21)
    private Slide setupWindowAnimations(){
        Slide slide = new Slide(Gravity.START);
        slide.setDuration(800);
        return slide;
    }
}
