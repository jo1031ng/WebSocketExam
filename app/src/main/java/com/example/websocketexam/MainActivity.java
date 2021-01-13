package com.example.websocketexam;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private  static  final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new HttpAsyncTask().execute("https://goo.gl/eIXu9l");


    }

    private static class HttpAsyncTask extends AsyncTask <String, Void, String>{

        OkHttpClient client = new OkHttpClient();
        @Override
        protected String doInBackground(String... params) {
            List<Weather> weatherList = new ArrayList<Weather>();
            String result = null;
            String strUrl = params[0];
            try {
                Request request = new Request.Builder()
                        .url(strUrl).build();

                Response response =  client.newCall(request).execute();
                JSONArray jsonArray = new JSONArray(response.body().string());
                for(int i=0;i<=jsonArray.length();i++)
                {
                    JSONObject jsonObject =  jsonArray.getJSONObject(i);
                    String contry = jsonObject.getString("contry");
                    String weather = jsonObject.getString("weather");
                    String temperature = jsonObject.getString("temperature");
                    Weather w =  new Weather(contry,weather,temperature);
                    weatherList.add(w);
                }


                //Log.d(TAG,"doInBackground : "+ response.body().string());

                //result =  response.body().string();
            }catch (IOException | JSONException e){
                e.printStackTrace();
            }
            return result;
        }

        protected void  onPostExecute(String s){
            super.onPostExecute(s);
            if(s != null)
            {
                Log.d(TAG , s);

            }


        }


    }
}