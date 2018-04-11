package ru.production.ssobolevsky.juntotask.presenters;

import ru.production.ssobolevsky.juntotask.activities.MainView;
import ru.production.ssobolevsky.juntotask.activities.TopicsView;
import ru.production.ssobolevsky.juntotask.models.Topic;

/**
 * Created by pro on 11.04.2018.
 */

public interface TopicsPresenter {

    void detachView();

    void attachView(TopicsView mainView);

    /**
     * Load trending topics.
     */
    void loadTopics();
}
