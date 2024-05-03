package tests_task2;

import org.example.task2.NotFoundAnswerException;
import org.example.task2.Pair;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import org.junit.jupiter.api.function.Executable;

import static java.lang.Integer.parseInt;
import static org.junit.jupiter.api.Assertions.*;

public class MathServiceTest extends AbstractMathServiceTest{

    @ParameterizedTest
    @CsvSource({
            "1, 2, 1, -1", // дискриминант равен 0
    })
    public void checkGetAnswer_DiscriminantEqualZero(String a, String b, String c, String expected) throws NotFoundAnswerException  {

        Pair result = getMathService().getAnswer(parseInt(a),parseInt(b),parseInt(c));

        assertTrue(result.toString().contains("first="+expected),"Первый корень рассчитан некорректно");
        assertTrue(result.toString().contains("second="+expected), "Второй корень рассчитан некорректно");
    }
    @ParameterizedTest
    @CsvSource({
            "1, -3, 2, 2.0, 1.0", // дискриминант больше 0
    })
    public void checkGetAnswer_DiscriminantMoreZero(String a, String b, String c, double expectedFirst, double expectedSecond) throws NotFoundAnswerException  {

        Pair result = getMathService().getAnswer(parseInt(a),parseInt(b),parseInt(c));
        assertTrue(result.toString().contains("first="+expectedFirst),"Первый корень рассчитан некорректно");
        assertTrue(result.toString().contains("second="+expectedSecond), "Второй корень рассчитан некорректно");
    }
    @ParameterizedTest
    @CsvSource({
            "10, -8, 2", // дискриминант меньше 0
    })
    public void checkGetAnswer_DiscriminantZero(String a, String b, String c) throws NotFoundAnswerException {
        Executable executable = ()-> getMathService().getAnswer(parseInt(a),parseInt(b),parseInt(c));

        assertThrows(NotFoundAnswerException.class, executable, "Должно быть выброшено исключение NotFoundAnswerException");
    }
    @ParameterizedTest
    @CsvSource({
            "1, 2, 1, 0"  //дискриминант 0, корни равны
    })
    public void checkZeroDescriminant(String a, String b, String c, String answer){
        int result = getMathService().getD(parseInt(a),parseInt(b),parseInt(c));

        assertEquals(parseInt(answer), result, "Вычисленный дискриминант не соответствует ожидаемому");
    }

    @ParameterizedTest
    @CsvSource({
        "10, -8, 2, -16", //дискриминант -16 корни равны, дискриминант меньше 0
        "20, -3, 1, -71" //дискриминант - 71 корни равны, дискриминант меньше 0
    })
    public void checkNegativeDescriminant(String a, String b, String c, String answer){
        int result = getMathService().getD(parseInt(a),parseInt(b),parseInt(c));

        assertEquals(parseInt(answer), result, "Вычисленный дискриминант не соответствует ожидаемому");
    }

    @ParameterizedTest
    @CsvSource({
            "1, -3, 2, 1", //дискриминант 1 x1 = 2, x2 = 1, дискриминант больше 0
            "3, -26, 5, 616" //дискриминант 576 x1 = 5, x2 = 0.2, дискриминант больше 0
    })
    public void checkPositiveDescriminant(String a, String b, String c, String answer){
        int result = getMathService().getD(parseInt(a),parseInt(b),parseInt(c));

        assertEquals(parseInt(answer), result, "Вычисленный дискриминант не соответствует ожидаемому");


    }
}
