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
                .setGender(gender)
                .setNumber(number)
                .setBirthDate(day, month, year)
                .setSubject(subject)
                .setHobbies(hobbie)
                .setPicture(imgPath)
                .setAddress(address)
                .setLocation(state, city)
                .clickSubmit();

        registrationForm.checkResult("Student Name", (firstName + " " + lastName))
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", number)
                .checkResult("Date of Birth", day + " " + month + "," + year)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobbie)
                .checkResult("Picture", "test.jpg")
                .checkResult("Address", address)
                .checkResult("State and City", state + " " + city);
    }
}
