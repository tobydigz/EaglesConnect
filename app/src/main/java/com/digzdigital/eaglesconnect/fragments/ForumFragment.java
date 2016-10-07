package com.digzdigital.eaglesconnect.fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.digzdigital.eaglesconnect.R;
import com.digzdigital.eaglesconnect.adapters.ForumGridAdapter;
import com.digzdigital.eaglesconnect.items.Forum;

import java.util.ArrayList;

/**
 * Created by Digz on 27/08/2016.
 */
public class ForumFragment extends Fragment {
    ArrayList<Forum> forums;
    RecyclerView recyclerView;
    ForumGridAdapter forumGridAdapter;

    Context context;

    String[] forumNames =
            {
                    "Hope Foundation",
                    "James Doe",
                    "Jude Doe",
                    "Jana Sue",
                    "Ella Ekpoki",
                    "Ata Ayuwu"
            };

    int[] forumImages =
            {
                    R.mipmap.forum_image,
                    R.mipmap.james,
                    R.mipmap.jude,
                    R.mipmap.jana,
                    R.mipmap.ella,
                    R.mipmap.ata
            };

    String[] forumDescription =
            {
                    "Softcom's accuracy and timelines in delivering on large scale projects is commendable. It sets them apart from other companies offering similar services in their industry.",
                    "Lorem ipsum",
                    "Lorem ipsum",
                    "Lorem ipsum",
                    "Lorem ipsum",
                    "Lorem ipsum"
            };

    public ForumFragment() {

    }


    @Override
    public void onCreate(Bundle a) {
        super.onCreate(a);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle a) {
        View view = inflater.inflate(R.layout.fragment_recycler, container, false);
        context = getActivity();
        recyclerView = (RecyclerView) view.findViewById(R.id.itemGridList);
        generateForum();
        doRest();
        return view;
    }

    private void generateForum() {
        forums = new ArrayList<>();
        for (int i = 0; i < forumNames.length; i++) {
            String name = forumNames[i];
            String description = forumDescription[i];
            int resId = forumImages[i];
            forums.add(new Forum(name, description, resId));
        }
    }

    protected void doRest() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(linearLayoutManager);
        if (forums != null) {
            if (forums.size() > 0) {
                forumGridAdapter = new ForumGridAdapter(forums, context);
                recyclerView.setAdapter(forumGridAdapter);

                forumGridAdapter.setOnItemClickListener(new ForumGridAdapter.MyClickListener() {
                    @Override
                    public void onItemClick(int position, View v) {

                    }
                });
            }
        }

    }
}
