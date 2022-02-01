package com.application.potometeo;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class Search {

    //    private TextView input;
    private JSONArray data;

    public Search(Context ctx) {
//        this.input = input;
        setup(ctx);
    }

    private void setup(Context ctx) {
        InputStream is = ctx.getResources().openRawResource(R.raw.city_list_min);
        Writer writer = new StringWriter();
        char[] buffer = new char[2048];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            this.data = new JSONArray(writer.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
/*
    public List<City> search(String str) {
        List<City> result = new ArrayList<>();
        if (str.length() > 0) {
            for (int i = 0; i < this.data.length(); i++) {
                if (result.size() < 10) {
                    try {
                        JSONObject o = this.data.getJSONObject(i);
                        City c = new City(o.getString("id"), o.getString("name"), o.getString("country"));
                        if (c.getName().toLowerCase().startsWith(str.toLowerCase())) {
                            if (result.size() == 0) {
                                result.add(c);
                            } else {
                                boolean exists = false;
                                for (int j = 0; j < result.size(); j++) {
                                    City c2 = result.get(j);
                                    if (c2.getName() == c.getName() && c2.getCountry() == c.getCountry()) {
                                        exists = true;
                                    }
                                }
                                if (!exists) {
                                    result.add(c);
                                }
                            }
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return result;
    } */
}
