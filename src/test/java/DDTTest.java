import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class DDTTest {

    @Parameterized.Parameter
    public int x;
    @Parameterized.Parameter(1)
    public int y;
    @Parameterized.Parameter(2)
    public int expectedSum;
    @Parameterized.Parameter(3)
    public int expectedDeduct;
    @Parameterized.Parameter(4)
    public int expectedMul;
    @Parameterized.Parameter(5)
    public int expectedDiv;


    @Parameterized.Parameters
    public static Collection testData() throws IOException {
        return getTestData("/testData.csv");
    }

    public static Collection<Object[]> getTestData(String filename) throws IOException {
        List<Object[]> records = new ArrayList<Object[]>();
        String record;
        BufferedReader file = new BufferedReader(new InputStreamReader(DDTTest.class.getResourceAsStream(filename)));
        while ((record = file.readLine()) != null) {
            String fields[] = record.split(",");
            int x = Integer.parseInt(fields[0]);
            int y = Integer.parseInt(fields[1]);
            int sum = Integer.parseInt(fields[2]);
            int deduct = Integer.parseInt(fields[3]);
            int divide = Integer.parseInt(fields[4]);
            int multiply = Integer.parseInt(fields[5]);

            Object[] record1 = new Object[6];
            record1[0] = x;
            record1[1] = y;
            record1[2] = sum;
            record1[3] = deduct;
            record1[4] = divide;
            record1[5] = multiply;

            records.add(record1);
        }
        return records;
    }

    @Test
    public void addTest() {
        Mathematics mathematics = new Mathematics();
        mathematics.add(x, y);
        int result = mathematics.getResult();
        assertEquals(expectedSum, result);
    }

    @Test
    public void deductTest() throws InterruptedException {
        Mathematics mathematics = new Mathematics();
        mathematics.setResult(1);
        mathematics.deduct(x, y);
        int result = mathematics.getResult();
        assertEquals(expectedDeduct, result);
    }

    @Test
    public void multiplyTest() {
        Mathematics mathematics = new Mathematics();
        mathematics.multiply(x, y);
        int result = mathematics.getResult();
        assertEquals(expectedMul, result);
    }

    @Test
    public void divideTest() {
        Mathematics mathematics = new Mathematics();
        mathematics.divide(x, y);
        int result = mathematics.getResult();
        assertEquals(expectedDiv, result);
    }
}
