package com.bryan_alegria.androidexam.Holder;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bryan_alegria.androidexam.MainActivity;
import com.bryan_alegria.androidexam.Model.PersonData;
import com.bryan_alegria.androidexam.PersonActivity;
import com.bryan_alegria.androidexam.PersonDetailsActivity;
import com.bryan_alegria.androidexam.R;

import java.util.ArrayList;

public class PersonHolder extends RecyclerView.Adapter<PersonHolder.PersonRecyclerViewHolder> {
    private ArrayList<PersonData> personData;
    private Context mContext;
    public class PersonRecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView txt_name, txt_address;
        LinearLayout linear_layout_person;

        PersonRecyclerViewHolder(View itemView) {
            super(itemView);
            linear_layout_person = (LinearLayout) itemView.findViewById(R.id.linear_layout_person);
            txt_name = (TextView)itemView.findViewById(R.id.txt_name);
            txt_address = (TextView)itemView.findViewById(R.id.txt_address);
        }
    }
    public PersonHolder(ArrayList<PersonData> personData, Context context) {
        this.mContext = context;
        this.personData = personData;
    }

    @Override
    public PersonHolder.PersonRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.holder_person, parent, false);

        return new PersonRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PersonHolder.PersonRecyclerViewHolder holder, final int position) {

        String FullName = personData.get(position).getFname() + " " + personData.get(position).getLname();

        holder.txt_name.setText(FullName);
        holder.txt_address.setText(personData.get(position).getAddress());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(mContext, PersonDetailsActivity.class);
                intent.putExtra("FirstName",personData.get(position).getFname());
                intent.putExtra("LastName",personData.get(position).getLname());
                intent.putExtra("Bday",personData.get(position).getBday());
                intent.putExtra("EmailAddress",personData.get(position).getEmail());
                intent.putExtra("MobileNumber",personData.get(position).getMobile());
                intent.putExtra("Address",personData.get(position).getAddress());
                intent.putExtra("ContactPerson",personData.get(position).getContact_person());
                intent.putExtra("ContactPersonsPhoneNumber",personData.get(position).getContact_person_phone_number());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return personData.size();
    }
}
