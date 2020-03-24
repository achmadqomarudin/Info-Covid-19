package com.example.infocovid_19.ui.menu.menu_kasus;


import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.infocovid_19.R;
import com.example.infocovid_19.util.BaseApiService;
import com.example.infocovid_19.util.RetrofitClient;
import com.example.infocovid_19.util.UtilsApi;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class KasusFragment extends Fragment {

    private static final String TAG = KasusFragment.class.getSimpleName();
    private Context mContext;
    private BaseApiService baseApiService;
    private TextView tvKasusPositif, tvSehat, tvMeninggal;
    private SwipeRefreshLayout swipe;

    public KasusFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kasus, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        baseApiService = RetrofitClient.getClient(UtilsApi.BASE_URL_API).create(BaseApiService.class);

        setView(view);
        fetchData();
        initView();
    }

    private void setView(View view) {
        tvKasusPositif  = view.findViewById(R.id.tv_kasus_positif);
        tvSehat         = view.findViewById(R.id.tv_sehat);
        tvMeninggal     = view.findViewById(R.id.tv_meninggal);
        swipe           = view.findViewById(R.id.swipe);
    }

    private void fetchData() {
        Call<JsonArray> categoryCall = baseApiService.getInfoCovid19();
        categoryCall.enqueue(new Callback<JsonArray>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {

                if (response.isSuccessful()) {
                    try {
                        Log.e(TAG, "onResponse: " + response.body().toString());
                        JSONArray jsonArray = new JSONArray(response.body().toString());

                        for (int a=0; a<jsonArray.length(); a++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(a);

                            if (jsonObject.getString("country").contentEquals("Indonesia")) {

                                String kasus_positif = jsonObject.getString("cases");
                                String sehat         = jsonObject.getString("recovered");
                                String meninggal     = jsonObject.getString("deaths");

                                tvKasusPositif.setText(kasus_positif);
                                tvSehat.setText(sehat);
                                tvMeninggal.setText(meninggal);
                            }
                        }

                        swipe.setRefreshing(false);
                    } catch (JSONException e) {

                        Log.e(TAG, "Error " + e.getMessage());
                        swipe.setRefreshing(false);
                        Toast.makeText(mContext, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    try {
                        JSONObject jObjError = new JSONObject(response.errorBody().string());
                        Log.e(TAG, "message : " + jObjError.getString("status"));
                        String message = jObjError.getString("error");

                        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
                        swipe.setRefreshing(false);
                    } catch (Exception e) {
                        Log.e(TAG, "message : " + e.getMessage());
                        swipe.setRefreshing(false);
                    }
                }
            }

            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {
                Log.e(TAG, "onFailure :" + t.toString());
                Toast.makeText(mContext, "Maaf, silahkan cek koneksi internet dan coba lagi.", Toast.LENGTH_SHORT).show();
                swipe.setRefreshing(false);
            }
        });
    }

    private void initView() {
        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                fetchData();
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }
}