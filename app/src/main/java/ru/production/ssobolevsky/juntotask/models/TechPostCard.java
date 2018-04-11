package ru.production.ssobolevsky.juntotask.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by pro on 06.04.2018.
 */

public class TechPostCard {

    @SerializedName("name")
    @Expose
    private String mName;

    @SerializedName("tagline")
    @Expose
    private String mDescription;

    @SerializedName("votes_count")
    @Expose
    private String mVotesCount;

    @SerializedName("thumbnail")
    @Expose
    private Thumbnail mThumbnail;

    @SerializedName("screenshot_url")
    @Expose
    private Screenshot mScreenshot;

    @SerializedName("discussion_url")
    @Expose
    private String mWebPage;

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getVotesCount() {
        return mVotesCount;
    }

    public void setVotesCount(String votesCount) {
        mVotesCount = votesCount;
    }

    public Thumbnail getThumbnail() {
        return mThumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        mThumbnail = thumbnail;
    }

    public Screenshot getScreenshot() {
        return mScreenshot;
    }

    public void setScreenshot(Screenshot screenshot) {
        mScreenshot = screenshot;
    }

    public String getWebPage() {
        return mWebPage;
    }

    public void setWebPage(String webPage) {
        mWebPage = webPage;
    }
}
