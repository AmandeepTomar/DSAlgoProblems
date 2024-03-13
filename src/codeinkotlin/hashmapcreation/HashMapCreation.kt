package codeinkotlin.hashmapcreation


class Map<K,V>{
    data class EntryMap<K,V>(val key:K,val value: V)
    var capacity = 16
    val table = Array<MutableList<EntryMap<K,V>>?>(capacity){null}


}


fun main() {

}