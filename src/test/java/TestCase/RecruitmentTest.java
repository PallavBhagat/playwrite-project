//package TestCase;
//
//import PageObject.RecruitmentPage;
//import org.testng.annotations.Test;
//
//public class RecruitmentTest extends BaseTest {
//
//    public RecruitmentPage rp;
//
//    @Test
//    public void recruitmentTest() throws InterruptedException {
//
//        // Create RecruitmentPage object
//        rp = new RecruitmentPage(page);
//
//        // Click Recruitment
//        rp.clickOnRecuitmentBth();
//
//        // Click Add
//        rp.clickOnAddBth();
//
//        // Enter candidate details
//        rp.enterCandidateFirstName("Pallav");
//        rp.enterCandidateMiddleName("Dilip");
//        rp.enterCandidateLastName("Bhagat");
//
//        // Select vacancy
//        rp.selectvacancy();
//
//        // Enter email
//        rp.enterCandidateEmail("pallavbhagat123@gmail.com");
//
//        // Enter contact number
//        rp.enterCandidateContactNumber("7558622345");
//
//        // Enter keywords
//        rp.enterCandidateKeywords(
//                "java, selenium webdriver, cucumber, testng, playwright, sql"
//        );
//
//
//        // Enter note
//        rp.enterCandidateNote(
//                "hi my name is pallav bhagat i am from amravati. i have 3 years of experience in qa engineer"
//        );
//
//        // Select checkbox
//        rp.clickCandidateCheckBox();
//
//        Thread.sleep(3000);
//
//        // Save candidate
//        rp.clickOnSaveBth();
//
//        // check the data is added in the table
//
//
//        // find the record using the Vacancy inside the table
//        rp.checkingofusingVacancy();
//
//
//
//    }
//}