package com.reactive.basic;

import rx.Observable;
import rx.Observer;

import java.util.Arrays;

public class Basic {
  public static void main(String[] args) {
    /*createObservableWithJust();
    createObservablwWithIterable();
    cretaEmittor();*/
    obserbableWithObserver();
  }

  public static void createObservableWithJust(){
    System.out.println("just");
    Observable<Integer> observable = Observable.just(1, 2, 3, 4, 5);
    observable.subscribe(x -> System.out.println(x));
  }

  public static void createObservablwWithIterable(){
    System.out.println("\niterable");
    Observable<Integer> observable = Observable.from(Arrays.asList(1, 2, 3, 4, 5));
    observable.subscribe(x -> System.out.println(x));
  }

  public static void cretaEmittor(){
    System.out.println("\nEmittor");
    Observable<String> observable = Observable.create(integerEmitter -> {
      integerEmitter.onNext("1");
      integerEmitter.onNext("2");
      integerEmitter.onNext("3");
      //throw new RuntimeException();
      integerEmitter.onCompleted();
    });

    observable.subscribe( x -> System.out.println(x),
        error -> System.out.println("Got error : " + error.getLocalizedMessage()),
        () -> System.out.println("Completed"));
  }

  public static void obserbableWithObserver(){
    Integer sum = 0;
    Observable<Integer> observable = Observable.from(Arrays.asList(1, 2, 3, 4, 5))
        .map(x -> x + 1)
        .filter(x -> x % 2 == 0);

    Observer<Integer> observer =  new Observer<Integer>() {
        @Override
        public void onCompleted() {
          System.out.println("Completed process");
        }

        @Override
        public void onError(Throwable throwable) {
          System.out.println(throwable.getLocalizedMessage());
        }

        @Override
        public void onNext(Integer integer) {
          System.out.println("Got it : " + integer);
        }
    };
    observable.subscribe(observer);
  }
}
