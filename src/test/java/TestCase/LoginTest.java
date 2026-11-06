//package TestCase;
//
//import org.testng.Assert;
//import org.testng.SkipException;
//import org.testng.annotations.Test;
//
//public class LoginTest extends BaseTest {
//
//    @Test
//    public void loginTest() {
//
//        // Verify successful login
//        test.info("Verifying Test");
//        String actualTitle = page.title();
//
//        Assert.assertEquals(actualTitle, "OrangeHRM");
//    }
//
//    @Test
//    public void loginTest1() {
//
//        test.skip("skip Login Test");
//        throw new SkipException("Skip Login Test");
//        // Verify successful login
//        //test.info("Verifying Test");
//        //String actualTitle = page.title();
//
//        //Assert.assertEquals(actualTitle, "OrangeHRM");
//    }
//
//    @Test
//    public void loginTest2() {
//
//        // Verify successful login
//        test.info("Verifying Test");
//        String actualTitle = page.title();
//
//        Assert.assertEquals(actualTitle, "Orange");
//    }
//}