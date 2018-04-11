package ru.production.ssobolevsky.juntotask.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import ru.production.ssobolevsky.juntotask.R;
import ru.production.ssobolevsky.juntotask.presenters.ProductPresenter;
import ru.production.ssobolevsky.juntotask.presenters.ProductPresenterImpl;

public class ProductActivity extends AppCompatActivity implements ProductView {


    private TextView mName;
    private TextView mDesc;
    private TextView mVotesCount;
    private Button mGetItButton;
    private ImageView mScreenshotImage;
    ProductPresenter mProductPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        mName = (TextView) findViewById(R.id.product_name);
        mDesc = (TextView) findViewById(R.id.product_desc);
        mVotesCount = (TextView) findViewById(R.id.product_upvotes);
        mGetItButton = (Button) findViewById(R.id.get_it_btn);
        mScreenshotImage = (ImageView) findViewById(R.id.product_img);

        mName.setText(getIntent().getStringExtra("name"));
        mDesc.setText(getIntent().getStringExtra("desc"));
        mVotesCount.setText(getIntent().getStringExtra("votes") + " upvotes");
        Picasso.get().load(getIntent().getStringExtra("screenshot")).into(mScreenshotImage);

        mProductPresenter = new ProductPresenterImpl();
        mProductPresenter.attachView(this);

        mGetItButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mProductPresenter.onGetItClick();
            }
        });

    }

    @Override
    public void onReadyActivityStart(Intent intent) {
        startActivity(intent);
    }

    @Override
    public String getUri() {
        return getIntent().getStringExtra("page");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mProductPresenter.detachView();
    }
}
