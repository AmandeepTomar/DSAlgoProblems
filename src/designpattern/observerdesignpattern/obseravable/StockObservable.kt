package designpattern.observerdesignpattern.obseravable

import designpattern.observerdesignpattern.observer.NotificationAlertObserver

interface StockObservable {

    fun add(notificationAlertObserver: NotificationAlertObserver)

    fun remove(notificationAlertObserver: NotificationAlertObserver)

    fun notifyAllSubscriber()

    fun setStockCount(stockCount: Int)

    fun getStockCount(): Int
}