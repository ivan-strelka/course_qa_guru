package com.demoqa.constants;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserTestData {

    public static final String USER_FIRST_NAME = "John";
    public static final String USER_LAST_NAME = "Smith";
    public static final String USER_EMAIL = "xaxepat@mailinator.com";
    public static final String USER_MOBILE_PHONE = "1234567901";
    public static final String USER_DATA_OF_BIRTH = "12";
    public static final String USER_MONTH_OF_BIRTH = "April";
    public static final String USER_YEAR_OF_BIRTH = "1995";
    public static final List<String> USER_SUBJECTS = List.of("Maths", "Hindi");
    public static final String USER_PHOTO_PATH = "src/test/resources/img.png";
    public static final String USER_CURRENT_ADDRESS = "Brighton Beach of the New York";
    public static final String USER_STATE = "NCR";
    public static final String USER_CITY = "Delhi";
    public static final String USER_MALE_GENDER = "Male";
    public static final String USER_FEMALE_GENDER = "Female";
    public static final String USER_OTHER_GENDER = "Other";
    public static final String USER_HOBBIES = "Sports";
    public static final String USER_PIC_NAME = "img.png";


    public static final Map<String, String> expectedUserData() {
        Map<String, String> mapUserData = new HashMap<>();
        mapUserData.put("Student Name", "John Smith");
        mapUserData.put("Student Email", "xaxepat@mailinator.com");
        mapUserData.put("Gender", "Male");
        mapUserData.put("Mobile", "1234567901");
        mapUserData.put("Date of Birth", "12 April,1995");
        mapUserData.put("Subjects", "Maths, Hindi");
        mapUserData.put("Hobbies", "Sports");
        mapUserData.put("Picture", "img.png");
        mapUserData.put("Address", "Brighton Beach of the New York");
        mapUserData.put("State and City", "NCR Delhi");
        return mapUserData;
    }

}
