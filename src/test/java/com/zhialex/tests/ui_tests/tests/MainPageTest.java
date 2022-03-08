package com.zhialex.tests.ui_tests.tests;

import com.zhialex.tests.ui_tests.pages.MainPage;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class MainPageTest extends BaseTest{

    MainPage mainPage = new MainPage();

    @Epic("Главная страница")
    @Test
    @DisplayName("Проверка отправки контактов без проверка на человека")
    void checkScrollByNewProjectButton() {

//        open("https://maxilect.ru/");
        mainPage.clickStartProjectButton();
    }

    @Epic("Главная страница")
    @Test
    @DisplayName("Проверка перехода на решение автоматизации тестирования")
    void openAutotestsSolutions() {

//        open("https://maxilect.ru/");
        mainPage.openSolution("Автоматизация тестирования", "В настоящее время все больше компаний" +
                "осознают важность автоматизации процесса контроля качества");
    }
}
