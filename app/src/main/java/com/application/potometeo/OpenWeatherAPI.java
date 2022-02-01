package com.application.potometeo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OpenWeatherAPI {
    @GET("weather?units=metric&appid=a14308a6ed76ca8c4853486283290312")
    Call<WeatherResponse> getResponse(@Query("lat") String lat, @Query("lon") String lon);
}
