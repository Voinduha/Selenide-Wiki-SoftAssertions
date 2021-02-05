import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;

public class SoftAssertionTest {

    @Test
    void MustFindSelenideText() {
        // open GitHub
        Selenide.open("https://github.com/");
        // ввести в поле поиска Selenide and press Enter
        Selenide.$("[name=q]").setValue("Selenide").pressEnter();
        // выбрать первый найденный проект из списка
        Selenide.$("ul.repo-list li a").click();
        // проверка в заголовке встречается selenide / selenide
        Selenide.$("h1").shouldHave(text("selenide / selenide"));
        // переходим в раздел Wiki проекта
        Selenide.$("[data-content='Wiki']").click();
        // убеждаемся что он видимый
        Selenide.$("#wiki-body div ul").shouldBe(Condition.visible);
        // ищем текст
        Selenide.$$("#wiki-pages-box li").findBy(text("SoftAssertions")).click();
        // убеждаемся что
        Selenide.$("#wiki-body").shouldHave(text("Using JUnit5 extend test class:"));
    }
}
