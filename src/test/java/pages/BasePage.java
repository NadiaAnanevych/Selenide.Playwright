package pages;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.url;

public class BasePage {
    @Step("Get web title")
    public String getWebTitle() {
        return Selenide.title();
    }

    @Step("Get title")
    public String getTitle() {
        return $(By.className ("display-6")).getText();

    }
    @Step("Get current url")
    public String getCurrentUrl() {
        return url();
    }
}
