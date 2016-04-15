package test.build;

/**
 * Created by licheng on 5/3/16.
 */
public class BuilderTest {
    public static void main(String[] args) {
        ConcreteBuilder builder = new ConcreteBuilder();
        Director director = new Director();
        director.setBuilder(builder);

        director.construct();
        Product product = builder.getResult();
        System.out.println(product.toString());
    }
}
