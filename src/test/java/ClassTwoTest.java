import org.apache.log4j.Logger;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClassTwoTest {
    private final Logger LOG = Logger.getLogger(ClassOneTest.class);

    @Category(FastTests.class)
    @Ignore
    @Test
    public void emptyMethodTest() {
        LOG.info("This is the empty method");
    }
}
