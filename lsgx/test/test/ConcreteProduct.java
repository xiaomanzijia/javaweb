package test;

/**
 * Created by licheng on 1/3/16.
 */
public class ConcreteProduct extends Product {
    @Override
    void use() {
        System.out.println("生产具体商品");
    }
}
