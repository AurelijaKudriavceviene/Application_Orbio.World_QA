
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobject.HomePage;

public class SearchingQAPositionTest extends BaseTest {

    @Test
    void findingQAPosition() {
        HomePage homePage = new HomePage(driver);

        String searchingTitle = "Junior Quality Assurance";

        homePage.goToTechnicalPositions();

        boolean isThereJuniorQAPosition = homePage.hasAJobTitle(searchingTitle);
        Assertions.assertTrue(isThereJuniorQAPosition, "So sad, there are no junior QA positions at the moment");
    }
}
