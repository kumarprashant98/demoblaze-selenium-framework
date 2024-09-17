package datafactory;

import dataobjects.UserDetails;

public class LoginData {
    UserDetails userdata = new UserDetails();

    public UserDetails loginData() {
        userdata.setUsername("TestData");
        userdata.setPassword("123456");
        return userdata;
    }
}
