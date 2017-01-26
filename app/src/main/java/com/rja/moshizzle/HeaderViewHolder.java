package com.rja.moshizzle;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by michellebui on 1/25/17
 */

public class HeaderViewHolder extends RecyclerView.ViewHolder {

    private TextView mTitle;

    public static View inflate(Context context, ViewGroup root) {
        return LayoutInflater.from(context).inflate(R.layout.cell_image_header, root, false);
    }

    public HeaderViewHolder(View itemView) {
        super(itemView);

        mTitle = (TextView) itemView.findViewById(R.id.cih_title);
    }

    public void setTitle(String title) {
        mTitle.setText(title);
    }
}
