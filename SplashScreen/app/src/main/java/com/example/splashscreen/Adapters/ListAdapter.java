package com.example.splashscreen.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.splashscreen.DataBaseFile.PeopleMainScreen;
import com.example.splashscreen.R;

public class ListAdapter extends RecyclerView.Adapter {


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_people, parent, false);
       return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ListViewHolder) holder).bindView(position);
    }

    @Override
    public int getItemCount() {
        return  PeopleMainScreen.name.length;
    }


    private class ListViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{

private TextView peopleName, peopleJob, peoplePlaceOfLiving;
private ImageView peoplePhoto;

public ListViewHolder(View itemView){

    super(itemView);
peopleName = (TextView) itemView.findViewById(R.id.tv_people_name);
peopleJob = (TextView) itemView.findViewById(R.id.tv_people_job);
peoplePlaceOfLiving = (TextView) itemView.findViewById(R.id.tv_people_place_of_living);
peoplePhoto = (ImageView) itemView.findViewById(R.id.iv_people);
itemView.setOnClickListener(this);
}

public  void bindView(int position) {
    peopleName.setText(PeopleMainScreen.name[position]);
    peopleJob.setText(PeopleMainScreen.job[position]);
    peoplePlaceOfLiving.setText(PeopleMainScreen.placeOfLiving[position]);
    peoplePhoto.setImageResource(PeopleMainScreen.picturePath[position]);
}

public void onClick(View view){

}

    }
}
