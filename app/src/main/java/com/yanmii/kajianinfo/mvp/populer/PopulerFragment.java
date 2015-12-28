package com.yanmii.kajianinfo.mvp.populer;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.yanmii.kajianinfo.R;
import com.yanmii.kajianinfo.data.Audio;
import com.yanmii.kajianinfo.mvp.detailaudio.DetailAudioActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class PopulerFragment extends Fragment implements
                        PopulerContract.PopulerView, PopulerAdapter.ClickListener{

    //UI References
    @Bind(R.id.main_content)
    View mainContent;
    @Bind(R.id.swipe_refresh)
    SwipeRefreshLayout mSwipeRefresh;
    @Bind(R.id.progress_bar)
    ProgressBar mProgressBar;
    @Bind(android.R.id.list)
    RecyclerView mRecyclerView;


    PopulerAdapter mAdapter;
    
    PopulerContract.PopulerPresenter populerPresenter;
    

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        populerPresenter = new PopulerPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_popular, container, false);
        ButterKnife.bind(this, view);
        populerPresenter.onCreateView();

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        populerPresenter.loadContent();
    }

    @Override
    public void setItems(List<Audio> items) {
        mAdapter.setData(items);
    }

    @Override
    public void onListItemClicked(@NonNull Audio audio) {
        String id = String.valueOf(audio.guid);
        String poster = audio.gambar;
        Intent intent = new Intent(getActivity(), DetailAudioActivity.class);
        intent.putExtra(DetailAudioActivity.ARG_AUDIO_ID, id);
        intent.putExtra(DetailAudioActivity.ARG_AUDIO_POSTER, poster);
        startActivity(intent);
    }

    @Override
    public void initViews() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        mAdapter = new PopulerAdapter(new ArrayList<>());
        mAdapter.setClickListener(this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void showLoading(boolean showLoading) {
        if(showLoading){
            mRecyclerView.setVisibility(View.GONE);
            mProgressBar.setVisibility(View.VISIBLE);
        }else{
            mRecyclerView.setVisibility(View.VISIBLE);
            mProgressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void showError(String message) {
        Snackbar.make(mainContent, message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void onClick(Audio audio) {
        populerPresenter.openDetail(audio);
    }
}
