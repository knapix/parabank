import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import scenarios.RegisterScenario;

import java.util.Random;

public class RegistrationScenarioTest extends MainTest {


//    @BeforeTest
//    public  void registration2(){
//        welcomePage = indexPage.run(new RegisterScenario(username));
//    }

    @Test
    public void shouldRegisterNewUser(){
        indexPage.run(new RegisterScenario(username))
                .registrationAssertion
                .isWelcomeMessageDisplayed();
        System.out.println(username);
    }



    //@Test
//    public void registration() {
//         indexPage.run(new RegisterScenario(username))
//                .registrationAssertion
//                .isWelcomeMessageDisplayed();
//
//    }
}


//  //  @BeforeTest
//    public void beforeTest(String username) {
//        welcomePage = indexPage.run(new RegisterScenario(username));
//    }
//
//    @Test
//    public void shouldRegister2(){
//        welcomePage
//                .registrationAssertion
//                .isWelcomeMessageDisplayed();
//        System.out.println(username);
//    }

