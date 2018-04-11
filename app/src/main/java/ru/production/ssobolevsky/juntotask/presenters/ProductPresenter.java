package ru.production.ssobolevsky.juntotask.presenters;

import ru.production.ssobolevsky.juntotask.activities.ProductView;

/**
 * Created by pro on 11.04.2018.
 */

public interface ProductPresenter {

    void attachView(ProductView view);

    void detachView();
    /**
     * Action when GetIt button clicked.
     */
    void onGetItClick();
}
