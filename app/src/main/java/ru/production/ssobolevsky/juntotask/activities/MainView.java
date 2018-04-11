package ru.production.ssobolevsky.juntotask.activities;

import android.content.Intent;

import java.util.List;

import ru.production.ssobolevsky.juntotask.models.TechPostCard;

/**
 * Created by pro on 11.04.2018.
 */

public interface MainView {
    /**
     * Update adapter when products loaded.
     * @param data - products.
     */
    void onLoadedPosts(List<TechPostCard> data);

    String getSlug();

    String getTopicName();

    void onReadyActivityStart(Intent intent);
}
