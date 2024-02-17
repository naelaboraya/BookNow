package com.myapp.booknow.business;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.myapp.booknow.R;
import com.myapp.booknow.Utils.ShowBusinessActivity;
import com.myapp.booknow.Utils.User;

import java.util.List;

/**
 * Adapter for RecyclerView to display business information.
 * This adapter handles the layout and binding of business data
 * to the views defined in the ViewHolder.
 */
public class BusinessAdapter extends RecyclerView.Adapter<BusinessAdapter.ViewHolder> {

    private List<User> businessList;

    public BusinessAdapter(List<User> businessList) {
        this.businessList = businessList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.business_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        User business = businessList.get(position);
        holder.businessName.setText(business.getName());


        Glide.with(holder.itemView)
                .load(business.getImageURL())
                        .placeholder(R.drawable.business_icon)
                                .error(R.drawable.ic_menu_gallery)//should change !!
                                        .into(holder.businessLogo);
        //we can set other attributes !
        holder.itemView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ShowBusinessActivity.class);
                intent.putExtra("businessId",business.getId());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return businessList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView businessName; // and other views
        public ImageView businessLogo;
        public ViewHolder(View view) {
            super(view);
            businessName = view.findViewById(R.id.businessName); // can replace with actual view ID
            businessLogo = view.findViewById(R.id.businessLogo);
            // Initialize other views
        }
    }


    public void setBusinesses(List<User> businesses) {
        this.businessList = businesses;
    }


}