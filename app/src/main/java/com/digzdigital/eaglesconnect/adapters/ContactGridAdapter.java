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
import com.digzdigital.eaglesconnect.items.Person;

import java.util.ArrayList;

import io.realm.RealmResults;

/**
 * Created by Digz on 12/05 /2016. f
 */
public class ContactGridAdapter extends RecyclerView.Adapter<ContactGridAdapter.ViewHolder> {
    private static MyClickListener myClickListener;
    ArrayList<Person> persons;
    Context context;

    public ContactGridAdapter(ArrayList<Person> persons, Context context) {
        this.persons = persons;
        this.context = context;
    }

    public Person getItem(int position) {
        return persons.get(position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragments_contact, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Person person = getItem(position);

        holder.contactName.setText(person.getName());
        holder.contactImage.setImageResource(person.getImageResId());

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
        return persons.size();
    }


    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CardView cv;
        TextView contactName;
        ImageView contactImage;
        ViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.contactCard);
            contactName = (TextView) itemView.findViewById(R.id.contactName);
            contactImage = (ImageView) itemView.findViewById(R.id.contactImage);
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
