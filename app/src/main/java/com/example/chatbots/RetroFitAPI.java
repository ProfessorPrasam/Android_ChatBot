package com.example.chatbots;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface RetroFitAPI {

    @GET
    Call<MsgModle> getMessage(@Url String url);
}
