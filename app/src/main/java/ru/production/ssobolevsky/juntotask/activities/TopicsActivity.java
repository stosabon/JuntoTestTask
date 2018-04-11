package ru.production.ssobolevsky.juntotask.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import java.util.List;

import ru.production.ssobolevsky.juntotask.R;
import ru.production.ssobolevsky.juntotask.adapters.ProductsAdapter;
import ru.production.ssobolevsky.juntotask.adapters.TopicsAdapter;
import ru.production.ssobolevsky.juntotask.models.Topic;
import ru.production.ssobolevsky.juntotask.presenters.MainPresenter;
import ru.production.ssobolevsky.juntotask.presenters.TopicsPresenter;
import ru.production.ssobolevsky.juntotask.presenters.TopicsPresenterImpl;

/**
 * Created by pro on 11.04.2018.
 */

public class TopicsActivity extends AppCompatActivity implements TopicsView {

    private RecyclerView mRecyclerView;
    private TopicsAdapter mAdapter;
    private TopicsPresenter mTopicsPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topics);
        mTopicsPresenter = new TopicsPresenterImpl();
        mTopicsPresenter.attachView(this);
        mAdapter = new TopicsAdapter(this);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_topics);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mTopicsPresenter.loadTopics();
    }

    @Override
    public void onLoadedTopics(List<Topic> data) {
        mAdapter.setTopics(data);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onReadyActivityStart(Intent intent) {
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mTopicsPresenter.detachView();
    }
}
