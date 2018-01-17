package com.example.home_pc.rxandroidverysimpleexample;


import com.example.home_pc.rxandroidverysimpleexample.Api.RootObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JokeRetrofitInterface {

    @GET("/jokes/random/3")
    Call<RootObject> getJokes();

}


//http://api.icndb.com/jokes/random/3
//        1
//        http://api.icndb.com/jokes/random/3
//
////public interface RetrofitInterface {
////    @GET("/r/EarthPorn/{type}/.json")
////    Call<RootObject> getChilds(@Path("type") String type, @Query("limit") int limitQuantity);
////    // Observable<RootObject> getChilds(@Path("type") String type, @Query("limit") int limitQuantity);
////}
