package homeWork.vinogradov;

import org.junit.jupiter.api.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

public class SelenideInGitHub {

    private static final String URL = "https://github.com/";

    @Test
    void selenideGitHubSearchTest() {

         open(URL);
         $x("//input[@name='q']").setValue("Selenide").pressEnter();
         // choose the first Project
         $(".repo-list a").click();
         // make sure if the project we opened has expected text
         $("h1").shouldHave(text("selenide / selenide"));
         // click on wiki section
         $x("//span[@data-content='Wiki']").click();
         // find "Soft assertions" and click on it
         $x("//a[contains(text(),'Soft assertions')]").click();
        // make sure if page has JUnit 5
        $(byText("SoftAssertions")).shouldHave(text("SoftAssertions"));
        $x("//div[@id='wiki-body']").shouldHave(text("Using JUnit5 extend test class:"));

    }

}
