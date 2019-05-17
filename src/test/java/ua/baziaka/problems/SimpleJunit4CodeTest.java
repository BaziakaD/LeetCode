package ua.baziaka.problems;

import org.junit.Assert;
import org.junit.Test;

class SimpleJunit4CodeTest {

    @Test
    public void test() {
        SimpleJunit4Code simpleJunit4Code = new SimpleJunit4Code();

        Assert.assertEquals(1, simpleJunit4Code.calc(1));
    }


    @Test
    public void faildeTest() {
        SimpleJunit4Code simpleJunit4Code = new SimpleJunit4Code();

        Assert.assertEquals(1, simpleJunit4Code.calc(1));
    }

}