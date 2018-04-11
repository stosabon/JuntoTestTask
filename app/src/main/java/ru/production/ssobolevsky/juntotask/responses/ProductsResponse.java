package ru.production.ssobolevsky.juntotask.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import ru.production.ssobolevsky.juntotask.models.TechPostCard;

/**
 * Created by pro on 11.04.2018.
 */

public class ProductsResponse {

    @SerializedName("posts")
    @Expose
    private List<TechPostCard> mData;

    public List<TechPostCard> getData() {
        return mData;
    }

    public void setData(List<TechPostCard> data) {
        mData = data;
    }
}
