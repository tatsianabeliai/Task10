import org.apache.log4j.Logger;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.util.Collection;

import static junit.framework.TestCase.assertEquals;

@RunWith(value = Parameterized.class)
public class DDTTest {
    private static final Logger LOG = Logger.getLogger(DDTTest.class);
    @Parameterized.Parameter(0)
    public int numberOne;
    @Parameterized.Parameter(1)
    public int numberTwo;
    @Parameterized.Parameter(2)
    public int expectedSum;
    @Parameterized.Parameter(3)
    public int expectedDeduct;
    @Parameterized.Parameter(4)
    public int expectedDiv;
    @Parameterized.Parameter(5)
    public int expectedMul;
    Mathematics mathematics;

    @Parameterized.Parameters
    public static Collection testData() throws IOException {
        return DataProvider.getTestData("/testData.csv");
    }

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

    @Test
    public void addTest() {
        mathematics.add(numberOne, numberTwo);
        int result = mathematics.getResult();
        assertEquals("Not correct result: ", expectedSum, result);
    }

    @Test
    public void deductTest() {
        mathematics.setResult(1);
        mathematics.deduct(numberOne, numberTwo);
        int result = mathematics.getResult();
        assertEquals("Not correct result: ", expectedDeduct, result);
    }

    @Test
    public void multiplyTest() {
        mathematics.multiply(numberOne, numberTwo);
        int result = mathematics.getResult();
        assertEquals("Not correct result: ", expectedMul, result);
    }

    @Test
    public void divideTest() {
        mathematics.divide(numberOne, numberTwo);
        int result = mathematics.getResult();
        assertEquals("Not correct result: ", expectedDiv, result);
    }
}
