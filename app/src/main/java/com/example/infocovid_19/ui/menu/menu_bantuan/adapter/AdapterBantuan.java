package com.example.infocovid_19.ui.menu.menu_bantuan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.infocovid_19.R;
import com.example.infocovid_19.ui.menu.menu_informasi.adapter.AdapterInformasi;
import com.example.infocovid_19.ui.menu.menu_informasi.model.PojoInformasi;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterBantuan extends RecyclerView.Adapter<AdapterBantuan.ViewHolder> {

    private List<PojoInformasi> list;

    private static OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public AdapterBantuan.OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public AdapterBantuan(List<PojoInformasi> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public AdapterBantuan.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_informasi, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        PojoInformasi result = list.get(position);
        Context context      = holder.itemView.getContext();

        holder.title.setText(result.getTitle());
        holder.bgImage.setImageResource(result.getColorBg());

        Glide.with(context)
                .load(result.getImage())
                .centerCrop()
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;
        private CircleImageView bgImage;
        private TextView title;
        private CardView container;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image     = itemView.findViewById(R.id.iv_row_image);
            bgImage   = itemView.findViewById(R.id.iv_bg_image);
            title     = itemView.findViewById(R.id.tv_row_name);
            container = itemView.findViewById(R.id.container);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position  = ViewHolder.super.getAdapterPosition();
                    onItemClickListener.onItemClick(view, position);
                }
            });
        }
    }
}
