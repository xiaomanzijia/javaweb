package test.abstarctfactory;

/**
 * Created by licheng on 5/3/16.
 */
public class ConcreteFactory2 implements AbstractFactory {
    @Override
    public AbstractProduct createProductA() {
        return new ProductA2();
    }

    @Override
    public AbstractProduct createProductB() {
        return new ProductB2();
    }
}
