package codeinkotlin.LruCache


class  LRUCache<K,V>(val capacity:Int){

    val cache = object : LinkedHashMap<K,V>(capacity,.75f,true){
        override fun removeEldestEntry(eldest: MutableMap.MutableEntry<K, V>?): Boolean {
            return size > capacity
        }
    }

    fun put(key:K,value:V){
        cache.put(key,value)
    }

    fun get(key: K): Any {
       return cache[key]?:-1
    }

    fun displayCache(){
        println(cache)
    }

}


fun main() {
    val lruCache = LRUCache<Int,Int>(2)
    lruCache.put(1,1)
    lruCache.put(2,2)
    println(lruCache.displayCache())
    lruCache.get(1)
    lruCache.put(3,3)
    println(lruCache.displayCache())
}