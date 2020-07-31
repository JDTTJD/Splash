package com.tuoren.jetpack.lifeCircle;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

/**
 * Create by JDT on 2020-07-13.
 */
public class LifeCircleViewModel extends ViewModel implements LifecycleObserver {

    private MutableLiveData<String> currentName;

    public MutableLiveData<String> getCurrentName() {
        if (currentName == null) {
            currentName = new MutableLiveData<String>();
        }
        return currentName;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void connectListener() {
        currentName.setValue("on_create");
        Log.e("LifeCircleObserver", "Lifecycle.Event.ON_CREATE");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void on_resume() {
        currentName.setValue("on_resume");
        Log.e("LifeCircleObserver", "Lifecycle.Event.ON_RESUME");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void disconnectListener() {
        Log.e("LifeCircleObserver", "Lifecycle.Event.ON_PAUSE");
    }
}
