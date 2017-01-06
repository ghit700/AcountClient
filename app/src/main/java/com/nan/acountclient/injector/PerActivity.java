package com.nan.acountclient.injector;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by wzn on 2017/1/6.
 */

@Scope
@Retention(RUNTIME) public @interface PerActivity {
}
