package com.rja.moshizzle;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import static com.bumptech.glide.load.engine.DiskCacheStrategy.SOURCE;

/**
 * Created by rjaylward on 11/26/16
 */

public class ImageViewHolder extends RecyclerView.ViewHolder {

    private ImageView profileImage;
    private TextView nameView;
    private ImageView mainImage;
    private View profileLayout;

    public static View inflate(Context context, ViewGroup root) {
        return LayoutInflater.from(context).inflate(R.layout.instagram_cell, root, false);
    }

    public ImageViewHolder(View itemView) {
        super(itemView);

        profileLayout = itemView.findViewById(R.id.profile_layout);
        profileImage = (ImageView) itemView.findViewById(R.id.profile_image);
        nameView = (TextView) itemView.findViewById(R.id.profile_name);
        mainImage = (ImageView) itemView.findViewById(R.id.main_image);
    }

    public void loadData(final CellInfo data, final Context context) {
        Log.d("ImageViewHolder", data.toString());

        Glide.with(context).load(data.getMainUrl())
                .diskCacheStrategy(SOURCE)
                .placeholder(R.mipmap.ic_launcher)
                .into(mainImage);

        Glide.with(context).load(data.getProfileImageUrl())
                .centerCrop()
                .into(profileImage);

        nameView.setText(data.getName());
    }

    public void loadBandsintownData(final BandsintownEvent event, final Context context) {
        //check array not null and empty
        if (event.getArtists() != null && !event.getArtists().isEmpty()) {
            BandsintownArtist artist = event.getArtists().get(0);
            Glide.with(context).load(artist.getThumbUrl())
                    .diskCacheStrategy(SOURCE)
                    .placeholder(R.mipmap.ic_launcher)
                    .into(mainImage);

            Glide.with(context).load(artist.getImageUrl())
                    .centerCrop()
                    .into(profileImage);

        }
        nameView.setText(event.getTitle());
    }
}
