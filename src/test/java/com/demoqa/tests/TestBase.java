package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;

import java.util.Locale;

public class TestBase {
    Faker faker = new Faker(new Locale("ru"));
    Faker fakerEn = new Faker(new Locale("en"));

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = fakerEn.internet().emailAddress();
    String number = faker.phoneNumber().subscriberNumber(10);
    String address = faker.address().fullAddress();
    String day = "26";
    String month = "August";
    String year = "1998";
    String gender = "Male";
    String subject = "Maths";
    String hobbie = "Sports";
    String state = "Haryana";
    String city = "Karnal";
    String imgPath = "img/test.jpg";




    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;

    }
}
