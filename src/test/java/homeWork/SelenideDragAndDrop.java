package homeWork;

import com.codeborne.selenide.Configuration;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Browsers.FIREFOX;
import static com.codeborne.selenide.Browsers.SAFARI;
import static com.codeborne.selenide.Selenide.*;

public class SelenideDragAndDrop {

    @BeforeAll
    public static void setUp() {
        final DesiredCapabilities capabilities = new DesiredCapabilities();

        Configuration.remote = "http://192.168.64.4:4444/wd/hub";
        Configuration.browserCapabilities = capabilities;
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.startMaximized = true;

    }

    @Test
    void dragAndDropTestSelenide() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        SelenideElement elementA = $("#column-a");
        SelenideElement elementB = $("#column-b");
        //Locate element for which you wants to retrieve x y coordinates.
        SelenideElement Image = $("#column-b");
        //Used points class to get x and y coordinates of element.
        Point classname = Image.getLocation();
        int xcordi = classname.getX()-690;
        System.out.println("Element's X"+xcordi +" pixels.");
        int ycordi = classname.getY()+10;
        System.out.println("Element's Y"+ycordi +" pixels.");
        actions().clickAndHold(elementA).moveToElement(elementB, xcordi, ycordi).release(elementA).build().perform();
       // sleep(10000);

    }
}
