package com.brex.galangue.sampleweatherapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.brex.galangue.sampleweatherapp.R;
import com.brex.galangue.sampleweatherapp.api.dto.BeanList;
import com.brex.galangue.sampleweatherapp.helper.AppUtils;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class WeatherListAdapter extends ArrayAdapter<BeanList> {

    private Context context;
    private List<BeanList> valList;
    private LayoutInflater inflater;


    public WeatherListAdapter(@NonNull Context context, List<BeanList> valList) {
        super(context, 0, valList);
        this.context = context;
        this.valList = valList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.custom_weather_item, null);

        final ImageView imWeatherIcon   = convertView.findViewById(R.id.imWeatherIcon);
        final TextView tvForecast   = convertView.findViewById(R.id.tvForecast);
        final TextView tvWeather   = convertView.findViewById(R.id.tvWeather);
        final TextView tvDescription   = convertView.findViewById(R.id.tvDescription);
        final TextView tvTemp   = convertView.findViewById(R.id.tvTemp);

        final BeanList options = valList.get(position);


        tvForecast.setText(AppUtils.formatDateTime(options.getDt_txt()));
        AppUtils.loadImageWithGlide(context, "http://openweathermap.org/img/w/"+options.getWeather().get(0).getIcon()+".png", imWeatherIcon);
        tvTemp.setText( AppUtils.convertToCelcius(String.valueOf(options.getMain().getTemp()))+ "\u00B0C");
        tvWeather.setText(options.getWeather().get(0).getMain());
        tvDescription.setText(options.getWeather().get(0).getDescription());

        return convertView;
    }


}
