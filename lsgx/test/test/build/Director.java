package test.build;

/**
 * Created by licheng on 5/3/16.
 */
public class Director {
    private Builder pbuilder;

    public void construct(){
        pbuilder.buildPartA();
        pbuilder.buildPartB();
        pbuilder.buildPartC();
    }

    public void setBuilder(Builder builder){
        pbuilder = builder;
    }
}
