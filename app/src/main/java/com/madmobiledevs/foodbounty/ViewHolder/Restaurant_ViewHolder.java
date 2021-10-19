package com.madmobiledevs.foodbounty.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.madmobiledevs.foodbounty.Interface.ItemClickListener;
import com.madmobiledevs.foodbounty.R;

public class Restaurant_ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private ItemClickListener itemClickListener;

    public TextView restName_TxtVw, restDetails_TxtVw, rest_Address_TxtVw;
    public ImageView rest_ImgVw;

    public RelativeLayout main_Rel1;
    public CardView cardView;

    public Restaurant_ViewHolder(@NonNull View itemView) {
        super(itemView);

        restName_TxtVw = itemView.findViewById(R.id.name_Restrent);
        restDetails_TxtVw = itemView.findViewById(R.id.details_Restrnt);
        rest_Address_TxtVw = itemView.findViewById(R.id.address_Restrnt);

        main_Rel1 = itemView.findViewById(R.id.main_Rel1);

        cardView = itemView.findViewById(R.id.card_view_main);
        rest_ImgVw = itemView.findViewById(R.id.restaurent_Img);
    }

    @Override
    public void onClick(View v) {

    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
}
