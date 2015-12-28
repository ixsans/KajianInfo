package com.yanmii.kajianinfo.data;

import java.util.List;

public class AudioListResponse {

    private int page;
    private List<Audio> audio;

    public int getPage() {
        return page;
    }

    public List<Audio> getAudios() {
        return audio;
    }
}
