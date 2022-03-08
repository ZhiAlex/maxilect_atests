package com.zhialex.tests.ui_tests.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.zhialex.tests.ui_tests.pages.MainPage;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class MainPageTest extends BaseTest {

    MainPage mainPage = new MainPage();

    @Epic("Главная страница")
    @Test
    @DisplayName("Проверка перехода к компоненту обратной связи")
    void checkScrollByNewProjectButton() {

//        mainPage.openPage();
//        mainPage.clickStartProjectButton();
//        mainPage.checkScroll();
        open("https://maxilect.ru/");
        $x("//a[contains(text(),'Start your project')]").shouldBe(visible).click();
        $x("//input[@name='user-name']").shouldBe(visible);
    }

    @Epic("Главная страница")
    @Test
    @DisplayName("Проверка перехода на решение автоматизации тестирования")
    void openAutotestsSolutions() {

        mainPage.openPage();
        mainPage.openSolution("QA Automation", "The importance of automated quality control" +
                        " in facilitating the agile development");
    }
}
