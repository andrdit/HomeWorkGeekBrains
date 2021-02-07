package test.tests;

import annotations.*;
import test.Testing;

@TestClass
public class Test1 implements Testing {

    private int priority = 2;

    @BeforeSuite
    private void beforeSuite(){
        System.out.println("beforeSuit from " + getClass().getName());
    }

    @AfterSuite
    private void afterSuite(){
        System.out.println("afterSuit from " + getClass().getName());
    }

//    @BeforeSuite
//    private void beforeSuite1(){
//        System.out.println("beforeSuit from " + Test1.class.getName());
//    }

//    @AfterSuite
//    private void afterSuite1(){
//        System.out.println("afterSuit from " + Test1.class.getName());
//    }

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
