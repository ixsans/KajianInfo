package com.yanmii.kajianinfo.data;


import com.activeandroid.annotation.Table;

import java.util.List;

@Table(name = "Audio")
public class Audio {

    public int guid;

    public String judul;

    public String deskripsi;

    public String gambar;

    public String url_download;

    public String ukuran;

    public String youtube_id;

    public String tanggal_dibuat;

    public String url_web;

    public Ustadz ustadz;

    public Playlist playlist;

    public Kontributor kontributor;

    public Tempat tempat;

    //public List<Tag> tag;


    public Audio(){
        super();
    }

}


/*
@Table(name = "Audio")
public class Audio extends Model{

    @Column(name = "audioId")
    public int guid;

    @Column(name = "judul")
    public String judul;

    @Column(name = "gambar")
    public String gambar;

    @Column(name = "url_download")
    public String url_download;

    @Column(name = "ustadz")
    public Ustadz ustadz;

    @Column(name = "playlist")
    public Playlist playlist;


    public Audio(){
        super();
    }

    public Audio(int guid, String judul, String gambar, String url_download, Ustadz ustadz, Playlist playlist) {
        super();
        this.guid = guid;
        this.judul = judul;
        this.gambar = gambar;
        this.url_download = url_download;
        this.ustadz = ustadz;
        this.playlist = playlist;
    }
}
*/
