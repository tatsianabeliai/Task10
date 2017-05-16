import org.junit.*;
import org.junit.experimental.categories.Category;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClassOneTest {

    @BeforeClass
    public static void onceExecutedBeforeAll() {
        System.out.println("@BeforeClass: executedBeforeAllTests");
    }

    @Before
    public void executedBeforeEachTest() {
        System.out.println("@Before: executedBeforeEachTest");
    }

    @After
    public void executedAfterEachTest() {
        System.out.println("@After: executedAfterEachTest");
    }

    @AfterClass
    public static void onceExecutedAfterAll() {
        System.out.println("@AfterClass: executedAfterAllTests");
    }


    public final static int x = 50;
    public final static int y = 5;

    @Category(SlowTests.class)
    @Test
    public void addTest() {
        Mathematics mathematics = new Mathematics();
        mathematics.add(x, y);
        int result = mathematics.getResult();
        assertEquals("Not Expected sum result", 55, result);

    }

    @Category(SlowTests.class)
    @Test(timeout = 1000)
    public void deductTest() throws InterruptedException {
        Mathematics mathematics = new Mathematics();
        mathematics.setResult(1);
        Thread.sleep(1500);
        mathematics.deduct(x, y);
        int result = mathematics.getResult();
        assertEquals("Not Expected Deduct result",45, result);
    }

    @Category(SlowTests.class)
    @Test
    public void multiplyTest() {
        Mathematics mathematics = new Mathematics();
        mathematics.multiply(x, y);
        int result = mathematics.getResult();
        assertEquals("Not Expected Multiply result",250, result);
    }

    @Category(SlowTests.class)
    @Test
    public void divideTest() {
        Mathematics mathematics = new Mathematics();
        mathematics.divide(x, y);
        int result = mathematics.getResult();
        assertEquals("Not Expected Divide result",10, result);
    }

    @Category(SlowTests.class)
    @Test
    public void divideByZeroTest() {
        Mathematics mathematics = new Mathematics();
        mathematics.divide(1, 0);
        int result = mathematics.getResult();
        assertEquals("Not Expected Divide By zero result",0, result);
    }
}
