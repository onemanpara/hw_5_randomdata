package com.demoqa.tests;

import com.demoqa.pages.RegistrationForm;
import org.junit.jupiter.api.Test;

public class RegistationFormTest extends TestBase {

    RegistrationForm registrationForm = new RegistrationForm();
    @Test
    void formTest() {
        registrationForm.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender("Male")
                .setNumber(number)
                .setBirthDate("26", "August", "1998")
                .setSubject("Maths")
                .setHobbies("Sports")
                .setHobbies("Reading")
                .setHobbies("Music").setPicture("img/test.jpg")
                .setAddress(address)
                .setLocation("Haryana", "Karnal")
                .clickSubmit();

        registrationForm.checkResult("Student Name", (firstName + " " + lastName))
                .checkResult("Student Email", email)
                .checkResult("Gender", "Male")
                .checkResult("Mobile", number)
                .checkResult("Date of Birth", "26 August,1998")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Sports, Reading, Music")
                .checkResult("Picture", "test.jpg")
                .checkResult("Address", address)
                .checkResult("State and City", "Haryana Karnal");
    }
}
