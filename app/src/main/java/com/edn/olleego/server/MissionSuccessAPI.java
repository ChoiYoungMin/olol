package com.edn.olleego.server;

import com.edn.olleego.model.MissionsModel;
import com.edn.olleego.model.UserMissionModel;
import com.edn.olleego.server.request.MissionSuccess;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Antonio on 2016-07-25.
 */
public interface MissionSuccessAPI {

    @Headers("Content-Type: application/json")
    @POST("/api/v2/histories/mission/{id}/day")
    Call<MissionsModel> listRepos(@Header("Authorization") String authorization, @Path("id") int id, @Query("type") String type, @Body MissionSuccess missionSuccess);


}
