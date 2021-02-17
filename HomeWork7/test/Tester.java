package test;

import annotations.*;
import core.Context;
import java.lang.reflect.Method;
import java.util.*;


@StartUp(scanPackage = "test.tests")
public class Tester {

    @Autowired
    private static Set<Testing> tests;

    private static Map<Testing, LinkedList<Method>> servicesMap;


    public static void start(Class<?> testerClass){

        try {
            Tester tester = (Tester) Context.getInstanceObject(testerClass);

            for (Map.Entry<Testing, LinkedList<Method>> o : servicesMap.entrySet()) {

                LinkedList<Method> methodLinkedList = o.getValue();

                for (Method m: methodLinkedList){
                    m.setAccessible(true);
                    m.invoke(o.getKey(), null);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        start(Tester.class);
    }

    public Tester() {
        servicesMap = new TreeMap<>();
    }

    @ServiceMethod
    private void addValueToMap(Map<Testing, LinkedList<Method>> instanceWithTestMethods){
        servicesMap = instanceWithTestMethods;
    }

}
