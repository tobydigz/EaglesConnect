package com.digzdigital.eaglesconnect.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.digzdigital.eaglesconnect.MainActivity;
import com.digzdigital.eaglesconnect.R;
import com.digzdigital.eaglesconnect.adapters.ContactGridAdapter;
import com.digzdigital.eaglesconnect.items.Person;

import java.util.ArrayList;

/**
 * Created by Digz on 27/08/2016.
 */
public class ContactsFragment extends Fragment {
    ArrayList<Person> persons;
    RecyclerView recyclerView;
    ContactGridAdapter contactGridAdapter;

    Context context;

    String[] contactNames = {"John Doe", "James Doe", "Jude Doe", "Jana Sue", "Ella Ekpoki", "Ata Ayuwu"};

    int[] contactImages = {R.mipmap.profile_image, R.mipmap.james, R.mipmap.jude, R.mipmap.jana, R.mipmap.ella, R.mipmap.ata};

    String[] contactEntryYear = {"2011" , "2012", "2010", "2011", "2013", "2011"};
    String[] contactExitYear = {"2015" , "2017", "2015", "2016", "2018", "2016"};
    String[] contactLocation = {"Port-Harcourt, Nigeria" , "Lagos, Nigeria", "Lagos, Nigeria", "Ibadan, Nigeria", "Jos, Nigeria", "Lagos, Nigeria"};
    String[] contactCourse = {"CIS" , "EEE", "CVE", "MECH", "ICE", "CEN"};
    String[] contactEmail = {"johndoe@gmail.com" , "", "", "", "ekpoki.naomi@gmail.com", ""};
    String[] contactPhone = {"112233" , "", "", "", "08104541804", ""};
    String[] contactBirthday = {"21st, January" , "3rd, May", "15th, April", "29th, March", "12th, December", "24th, June"};


    public ContactsFragment() {

    }



    @Override
    public void onCreate(Bundle a) {
        super.onCreate(a);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle a) {
        View view = inflater.inflate(R.layout.fragment_recycler, container, false);
        context = getActivity();
        recyclerView = (RecyclerView) view.findViewById(R.id.itemGridList);
        generatePersons();
        doRest();
        return view;
    }

    private void generatePersons() {
        persons = new ArrayList<>();
        for(int i = 0; i<contactNames.length; i++){
            String name = contactNames[i];
            int resId = contactImages[i];
            String entryYear = contactEntryYear[i];
            String exitYear = contactExitYear[i];
            String location = contactLocation[i];
            String course = contactCourse[i];
            String email = contactEmail[i];
            String phone = contactPhone[i];
            String birthday = contactBirthday[i];
            persons.add(new Person(name, entryYear, exitYear, location, course, email, phone, resId, birthday));
        }
    }

    protected void doRest() {
            GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 2);
            recyclerView.setLayoutManager(gridLayoutManager);
            if (persons !=null){
                if (persons.size()>0){
                    contactGridAdapter = new ContactGridAdapter(persons, context);
                    recyclerView.setAdapter(contactGridAdapter);

                    contactGridAdapter.setOnItemClickListener(new ContactGridAdapter.MyClickListener() {
                        @Override
                        public void onItemClick(int position, View v) {
                            MainActivity mainActivity = (MainActivity) getActivity();
                            Person person = persons.get(position);
                            String name = person.getName();
                            String entryYear = person.getEntryYear();
                            String gradYear = person.getExitYear();
                            String location = person.getLocation();
                            String course = person.getCourse();
                            String email = person.getEmail();
                            String phone = person.getPhone();
                            int resId = person.getImageResId();
                            String birthday = person.getBirthday();
                            mainActivity.updateContactFragment(name, entryYear, gradYear, location, course, email, phone, resId, birthday);

                        }
                    });
                }
        }

    }
}
