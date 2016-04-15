package test;

/**
 * Created by licheng on 1/3/16.
 */
public class ConcreteFactory extends Factory {

    @Override
    Product factoryMethod() {
        return new ConcreteProduct();
    }
}
