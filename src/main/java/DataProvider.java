import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class DataProvider {

    public static Collection<Object[]> getTestData(String filename) throws IOException {
        List<Object[]> records = new ArrayList<Object[]>();
        String record;
        BufferedReader file = new BufferedReader(new InputStreamReader(DataProvider.class.getResourceAsStream(filename)));
        while ((record = file.readLine()) != null) {
            String fields[] = record.split(",");
            int numberOne = Integer.parseInt(fields[0]);
            int numberTwo = Integer.parseInt(fields[1]);
            int sum = Integer.parseInt(fields[2]);
            int deduct = Integer.parseInt(fields[3]);
            int divide = Integer.parseInt(fields[4]);
            int multiply = Integer.parseInt(fields[5]);

            Object[] record1 = new Object[6];
            record1[0] = numberOne;
            record1[1] = numberTwo;
            record1[2] = sum;
            record1[3] = deduct;
            record1[4] = divide;
            record1[5] = multiply;

            records.add(record1);
        }
        return records;
    }
}
