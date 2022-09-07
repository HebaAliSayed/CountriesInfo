package com.jwhh.countriesinfo;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class countryRecyclerAdapter extends RecyclerView.Adapter<countryRecyclerAdapter.ViewHolder>{
    private final Context mContext;
    private final List<contryInfo> mCountry;
    private final LayoutInflater layoutInflater;

    public countryRecyclerAdapter(Context mContext, List<contryInfo> mCountry) {
        this.mContext = mContext;
        layoutInflater = LayoutInflater.from(mContext);
        this.mCountry = mCountry;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView= layoutInflater.inflate(R.layout.iem_country_list,viewGroup,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        contryInfo country=mCountry.get(i);
        viewHolder.textCountry.setText(country.getCountry());
        viewHolder.textGov.setText(country.getCapital());
        viewHolder.setmCurrentPosition(i);
    }

    @Override
    public int getItemCount() {
        return mCountry.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public final TextView textCountry;
        public final TextView textGov;
        public int mCurrentPosition;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textCountry= (TextView) itemView.findViewById(R.id.text_country);
            textGov = (TextView) itemView.findViewById(R.id.text_gov);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent =new Intent(mContext,CountryActivity.class);
                   // intent.putExtra(CountryActivity.COUNTRY_POSITION,mCurrentPosition);

                }
            });

        }

        public void setmCurrentPosition(int mCurrentPosition) {
            this.mCurrentPosition = mCurrentPosition;
        }
    }
}
