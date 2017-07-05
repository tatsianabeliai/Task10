import org.apache.log4j.Logger;
import org.junit.*;
import org.junit.experimental.categories.Category;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClassOneTest {
    private final int NUMBER_ONE = 50;
    private final int NUMBER_TWO = 5;
    private final int SUM_RESULT = 55;
    private final int DEDUCT_RESULT = 45;
    private final int DIVIDE_RESULT = 10;
    private final int MULTIPLY_RESULT = 250;
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
        mathematics.add(NUMBER_ONE, NUMBER_TWO);
        int result = mathematics.getResult();
        assertEquals("Not expected result is displayed", SUM_RESULT, result);
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
        mathematics.deduct(NUMBER_ONE, NUMBER_TWO);
        int result = mathematics.getResult();
        assertEquals("Not expected result is displayed", DEDUCT_RESULT, result);
    }

    @Category(SlowTests.class)
    @Test
    public void multiplyTest() {
        mathematics.multiply(NUMBER_ONE, NUMBER_TWO);
        int result = mathematics.getResult();
        assertEquals("Not expected result is displayed", MULTIPLY_RESULT, result);
    }

    @Category(SlowTests.class)
    @Test
    public void divideTest() {
        mathematics.divide(NUMBER_ONE, NUMBER_TWO);
        int result = mathematics.getResult();
        assertEquals("Not expected result is displayed", DIVIDE_RESULT, result);
    }

    @Category(SlowTests.class)
    @Test
    public void divideByZeroTest() {
        mathematics.divide(NUMBER_ONE, 0);
        int result = mathematics.getResult();
        assertEquals("Not expected result is displayed", DIVIDE_RESULT, result);
    }
}
