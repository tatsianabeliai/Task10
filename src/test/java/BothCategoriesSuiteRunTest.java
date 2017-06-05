import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)

@Categories.IncludeCategory({SlowTests.class, FastTests.class})
@Suite.SuiteClasses({ClassOneTest.class, ClassTwoTest.class})

public class BothCategoriesSuiteRunTest {
}