
package pageobject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a[href='https://orbio.world/#careers']")
    private WebElement careersBtnElement;

    @FindBy(css = "h3.grow.text-xl.font-bold.uppercase")
    private WebElement technicalBtnElement;

    @FindBy(xpath = ".//div[@class='text-lg flex flex-col']")
    private List<WebElement> jobElements;


    public void goToTechnicalPositions() {
        careersBtnElement.click();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            System.out.println(e.getLocalizedMessage());
        }
        technicalBtnElement.click();
    }

    public boolean hasAJobTitle(String expectedJobTitle) {
        for (WebElement jobElement : jobElements) {
            String jobTitle = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].textContent;", jobElement);
            if (jobTitle.contains(expectedJobTitle)) {
                return true;
            }
        }
        return false;
    }
}
