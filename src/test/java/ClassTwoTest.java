import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClassTwoTest {

    @Category(FastTests.class)
    @Ignore
    @Test
    public void emptyMethodTest() {

    }
}
