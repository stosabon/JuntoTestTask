package ru.production.ssobolevsky.juntotask.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by pro on 11.04.2018.
 */

public class Topic {

    @SerializedName("name")
    @Expose
    private String mName;

    @SerializedName("slug")
    @Expose
    private String mSlug;

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getSlug() {
        return mSlug;
    }

    public void setSlug(String slug) {
        mSlug = slug;
    }
}
