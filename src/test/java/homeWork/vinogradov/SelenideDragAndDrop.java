package homeWork.vinogradov;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Point;
import org.openqa.selenium.remote.DesiredCapabilities;
import static com.codeborne.selenide.Selenide.*;

public class SelenideDragAndDrop {

    @Test
    void dragAndDropTestSelenide() {

        final DesiredCapabilities capabilities = new DesiredCapabilities();
        Configuration.remote = "http://192.168.1.86:4444/wd/hub";
        Configuration.browserCapabilities = capabilities;
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.startMaximized = true;

        open("https://the-internet.herokuapp.com/drag_and_drop");
        SelenideElement elementA = $("#column-a");
        SelenideElement elementB = $("#column-b");
        //Locate element for which you wants to retrieve x y coordinates.
        SelenideElement image = $("#column-b");
        //Used points class to get x and y coordinates of element.
        Point classname = image.getLocation();
        int xcordi = classname.getX()-690;
        int ycordi = classname.getY()+10;
        actions().clickAndHold(elementA).moveToElement(elementB, xcordi, ycordi).release(elementA).build().perform();


    }
}
