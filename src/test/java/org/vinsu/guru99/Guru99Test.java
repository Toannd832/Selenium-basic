/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.vinsu.guru99;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author toan0
 */
public class Guru99Test {

    private static WebDriver myBrowser;

    @BeforeAll
    //Chạy 1 lần duy nhất trước tất cả các @Test
    //Khởi động các giá trị sẽ dùng trong @Test
    public static void setUpClass() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        myBrowser = new ChromeDriver();
        myBrowser.manage().window().maximize();
    }

    @Test
    //Test case: check the login function with a vaild account
    //Input: User ID :	mngr481425
    //       Password :	YdYnAnu
    //Expected: result: a Welcome message appears under 
    //the formal of Manage ID: <username>
    public void checkLoginGivenValidAccountShowWelcomeMessage() throws InterruptedException {
        String username = "mngr481425";
        String password = "YdYnAnu";

        myBrowser.get("https://demo.guru99.com/v4/");
        WebElement txtuserName = myBrowser.findElement(By.xpath("//input[@name='uid']"));
        txtuserName.sendKeys(username);
        WebElement txtPassWord = myBrowser.findElement(By.cssSelector("input[name='password']"));
        txtPassWord.sendKeys(password);
        WebElement btnLogin = myBrowser.findElement(By.xpath("//input[@name='btnLogin']"));
        btnLogin.click();

        //LOGIC: NẾU CHUYỂN TRANG NẾU MẠNG LAG CHƯA LOAD KỊP => KO TÌM THẤY TAG
        //=> FAIL CODE JAVA(VÌ CODE JAVA CHẠY LIÊN TỤC) 
        //=> CHO CPU SLEEP 1 KHOẢNG THỜI GIAN
        Thread.sleep(3000);
        WebElement lblWelcomeMsg = myBrowser.findElement(By.cssSelector("tr[class='heading3'] td"));
        //the formal of Manage ID: <username>
        //System.out.println("Welcome message: " + lblWelcomeMsg.getText());
        //in ra text cua the td
        //=> hoàn thành chương trình CRAWLER => cào data của 1 website => Bot cào data
        
        String Expected ="Manger ID : ";
        String Actual = lblWelcomeMsg.getText();
        assertEquals(Expected + username, Actual );
        
        Thread.sleep(6000);
    }

    @AfterAll
    //Chạy 1 lần duy nhất sau tất cả các @Test
    //Thường dùng để dọn dẹp các thứ mà @Test đã bầy ra trước đó
    public static void tearDownClass() {
        myBrowser.quit();
    }

}
