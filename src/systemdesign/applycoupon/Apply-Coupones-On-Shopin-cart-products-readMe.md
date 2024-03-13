# Apply Coupons on Shopping cart products And calculate the final cost

- Coupon can be different conditions
- For each product multiple coupon can be applied at a time.
  - It is similar to decorator pattern. 
  - Coupon1 -> Coupon2->Coupon3
  - 100->90->80

## Flow

## Requirements

## objects
- ShoppingCart
- Coupon
- Products

## LLD

```java
import java.util.ArrayList;
import java.util.List;

class ShoppingCart {
    List<Procuct> procuctList;

    ShoppingCart() {
        procuctList = new ArrayList<>();
    }

    public void addToCart(Product product) {
        Product newProduct = new TypeCouponDecorator(new PercentageCouponDecorator(product, 10), 3, product.productType);
        procuctList.add(newProduct);
    }

    public double getTotalPrice() {
        int total = 0;
        for (Product product : procuctList) {
            total = total + product.getPrice();
        }
        return total;
    }

}

class Coupon {


}

abstract class Product {
    String name;
    double originalPrice;
    ProductType productType;

    abstract double getPrice();
}

enum ProductType {
    ELECTRONIC, HOME,
}

class Item1 extends Product {

    Item1(String name, double originalPrice, ProductType productType) {
        super(name, originalPrice, productType);
    }

    @Override
    double getPrice() {
        return originalPrice;
    }
}

class Item2 extends Product {

    Item2(String name, double originalPrice, ProductType productType) {
        super(name, originalPrice, productType);
    }

    @Override
    double getPrice() {
        return originalPrice;
    }
}

// create the coupon decorator 
abstract class CouponDecorator extends Product {

}

class PercentageCouponDecorator extends CouponDecorator {
    Product product;
    int percentageDiscount;

    PercentageCouponDecorator(Product product, int percentageDiscount) {
        this.percentageDiscount = percentageDiscount;
        this.product = product;
    }

    @Override
    double getPrice() {
        double price = product.getPrice();
        return (price - (price * percentageDiscount) / 100);
    }
}

class TypeCouponDecorator extends CouponDecorator {
    Product product;
    int percentageDiscount;
    ProductType productType;

    static List<ProductType> eligibleTypes = new ArrayList<>();

    static {
        eligibleTypes.add(ProductType.ELECTRONIC);
        eligibleTypes.add(ProductType.HOME);
    }

    TypeCouponDecorator(Product product, int percentageDiscount, ProductType productType) {
        this.percentageDiscount = percentageDiscount;
        this.product = product;
        this.productType = productType;
    }

    @Override
    double getPrice() {
        double price = product.getPrice();
        if (eligibleTypes.contains(productType))
            return (price - (price * percentageDiscount) / 100);
        else price;
    }
}


class TestApp {
    public static void main(String[] args) {
        Product product = Item1("Name", 100, ProductType.HOME);
        Product product2 = Item2("Name", 100, ProductType.ELECTRONIC);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addToCart(product);
        shoppingCart.addToCart(product2);
        shoppingCart.getTotalPrice();
    }

}

```