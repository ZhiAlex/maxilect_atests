package com.zhialex.tests.ui_tests.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.zhialex.tests.ui_tests.tests.BaseTest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPage extends BaseTest {

    private SelenideElement
            startProjectButton = $x("//a[contains(text(),'Start your project')]");

    private ElementsCollection solutionsButtons = $$(".row.home-solutions.home-solutions-full a");

    public MainPage openPage() {
        open("https://maxilect.ru/");
        return this;
    }

    public void clickStartProjectButton() {
        startProjectButton.shouldBe(visible);
        startProjectButton.click();
        $x("//input[@name='user-name']").shouldBe(visible);
    }

    public void openSolution(String solution, String resultText) {
        solutionsButtons.findBy(text(solution)).click();
        $x("(//div[@class='page-content']/p)[1]")
                .shouldHave(text(resultText));
    }
}
