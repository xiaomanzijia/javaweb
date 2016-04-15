package test.abstarctfactory;

/**
 * Created by licheng on 5/3/16.
 */
public class AbstractFactoryTest {
    public static void main(String[] args) {
        AbstractFactory factory1 = new ConceteFacotry1();
        AbstractFactory factory2 = new ConcreteFactory2();
        factory1.createProductA().use();
        factory1.createProductB().use();
        factory2.createProductA().use();
        factory2.createProductB().use();
    }
}
