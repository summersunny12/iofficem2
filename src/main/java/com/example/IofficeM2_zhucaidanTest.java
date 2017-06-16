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
 * Created by admin on 2017/5/12.
 */

public class IofficeM2_zhucaidanTest {
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
    public void zhucaidan_Test() throws Exception{
        //先登录再进入通知公告功能区
        login();
        Thread.sleep(20000);
        //1.进入通知公告功能区
        tongzhigonggao_Test();
        //2、登录系统，点击“办公”，在点击“流程管理”菜单
        liuchengs_Test();
        //3、登录系统，点击“办公”，再点击“普通传阅”菜单
        chuangyue_Test();
        //4、登录系统，点击“我”，再点击“设置”菜单
        Settings_Test();
        //5、登录系统，点击“通信录”菜单
        tongxunlu_Text();
        //6、登录系统，点击“通信录”，再点击“个人”菜单
        Gertongxunlu_Text();
        //7、登录系统，先点击“办公”，再点击“即时消息”菜单
        instantmessage_Test();
        //8、登录系统，先点击“办公”，再点击“在线对话”菜单
        onlineChat_Test();
        //9、登录系统，先点击“我”，再点击“关于”菜单
        guanyu_Test();

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
    //进入通知公告功能区
    public  void tongzhigonggao_Test() throws Exception{
        driver.findElement(By.id("id_indicator_two")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("通知公告")).click();
        Thread.sleep(1000);
        List<WebElement> sqnrfanhui =driver.findElementsByClassName("android.widget.ImageButton");
        sqnrfanhui.get(0).click();
        Thread.sleep(5000);
        //进入了通知公告的功能区
        return;
    }
    //2、登录系统，点击“办公”，在点击“流程管理”菜单
    public void liuchengs_Test() throws Exception{
        driver.findElement(By.id("id_indicator_two")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("流程管理")).click();
        Thread.sleep(1000);
        List<WebElement> sqnrfanhui =driver.findElementsByClassName("android.widget.ImageButton");
        sqnrfanhui.get(0).click();
        Thread.sleep(5000);
        //进入流程管理的功能区
        return;

    }
    //3、登录系统，点击“办公”，再点击“普通传阅”菜单
    public void chuangyue_Test() throws Exception{
        driver.findElement(By.id("id_indicator_two")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("普通传阅")).click();
        Thread.sleep(1000);
        //进入普通传阅的功能区
        List<WebElement> sqnrfanhui =driver.findElementsByClassName("android.widget.ImageButton");
        sqnrfanhui.get(0).click();
        Thread.sleep(5000);

        return;

    }
    //4、登录系统，点击“我”，再点击“设置”菜单
    public void Settings_Test() throws Exception{
        driver.findElement(By.id("id_indicator_four")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("设置")).click();
        Thread.sleep(1000);
        //进入设置的功能区
        List<WebElement> sqnrfanhui =driver.findElementsByClassName("android.widget.ImageButton");
        sqnrfanhui.get(0).click();
        Thread.sleep(5000);
        return;

    }
    //5、登录系统，点击“通信录”菜单
    public void tongxunlu_Text() throws Exception{
        driver.findElement(By.id("id_indicator_three")).click();
        Thread.sleep(1000);

        //进入通信录的功能区

        Thread.sleep(5000);
        return;

    }
    //6、登录系统，点击“通信录”，再点击“个人”菜单
    public void Gertongxunlu_Text() throws Exception{
        driver.findElement(By.id("id_indicator_three")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("个人")).click();
        Thread.sleep(1000);
        //进入个人通信录的功能区
        List<WebElement> sqnrfanhui =driver.findElementsByClassName("android.widget.ImageButton");
        sqnrfanhui.get(0).click();
        Thread.sleep(5000);
        return;

    }
    //7、登录系统，先点击“办公”，再点击“即时消息”菜单
    public void instantmessage_Test() throws Exception{
        driver.findElement(By.id("id_indicator_two")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("即时消息")).click();
        Thread.sleep(1000);
        //进入即时消息的功能区
        List<WebElement> sqnrfanhui =driver.findElementsByClassName("android.widget.ImageButton");
        sqnrfanhui.get(0).click();
        Thread.sleep(5000);
        return;

    }
    //8、登录系统，先点击“办公”，再点击“在线对话”菜单
    public void onlineChat_Test() throws Exception{
        driver.findElement(By.id("id_indicator_two")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("在线对话")).click();
        Thread.sleep(5000);
        //进入在线对话的功能区
        List<WebElement> sqnrfanhui =driver.findElementsByClassName("android.widget.ImageButton");
        sqnrfanhui.get(0).click();
        Thread.sleep(5000);
        return;

    }
    //9、登录系统，先点击“我”，再点击“关于”菜单

    public void guanyu_Test() throws Exception{
        driver.findElement(By.id("id_indicator_four")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("关于")).click();
        Thread.sleep(1000);
        //进入关于的功能区
        List<WebElement> sqnrfanhui =driver.findElementsByClassName("android.widget.ImageButton");
        sqnrfanhui.get(0).click();
        Thread.sleep(5000);
        return;

    }




}
