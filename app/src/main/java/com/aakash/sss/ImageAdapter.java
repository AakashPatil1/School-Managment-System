package com.aakash.sss;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    public ImageAdapter(Context c) {
        mContext = c;
    }

    @Override
    public int getCount() {
        return imageIDs.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(1000, 450));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(imageIDs[i]);

        return imageView;
    }

    public  Integer[] imageIDs = {
            R.drawable.sindhutaisapkal01,R.drawable.sindhutaisapkal02,R.drawable.sindhutaisapkal03,
            R.drawable.sindhutaisapkal04,R.drawable.sindhutaisapkal05,R.drawable.sindhutaisapkal06,
            R.drawable.sindhutaisapkal07,R.drawable.sindhutaisapkal08,
    };
}

