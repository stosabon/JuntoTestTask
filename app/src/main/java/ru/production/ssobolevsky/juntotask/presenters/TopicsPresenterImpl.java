package ru.production.ssobolevsky.juntotask.presenters;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.production.ssobolevsky.juntotask.responses.ApiProductHuntPost;
import ru.production.ssobolevsky.juntotask.retrofit.ApiUtils;
import ru.production.ssobolevsky.juntotask.responses.TopicsResponse;
import ru.production.ssobolevsky.juntotask.activities.TopicsView;

/**
 * Created by pro on 11.04.2018.
 */

public class TopicsPresenterImpl implements TopicsPresenter {

    private TopicsView mTopicsView;
    private ApiProductHuntPost mService;
    @Override
    public void detachView() {
        mTopicsView = null;
        mService = null;
    }

    @Override
    public void attachView(TopicsView mainView) {
        this.mTopicsView = mainView;
        mService = ApiUtils.getApiService();
    }

    @Override
    public void loadTopics() {
        mService.getTrendingTopics().enqueue(new Callback<TopicsResponse>() {
            @Override
            public void onResponse(Call<TopicsResponse> call, Response<TopicsResponse> response) {
                mTopicsView.onLoadedTopics(response.body().getData());
                Log.d("MainActivity", "topics loaded from API");
            }

            @Override
            public void onFailure(Call<TopicsResponse> call, Throwable t) {
                Log.d("MainActivity", "topics dont loaded from API");
            }
        });
    }
}
