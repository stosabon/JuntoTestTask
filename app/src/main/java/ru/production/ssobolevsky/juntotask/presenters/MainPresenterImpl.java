package ru.production.ssobolevsky.juntotask.presenters;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.production.ssobolevsky.juntotask.responses.ApiProductHuntPost;
import ru.production.ssobolevsky.juntotask.retrofit.ApiUtils;
import ru.production.ssobolevsky.juntotask.responses.ProductsResponse;
import ru.production.ssobolevsky.juntotask.activities.MainView;

/**
 * Created by pro on 11.04.2018.
 */

public class MainPresenterImpl implements MainPresenter {

    private MainView mMainView;
    private ApiProductHuntPost mService;
    @Override
    public void detachView() {
        mMainView = null;
        mService = null;
    }

    @Override
    public void attachView(MainView mainView) {
        this.mMainView = mainView;
        mService = ApiUtils.getApiService();
    }

    @Override
    public void loadPosts() {
        Log.d("MainActivity", mMainView.getSlug());
        mService.getTechPosts(mMainView.getSlug()).enqueue(new Callback<ProductsResponse>() {
            @Override
            public void onResponse(Call<ProductsResponse> call, Response<ProductsResponse> response) {
                mMainView.onLoadedPosts(response.body().getData());
                Log.d("MainActivity", "posts loaded from API");
            }

            @Override
            public void onFailure(Call<ProductsResponse> call, Throwable t) {
                Log.d("MainActivity", "error loading from API");

            }
        });
    }


}
