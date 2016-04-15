package test;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by lin on 2016/1/6.
 */
public class SimpleTest extends TestCase {

    @Test
    public void testString1(){
        double val = Double.parseDouble("abc");
        System.out.println("val = " + val);
    }
}
