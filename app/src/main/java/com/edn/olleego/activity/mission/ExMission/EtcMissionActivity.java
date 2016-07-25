package com.edn.olleego.activity.mission.exmission;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.edn.olleego.R;
import com.edn.olleego.common.ServerInfo;
import com.edn.olleego.model.Lifes.LfList;
import com.edn.olleego.model.MissionsModel;
import com.edn.olleego.model.exgroups.Ex;
import com.edn.olleego.model.foods.FdList;
import com.edn.olleego.server.MissionSuccessAPI;
import com.edn.olleego.server.request.MissionSuccess;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EtcMissionActivity extends AppCompatActivity {

    Intent intent;

    FdList fdList;
    LfList lfList;

    String type;


    @BindView(R.id.etc_mission_type)
    TextView mission_type;

    @BindView(R.id.etc_mission_title)
    TextView mission_title;

    @BindView(R.id.etc_mission_description)
    TextView mission_description;

    @BindView(R.id.etc_mission_level)
    TextView mission_level;

    @BindView(R.id.etc_mission_time)
    TextView mission_time;

    @BindView(R.id.etc_mission_tip)
    TextView mission_tip;

    String tokens;

    int mission_id;
    int mission_today;
    int food_id;
    int life_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etc_mission);
        ButterKnife.bind(this);

        intent = getIntent();

        type= intent.getStringExtra("type");


        switch (type) {
            case "food":
                fdList = (FdList) intent.getSerializableExtra("food");
                mission_type.setText("식습관");
                mission_title.setText(fdList.getTitle());
                mission_level.setText(getlevel(fdList.getFd_level(),1));
                mission_time.setText(gettime(fdList.getFd_time(),1));
                mission_description.setText(fdList.getDescription1());
                mission_tip.setText(fdList.getTip());


                tokens = intent.getStringExtra("token");
                mission_id = intent.getIntExtra("mission_id", 0);
                mission_today = intent.getIntExtra("mission_today", 0);
                food_id = intent.getIntExtra("food_id", 0);



                break;

            case "life":
                lfList =  (LfList) intent.getSerializableExtra("life");
                mission_type.setText("생활습관");

                mission_title.setText(lfList.getTitle());
                mission_level.setText(getlevel(lfList.getLf_level(),2));
                mission_time.setText(gettime(lfList.getLf_time(),2));
                mission_description.setText(lfList.getDescription1());
                mission_tip.setText(lfList.getTip());


                tokens = intent.getStringExtra("token");
                mission_id = intent.getIntExtra("mission_id", 0);
                mission_today = intent.getIntExtra("mission_today", 0);
                life_id = intent.getIntExtra("life_id", 0);
                break;
        }


    }

    @OnClick(R.id.etc_mission_ok)
    void mission_ok_click() {
        Retrofit retrofit_diary = new Retrofit.Builder()
                .baseUrl(ServerInfo.OLLEEGO_HOST)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MissionSuccess missionSuccess = null;
        if( type.equals("food")) {
             missionSuccess = new MissionSuccess(mission_today, food_id, 3);
        } else if(type.equals("life")) {
             missionSuccess = new MissionSuccess(mission_today, life_id, 2);
        }
        String token = "olleego " + tokens;
        MissionSuccessAPI missionSuccessAPI = retrofit_diary.create(MissionSuccessAPI.class);

        final Call<MissionsModel> diaryPos = missionSuccessAPI.listRepos( token,mission_id, missionSuccess);
        diaryPos.enqueue(new Callback<MissionsModel>() {
            @Override
            public void onResponse(Call<MissionsModel> call, Response<MissionsModel> response) {
                if(response.body().getSuccess() == true) {
                    Toast.makeText(getApplicationContext(), "성공", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }

            @Override
            public void onFailure(Call<MissionsModel> call, Throwable t) {

            }
        });
    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
        finish();
    }

    public String getlevel(int level, int type) {

        if(type == 1) {
            switch (level) {
                case 216:
                    return "쉬워요";

                case 217:
                    return "보통이에요";

                case 218:
                    return "조금 어려워요.";

                case 219:
                    return "어려워요.";
            }
        }
        else if(type==2) {
            switch (level) {
                case 260:
                    return "쉬워요";

                case 261:
                    return "보통이에요";

                case 262:
                    return "조금 어려워요.";

                case 263:
                    return "어려워요.";
            }
        }

        return "";
    }


    public String gettime(int time, int type) {

        if(type == 1) {
            switch (time) {

                case 220:
                    return "즉시완료";
                case 221:
                    return "하루종일";
                case 222:
                    return "반나절";
                case 223:
                    return "10분";
                case 224:
                    return "20분";
                case 225:
                    return "30분";
                case 226:
                    return "40분";
                case 227:
                    return "50분";
                case 228:
                    return "60분";
                case 229:
                    return "90분";
            }
        }
        else if(type == 2) {
            switch (time) {

                case 264:
                    return "즉시완료";
                case 265:
                    return "하루종일";
                case 266:
                    return "오전시간";
                case 267:
                    return "저녁시간";
                case 268:
                    return "10분";
                case 269:
                    return "20분";
                case 270:
                    return "30분";
                case 271:
                    return "40분";
                case 272:
                    return "50분";
                case 273:
                    return "60분";
                case 274:
                    return "90분";
            }
        }

        return "";
    }


}
