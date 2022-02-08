package com.application.potometeo;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomGridAdapter extends BaseAdapter {

    private List<Display> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomGridAdapter(Context aContext, List<Display> listData) {
        this.context = aContext;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.grid_item_layout, null);
            holder = new ViewHolder();
            holder.displayImg = (ImageView) convertView.findViewById(R.id.imageView_displayImg);
            holder.nameImg = (TextView) convertView.findViewById(R.id.textView_nameImg);
            holder.clothes = (TextView) convertView.findViewById(R.id.textView_clothes);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Display display = this.listData.get(position);
        holder.nameImg.setText(display.getNameImg());
        holder.clothes.setText("" + display.getClothes());

        int imageId = this.getDrawableResIdByName(display.getLinkImg());

        holder.displayImg.setImageResource(imageId);
        holder.displayImg.setContentDescription("choisir une " + display.getNameImg());

        return convertView;
    }

    // Find Image ID corresponding to the name of the image (in the directory mipmap).
    public int getDrawableResIdByName(String resName) {
        String pkgName = context.getPackageName();

        // Return 0 if not found.
        int resID = context.getResources().getIdentifier(resName, "drawable", pkgName);
        Log.i("CustomGridView", "Res Name: " + resName + "==> Res ID = " + resID);
        return resID;
    }

    static class ViewHolder {
        ImageView displayImg;
        TextView nameImg;
        TextView clothes;
    }

}