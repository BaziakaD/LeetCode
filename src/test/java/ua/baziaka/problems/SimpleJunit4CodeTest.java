package ua.baziaka.problems;

import org.junit.Assert;
import org.junit.Test;

public class SimpleJunit4CodeTest {

    @Test
    public void test() {
        Assert.assertEquals(1, new SimpleJunit4Code().calc(1));
    }


    @Test
    public void failedTest() {
        Assert.assertEquals(1, new SimpleJunit4Code().calc(1));
    }
}