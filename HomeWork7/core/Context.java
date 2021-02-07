package core;

import annotations.*;

import exception.CannotCreateClassObjectException;
import exception.WrongCountMethodsWithSingleAnnotation;
import org.reflections.Reflections;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.*;

public class Context {

    public static <T> T getInstanceObject(Class<T> template) {
        if (template.isAnnotationPresent(StartUp.class)) {
            StartUp startUpAnnotation = template.getAnnotation(StartUp.class);
            String packageForScan = startUpAnnotation.scanPackage();
            Set<Class<?>> testsClasses = scanPackageAndFindClassesByAnnotation(packageForScan, TestClass.class);

            Map<Object, LinkedList<Method>> instanceWithTestMethods = getInstanceWithTestMethods(testsClasses);

            return configAndGetObjectOfClass(template, instanceWithTestMethods);

        } else {
            throw new IllegalArgumentException("It is not start up class");
        }
    }

    private static <T> T configAndGetObjectOfClass(Class<T> template, Map<Object, LinkedList<Method>> instanceWithTestMethods) {

            Method serviceMethod = null;
        try {

            Method[] methods = template.getDeclaredMethods();

            for (Method o : methods) {
                if (o.isAnnotationPresent(ServiceMethod.class)) {
                    serviceMethod = o;
                }
            }

            T instance = getClassInstanceByEmptyConstructor(template);

            serviceMethod.setAccessible(true);
            serviceMethod.invoke(instance,  instanceWithTestMethods);

            return instance;

        } catch (Exception e) {
            throw new CannotCreateClassObjectException("Cannot create object of " + template.getName() + " class");
        }

    }

    private static Map<String, Object> getInstanceOfTestClasses(Set<Class<?>> testsClasses) {

        Map<String, Object> servicesMap = new HashMap<>();

        LinkedList<Method> methodLinkedList = new LinkedList<>();

        for (Class<?> testClass : testsClasses) {
            Class<?>[] interfaces = testClass.getInterfaces();

            methodLinkedList = getMethodsForTest(testClass);

            Object testClassInstance = getClassInstanceByEmptyConstructor(testClass);

            for (Class<?> anInterface : interfaces) {
                servicesMap.put(anInterface.getName(), testClassInstance);
            }
        }

        return servicesMap;
    }

    private static Map<Object, LinkedList<Method>> getInstanceWithTestMethods(Set<Class<?>> testsClasses) {

        Map<Object, LinkedList<Method>> map = new TreeMap<>();

        LinkedList<Method> methodLinkedList = new LinkedList<>();

        for (Class<?> testClass : testsClasses) {
            Class<?>[] interfaces = testClass.getInterfaces();

            methodLinkedList = getMethodsForTest(testClass);

            Object testClassInstance = getClassInstanceByEmptyConstructor(testClass);

            map.put(testClassInstance, methodLinkedList);

        }

        return map;
    }

    private static <T> T getClassInstanceByEmptyConstructor(Class<T> aClass) {
        try {
            return aClass.getConstructor().newInstance();
        }
        catch (Exception e) {
            throw new CannotCreateClassObjectException("Cannot create object of " + aClass.getName() + " class");
        }
    }

    private static Set<Class<?>> scanPackageAndFindClassesByAnnotation(String scanPackage,
                                                                       Class<? extends Annotation> annotationClass) {

        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .setUrls(ClasspathHelper.forPackage(scanPackage)));

        return reflections.getTypesAnnotatedWith(annotationClass);

    }

    private static LinkedList<Method> getMethodsForTest(Class<?> testClass){

        LinkedList<Method> listExecuteMethods = new LinkedList<>();

        try {

            int countBeforeSuiteOne = 0;
            int countAfterSuite = 0;

            Method[] methods = testClass.getDeclaredMethods();

            for (Method o : methods) {
                if (o.isAnnotationPresent(Test.class)) {
                    listExecuteMethods.add(o);
                }
            }

            for (Method o : methods) {
                if (o.isAnnotationPresent(BeforeSuite.class)) {
                    listExecuteMethods.addFirst(o);
                    countBeforeSuiteOne++;
                }
            }

            if (countBeforeSuiteOne > 1)
                throw new WrongCountMethodsWithSingleAnnotation("Class " + testClass.getName() + " has more one method with annotation @BeforeSuite");

            for (Method o : methods) {
                if (o.isAnnotationPresent(AfterSuite.class)) {
                    listExecuteMethods.addLast(o);
                    countAfterSuite++;
                }
            }

            if (countAfterSuite > 1)
                throw new WrongCountMethodsWithSingleAnnotation("Class " + testClass.getName() + " has more one method with annotation @AfterSuite");


        } catch (WrongCountMethodsWithSingleAnnotation e) {
            e.printStackTrace();
            throw new CannotCreateClassObjectException("Cannot create object of " + testClass.getName() + " class");
        }

        return listExecuteMethods;
    }

}
