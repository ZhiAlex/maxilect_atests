package com.zhialex.tests.ui_tests.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

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
                    "//form//div[text()='One or more fields have an error. Please check and try again.']"
            ),
            errorMessage = $x(
                    "//form//div[text()='There was an error trying " +
                            "to send your message. Please try again later.']"
            );

    @Step("scroll to communication component")
    public CommunicationComponent scrollToCommunicationComponent() {
        setNameInput.scrollTo();
        return this;
    }

    @Step("set data")
    public CommunicationComponent setName(String name, String contact, String message) {
        setNameInput.setValue(name);
        setContactInput.setValue(contact);
        setMessageTextArea.setValue(message);
        return this;
    }

    @Step("click send button")
    public CommunicationComponent clickSendButton() {
        sendButton.click();
        return this;
    }

    @Step("check invalid data error")
    public void invalidDataMessageIsVisible() {
        invalidDataMessage.shouldBe(visible);
    }

    @Step("check error message is visible")
    public void errorMessageIsVisible() {
        errorMessage.shouldBe(visible);
    }
}
