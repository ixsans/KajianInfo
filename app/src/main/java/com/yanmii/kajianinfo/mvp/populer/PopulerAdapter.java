package com.yanmii.kajianinfo.mvp.populer;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.yanmii.kajianinfo.R;
import com.yanmii.kajianinfo.data.Audio;
import com.yanmii.kajianinfo.utils.ImageLoader;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class PopulerAdapter extends RecyclerView.Adapter<PopulerAdapter.ViewHolder> {

    private List<Audio> audioList;
    private ClickListener clickListener;

    public PopulerAdapter(List<Audio> audioList){
        this.audioList = audioList;
    }

    public void setData(List<Audio> data){
        this.audioList = data;
        notifyDataSetChanged();
    }

    public Audio getItem(int position){
        return audioList!=null?audioList.get(position) : null;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_audio, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Audio audio = audioList.get(position);

        holder.mTextJudul.setText(audio.judul);
        holder.mTextPemateri.setText(audio.ustadz.nama);
        holder.mTextPlaylist.setText(audio.playlist.judul);
        ImageLoader.displayThumbnail(holder.mImage.getContext(), audio.gambar, holder.mImage);

    }


    @Override
    public int getItemCount() {
        return audioList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @Bind(R.id.judul)
        TextView mTextJudul;
        @Bind(R.id.playlist)
        TextView mTextPlaylist;
        @Bind(R.id.pemateri)
        TextView mTextPemateri;
        @Bind(R.id.image)
        ImageView mImage;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(clickListener!=null) clickListener.onClick(audioList.get(getAdapterPosition()));
        }
    }

    public void setClickListener(ClickListener clickListener){
        this.clickListener = clickListener;
    }

    public interface ClickListener{
        void onClick(Audio audio);
    }
}
