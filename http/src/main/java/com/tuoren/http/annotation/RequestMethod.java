package com.tuoren.http.annotation;

import androidx.annotation.IntDef;

import static com.tuoren.http.annotation.RequestMethod.Get;
import static com.tuoren.http.annotation.RequestMethod.Post;

/**
 * Create by JDT on 2019/11/15.
 */
@IntDef({Get,Post})
public @interface RequestMethod {
    int Get = 1;
    int Post = 2;
}
