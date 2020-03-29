package com.example.infocovid_19.ui.menu.menu_bantuan;


import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.infocovid_19.R;
import com.example.infocovid_19.ui.menu.menu_bantuan.adapter.AdapterBantuan;
import com.example.infocovid_19.ui.menu.menu_detail.DetailBantuanActivity;
import com.example.infocovid_19.ui.menu.menu_informasi.model.PojoInformasi;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BantuanFragment extends Fragment {

    private static final int REQUEST_CALL = 1;
    private RecyclerView recyclerView;
    private AdapterBantuan adapter;
    private Button btnPanggil;
    private TextView tvSepertiIni;
    private List<PojoInformasi> list;
    private Context mContext;

    public BantuanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bantuan, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    private void initView(View view) {
        recyclerView = view.findViewById(R.id.rc_bantuan);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));

        list    = new ArrayList<>();
        adapter = new AdapterBantuan(list);

        recyclerView.setAdapter(adapter);
        createListData();

        adapter.setOnItemClickListener(new AdapterBantuan.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //Do something when an item has been clicked
                Intent i = new Intent(mContext, DetailBantuanActivity.class);
                i.putExtra("position", position);
                startActivity(i);
            }
        });

        tvSepertiIni = view.findViewById(R.id.tv_seperti_ini);
        tvSepertiIni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.covid19.go.id/faqs/apa-saja-tanda-atau-gejala-infeksi-virus-corona/"));
                startActivity(browserIntent);
            }
        });

        btnPanggil   = view.findViewById(R.id.btn_panggil);
        btnPanggil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makePhoneCall();
            }
        });
    }

    private void createListData() {
        PojoInformasi pojoInformasi = new PojoInformasi(R.drawable.ic_konsultasi_dokter, R.color.bgColorKonsultasiDokter, "Konsultasi Dokter");
        list.add(pojoInformasi);

        pojoInformasi = new PojoInformasi(R.drawable.ic_rumah_sakit, R.color.bgColorRumahSakitRujukan, "Rumah Sakit Rujukan");
        list.add(pojoInformasi);

        adapter.notifyDataSetChanged();
    }

    private void makePhoneCall() {
        if (ContextCompat.checkSelfPermission(getActivity(),
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
        } else {
            String dial = "tel:119";
            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CALL) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                makePhoneCall();
            } else {
                Toast.makeText(mContext, "Permission DENIED", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }
}
