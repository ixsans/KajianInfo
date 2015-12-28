package com.yanmii.kajianinfo.mvp.detailaudio;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.yanmii.kajianinfo.R;
import com.yanmii.kajianinfo.data.Audio;
import com.yanmii.kajianinfo.utils.ImageLoader;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DetailAudioActivity extends AppCompatActivity implements DetailAudioContract.DetailAudioView{

    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.progress_bar)
    ProgressBar mProgressBar;
    @Bind(R.id.text_error)
    TextView mTextError;
    @Bind(R.id.poster)
    ImageView mImagePoster;
    @Bind(R.id.container_details)
    View mContainerDetails;
    @Bind(R.id.judul)
    TextView mTextJudul;
    @Bind(R.id.deskripsi)
    TextView mTextDeskripsi;
    @Bind(R.id.kontributor)
    TextView mTextKontributor;
    @Bind(R.id.ukuran)
    TextView mTextUkuran;
    @Bind(R.id.fab)
    FloatingActionButton mFab;

    DetailAudioContract.DetailAudioPresenter mPresenter;


    public static String ARG_AUDIO_ID = "audio_id";
    public static String ARG_AUDIO_POSTER = "audio_poster";


    String audioId;
    String poster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_audio);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);

        audioId = getIntent().getStringExtra(ARG_AUDIO_ID);
        poster = getIntent().getStringExtra(ARG_AUDIO_POSTER);

        if(audioId==null) {
            finish();
            Toast.makeText(getApplicationContext(), "Audio tidak ditemukan", Toast.LENGTH_SHORT).show();
        }

        ImageLoader.displayImage(getApplicationContext(), poster, mImagePoster);

        mPresenter = new DetailAudioPresenter(this);

        mPresenter.onCreateView();
        mPresenter.loadContent(audioId);

    }


    @Override
    public void initViews() {
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public void showLoading(boolean showLoading) {
        if(showLoading){
            mContainerDetails.setVisibility(View.GONE);
            mProgressBar.setVisibility(View.VISIBLE);
        }else{
            mContainerDetails.setVisibility(View.VISIBLE);
            mProgressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void showError(String message) {
        Snackbar.make(mContainerDetails, message, Snackbar.LENGTH_LONG).show();

        mContainerDetails.setVisibility(View.GONE);
        mProgressBar.setVisibility(View.GONE);

    }

    @Override
    public void setAudio(Audio audio) {
        mProgressBar.setVisibility(View.GONE);
        mContainerDetails.setVisibility(View.VISIBLE);
        mTextJudul.setText(audio.judul);
        mTextDeskripsi.setText(Html.fromHtml(audio.deskripsi));

        ImageLoader.displayImage(getApplicationContext(), audio.gambar, mImagePoster);
    }


}
