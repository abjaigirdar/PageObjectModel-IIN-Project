import org.testng.annotations.Test;

public class HomepageTest extends BaseTest{

    @Test
    public void test01() {
        startHomePage()
                .getSampleClass(
                        "Joe Root",
                        "randomguys@gmail.com",
                        "2159299112");

    }
    @Test
    public void test02() {
        startHomePage()
                .navigateToApplicationPage()
                .applicationFirstPage(
                        "Lolita",
                        "Bonita",
                        "lolitabonita@gmail.com",
                        "2157679283")
                .applicationSecondPage(
                        "123 Main St",
                        "Philadelphia",
                        "United States",
                        "Pennsylvania",
                        "19149")
                .applicationThirdPage(
                        "Accountant",
                        "Post graduate degree",
                        "1-year Health Coach Training Program");

    }
}