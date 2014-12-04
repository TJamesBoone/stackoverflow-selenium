package fun.seleniumtesting.stackoverflow.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by James on 11/1/14.
 */
public class Home {

    private WebDriver driver;

    public void search(String searchPhrase) {
        WebElement searchBar = driver.findElement(By.name("q"));
        searchBar.sendKeys(searchPhrase);
        searchBar.sendKeys(Keys.ENTER);
    }

    // Buttons at top of page

    public void clickQuestionsButton() {
        //TODO click the "Questions" button
    }

    public void clickTagsButton() {
        //TODO click the "Tags" button
    }

    public void clickUsersButton() {
        //TODO click the "Users" button
    }

    public void clickBadgesButton() {
        //TODO click the "Badges" button
    }

    public void clickUnansweredButton() {
        //TODO click the "Unanswered" button
    }

    public void clickAskQuestionButton() {
        //TODO click the "Ask Question" button
    }


}
