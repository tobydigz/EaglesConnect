package com.digzdigital.eaglesconnect.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.digzdigital.eaglesconnect.R;

/**
 * Created by Digz on 27/08/2016.
 */
public class ProfileFragment extends Fragment {

    TextView profileName, profileYearEntry, profileYearExit, profileLocation, profileCourse, profileEmail, profilePhone, profileBirthday;
    ImageView profileImage;
    public ProfileFragment() {

    }


    @Override
    public void onCreate(Bundle a) {
        super.onCreate(a);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle a) {
        View view = inflater.inflate(R.layout.fragment_profile_view, container, false);

        findViews(view);
        Bundle data = getArguments();
        profileName.setText(data.getString("name"));
        profileYearEntry.setText(data.getString("entryYear"));
        profileYearExit.setText(data.getString("gradYear"));
        profileLocation.setText(data.getString("location"));
        profileCourse.setText(data.getString("course"));
        profileEmail.setText(data.getString("email"));
        profilePhone.setText(data.getString("phone"));
        profileBirthday.setText(data.getString("birthday"));
        profileImage.setImageResource(data.getInt("image"));
        return view;
    }

    private void findViews(View view) {
        profileName = (TextView) view.findViewById(R.id.profileName);
        profileYearEntry = (TextView) view.findViewById(R.id.profileYearOfEntry);
        profileYearExit = (TextView) view.findViewById(R.id.profileYear);
        profileLocation = (TextView) view.findViewById(R.id.profileLocation);
        profileCourse = (TextView) view.findViewById(R.id.profileCourse);
        profileEmail = (TextView) view.findViewById(R.id.profileEmail);
        profilePhone = (TextView) view.findViewById(R.id.profilePhone);
        profileBirthday = (TextView) view.findViewById(R.id.profileBirthday);
        profileImage = (ImageView) view.findViewById(R.id.profileImage);
    }

}
