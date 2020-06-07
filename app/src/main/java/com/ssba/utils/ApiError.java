package com.ssba.utils;

import com.ssba.callback.ApiCallback;

public class ApiError
{
    public static void sendError(ApiCallback callback, Throwable t)
    {
        t.printStackTrace();
        callback.onFailure(0);
    }
}
