package com.yanmii.kajianinfo.mvp.tag;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yanmii.kajianinfo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TagFragment extends Fragment {


    public TagFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tag, container, false);
    }

}
