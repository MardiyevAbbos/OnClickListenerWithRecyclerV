package com.example.onclicklistenerwithrecyclerv.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.onclicklistenerwithrecyclerv.R;
import com.example.onclicklistenerwithrecyclerv.adapter.CustomAdapter;
import com.example.onclicklistenerwithrecyclerv.model.Member;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        ArrayList<Member> members = prepareMemberList();
        refreshAdapter(members);

    }


    private void initViews() {
        context = this;
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 1));
    }


    private void refreshAdapter(ArrayList<Member> members) {
        CustomAdapter adapter = new CustomAdapter((MainActivity) context, members);
        recyclerView.setAdapter(adapter);
    }


    public void clickItem(Member member) {
        Intent intent = new Intent(this, UserActivity.class);
        intent.putExtra("user", member);
        startActivity(intent);
    }


    private ArrayList<Member> prepareMemberList() {
        ArrayList<Member> members = new ArrayList<>();

        for (int i = 1; i < 31; i++) {
            members.add(new Member(i + ")Michael", i + ")Jackson", R.drawable.michael));
        }
        return members;
    }


}