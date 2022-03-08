package com.zhialex.tests.ui_tests.tests;

import com.github.javafaker.Faker;
import com.zhialex.tests.ui_tests.components.CommunicationComponent;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SendContactTest {

    CommunicationComponent communicationComponent = new CommunicationComponent();
    Faker faker = new Faker();

    @Epic("Отправка контактов")
    @Feature("Обработка ошибок")
    @Story("Ошибка незаполненных полей")
    @Test
    @DisplayName("Проверка отправки контактов, все поля пустые")
    void sendContactWithoutData() {

//        open("https://maxilect.ru/");
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

//        open("https://maxilect.ru/");
        communicationComponent
                .scrollToCommunicationComponent()
                .setName(faker.name().firstName())
                .setContact(faker.phoneNumber().phoneNumber())
                .setMessage(faker.harryPotter().book())
                .clickSendButton()
                .errorMessageIsVisible();
    }
}
