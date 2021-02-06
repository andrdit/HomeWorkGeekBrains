import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private Main main = new Main();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void main() {
    }

    @Test
    void getArray() {
        int[] array = {1, 2, 3, 5, 2, 3, 4, 1, 7};
        int[] arr = main.getArray(array);
        Assertions.assertArrayEquals(new int[]{1,7}, arr);
    }

    @Test
    void checkExceptionGetArray() {

        final int[] array = {1, 2, 3, 5, 2, 3, 0, 1, 7}; //dosen't contain number 4

        RuntimeException runtimeException = assertThrows(RuntimeException.class,
                () -> main.getArray(array));

        Assertions.assertEquals("Array doesn't contain number 4", runtimeException.getMessage());
    }


    @ParameterizedTest
    @MethodSource("getArraysForTest")
    void getArrayParameterizedTest(int[] array, int[] result) {

        int[] arr = main.getArray(array);

        Assertions.assertArrayEquals(result, arr);
    }

    public static Stream<Arguments> getArraysForTest (){

        List<Arguments> out = new ArrayList();

        out.add(Arguments.arguments(new int[]{1, 2, 3, 5, 2, 3, 4, 1, 7}, new int[]{1,7}));
        out.add(Arguments.arguments(new int[]{1, 2, 3, 5, 2, 3, 4, 1, 4}, new int[]{}));
        out.add(Arguments.arguments(new int[]{1, 2, 3, 4, 2, 3, 7, 1, 7}, new int[]{2,3,7,1,7}));

        return out.stream();

    }

    @ParameterizedTest
    @MethodSource("getArraysForTestcheckException")
    void checkExceptionGetArrayParameterizedTest(int[] array) {

        RuntimeException runtimeException = assertThrows(RuntimeException.class,
                () -> main.getArray(array));

        Assertions.assertEquals("Array doesn't contain number 4", runtimeException.getMessage());
    }

    public static Stream<Arguments> getArraysForTestcheckException (){

        List<Arguments> out = new ArrayList();

        out.add(Arguments.arguments(new int[]{1, 4, 3, 5, 2, 3, 0, 1, 7}));
        out.add(Arguments.arguments(new int[]{1, 2, 3, 5, 2, 3, 10, 1, 5}));
        out.add(Arguments.arguments(new int[]{1, 2, 3, 8, 2, 4, 7, 1, 7}));

        return out.stream();

    }

    @ParameterizedTest
    @MethodSource("getArraysForCheckContains")
    void checkContains(int[] array, boolean result) {

        boolean isCorrect = main.checkContains(array);

        Assertions.assertEquals(result, isCorrect);
    }

    public static Stream<Arguments> getArraysForCheckContains (){

        List<Arguments> out = new ArrayList();

        out.add(Arguments.arguments(new int[]{1, 1, 1, 4, 4, 4, 1, 4, 4}, true));
        out.add(Arguments.arguments(new int[]{1, 1, 1, 1}, false));
        out.add(Arguments.arguments(new int[]{4, 4, 4, 4, 4, 4}, false));
        out.add(Arguments.arguments(new int[]{1, 4, 4, 1, 4, 3}, false));

        return out.stream();
    }
}