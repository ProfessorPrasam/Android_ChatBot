package com.example.chatbots;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ChatRVAdapter extends RecyclerView.Adapter {
//    TextView textView;

    private ArrayList<ChatsModle> chatsModleArrayList;
    private Context context;

    public ChatRVAdapter(ArrayList<ChatsModle> chatsModleArrayList, Context context) {
        this.chatsModleArrayList = chatsModleArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view;
//       textView = findViewById(R.id.textView);
       switch (viewType){
           case 0:
               view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_msg_rv_item,parent,false);
               return new UserViewHolder(view);
           case 1:
               view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bot_msg_rv_item,parent,false);
               return new BotViewHolder(view);
       }
       return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ChatsModle chatsModle = chatsModleArrayList.get(position);
        switch (chatsModle.getSender()){
            case "user":
                ((UserViewHolder)holder).userTV.setText(chatsModle.getMessage());
                break;
            case "bot":
                ((BotViewHolder)holder).botMsgTV.setText(chatsModle.getMessage());
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        switch (chatsModleArrayList.get(position).getSender()){
            case "user":
                return 0;
            case "bot":
                return 1;
            default:
                return -1;
        }
    }

    @Override
    public int getItemCount() {
        return chatsModleArrayList.size();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        TextView userTV;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            userTV = itemView.findViewById(R.id.idTVUser);
        }
    }
    public static class BotViewHolder extends RecyclerView.ViewHolder{
        TextView botMsgTV;
        public BotViewHolder(@NonNull View itemView) {
            super(itemView);
            botMsgTV = itemView.findViewById(R.id.idTVBot);
        }
    }

}
