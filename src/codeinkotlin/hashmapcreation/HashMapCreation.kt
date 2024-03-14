package codeinkotlin.hashmapcreation

import kotlin.coroutines.CoroutineContext


class CustomMap<K, V> constructor(val initialCalacity: Int = INITIAL_CAPACITY) {

    companion object {
        val INITIAL_CAPACITY = 16
        val LOAD_FACTOR = .75
    }

    data class Entry<K, V>(val key: K, var value: V)

    var buckets: Array<MutableList<Entry<K, V>?>>

    private val size: Int
        get() {
            var count = 0
            for (bucket in buckets) {
                count += bucket.size
            }
            return count
        }

    init {
        buckets = Array(initialCalacity) { mutableListOf() }
    }

    fun getHashCode(key: K): Int {
        return key.hashCode().rem(buckets.size)
    }


    fun put(key: K, value: V) {
        val index = getHashCode(key)
        for (entry in buckets[index]) {
            entry?.let {
                if (it.key == key) {
                    it.value = value
                }
            }
        }

        buckets[index]?.add(Entry(key, value))

        if (size.toDouble() / buckets.size >= LOAD_FACTOR) {
            resize()
        }

    }

    fun get(key: K): V? {
        val index = getHashCode(key)
        for (entry in buckets[index]) {
            if (entry?.key == key) {
                return entry?.value
            }
        }
        return null

    }

    fun remove(key: K): Boolean? {
        val index = getHashCode(key)
        val value = get(key)
        return value?.let {
            buckets[index].remove(Entry(key, value))
        }
    }

    fun resize() {
        val newCapacity = initialCalacity * 2
        val newBuckets = Array(newCapacity) { mutableListOf<Entry<K, V>?>() }
        for (bucket in buckets) {
            for (entry in bucket) {
                val newIndex = entry?.key.hashCode().rem(newCapacity)
                newBuckets[newIndex]?.add(entry)
            }
        }
        buckets = newBuckets
    }

    fun print() {

        for (i in buckets.indices) {
            for (entry in buckets[i]) {
                entry?.let {
                    print("${it?.key} ${it.value} ")
                }
            }
        }
        println()
    }

}


fun main() {

    val map = CustomMap<String, String>()
    map.put("A", "Aman")
    map.print()
    map.put("K", "Komal")
    map.print()
    map.put("C", "Data")

    map.print()

    val value = map.get("A")
    println(value)
    val remopved = map.remove("A")
    println(remopved)
    val value1 = map.get("A")
    println(value1)

    println(map.buckets.size)

}