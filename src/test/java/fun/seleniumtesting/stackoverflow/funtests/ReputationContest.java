package fun.seleniumtesting.stackoverflow.funtests;

import fun.seleniumtesting.stackoverflow.domain.Contestant;
import fun.seleniumtesting.stackoverflow.domain.ScoreBoard;
import fun.seleniumtesting.stackoverflow.domain.User;
import fun.seleniumtesting.stackoverflow.util.Strings;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Created by James on 11/1/14.
 */
public class ReputationContest {

    private WebDriver driver;

    @Before
    public void setUp() {
        File chromeDriverExecutable = new File("src/main/resources/chromedriver");
        String pathToExecutable = chromeDriverExecutable.getAbsolutePath();
        System.setProperty("webdriver.chrome.driver", pathToExecutable);
        driver = new ChromeDriver();
    }

    @Test
    public void testJamesHasTheMostRep() {
        ScoreBoard scoreBoard = new ScoreBoard();
        for(Contestant contestant : Contestant.values()) {
            scoreBoard.setScore(contestant, Strings.toInt(getRep(driver, contestant)));
        }
        boolean jamesIsWinner = scoreBoard.getUserByPlacement(1) == Contestant.JAMES_DUNN;
        System.out.println("The winner is: " + scoreBoard.getUserByPlacement(1));
        printScoreBoard(scoreBoard);
        assertTrue("Expected James Dunn to have more reputation than anyone else.", jamesIsWinner);
    }

    private static String getRep(WebDriver driver, User user) {
        driver.get("http://www.stackoverflow.com");
        driver.findElement(By.id("nav-users")).click();
        driver.findElement(By.xpath("//a[contains(@href, 'filter=all')]")).click();
        driver.findElement(By.id("userfilter")).sendKeys(user.getUsername());
        try {
            Thread.sleep(1000l);
        } catch(InterruptedException ie) {
            throw new RuntimeException(ie);
        }
        return driver.findElement(By.className("reputation-score")).getText();
    }

    private static void printScoreBoard(ScoreBoard scoreBoard) {
        for(User user : scoreBoard.getContestants()) {
            System.out.printf("%s\t\t%d\n", user, scoreBoard.getScore(user));
        }
    }

}
