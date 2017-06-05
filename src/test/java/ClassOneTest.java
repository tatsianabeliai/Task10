import org.apache.log4j.Logger;
import org.junit.*;
import org.junit.experimental.categories.Category;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClassOneTest {
    final static int numberOne = 50;
    final static int numberTwo = 5;
    final static int sumResult = 55;
    final static int deductResult = 45;
    final static int divideResult = 10;
    final static int multiplyResult = 250;
    private static final Logger LOG = Logger.getLogger(ClassOneTest.class);
    private Mathematics mathematics;

    @BeforeClass
    public static void onceExecutedBeforeAll() {
        LOG.info("@BeforeClass: executedBeforeAllTests");
    }

    @AfterClass
    public static void onceExecutedAfterAll() {
        LOG.info("@AfterClass: executedAfterAllTests");
    }

    @Before
    public void executedBeforeEachTest() {
        LOG.info("@Before: executedBeforeEachTest");
        mathematics = new Mathematics();
    }

    @After
    public void executedAfterEachTest() {
        LOG.info("@After: executedAfterEachTest");
        mathematics.setResult(0);
    }

    @Category(SlowTests.class)
    @Test
    public void addTest() {
        mathematics.add(numberOne, numberTwo);
        int result = mathematics.getResult();
        assertEquals("Not expected result is displayed", sumResult, result);
    }

    @Category(SlowTests.class)
    @Test(timeout = 1000)
    public void deductTest() {
        mathematics.setResult(1);
        try {
            Thread.sleep(1500);
        } catch (InterruptedException ex) {
            LOG.error(ex);
            Assert.fail("The exception has been caught " + ex);
        }
        mathematics.deduct(numberOne, numberTwo);
        int result = mathematics.getResult();
        assertEquals("Not expected result is displayed", deductResult, result);
    }

    @Category(SlowTests.class)
    @Test
    public void multiplyTest() {
        mathematics.multiply(numberOne, numberTwo);
        int result = mathematics.getResult();
        assertEquals("Not expected result is displayed", multiplyResult, result);
    }

    @Category(SlowTests.class)
    @Test
    public void divideTest() {
        mathematics.divide(numberOne, numberTwo);
        int result = mathematics.getResult();
        assertEquals("Not expected result is displayed", divideResult, result);
    }

    @Category(SlowTests.class)
    @Test
    public void divideByZeroTest() {
        mathematics.divide(numberOne, 0);
        int result = mathematics.getResult();
        assertEquals("Not expected result is displayed", divideResult, result);
    }
}
