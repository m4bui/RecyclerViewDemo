package com.rja.moshizzle;

import android.support.annotation.Nullable;

/**
 * Created by michellebui on 1/25/17.
 */

public class ImageItem {

    public static final int TYPE_IMAGE = 1;
    public static final int TYPE_HEADER = 2;

    public static final int TYPE_BANDSINTOWNEVENT = 3;

    private String mTitle;
    private CellInfo mCellInfo;
    private int mType;
    private BandsintownEvent mBandsintownEvent;

    public ImageItem(@Nullable CellInfo cellInfo, int type) {
        mCellInfo = cellInfo;
        mType = type;
    }

    public ImageItem(@Nullable String cellTitle, int type) {
        mTitle = cellTitle;
        mType = type;
    }

    public ImageItem(@Nullable BandsintownEvent event, int type){
        mBandsintownEvent = event;
        mType = type;
    }
    public CellInfo getCellInfo() {
        return mCellInfo;
    }

    public int getType() {
        return mType;
    }

    public String getTitle() {
        return mTitle;
    }

    public BandsintownEvent getBandsintownEvent() {
        return mBandsintownEvent;
    }




}
