package test.abstarctfactory;


/**
 * Created by licheng on 5/3/16.
 */
public class ConceteFacotry1 implements AbstractFactory {

    @Override
    public AbstractProduct createProductA() {
        return new ProductA1();
    }

    @Override
    public AbstractProduct createProductB() {
        return new ProductA2();
    }
}
