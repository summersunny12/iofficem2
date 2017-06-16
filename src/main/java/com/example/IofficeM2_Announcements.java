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

public class IofficeM2_Announcements {
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
        System.out.println("appium���ӳɹ���");

    }
    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
        //driver.closeApp();
    }
    @Test
    public void Announces_Test() throws Exception{
        //���ȵ�¼����
        login();
        Thread.sleep(20000);
        //1������֪ͨ����Ľ��棬�鿴���е�֪ͨ������б�
        Announce_List_Test();

        //2������֪ͨ����Ľ��棬ͨ�������ؼ��������ٲ����û���Ҫ�鿴֪ͨ������б�
        Announce_Search_Test();
        //3����������ʵ��
        Announce_fujian_Download();
    }
    //��¼���Զ���ʵ��
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
    //1������֪ͨ����Ľ��棬�鿴���е�֪ͨ������б� Announce_List_Test
    public void  Announce_List_Test() throws Exception{
        driver.findElement(By.id("id_indicator_two")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("֪ͨ����")).click();
        Thread.sleep(5000);
        List<WebElement> fanhui = driver.findElementsByClassName("android.widget.ImageButton");
        fanhui.get(0).click();
        return;
    }
    //2������֪ͨ����Ľ��棬ͨ�������ؼ��������ٲ����û���Ҫ�鿴֪ͨ������б� Announce_Search_Test
    public void  Announce_Search_Test() throws Exception{
        driver.findElement(By.id("id_indicator_two")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("֪ͨ����")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("search_button")).click();
        driver.findElement(By.id("search_src_text")).sendKeys("֪ͨ");
        Thread.sleep(5000);
        List<WebElement> fanhui = driver.findElementsByClassName("android.widget.ImageButton");
        fanhui.get(0).click();
        return;
    }
    //3����������ʵ��
    public void Announce_fujian_Download() throws Exception{
        driver.findElement(By.id("id_indicator_two")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("֪ͨ����")).click();
        Thread.sleep(5000);
        //֪ͨ������б�
        List<WebElement> announces=driver.findElementsByClassName("android.widget.LinearLayout");
        announces.get(0).click();
        Thread.sleep(5000);
        driver.findElement(By.id("ivDownLoad")).click();
        List<WebElement> fanhui = driver.findElementsByClassName("android.widget.ImageButton");
        fanhui.get(0).click();
        return;
    }
}
