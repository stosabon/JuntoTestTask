package ru.production.ssobolevsky.juntotask.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by pro on 11.04.2018.
 */

public class Screenshot {

    @SerializedName("300px")
    @Expose
    private String mSmallScreenshot;

    public String getSmallScreenshot() {
        return mSmallScreenshot;
    }

    public void setSmallScreenshot(String smallScreenshot) {
        mSmallScreenshot = smallScreenshot;
    }
}
