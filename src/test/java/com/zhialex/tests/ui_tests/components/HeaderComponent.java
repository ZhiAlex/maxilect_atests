package com.zhialex.tests.ui_tests.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;

public class HeaderComponent {

    private SelenideElement solutionsButton = $$("#menu-main span").findBy(text("Решения"));

    public void clickSolutionsButton() {
        solutionsButton.click();
    }
}
