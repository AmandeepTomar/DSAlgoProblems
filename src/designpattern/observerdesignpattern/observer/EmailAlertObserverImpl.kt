package designpattern.observerdesignpattern.observer

import designpattern.observerdesignpattern.obseravable.StockObservable

class EmailAlertObserverImpl(private val email: String, private val stockObservable: StockObservable) : NotificationAlertObserver {


    override fun update() {
        sendEmailId("$email Product is in stock")
    }

    private fun sendEmailId(s: String) {
        println(s)
    }
}