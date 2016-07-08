package com.edn.olleego.fragment.Mission;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.edn.olleego.R;
import com.edn.olleego.adapter.mission.Mission_Adapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class MissionFragment extends Fragment {

    private Mission_Adapter missionAdapter = null;

    private Fragment fragment;

    ListView mListView;

    public MissionFragment() {
        // Required empty public constructor
    }

    public static MissionFragment newInstance(String param1, String param2) {
        MissionFragment fragment = new MissionFragment();

        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View rootView = inflater.inflate(R.layout.fragment_mission, container, false);

        mListView = (ListView)rootView.findViewById(R.id.mission_list);

        missionAdapter = new Mission_Adapter(inflater);



        mListView.setAdapter(missionAdapter);

        missionAdapter.addItem(R.drawable.kakao_default_profile_image,"쉽게 따라하는 초보용 미션 프로그램", "복근 , 하체 , 상체");

        missionAdapter.addItem(R.drawable.kakao_default_profile_image,"쉽게 따라하는 초보용 미션 프로그램", "복근 , 하체 , 상체");


        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                fragment = new MissionDetailFragment();
                MissionDetailFragment missionDetailFragment = new MissionDetailFragment();



                android.support.v4.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();



                transaction.replace(R.id.content_main, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });


        // Inflate the layout for this fragment
        return rootView;
    }

}
