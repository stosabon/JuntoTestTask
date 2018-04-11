package ru.production.ssobolevsky.juntotask.activities;

import android.content.Intent;

import java.util.List;

import ru.production.ssobolevsky.juntotask.models.Topic;

/**
 * Created by pro on 11.04.2018.
 */

public interface TopicsView {
    /**
     * Update adapter when topics loaded.
     * @param data - topics.
     */
    void onLoadedTopics(List<Topic> data);

    void onReadyActivityStart(Intent intent);
}
