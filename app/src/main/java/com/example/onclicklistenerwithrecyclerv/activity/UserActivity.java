package com.example.onclicklistenerwithrecyclerv.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.onclicklistenerwithrecyclerv.R;
import com.example.onclicklistenerwithrecyclerv.model.Member;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        initViews();

    }


    private void initViews() {
        TextView firstName = findViewById(R.id.tv_firstName_user);
        TextView lastName = findViewById(R.id.tv_lastName_user);
        ImageView image = findViewById(R.id.iv_user);

        Member member = (Member) getIntent().getSerializableExtra("user");  // Serializable objectni getSerializable qilib olamiz

        firstName.setText(member.getFirstName());
        lastName.setText(member.getLastName());
        image.setImageResource(member.getImage());
    }


}