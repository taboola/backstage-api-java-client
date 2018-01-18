package com.taboola.backstage.internal.functional;

/**
 * Created by vladi
 * Date: 1/18/2018
 * Time: 12:06 AM
 * By Taboola
 */
@FunctionalInterface
public interface BiFunction<A,B,R,T extends Throwable> {
    R apply(A a, B b) throws T;
}
