package com.zhialex.tests.ui_tests.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.zhialex.tests.ui_tests.components.CommunicationComponent;
import com.zhialex.tests.ui_tests.tests.BaseTest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage extends BaseTest {

    CommunicationComponent communicationComponent = new CommunicationComponent();

    SelenideElement
            startProjectButton = $x("//a[contains(text(),'Начать проект')]");

    ElementsCollection solutionsButtons = $$(".row.home-solutions.home-solutions-full a");

    public void clickStartProjectButton() {
        startProjectButton.scrollTo().click();
        communicationComponent.componentIsVisible();
    }

    public void openSolution(String solution, String resultText) {
        solutionsButtons.findBy(text(solution)).click();
        $x("(//div[@class='page-content']/p)[1]")
                .shouldHave(text(resultText));
    }
}
