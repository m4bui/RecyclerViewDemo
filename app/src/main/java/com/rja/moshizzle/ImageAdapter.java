package com.rja.moshizzle;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rjaylward on 11/26/16
 */

public class ImageAdapter extends RecyclerView.Adapter {

    private List<ImageItem> mItems = new ArrayList<>();
    private Context mContext;

    public ImageAdapter(Context context) {
        mContext = context;
    }

    public void setError(){
        mItems.clear();
        ImageItem headerItem = new ImageItem("No Artists found", ImageItem.TYPE_HEADER);
        mItems.add(headerItem);

        notifyDataSetChanged();
    }

    public void setItem(List<GifyApiResponse.GifyInfo> list) {
        mItems.clear();

        ImageItem headerItem = new ImageItem("images", ImageItem.TYPE_HEADER);
        mItems.add(headerItem);

        for (GifyApiResponse.GifyInfo gifyInfo : list) {
            ImageItem imageItem = new ImageItem(gifyInfo.toCellInfo(), ImageItem.TYPE_IMAGE);
            mItems.add(imageItem);
        }

        notifyDataSetChanged();
    }

    public void setBandsintownEvents(String artistName, List<BandsintownEvent> list) {
        mItems.clear();

        //set the name you searched for
        ImageItem headerItem = new ImageItem(artistName, ImageItem.TYPE_HEADER);
        mItems.add(headerItem);

        for (BandsintownEvent bandsintownEvent : list) {
            ImageItem imageItem = new ImageItem(bandsintownEvent, ImageItem.TYPE_BANDSINTOWNEVENT);
            mItems.add(imageItem);
        }

        notifyDataSetChanged();

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case ImageItem.TYPE_HEADER:
                return new HeaderViewHolder(HeaderViewHolder.inflate(mContext, parent));
            case ImageItem.TYPE_BANDSINTOWNEVENT:
            case ImageItem.TYPE_IMAGE :
                return new ImageViewHolder(ImageViewHolder.inflate(mContext, parent));
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof ImageViewHolder) {
            if(mItems.get(position).getType() == ImageItem.TYPE_IMAGE) {
                ((ImageViewHolder) holder).loadData(mItems.get(position).getCellInfo(), mContext);
            }
            else {
                ((ImageViewHolder) holder).loadBandsintownData(mItems.get(position).getBandsintownEvent(), mContext);
            }

        }
        else if(holder instanceof HeaderViewHolder) {
            ((HeaderViewHolder) holder).setTitle(mItems.get(position).getTitle());
        }
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mItems.get(position).getType();
    }
}
