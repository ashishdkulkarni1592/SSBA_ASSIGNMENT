package com.ssba.api;

import android.content.Context;

import com.ssba.app.RetroFitClient;
import com.ssba.callback.ApiCallback;
import com.ssba.model.MResume;
import com.ssba.utils.ApiError;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiImpl
{
    private static ApiImpl locationsApi;
    private static Endpoint endpoint;

    private ApiImpl(Context context)
    {
        endpoint = RetroFitClient.getApiClient(context).create(Endpoint.class);
    }

    public static ApiImpl getInstance(Context context)
    {
        if (locationsApi == null)
        {
            locationsApi = new ApiImpl(context.getApplicationContext());
        }
        return locationsApi;
    }

    public void getResumeData(final ApiCallback<MResume> callback)
    {
        Call<MResume> call = endpoint.getResumeData();
        call.enqueue(new Callback<MResume>() {
            @Override
            public void onResponse(@NotNull Call<MResume> call, @NotNull Response<MResume> response)
            {
                if (response.code() == 200)
                {

                    callback.onSuccess(response.body());
                } else {
                    callback.onFailure(response.code());
                }
            }

            @Override
            public void onFailure(@NotNull Call<MResume> call, Throwable t)
            {
                ApiError.sendError(callback, t);
            }
        });

    }
}
