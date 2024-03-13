package designpattern.observerdesignpattern.obseravable

import designpattern.observerdesignpattern.observer.NotificationAlertObserver

class IphoneObservableImpl : StockObservable {

    val observableList = mutableListOf<NotificationAlertObserver>()
    private var stockCount = 0
    override fun add(notificationAlertObserver: NotificationAlertObserver) {
        observableList.add(notificationAlertObserver)
    }

    override fun remove(notificationAlertObserver: NotificationAlertObserver) {
        observableList.remove(notificationAlertObserver)
    }

    override fun notifyAllSubscriber() {
        observableList.forEach {
            it.update()
        }
    }

    override fun setStockCount(newstockCount: Int) {
        if (stockCount == 0) {
            notifyAllSubscriber()
        }
        this.stockCount += newstockCount
    }

    override fun getStockCount(): Int {
        return stockCount
    }
}