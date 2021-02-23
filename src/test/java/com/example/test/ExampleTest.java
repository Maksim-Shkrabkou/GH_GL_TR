package com.example.test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ExampleTest {

    @BeforeAll
    static void setUp() {
        // Configuration.headless = true;
        Configuration.timeout = 6000;
        Configuration.browser = "com.example.test.ChromeWebdriverProvider";
        // Configuration.remote = "http://localhost:4444/wd/hub";
    }

    @Test
    void testCanSignIn() {
        Selenide.open("https://angular.realworld.io/");
        $(By.xpath("//a[normalize-space()='Sign in']")).click();
        $(By.xpath("//input[@placeholder='Email']")).setValue("max1995@gmail.com");
        $(By.xpath("//input[@placeholder='Password']")).setValue("password");
        $(By.xpath("//button[normalize-space()='Sign in']")).click();
        $(By.xpath("//li[normalize-space()='email or password is invalid']"))
                .shouldHave(Condition.exactText("email or password is invalid"));
    }
}
