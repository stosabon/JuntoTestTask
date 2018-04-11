package ru.production.ssobolevsky.juntotask.activities;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.List;

import ru.production.ssobolevsky.juntotask.R;
import ru.production.ssobolevsky.juntotask.adapters.ProductsAdapter;
import ru.production.ssobolevsky.juntotask.models.TechPostCard;
import ru.production.ssobolevsky.juntotask.presenters.MainPresenter;
import ru.production.ssobolevsky.juntotask.presenters.MainPresenterImpl;

public class MainActivity extends AppCompatActivity implements MainView {

    private RecyclerView mRecyclerView;
    private ProductsAdapter mAdapter;
    private MainPresenter mMainPresenter;
    private Toolbar mToolbar;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_list);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        mToolbar.setTitle(getTopicName());
        setSupportActionBar(mToolbar);
        mToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TopicsActivity.class);
                startActivity(intent);
            }
        });
        mMainPresenter = new MainPresenterImpl();
        mMainPresenter.attachView(this);
        mAdapter = new ProductsAdapter(this);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_posts);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mMainPresenter.loadPosts();

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mMainPresenter.loadPosts();
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });
    }


    @Override
    public void onLoadedPosts(List<TechPostCard> data) {
        mAdapter.setTechPostCards(data);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public String getSlug() {
        return getIntent().getStringExtra("Slug") != null ? getIntent().getStringExtra("Slug") : "tech";
    }
    @Override
    public String getTopicName() {
        return getIntent().getStringExtra("Topic") != null ? getIntent().getStringExtra("Topic") : "Tech";
    }

    @Override
    public void onReadyActivityStart(Intent intent) {
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMainPresenter.detachView();
    }
}
