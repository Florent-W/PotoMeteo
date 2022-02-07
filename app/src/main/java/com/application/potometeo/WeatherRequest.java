package com.application.potometeo;

import android.util.Log;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherRequest {

    private OpenWeatherAPI openWeatherAPI;

    public WeatherRequest() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        this.openWeatherAPI = retrofit.create(OpenWeatherAPI.class);
    }

    public String getTemperature(String lat, String lon) {
        Log.d("clicked", "fetching...");
        Call<WeatherResponse> call = openWeatherAPI.getResponse(lat, lon);
        Response<WeatherResponse> response = null;
        String result;
        try {
            response = call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (response != null) {
            result = response.body().getMain().getTemp();
            Log.d("result", result);
        } else {
            result = null;
        }
        return result;
    }

}