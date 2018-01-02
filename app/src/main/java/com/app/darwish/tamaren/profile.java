package com.app.darwish.tamaren;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.security.PrivateKey;


public class profile extends Fragment {
    private ImageView profileImage;
    private Switch StudentType;
    private TextView userEmail,userName;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private String TAG = getClass().getSimpleName();

    private String email , name;
    private Uri userPhoto;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                     name = user.getDisplayName();
                     email = user.getEmail();
                     userPhoto = user.getPhotoUrl();
                } else {
                    Toast.makeText(getActivity(),"please sgn in firest",Toast.LENGTH_SHORT).show();
                    FragmentManager fragmentManager = getFragmentManager();
                    Fragment fragment = new signin();
                    fragmentManager.beginTransaction().replace(R.id.fragment,fragment).commit();

                }

            }
        };

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        profileImage = (ImageView) view.findViewById(R.id.profileLogo);
        userEmail = (TextView) view.findViewById(R.id.profileEmail);
        StudentType = (Switch) view.findViewById(R.id.profileType);
        userName=(TextView)view.findViewById(R.id.profileName);
        /***************************************************/
//        set user data
        /*********************************************************/
        try {
            userName.setText(name);
            userEmail.setText(email);
            Picasso.with(getActivity())
                    .load(userPhoto)
                    .placeholder(R.drawable.card_engag)
                    .error(R.drawable.card_engag)
                    .into(profileImage);

        }catch (NullPointerException e){
            Log.e(TAG,e.getMessage());

        }

// Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        database.getInstance().setPersistenceEnabled(true);
        DatabaseReference myRef = database.getReference("    ");
        StudentType.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    Toast.makeText(getActivity(), "now you activate arabic student mode", Toast.LENGTH_SHORT).show();


                } else {
                    Toast.makeText(getActivity(), "now you activate English student mode", Toast.LENGTH_SHORT).show();
                }
            }
        });


        return view;
    }
}
