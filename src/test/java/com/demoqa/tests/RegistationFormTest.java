package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationForm;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Locale;

public class RegistationFormTest {

    Faker faker = new Faker(new Locale("ru"));
    Faker fakerEn = new Faker(new Locale("en"));
    RegistrationForm registrationForm = new RegistrationForm();

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = fakerEn.internet().emailAddress();
    String number = faker.phoneNumber().subscriberNumber(10);
    String address = faker.address().fullAddress();

    @Test
    void formTest() {
        registrationForm.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender("Male")
                .setNumber(number).setBirthDate("26", "August", "1998")
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
