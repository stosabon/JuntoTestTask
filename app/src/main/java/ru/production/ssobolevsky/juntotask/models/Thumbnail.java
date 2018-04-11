package ru.production.ssobolevsky.juntotask.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by pro on 11.04.2018.
 */

public class Thumbnail {

    @SerializedName("image_url")
    @Expose
    private String mImageUrl;

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }
}
