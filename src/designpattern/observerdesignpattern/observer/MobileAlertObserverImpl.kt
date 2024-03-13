package designpattern.observerdesignpattern.observer

import designpattern.observerdesignpattern.obseravable.StockObservable

class MobileAlertObserverImpl(private val emailId:String, private val stockObservable: StockObservable) : NotificationAlertObserver {
    override fun update() {
        sendEmailToMobile("$emailId Product is in stock")
    }

    private fun sendEmailToMobile(s: String) {
        println(s)
    }
}