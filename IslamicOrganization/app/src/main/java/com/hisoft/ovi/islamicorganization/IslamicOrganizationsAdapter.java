package com.hisoft.ovi.islamicorganization;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Invariant on 10/8/17.
 */

public class IslamicOrganizationsAdapter extends RecyclerView.Adapter<IslamicOrganizationsAdapter.ViewHolder> {
    private Context context;
    private List<GooglePlaces> googlePlaces;

    public IslamicOrganizationsAdapter(Context context, List<GooglePlaces> googlePlaces) {
        this.context = context;
        this.googlePlaces = googlePlaces;
    }

    @Override
    public IslamicOrganizationsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.islamic_organization_layout, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(IslamicOrganizationsAdapter.ViewHolder holder, int position) {
        GooglePlaces place = googlePlaces.get(position);
        if(place.getPhotos()!=null){
            Picasso.with(context).load("https://maps.googleapis.com/maps/api/place/photo?maxwidth="+place.getPhotos().get(0).getWidth()+"&photoreference="+place.getPhotos().get(0).getPhoto_reference()+"&sensor=false&key="+context.getResources().getString(R.string.API_KEY)).into(holder.images);
        }else{
            Picasso.with(context).load(place.getIcon()).into(holder.images);

        }
        holder.nameTextView.setText(place.getName());
        holder.addressTextView.setText(place.getVicinity());
    }

    @Override
    public int getItemCount() {
        return googlePlaces.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView images;
        private TextView nameTextView;
        private TextView addressTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            images = (ImageView) itemView.findViewById(R.id.images);
            nameTextView = (TextView) itemView.findViewById(R.id.nameTextView);
            addressTextView = (TextView) itemView.findViewById(R.id.addressTextView);
        }
    }
}
