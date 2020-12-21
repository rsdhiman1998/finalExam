package com.example.finalexam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CountryAdapter extends BaseAdapter {
    private ArrayList<POI> places;
    LayoutInflater inflater;

    public CountryAdapter(Context context, ArrayList<POI>places1) {
        this.places = places1;
        inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return places.size();
    }

    @Override
    public Object getItem(int position) {
        return places.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = new ViewHolder();
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.rowcountry, null);
            holder.img = convertView.findViewById(R.id.image1);
            holder.name = convertView.findViewById(R.id.countryname);
            holder.price = convertView.findViewById(R.id.price1);
            convertView.setTag(holder);
        } else {
            convertView.getTag();

        }
            convertView.setTag(holder);
            int id = convertView.getResources().getIdentifier(places.get(position).p_image, "mipmap", convertView.getContext().getPackageName());
            holder.img.setImageResource(id);
            holder.name.setText(places.get(position).p_name);
            holder.price.setText(String.valueOf(places.get(position).getP_price()));
            return convertView;
    }



    static class ViewHolder
    {
        ImageView img;
        TextView name,price;
    }
}
