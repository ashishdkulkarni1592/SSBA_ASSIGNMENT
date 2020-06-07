package com.ssba.api;

import com.ssba.model.MResume;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface Endpoint
{
    @GET("ashish_resume.json")
    Call<MResume> getResumeData();

}
