package com.zhialex.tests.ui_tests.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import com.zhialex.tests.ui_tests.helpers.Attach;
import com.zhialex.tests.ui_tests.pages.MainPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {

    Faker faker = new Faker();

    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        String browser = System.getProperty("browser", "chrome_91.0");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        capabilities.setCapability("browserName", browser.split("_")[0]);
        capabilities.setCapability("browserVersion", browser.split("_")[1]);

        Configuration.browserCapabilities = capabilities;
        Configuration.remote = String.format(
                "https://%s:%s@selenoid.autotests.cloud/wd/hub",
                System.getProperty("user", "user1"),
                System.getProperty("password", "1234")
        );
        Configuration.holdBrowserOpen = false;
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }
}
