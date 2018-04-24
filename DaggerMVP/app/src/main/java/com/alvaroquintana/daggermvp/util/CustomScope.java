package com.alvaroquintana.daggermvp.util;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Alvaro Quintana on 24-Apr-18.
 */
@Documented
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomScope {
}
