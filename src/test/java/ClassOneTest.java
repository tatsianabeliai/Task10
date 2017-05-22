import org.apache.log4j.Logger;
import org.junit.*;
import org.junit.experimental.categories.Category;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClassOneTest {
    private static final Logger LOG = Logger.getLogger(ClassOneTest.class);
    final static int numberOne = 50;
    final static int numberTwo = 5;
    Mathematics mathematics;

    @BeforeClass
    public static void onceExecutedBeforeAll() {
        LOG.info("@BeforeClass: executedBeforeAllTests");
    }

    @Before
    public void executedBeforeEachTest() {
        LOG.info("@Before: executedBeforeEachTest");
        Mathematics math = new Mathematics();
        mathematics = math;
    }

    @After
    public void executedAfterEachTest() {
        LOG.info("@After: executedAfterEachTest");
        mathematics.setResult(0);
    }

    @AfterClass
    public static void onceExecutedAfterAll() {
        LOG.info("@AfterClass: executedAfterAllTests");
    }


    @Category(SlowTests.class)
    @Test
    public void addTest() {
        mathematics.add(numberOne, numberTwo);
        int result = mathematics.getResult();
        assertEquals("Not expected result is displayed", 55, result);
    }

    @Category(SlowTests.class)
    @Test(timeout = 1000)
    public void deductTest() {
        try {
            mathematics.setResult(1);
            Thread.sleep(1500);
            mathematics.deduct(numberOne, numberTwo);
            int result = mathematics.getResult();
            assertEquals("Not expected result is displayed", 45, result);
        } catch (InterruptedException ex) {
            LOG.error(ex);
            Assert.fail();
        }
    }

    @Category(SlowTests.class)
    @Test
    public void multiplyTest() {
        mathematics.multiply(numberOne, numberTwo);
        int result = mathematics.getResult();
        assertEquals("Not expected result is displayed", 250, result);
    }

    @Category(SlowTests.class)
    @Test
    public void divideTest() {
        mathematics.divide(numberOne, numberTwo);
        int result = mathematics.getResult();
        assertEquals("Not expected result is displayed", 10, result);
    }

    @Category(SlowTests.class)
    @Test
    public void divideByZeroTest() {
        mathematics.divide(1, 0);
        int result = mathematics.getResult();
        assertEquals("Not expected result is displayed", 10, result);
    }
}
