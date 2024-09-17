package datafactory;

import dataobjects.UserDetails;
import utilities.JavaHelpers;

public class SignupData {
    JavaHelpers helper = new JavaHelpers();
    UserDetails userdata = new UserDetails();

    public UserDetails signupData() {
        String username = "Test" + helper.getRandomNumbers(5);
        userdata.setUsername(username);
        String password = helper.getRandomNumbers(6);
        userdata.setPassword(password);
        return userdata;
    }

    public UserDetails invalidSignUpData() {
        userdata.setUsername("TestData");
        userdata.setPassword("123456");
        return userdata;
    }
}
