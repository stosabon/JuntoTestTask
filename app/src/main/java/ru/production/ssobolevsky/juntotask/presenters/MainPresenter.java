package ru.production.ssobolevsky.juntotask.presenters;

import ru.production.ssobolevsky.juntotask.activities.MainView;

/**
 * Created by pro on 11.04.2018.
 */

public interface MainPresenter {

    void detachView();

    void attachView(MainView mainView);

    /**
     * Load products of given category for today.
     */
    void loadPosts();



}
