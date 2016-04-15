package test.build;

/**
 * Created by licheng on 5/3/16.
 */
public class ConcreteBuilder implements Builder {
    Product product = new Product();

    @Override
    public void buildPartA() {
        product.setPart1("编号：9527");
    }

    @Override
    public void buildPartB() {
        product.setPart2("颜色：红色");
    }

    @Override
    public void buildPartC() {
        product.setPart3("生产厂商：鸿基");
    }

    @Override
    public Product getResult() {
        return product;
    }
}
