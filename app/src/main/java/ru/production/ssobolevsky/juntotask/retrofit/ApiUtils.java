package ru.production.ssobolevsky.juntotask.retrofit;

import ru.production.ssobolevsky.juntotask.responses.ApiProductHuntPost;

/**
 * Created by pro on 06.04.2018.
 */

public class ApiUtils {
    public static final String BASE_URL = "https://api.producthunt.com/";

    public static ApiProductHuntPost getApiService() {
        return RetrofitClient.getClient(BASE_URL).create(ApiProductHuntPost.class);
    }
}
