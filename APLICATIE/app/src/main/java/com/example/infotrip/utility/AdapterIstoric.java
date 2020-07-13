package com.example.infotrip.utility;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.infotrip.R;

import org.w3c.dom.Text;

import java.util.List;

public  class AdapterIstoric  extends RecyclerView.Adapter<AdapterIstoric.myViewHolder>{


    Context mcontext;
    List<Item> mData;

    public AdapterIstoric(Context mcontext, List<Item> mData) {
        this.mcontext = mcontext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(mcontext);
        View v= inflater.inflate(R.layout.card_item,parent,false);
        return new myViewHolder(v);
    }

    @Override
    public void onBindViewHolder(myViewHolder holder, int position) {
        holder.background_image.setImageBitmap(mData.get(position).getBackground());
        holder.profile_photo.setImageResource(mData.get(position).getProfilePhoto());
        holder.tv_title.setText(mData.get(position).getProfile_name());
        holder.tv_review.setText(mData.get(position).getRating()+" Rating");

    }


    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class  myViewHolder extends  RecyclerView.ViewHolder{

        ImageView profile_photo,background_image;
        TextView tv_title,tv_review;

        public myViewHolder(View itemView){
            super(itemView);

            profile_photo=itemView.findViewById(R.id.imageViewIconLocatieIstoric);
            background_image=itemView.findViewById(R.id.imageViewImagineIstoric);
            tv_title=itemView.findViewById(R.id.textViewDenumireLocatie);
            tv_review=itemView.findViewById(R.id.textViewRating);



        }
    }
}
