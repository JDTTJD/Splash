package com.tuoren.http.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import androidx.annotation.IntDef;

import static com.tuoren.http.annotation.RequestMethod.Get;
import static com.tuoren.http.annotation.RequestMethod.Post;

/**
 * Create by JDT on 2019/11/15.
 */
@IntDef({Get,Post})
@Retention(RetentionPolicy.SOURCE)
public @interface RequestMethod {
    int Get = 1;
    int Post = 2;
}
