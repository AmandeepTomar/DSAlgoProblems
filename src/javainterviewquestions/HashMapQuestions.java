package javainterviewquestions;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashMapQuestions {

    public static void main(String[] args) {
        Map<Currency,Double> map=new HashMap<>();
        map.put(new Currency("US"),1.1);
        map.put(new Currency(null),1.2);
        map.put(null,1.4);


       assert map.get(new Currency("US"))==1.1;

     //   System.out.println(map.get(new Currency("US"))); // null
        System.out.println(map.get(new Currency(null))); // null as key 

        System.out.println(map.get(null));


    }
}


class Currency{
    private String currencyCode;

    public Currency(String currencyCode){
        this.currencyCode=currencyCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Currency currency = (Currency) o;
        System.out.println(currencyCode+" --- "+currency.currencyCode);
        return Objects.equals(currencyCode, currency.currencyCode);
    }

    @Override
    public int hashCode() {
        int hashCode=Objects.hash(currencyCode);
        System.out.println(hashCode);
        return hashCode;
    }
}
