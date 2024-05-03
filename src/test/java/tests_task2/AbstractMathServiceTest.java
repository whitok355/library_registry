package tests_task2;

import org.example.task2.MathService;
import org.junit.jupiter.api.BeforeAll;

public abstract class AbstractMathServiceTest {
    private static MathService mathService;
    public MathService getMathService() {
        return mathService;
    }
    @BeforeAll
    public static void init(){
        mathService = new MathService();
    }
}
