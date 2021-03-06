package com.zhialex.tests.ui_tests.tests;

import com.zhialex.tests.ui_tests.pages.MainPage;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MainPageTest extends BaseTest {

    MainPage mainPage = new MainPage();

    @Epic("Главная страница")
    @Test
    @DisplayName("Проверка перехода к компоненту обратной связи")
    void checkScrollByNewProjectButton() {

        mainPage.openPage().clickStartProjectButton().checkScroll();
    }

    @Epic("Главная страница")
    @Test
    @DisplayName("Проверка перехода на решение автоматизации тестирования")
    void openAutotestsSolutions() {

        mainPage.openPage().openSolution("QA Automation", "The importance of automated quality control"
                + " in facilitating the agile development");
    }
}
