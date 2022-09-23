package com.brex.galangue.sampleweatherapp.controller.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.brex.galangue.sampleweatherapp.R;
import com.brex.galangue.sampleweatherapp.adapter.WeatherListAdapter;
import com.brex.galangue.sampleweatherapp.api.JsonParser;
import com.brex.galangue.sampleweatherapp.api.dto.BeanForecast;
import com.brex.galangue.sampleweatherapp.api.dto.BeanList;
import com.brex.galangue.sampleweatherapp.helper.Constants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.apache.http.HttpEntity;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SecondPageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SecondPageFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SecondPageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SecondPageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SecondPageFragment newInstance(String param1, String param2) {
        SecondPageFragment fragment = new SecondPageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private ArrayList<BeanList> list_items;
    private ListView lvWeather;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second_page, container, false);
        initializeIds(view);
        list_items =  new ArrayList<>();
        Log.d("ungLAT", Constants.LOC_LAT);
        Handler handler =  new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    openForecast();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }, 1000);
        return view;
    }

    private void initializeIds(View view){
        lvWeather = view.findViewById(R.id.lvWeather);
    }

    void openForecast() throws IOException {

        OkHttpClient client = new OkHttpClient();
        Log.d("ungLAT", Constants.LOC_LAT);
        Log.d("ungURL_forecast", "http://api.openweathermap.org/data/2.5/forecast?lat="+Constants.LOC_LAT+"&lon="+Constants.LOC_LON+"&q="+Constants.LOCATION_COUNTRY+"&APPID="+Constants.APPID);

        Request request = new Request.Builder()
                .url("http://api.openweathermap.org/data/2.5/forecast?lat="+Constants.LOC_LAT+"&lon="+Constants.LOC_LON+"&q="+Constants.LOCATION_COUNTRY+"&APPID="+Constants.APPID)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                call.cancel();
            }

            @Override
            public void onResponse(Call call, okhttp3.Response response) throws IOException {
                final String myResponse = response.body().string();
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            BeanForecast beanForecast = JsonParser.getForecastData(myResponse);
                            Log.d("beanListssss", String.valueOf(beanForecast.getList().size()));

                            WeatherListAdapter weatherListAdapter =  new WeatherListAdapter(getActivity(), beanForecast.getList());
                            lvWeather.setAdapter(weatherListAdapter);
//                            Log.d("secPageVal", json.getJSONObject("city").getString("name"));
//
//                            Log.d("listSize", String.valueOf(json.getJSONArray("list").length()));
//
//                            for(int i=0; i<json.getJSONArray("list").length();i++){
//                                JSONObject jsonweather = json.getJSONArray("list").getJSONObject(i);
//                                Log.d("asdasdasd", jsonweather.getString("dt")+" "+i);
//                                list_items.add(new BeanList())
//                            }
//                            Log.d("CelsiusVal", String.valueOf(convertFahrenheitToCelsius(json.getJSONObject("main").getString("temp"))));
//                            Constants.LOC_LAT =  json.getJSONObject("coord").getString("lat");
//                            Constants.LOC_LON =  json.getJSONObject("coord").getString("lon");
//                            convertFahrenheitToCelsius(json.getJSONObject("main").getString("temp"));
//
//                            Log.d("Dateeee_sunrise", getDate(Long.parseLong(json.getJSONObject("sys").getString("sunrise"))));
//                            Log.d("Dateeee_sunset", getDate(Long.parseLong(json.getJSONObject("sys").getString("sunset"))));
//                            tvSunset.setText(getDate(Long.parseLong(json.getJSONObject("sys").getString("sunset"))));
//                            tvSunrise.setText(getDate(Long.parseLong(json.getJSONObject("sys").getString("sunrise"))));
//                            tvSunsetText.setVisibility(View.VISIBLE);
//                            tvSunriseText.setVisibility(View.VISIBLE);
//
//                            tvTemp.setText(String.valueOf(convertFahrenheitToCelsius(json.getJSONObject("main").getString("temp")))+ "\u00B0C");
//                            JSONObject jsonweather = json.getJSONArray("weather").getJSONObject(0);
//                            tvDescription.setText(jsonweather.getString("description"));
//                            tvLocation.setText(json.getString("name")+","+String.valueOf(json.getJSONObject("sys").getString("country")));




                        } catch (Exception e) {
                            Log.e("errorRun", e.getMessage());
                            e.printStackTrace();
                        }
                    }
                });
            }

        });
    }
}