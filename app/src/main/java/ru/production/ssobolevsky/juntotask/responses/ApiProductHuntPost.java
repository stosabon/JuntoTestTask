package ru.production.ssobolevsky.juntotask.responses;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import ru.production.ssobolevsky.juntotask.responses.ProductsResponse;
import ru.production.ssobolevsky.juntotask.responses.TopicsResponse;

/**
 * Created by pro on 06.04.2018.
 */

public interface ApiProductHuntPost {
    /**
     * Returns posts of given category for today.
     * @param topic - category.
     * @return call/
     */
    @Headers({"Authorization: Bearer 591f99547f569b05ba7d8777e2e0824eea16c440292cce1f8dfb3952cc9937ff"})
    @GET("v1/categories/{topic}/posts")
    Call<ProductsResponse> getTechPosts(@Path("topic") String topic);
    /**
     * Returns trending topics.
     * @return call/
     */
    @Headers({"Authorization: Bearer 591f99547f569b05ba7d8777e2e0824eea16c440292cce1f8dfb3952cc9937ff"})
    @GET("/v1/topics?search[trending]=true")
    Call<TopicsResponse> getTrendingTopics();
}
