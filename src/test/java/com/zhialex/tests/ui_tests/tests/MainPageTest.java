package com.zhialex.tests.ui_tests.tests;

import com.codeborne.selenide.Configuration;
import com.zhialex.tests.ui_tests.pages.MainPage;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MainPageTest extends BaseTest {

    MainPage mainPage = new MainPage();

    @Epic("Главная страница")
    @Test
    @DisplayName("Проверка отправки контактов без проверка на человека")
    void checkScrollByNewProjectButton() {
        Configuration.browserSize = "1920x1080";
        mainPage
                .openPage()
                .clickStartProjectButton();
    }

    @Epic("Главная страница")
    @Test
    @DisplayName("Проверка перехода на решение автоматизации тестирования")
    void openAutotestsSolutions() {

        mainPage
                .openPage()
                .openSolution("Автоматизация тестирования", "В настоящее время все больше компаний" +
                        "осознают важность автоматизации процесса контроля качества");
    }
}
