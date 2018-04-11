package ru.production.ssobolevsky.juntotask.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import ru.production.ssobolevsky.juntotask.models.Topic;

/**
 * Created by pro on 11.04.2018.
 */

public class TopicsResponse {

    @SerializedName("topics")
    @Expose
    private List<Topic> data;

    public List<Topic> getData() {
        return data;
    }

    public void setData(List<Topic> data) {
        this.data = data;
    }
}
