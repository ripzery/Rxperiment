package com.ripzery.rxperiment.model;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subjects.ReplaySubject;

/**
 * Created by Euro on 3/7/16 AD.
 */
public class RandomInteger {
    private Integer randomInteger;
    private ReplaySubject<Integer> randomSubject = ReplaySubject.create();

    /* ... */

    public void setRandomInteger(Integer newInteger) {
        this.randomInteger = newInteger;
        this.randomSubject.onNext(this.randomInteger);
    }

    public Observable<Integer> getRandomIntSubject() {
        return this.randomSubject.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io());
    }
}
