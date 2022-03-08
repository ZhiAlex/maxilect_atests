package com.zhialex.tests.ui_tests.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CommunicationComponent {

    private SelenideElement
            setNameInput = $x("//input[@name='user-name']"),
            setContactInput = $x("//input[@name='contact']"),
            setMessageTextArea = $x("//textarea[@name='message']"),
            sendButton = $("#feedback-form-submit-button"),
            invalidDataMessage = $x(
                    "//form//div[text()='Одно или несколько полей содержат ошибочные данные." +
                            " Пожалуйста, проверьте их и попробуйте ещё раз.']"
            ),
            errorMessage = $x(
                    "//form//div[text()='При отправке сообщения произошла ошибка." +
                            " Пожалуйста, попробуйте ещё раз позже.']"
            );

    public CommunicationComponent componentIsVisible() {
        setNameInput.shouldBe(visible);
        setContactInput.shouldBe(visible);
        setMessageTextArea.shouldBe(visible);
        sendButton.shouldBe(visible);
        return this;
    }

    public CommunicationComponent scrollToCommunicationComponent() {
        setNameInput.scrollTo();
        return this;
    }

    public CommunicationComponent setName(String name) {
        setNameInput.setValue(name);
        return this;
    }

    public CommunicationComponent setContact(String contact) {
        setContactInput.setValue(contact);
        return this;
    }

    public CommunicationComponent setMessage(String message) {
        setMessageTextArea.setValue(message);
        return this;
    }

    public CommunicationComponent clickSendButton() {
        sendButton.click();
        return this;
    }

    public void invalidDataMessageIsVisible() {
        invalidDataMessage.shouldBe(visible);
    }

    public void errorMessageIsVisible() {
        errorMessage.shouldBe(visible);
    }
}
