
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import pages.HomePage;
import pages.WebFormPage;

import static com.codeborne.selenide.Condition.value;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static pages.HomePage.BASE_URL;

public class SelenideTests {
    HomePage homePage;

    @BeforeEach
    void setup() {

        homePage = new HomePage();

    }

    @Test
    void openHomePageTest() {
        homePage.open();
        assertEquals(BASE_URL, homePage.getCurrentUrl());
    }

    @Test
    void openWebFormPageTest() {
        homePage.open();
        WebFormPage webFormPage = homePage.openWebFormPage();

        assertEquals(BASE_URL + webFormPage.getWebFormUrl(), webFormPage.getCurrentUrl());
        assertEquals("Hands-On Selenium WebDriver with Java", webFormPage.getWebTitle());
    }

    @Test
    void readonlyTextTest() {
        homePage.open();
        WebFormPage webFormPage = homePage.openWebFormPage();
        webFormPage.getReadonlyInput().shouldHave(value("Readonly input"));
    }

    @Test
    void sendTextTest() throws InterruptedException {
        homePage.open();
        WebFormPage webFormPage = homePage.openWebFormPage();
        webFormPage.sendText();
        Thread.sleep(2000);
        String textInput = webFormPage.getTextInput();
        assertEquals("my text",textInput);
    }

    @Test
    void submitFormTest() throws InterruptedException {
        homePage.open();
        WebFormPage webFormPage = homePage.openWebFormPage();
        webFormPage.submitForm();
        Thread.sleep(2000);
        assertEquals("Form submitted", webFormPage.getTitle());
    }

}
