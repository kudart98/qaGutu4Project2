package homeWork;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.*;

public class Differences {

    //Я провел тесты не на h1 div  а на других элементов, мне возвращает одно и тоже...

    @Test
    void whatTheDifference() {

        open("https://the-internet.herokuapp.com/challenging_dom");
        System.out.println("-------------START-----------");
        System.out.println($("tbody tr").getText());
        System.out.println("-------------NEW LINE-----------");
        System.out.println($("tbody").$("tr").getText());
        System.out.println("-------------FINISH-----------");
    }

    @Test
    void whatTheDifference1() {
        open("https://github.com/search?q=selenide");
        System.out.println("-------------START-----------");
        System.out.println($("ul.repo-list li").getText());
        System.out.println("-------------NEW LINE-----------");
        System.out.println($("ul.repo-list").$("li").getText());
        System.out.println("-------------FINISH-----------");


    }
}
