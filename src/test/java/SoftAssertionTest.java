import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SoftAssertionTest {

    @Test
    void MustFindSelenideText() {
        // open GitHub
        open("https://github.com/");
        // ввести в поле поиска Selenide and press Enter
        $("[name=q]").setValue("Selenide").pressEnter();
        // выбрать первый найденный проект из списка
        $("ul.repo-list li a").click();
        // проверка в заголовке встречается selenide / selenide
        $("h1").shouldHave(text("selenide / selenide"));
        // переходим в раздел Wiki проекта
        $("[data-content='Wiki']").click();
        // убеждаемся что он видимый
        $("#wiki-body div ul").shouldBe(Condition.visible);
        // ищем текст
        $$("#wiki-pages-box li").findBy(text("SoftAssertions")).click();
        // убеждаемся что
        $("#wiki-body").shouldHave(text("Using JUnit5 extend test class:"));
    }
}
