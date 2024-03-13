package designpattern.observerdesignpattern

import designpattern.observerdesignpattern.obseravable.IphoneObservableImpl
import designpattern.observerdesignpattern.observer.EmailAlertObserverImpl
import designpattern.observerdesignpattern.observer.MobileAlertObserverImpl

fun main() {

    val iphoneObservable = IphoneObservableImpl()

    val emailAlertObserverImpl = EmailAlertObserverImpl("abc@gmail.com", iphoneObservable)
    val emailAlertObserverImpl2 = EmailAlertObserverImpl("abc1@gmail.com", iphoneObservable)
    val emailAlertObserverImpl3 = MobileAlertObserverImpl("mobile@gmail.com", iphoneObservable)

    iphoneObservable.add(emailAlertObserverImpl3)
    iphoneObservable.add(emailAlertObserverImpl2)
    iphoneObservable.add(emailAlertObserverImpl)

    iphoneObservable.setStockCount(10)
}