package com.example.and1app.homepage.fragments;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.and1app.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WeatherFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WeatherFragment extends Fragment {


    private static final int REQUEST_LOCATION =  123;
    private static final long LOCATION_REFRESH_TIME = 100;
    private static final float LOCATION_REFRESH_DISTANCE = 1000;
    private TextView temp,city,description,date;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    String cityName;
    private GpsTracker gpsTracker;
    Location location;
    double latitude;
    double longitude;
    LocationManager locationManager = null;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public WeatherFragment() {
        // Required empty public constructor
    }

    public static WeatherFragment newInstance(String param1, String param2) {
        WeatherFragment fragment = new WeatherFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(getActivity(),Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION},REQUEST_LOCATION);

        }

       getLocation(getView());
        System.out.println(longitude + " Longitude");
        System.out.println(latitude + " Latitude");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_weather, container, false);
        temp = rootView.findViewById(R.id.temperature);
        city = rootView.findViewById(R.id.city);
        description =  rootView.findViewById(R.id.desc);
        date =  rootView.findViewById(R.id.date);
        System.out.println("Hello");
        find_weather();
        return rootView;

    }

    public void getLocation(View view)
    {
        gpsTracker = new GpsTracker(getActivity());
        if (gpsTracker.canGetLocation()){
            System.out.println("Halo");
            latitude = gpsTracker.getLatitude();
            longitude = gpsTracker.getLongitude();
        }
        else
        {
            gpsTracker.showSettingsAlert();
        }
    }

    public void find_weather()
    {
        String url = "https://api.openweathermap.org/data/2.5/weather?lat="+latitude+"&lon="+longitude+"&appid=5298ef7d68c196025a066080596c4a18&units=metric";
        JsonObjectRequest json = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    System.out.println("test 2");
                    JSONObject main = response.getJSONObject("main");
                    JSONArray array = response.getJSONArray("weather");
                    JSONObject object = array.getJSONObject(0);
                    String temp1 = String.valueOf(main.getDouble("temp"));
                    String desc1 = object.getString("description");
                    String city1 = response.getString("name");

                    temp.setText(temp1);
                    city.setText(city1);
                    description.setText(desc1);
                    System.out.println(temp1 + " " + desc1 + "  " + city1);

                    Calendar calendar = Calendar.getInstance();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");

                    String formmated_date = sdf.format(calendar.getTime());

                    date.setText(formmated_date);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error);
            }
        });
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        queue.add(json);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_LOCATION) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}