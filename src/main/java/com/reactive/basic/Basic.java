package com.reactive.basic;

import rx.Observable;

public class Basic {
  public static void main(String[] args) {
    createObservableWithJust();
  }

  public static void createObservableWithJust(){
    Observable<Integer> observable = Observable.just(1, 2, 3, 4, 5);
    observable.subscribe(x -> System.out.println(x));
  }
}
