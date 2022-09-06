import org.testng.annotations.Test;

public class HomepageTest extends BaseTest{

    @Test
    public void test01() {
        startHomePage()
                .getSampleClass("Joe Root",
                        "randomguys@gmail.com",
                        "2159299112");

    }
}
