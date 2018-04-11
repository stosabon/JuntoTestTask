package ru.production.ssobolevsky.juntotask.activities;

import android.content.Intent;

/**
 * Created by pro on 11.04.2018.
 */

public interface ProductView {

    String getUri();

    void onReadyActivityStart(Intent intent);
}
