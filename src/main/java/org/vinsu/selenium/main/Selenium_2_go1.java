/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package org.vinsu.selenium.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 *
 * @author toan0
 */
public class Selenium_2_go1 {

    //throws => nem' cho he dieu hanh(WINDOWS) hứng
    public static void main(String[] args) throws InterruptedException {
//        playWithGoogle();
        System.out.println("Please wait 3s to launch the browser...");
        Thread.sleep(3000);
        playWithGooleSearch();
    }
    
    public static void playWithGooleSearch() throws InterruptedException {
        WebDriver myBrowser;
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--lang=en-GB");
        opt.addArguments("--incognition");
        myBrowser = new ChromeDriver(opt);
        myBrowser.manage().window().maximize();
        myBrowser.get("https://www.google.com/");

        //định vị ô search để nhập keyword
        //myBrowser đã có được toàn bộ thẻ đã được render trên trình duyệt
        //viết câu query để select 1 tag bất kì theo id, name, css, selector, xPath
        //xPathlà ngầu nhất luồn tìm được 1 tag bất kì trong 1 mớ thẻ lồng nhau
        //MỖI TAG ĐƯỢC XEM LÀ 1 OBJECT THUỘC CLASS WEBELEMENT
//        WebElement searchBox = myBrowser.findElement(By.name("q"));
        WebElement searchBox = myBrowser.findElement(By.xpath("//input[@title='Search']"));
        
        searchBox.sendKeys("Nguyen Duc Toan");
        searchBox.submit();
        Thread.sleep(5000);
        myBrowser.quit();
    }

    //Điều khiển trình duyệt = code, không dùng sức người
    // TEST WEBAPP
    public static void playWithGoogle() throws InterruptedException {
        //1. Khai báo 1 biến Object trỏ thẳng vào 1 tab của trình duyệt
        //sẽ được new() nếu trỏ thẳng vào 1 tab => ta sẽ điểu khiển được trình duyệt thông qua code
        //do trình duyệt thông qua code để gọi trình duyệt
        WebDriver myBrowser;

        //2.Báo với máy ảo Java có file driver.exe => file này chứa 1 đống CLASS 
        //=> giúp tương tác với trình duyệt.DRIVER
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        //Lệnh này giống Class.forName() JDBC
        //làm thêm 1 vài trò cáu hình trước khi trình duyệt xuất hiện
        //LAM THEM NEU MUON GIUA BUOC 2 VA 3
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--lang=vi-VN");
        opt.addArguments("--incognition");

        //3. new 1 object trong HEAP => ton tai trong RAM
        myBrowser = new ChromeDriver(opt); // ton RAM va` tao ra 1 tab trinh duyet
        //Mặc định trình duyệt đã new chiếm 1/2 màn hình
        // Phóng to bản chất là gọi hành động của object myBrowser
        myBrowser.manage().window().maximize();
        //4. GET URL
        myBrowser.get("https://www.youtube.com/");

        //EP CPU ngưng đọng 10s
        Thread.sleep(10000); //Tác động ra bên ngoài đều có thể gây EXCEPTION

        //dọn dẹp trình duyệt để có rác trong RAM
        myBrowser.quit(); //=> teardown
        //JUNIT/UNIT Test: setup va                 teardown
        // new ChromeDriver()    //myBrowser.quit()
        //Để câu lệnh khởi động trình duyệt vào setup chạy hết các bộ test thi` dọn dẹp(CLEAR) vào teardown
    }
}
