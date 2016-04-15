package test;

/**
 * Created by licheng on 1/3/16.
 */
public class ConcreteFactoryA extends Factory {
    @Override
    Product factoryMethod() {
        return new ConcreteProductA();
    }
}
