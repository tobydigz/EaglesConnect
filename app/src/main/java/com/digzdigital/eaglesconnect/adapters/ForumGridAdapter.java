package com.digzdigital.eaglesconnect.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.digzdigital.eaglesconnect.R;
import com.digzdigital.eaglesconnect.items.Forum;
import com.digzdigital.eaglesconnect.items.Person;

import java.util.ArrayList;

import io.realm.RealmResults;

/**
 * Created by Digz on 12/05 /2016. f
 */
public class ForumGridAdapter extends RecyclerView.Adapter<ForumGridAdapter.ViewHolder> {
    private static MyClickListener myClickListener;
    ArrayList<Forum> forums;
    Context context;

    public ForumGridAdapter(ArrayList<Forum> forums, Context context) {
        this.forums = forums;
        this.context = context;
    }

    public Forum getItem(int position) {
        return forums.get(position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_forum, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Forum forum = getItem(position);

        holder.forumName.setText(forum.getName());
        holder.forumDescription.setText(forum.getDescription());
        holder.forumImage.setImageResource(forum.getImageResId());

        /*byte[] image = null;
        Bitmap bitmap = null;
        image = person.getImage();
        if (image != null){
            BitmapFactory.Options options = new BitmapFactory.Options();
            bitmap = BitmapFactory.decodeByteArray(image, 0, image.length, options); //Convert bytearray to bitmap
            //for performance free the memmory allocated by the bytearray and the blob variable
            image = null;
            if (bitmap != null) {
                holder.contactImage.setImageBitmap(bitmap);
                System.out.println("bitmap is not null");
            } else {
                System.out.println("bitmap is null");
            }
        }
*/



//        holder.viewDate.setText(devotional.getDate());


    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getItemCount() {
        return forums.size();
    }


    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CardView cv;
        TextView forumName, forumDescription;
        ImageView forumImage;
        ViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.forumCard);
            forumName = (TextView) itemView.findViewById(R.id.forumName);
            forumDescription = (TextView) itemView.findViewById(R.id.forumDescription);
            forumImage = (ImageView) itemView.findViewById(R.id.forumImage);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            myClickListener.onItemClick(getAdapterPosition(), v);

        }


    }
    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }
}
