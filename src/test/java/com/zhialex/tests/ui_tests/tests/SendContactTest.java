package com.zhialex.tests.ui_tests.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SendContactTest extends BaseTest {

    @Epic("Отправка контактов")
    @Feature("Обработка ошибок")
    @Story("Ошибка незаполненных полей")
    @Test
    @DisplayName("Проверка отправки контактов, все поля пустые")
    void sendContactWithoutData() {

        mainPage.openPage();

        communicationComponent
                .scrollToCommunicationComponent()
                .clickSendButton()
                .invalidDataMessageIsVisible();
    }

    @Epic("Отправка контактов")
    @Feature("Обработка ошибок")
    @Story("Ошибка проверки на человека")
    @Test
    @DisplayName("Проверка отправки контактов без проверка на человека")
    void sendContactWithoutHumanCheck() {

        mainPage.openPage();

        communicationComponent
                .scrollToCommunicationComponent()
                .setName(faker.name().firstName())
                .setContact(faker.phoneNumber().phoneNumber())
                .setMessage(faker.harryPotter().book())
                .clickSendButton()
                .errorMessageIsVisible();
    }
}
