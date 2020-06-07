package com.ssba.callback;

/**
 * Created by psk on 11/19/2017.
 */

public abstract class ApiCallback<T>
{
    public abstract void onSuccess(T t);

    public abstract void onFailure(int statusCode);
}
