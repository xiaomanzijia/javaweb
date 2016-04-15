package test;

/**
 * Created by licheng on 1/3/16.
 */
public class FactoryTest {
    public static void main(String[] args) {
        Factory c = new ConcreteFactory();
        Factory a = new ConcreteFactoryA();
        c.factoryMethod().use();
        a.factoryMethod().use();
    }
}
