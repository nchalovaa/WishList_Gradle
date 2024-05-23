package com.wishlist.tests.wishlist;

import com.wishlist.pages.*;
import com.wishlist.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EditWishListTest extends TestBase {

    @BeforeMethod
    public void precondition() throws InterruptedException {
        homePage = new HomePage(app.driver);
        loginPage = new LoginPage(app.driver);
        accountPage = new AccountPage(app.driver);
        wishListPage = new WishListPage(app.driver);
        signupPage = new SignUpPage(app.driver);
        giftPage =new GiftPage(app.driver);
        wishListContentPage=new WishListContentPage(app.driver);

        homePage
                .clickOnButtonCreateNewWishList();
        loginPage
                .enterPersonalData("lenadud2@com.me", "Berlin2024!")
        accountPage
                .createWishListButton();
        wishListPage
                .fillWishListForm("Birthday","I have birthday soon", "15102025");
        Thread.sleep(1500);

    }

    @Test
    public void addGiftToWishListTest()  {
//              wishListPage
//                      .clickOnWishList();
//              wishListContentPage
//               .clickOnAddGiftButton();
//              giftPage
//               .inputGiftLink("https://www.amazon.de/COFOF-Fitnessb%C3%A4nder-Widerstandsstufen-%C3%9Cbungsanleitung-Physiotherapie/dp/B0CQKB7RP5/?_encoding=UTF8&_encoding=UTF8&ref_=dlx_gate_sd_dcl_tlt_0f958573_dt_pd_hp_d_btf_unk&pd_rd_w=jWh6k&content-id=amzn1.sym.5b3ed663-dc9b-42d6-9b59-8397a19b7356&pf_rd_p=5b3ed663-dc9b-42d6-9b59-8397a19b7356&pf_rd_r=NAW7FPBVGY27SX9R8AKY&pd_rd_wg=SDk7y&pd_rd_r=ad6e943a-1b19-439e-a37a-5a184cf41b74")
//               .inputName("Fitnessbänder")
//               .inputPrice("8")
//               .chooseCurrency("EUR")
//               .inputCommentOnTheGift("I love fitness")
//               .clickOnSaveGiftButton();
    }
}
