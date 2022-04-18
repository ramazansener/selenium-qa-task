import org.junit.*;
import org.junit.jupiter.api.Order;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import java.util.List;
import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BaseTest extends Base {


    private By categoriessSelector = new By.ByXPath("//*[@id=\"header__container\"]/header/div[3]/nav/ul/li/a");
    private By goToHomePageSelector =new By.ByXPath("//*[@id=\"header__container\"]/header/div[1]/div[1]/a");
    private By cookieAcceptSelector = new By.ByXPath("//*[@id=\"footer__container\"]/div[2]/div/p[3]/button");
    private By megaMenuElementsSelector = new By.ByXPath("//*[@id=\"header__container\"]/header/div[3]/nav/ul/li[1]/div/div[1]/div[2]/ul/li/a");
    private By prodcutListContainerSelector = new By.ByClassName("product-list-container");
    private By productCartTitleSelector = new By.ByClassName("product-card__title");
    private By productSliderSelector = new By.ById("productSliderPhotos");
    private By addCartButtonSelector = new By.ById("pd_add_to_cart");
    private By coupenCodeSelector = new By.ByClassName("coupon-code-link");
    private By gotoCartSelector = new By.ByXPath("//*[@id=\"header__container\"]/header/div[1]/div[3]/div/div[2]/a");
    private By homeMainBannerAreaSelector = new By.ByClassName("home-main-banner-area");
    private By productSizeSelector = new By.ByXPath("//*[@id=\"option-size\"]/a");


    @Test
    @Order(1)
    public void a_home_page_enter() throws InterruptedException {
        Thread.sleep(1000);
        find(cookieAcceptSelector).click();
        Thread.sleep(1000);

        WebElement homePageBanner=find(homeMainBannerAreaSelector);
        boolean ishomePageBanner=homePageBanner.isDisplayed();
        assertEquals(true,ishomePageBanner);
        Thread.sleep(1000);


    }
    @Test
    @Order(2)
    public void b_click_category_go_category() throws InterruptedException {
        List<WebElement> categoriess=findAll(categoriessSelector);
        Thread.sleep(1000);

        Actions action = new Actions(driver);
        action.moveToElement(categoriess.get(0)).perform();
        Thread.sleep(1000);

        List<WebElement> megaMenuElements = findAll(megaMenuElementsSelector);
        megaMenuElements.get(1).click();

        Thread.sleep(1000);
        WebElement prodcutListContainer = find(prodcutListContainerSelector);
        boolean isProdcutListContainer=prodcutListContainer.isDisplayed();
        assertEquals(true,isProdcutListContainer);
        Thread.sleep(1000);

    }

    @Test
    @Order(3)
    public void c_click_product_go_product() throws InterruptedException {
        List<WebElement> products = findAll(productCartTitleSelector);
        products.get(2).click();
        Thread.sleep(500);

        WebElement productSlider=find(productSliderSelector);
        boolean isProductSlider = productSlider.isDisplayed();
        assertEquals(true,isProductSlider);

    }

    @Test
    @Order(4)
    public void d_add_product_to_cart() throws InterruptedException {
        List<WebElement> sizeSelector =findAll(productSizeSelector);
        sizeSelector.get(4).click();
        Thread.sleep(1000);
        WebElement addCartButton = find(addCartButtonSelector);
        addCartButton.click();
        Thread.sleep(1000);
        assertEquals("SEPETE EKLENDÝ",addCartButton.getText());

    }

    @Test
    @Order(5)
    public void e_go_to_cart() throws InterruptedException {
        WebElement goToCart = find(gotoCartSelector);
        goToCart.click();
        Thread.sleep(1000);
        WebElement coupenCode = find(coupenCodeSelector);
        boolean isCoupenCode=coupenCode.isDisplayed();
        assertEquals(true,isCoupenCode);

        Thread.sleep(500);

    }

    @Test
    @Order(6)
    public void f_back_to_home_page() throws InterruptedException {
        WebElement goToHomePage = find(goToHomePageSelector);
        goToHomePage.click();
        Thread.sleep(1000);
        WebElement homePageBanner= find(homeMainBannerAreaSelector);
        boolean ishomePageBanner=homePageBanner.isDisplayed();
        assertEquals(true,ishomePageBanner);
        Thread.sleep(1000);

    }
}
