package ru.production.ssobolevsky.juntotask.presenters;

import android.content.Intent;
import android.net.Uri;

import ru.production.ssobolevsky.juntotask.activities.ProductView;
import ru.production.ssobolevsky.juntotask.models.Topic;

/**
 * Created by pro on 11.04.2018.
 */

public class ProductPresenterImpl implements ProductPresenter {

    ProductView mProductView;


    @Override
    public void attachView(ProductView view) {
        mProductView = view;
    }

    @Override
    public void detachView() {
        mProductView = null;
    }

    @Override
    public void onGetItClick() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(mProductView.getUri()));
        mProductView.onReadyActivityStart(intent);

    }
}
