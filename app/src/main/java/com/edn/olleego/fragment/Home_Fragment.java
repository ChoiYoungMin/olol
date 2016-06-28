package com.edn.olleego.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.edn.olleego.R;

/**
 * Created by Antonio on 2016-06-23.
 */
public class Home_Fragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    public Home_Fragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static Home_Fragment newInstance(int sectionNumber) {
        Home_Fragment fragment = new Home_Fragment();
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        //TextView textView = (TextView) rootView.findViewById(R.id.section_label);

        return rootView;
    }
}