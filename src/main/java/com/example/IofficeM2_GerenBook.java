package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URL;
import java.util.List;

import io.appium.java_client.android.AndroidDriver;

/**
 * Created by admin on 2017/6/13.
 */

public class IofficeM2_GerenBook {
    private AndroidDriver driver;
    @BeforeMethod
    public void setUp() throws Exception {

        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "ioffcem2/src/main/java/apps");
        File app = new File(appDir, "iofficeM2.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName","emulator-5554");
        capabilities.setCapability("platformVersion", "5.0");
        //if no need install don't add this
        //capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage", "com.hf.iOffice");
        //support Chinese
        capabilities.setCapability("unicodeKeyboard" ,"True");
        capabilities.setCapability("resetKeyboard", "True");
        //no need sign
        capabilities.setCapability("noSign", "True");
        capabilities.setCapability("appActivity", "hf.iOffice.LoginActivity");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        System.out.println("appium连接成功！");

    }
    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
        //driver.closeApp();
    }
    @Test
    public void PersonBook_Test() throws Exception{
        //登录
        login();
        Thread.sleep(20000);
        //1、查看通过从手机的上传的通讯录
        PersonBook_MobileBooks();
        //2、查看个人的通讯录即自己的个人的通讯录
        PersonBook_personBooks();
        //3、查看个人通讯录中分享出来的员工的通讯录
        PersonBook_FenxiangBooks();
        //4、通过使用搜索按钮快速查找自己需要的通讯录
        PersonBook_SearchBooks();
        //5、从手机中的通讯录上传通讯录到个人通讯录界面的手机通讯录中
        PersonBook_MobileBook_Upload();
        //6、把个人通讯录界面的通讯录下载，然后保存到手机的通讯录中
        PersonBook_MobileBook_Download();
    }
    //登录
    public void login() throws Exception{
        Thread.sleep(15000);
        List<WebElement> listviewList = driver.findElementsByClassName("android.widget.EditText");
        //listviewList.get(0).clear();
        listviewList.get(0).sendKeys("zyj");
        listviewList.get(1).sendKeys("58993245zyj");
        // driver.findElement(By.id("com.hf.iOffice:id/txtLoginID")).sendKeys("zyj");
        // driver.findElement(By.id("com.hf.iOffice:id/txtLoginPwd")).sendKeys("58993245zyj");
        driver.findElement(By.id("btnLogin")).click();
        //Thread.sleep(10000);
        return;
    }
    //1、查看通过从手机的上传的通讯录
    public void PersonBook_MobileBooks() throws  Exception{
        driver.findElement(By.id("id_indicator_three")).click();
        driver.findElement(By.name("个人")).click();
        driver.findElement(By.name("手机通讯录")).click();
        List<WebElement> fanhui = driver.findElementsByClassName("android.widget.ImageButton");
        fanhui.get(0).click();
        return;
    }
    //2、查看个人的通讯录即自己的个人的通讯录
    public void PersonBook_personBooks() throws  Exception{
        driver.findElement(By.id("id_indicator_three")).click();
        driver.findElement(By.name("个人")).click();
        driver.findElement(By.name("个人目录")).click();
        List<WebElement> fanhui = driver.findElementsByClassName("android.widget.ImageButton");
        fanhui.get(0).click();
        return;
    }
    //3、查看个人通讯录中分享出来的员工的通讯录
    public void PersonBook_FenxiangBooks() throws  Exception{
        driver.findElement(By.id("id_indicator_three")).click();
        driver.findElement(By.name("个人")).click();
        driver.findElement(By.name("共享目录")).click();
        List<WebElement> fanhui = driver.findElementsByClassName("android.widget.ImageButton");
        fanhui.get(0).click();
        return;
    }
    //4、通过使用搜索按钮快速查找自己需要的通讯录
    public void PersonBook_SearchBooks() throws  Exception{
        driver.findElement(By.id("id_indicator_three")).click();
        driver.findElement(By.name("个人")).click();
        //单击“搜索”按钮
        driver.findElement(By.id("search_button")).click();
        //输入搜索的关键字
        driver.findElement(By.id("search_src_text")).sendKeys("s");
        List<WebElement> fanhui = driver.findElementsByClassName("android.widget.ImageButton");
        fanhui.get(0).click();
        return;
    }
    //5、从手机中的通讯录上传通讯录到个人通讯录界面的手机通讯录中
    public void PersonBook_MobileBook_Upload() throws Exception{
        driver.findElement(By.id("id_indicator_three")).click();
        driver.findElement(By.name("个人")).click();
        driver.findElement(By.id("action_upload")).click();
        //选择需要上传的通讯录
        Thread.sleep(5000);
        List<WebElement> Upload_Books=driver.findElementsByClassName("android.widget.RelativeLayout");
        Upload_Books.get(0).click();
        Upload_Books.get(2).click();
        Upload_Books.get(5).click();
        driver.findElement(By.id("action_upload")).click();
        Thread.sleep(2000);
        //在手机通讯录中查看
        driver.findElement(By.name("手机通讯录")).click();
        //返回
        List<WebElement> fanhui = driver.findElementsByClassName("android.widget.ImageButton");
        fanhui.get(0).click();
        return;

    }
    //6、把个人通讯录界面的通讯录下载，然后保存到手机的通讯录中
    public void PersonBook_MobileBook_Download() throws Exception{
        driver.findElement(By.id("id_indicator_three")).click();
        driver.findElement(By.name("个人")).click();
        driver.findElement(By.id("action_download")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("共享目录")).click();
        driver.findElement(By.name("杜小姐")).click();
        driver.findElement(By.name("中恒杨")).click();
        driver.findElement(By.name("完成")).click();
        Thread.sleep(2000);

        //返回
        List<WebElement> fanhui = driver.findElementsByClassName("android.widget.ImageButton");
        fanhui.get(0).click();
        return;

    }
}
