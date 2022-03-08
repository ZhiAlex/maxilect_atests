package com.zhialex.tests.ui_tests.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.zhialex.tests.ui_tests.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        capabilities.setCapability("browserName", System.getProperty("browser").split("_")[0]);
        capabilities.setCapability("browserVersion", System.getProperty("browser").split("_")[1]);

        Configuration.browserCapabilities = capabilities;
        Configuration.remote = String.format(
                "https://%s:%s@selenoid.autotests.cloud/wd/hub",
                System.getProperty("user"),
                System.getProperty("password")
        );
        Configuration.holdBrowserOpen = false;
        Configuration.browserSize = "1920x1080";
    }

    @BeforeEach
    void openSite() {
        open("https://maxilect.ru/");
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
