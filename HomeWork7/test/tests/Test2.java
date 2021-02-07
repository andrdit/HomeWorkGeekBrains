package test.tests;

import annotations.AfterSuite;
import annotations.BeforeSuite;
import annotations.Test;
import annotations.TestClass;
import test.Testing;

@TestClass
public class Test2 implements Testing {

    private int priority = 3;

    @BeforeSuite
    private void beforeSuite(){
        System.out.println("beforeSuit from " + getClass().getName());
    }

    @AfterSuite
    private void afterSuite(){
        System.out.println("afterSuit from " + getClass().getName());
    }

    @Test
    private void testMethod1(){
        System.out.println("testMethod1() from " + getClass().getName());
    }

    @Test
    private void testMethod2(){
        System.out.println("testMethod2() from " + getClass().getName());
    }

    @Test
    private void testMethod3(){
        System.out.println("testMethod3() from " + getClass().getName());
    }

    @Test
    private void testMethod4(){
        System.out.println("testMethod4() from " + getClass().getName());
    }

    @Test
    private void testMethod5() {
        System.out.println("testMethod5() from " + getClass().getName());
    }

    @Override
    public int compareTo(Object o) {

        Testing another = (Testing) o;
        if (this.priority > another.getPriority()) {
            return 1;
        }
        if (this.priority < another.getPriority()) {
            return -1;
        }
        return 0;
    }

    @Override
    public int getPriority() {
        return priority;
    }
}
