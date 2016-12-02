package com.q20.projectsummer.ui;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.media.Image;
import android.os.Build;
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

public class RegisterPageActivity extends CustomActivity {

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
        //switchFragment(fragment);

        ChangeBounds changeBounds = (ChangeBounds) TransitionInflater.from(this).inflateTransition(R.transition.change);
        fragment.setEnterTransition(setupWindowAnimations());
        fragment.setSharedElementEnterTransition(changeBounds);
        getFragmentManager().beginTransaction()
                .replace(R.id.register_page_fragment_container, fragment)
                .addSharedElement(imageView, "transition")
                .commit();
    }

    public void onChooseUsernameClicked(View view){
        EditText editText = (EditText)findViewById(R.id.register_username_page_edit_text);
        ImageView imageView = (ImageView)findViewById(R.id.register_username_profile_image);
        String username = String.valueOf(editText.getText());
        Bundle b = new Bundle();
        b.putInt("ID", (int) imageView.getTag());
        b.putString("USER_NAME", username);

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
        //TODO send imageView tags and profile name to next activity
        ImageView imageView = (ImageView)findViewById(R.id.register_password_profile_image);
        TextView textView = (TextView)findViewById(R.id.register_password_page_username_text_view);

        intent.putExtra("ID", (int) imageView.getTag());
        intent.putExtra("USER_NAME", String.valueOf(textView.getText()));
        startActivity(intent,
                ActivityOptionsCompat.makeSceneTransitionAnimation(this, null).toBundle());
    }
    @TargetApi(21)
    private Slide setupWindowAnimations(){
        Slide slide = new Slide(Gravity.START);
        slide.setDuration(800);
        return slide;
    }
}
