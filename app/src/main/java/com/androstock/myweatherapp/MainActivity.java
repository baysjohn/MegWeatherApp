package com.androstock.myweatherapp;
/**
 * Created by SHAJIB on 7/4/2017.
 */
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Project Created by Ferdousur Rahman Shajib
    // www.androstock.com


    TextView appName, cityField, detailsField, currentTemperatureFieldC, currentTemperatureFieldF, humidity_field, pressure_field, weatherIcon, updatedField;

    Typeface weatherFont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);


        weatherFont = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/weathericons-regular-webfont.ttf");

        cityField = (TextView)findViewById(R.id.city_field);
        updatedField = (TextView)findViewById(R.id.updated_field);
        detailsField = (TextView)findViewById(R.id.details_field);
        currentTemperatureFieldC = (TextView)findViewById(R.id.current_temperature_fieldC);
        currentTemperatureFieldF = (TextView)findViewById(R.id.current_temperature_fieldF);
        humidity_field = (TextView)findViewById(R.id.humidity_field);
        pressure_field = (TextView)findViewById(R.id.pressure_field);
        weatherIcon = (TextView)findViewById(R.id.weather_icon);
        weatherIcon.setTypeface(weatherFont);
        appName = (TextView)findViewById(R.id.app_name);

        Function.placeIdTask asyncTask =new Function.placeIdTask(new Function.AsyncResponse() {
            public void processFinish(String appname, String weather_city, String weather_description, String weather_temperatureC, String weather_temperatureF, String weather_humidity, String weather_pressure, String weather_updatedOn, String weather_iconText, String sun_rise) {

                cityField.setText(weather_city);
                updatedField.setText(weather_updatedOn);
                detailsField.setText(weather_description);
                currentTemperatureFieldC.setText(weather_temperatureC);
                currentTemperatureFieldF.setText(weather_temperatureF);
                humidity_field.setText("Humidity: "+weather_humidity);
                pressure_field.setText("Pressure: "+weather_pressure);
                weatherIcon.setText(Html.fromHtml(weather_iconText));
                appName.setText(appname);
            }
        });
        asyncTask.execute("38.8462", "-77.3064"); //  asyncTask.execute("Latitude", "Longitude")



    }


}
