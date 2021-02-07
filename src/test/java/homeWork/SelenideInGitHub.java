package homeWork;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

public class SelenideInGitHub {

    @Test
    void selenideGitHubSearchTest() {

        open("https://github.com/");
        // search for Selenide
        $x("//input[@name='q']").setValue("Selenide").pressEnter();
        // choose the first Project
        $x("//ul[@class='repo-list']//li[1]//a[1]").click();
        // make sure if the project we opened has expected text
        $("h1").shouldHave(text("selenide / selenide"));
        // click on wiki section
        $x("//span[@data-content='Wiki']").click();
        // find "Soft assertions" and click on it
        $x("//a[contains(text(),'Soft assertions')]").click();
        // make sure if page has JUnit 5
        $x("//h1[contains(text(),'SoftAssertions')]").shouldHave(text("SoftAssertions"));
        $x("//div[@id='wiki-body']").shouldHave(text("Using JUnit5 extend test class:"));

    }

}
