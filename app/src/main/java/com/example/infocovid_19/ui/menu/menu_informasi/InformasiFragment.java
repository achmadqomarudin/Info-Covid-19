package com.example.infocovid_19.ui.menu.menu_informasi;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.infocovid_19.R;
import com.example.infocovid_19.ui.menu.menu_detail.DetailInfoActivity;
import com.example.infocovid_19.ui.menu.menu_informasi.adapter.AdapterInformasi;
import com.example.infocovid_19.ui.menu.menu_informasi.model.PojoInformasi;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class InformasiFragment extends Fragment {

    private RecyclerView recyclerView;
    private AdapterInformasi adapter;
    private List<PojoInformasi> list;
    private Context mContext;

    public InformasiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_informasi, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    private void initView(View view) {
        recyclerView = view.findViewById(R.id.rc_informasi);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));

        list    = new ArrayList<>();
        adapter = new AdapterInformasi(list);

        recyclerView.setAdapter(adapter);
        createListData();

        adapter.setOnItemClickListener(new AdapterInformasi.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //Do something when an item has been clicked
                Intent i = new Intent(mContext, DetailInfoActivity.class);
                i.putExtra("position", position);
                startActivity(i);
            }
        });
    }

    private void createListData() {
        PojoInformasi pojoInformasi = new PojoInformasi(R.drawable.ic_mengenal, R.color.bgColorMengenal, "Mengenal");
        list.add(pojoInformasi);

        pojoInformasi = new PojoInformasi(R.drawable.ic_mencegah, R.color.bgColorMencegah, "Mencegah");
        list.add(pojoInformasi);

        pojoInformasi = new PojoInformasi(R.drawable.ic_mengobati, R.color.bgColorMengobati, "Mengobati");
        list.add(pojoInformasi);

        pojoInformasi = new PojoInformasi(R.drawable.ic_mengantisipasi, R.color.bgColorMengantisipasi, "Mengantisipasi");
        list.add(pojoInformasi);

        adapter.notifyDataSetChanged();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }
}
