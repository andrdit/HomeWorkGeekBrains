package test.tests;

import annotations.AfterSuite;
import annotations.BeforeSuite;
import annotations.Test;
import annotations.TestClass;
import test.Testing;

@TestClass
public class Test3 implements Testing {

    private int priority = 1;

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

//    @AfterSuite
//    private void afterSuite1(){
//        System.out.println("afterSuit from " + getClass().getName());
//    }

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
