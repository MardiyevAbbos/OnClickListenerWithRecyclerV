package com.example.onclicklistenerwithrecyclerv.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onclicklistenerwithrecyclerv.R;
import com.example.onclicklistenerwithrecyclerv.activity.MainActivity;
import com.example.onclicklistenerwithrecyclerv.model.Member;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private MainActivity activity;
    private ArrayList<Member> members;

    public CustomAdapter(MainActivity activity, ArrayList<Member> members) {
        this.activity = activity;
        this.members = members;
    }


    @Override
    public int getItemCount() {
        return members.size();
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.item_custom_layout_view, parent, false);
        return new CustomViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Member member = members.get(position);

        if (holder instanceof CustomViewHolder) {
            TextView firstN = ((CustomViewHolder) holder).firstName;
            TextView lastN = ((CustomViewHolder) holder).lastName;
            ImageView image = ((CustomViewHolder) holder).image;
            LinearLayout layClick = ((CustomViewHolder) holder).lay_click;

            firstN.setText(member.getFirstName());
            lastN.setText(member.getLastName());
            image.setImageResource(member.getImage());

            layClick.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.clickItem(member);
                }
            });
        }

    }


    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView firstName;
        public TextView lastName;
        public ImageView image;
        public LinearLayout lay_click;

        public CustomViewHolder(View v) {
            super(v);
            this.view = v;
            firstName = view.findViewById(R.id.first_name);
            lastName = view.findViewById(R.id.last_name);
            image = view.findViewById(R.id.image_view);
            lay_click = view.findViewById(R.id.lay_click);
        }

    }


}
