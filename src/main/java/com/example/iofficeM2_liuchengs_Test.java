package com.example;

/**
 * Created by admin on 2017/6/9.
 */

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

public class iofficeM2_liuchengs_Test {
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
    public void Liucheng_Test() throws Exception {
        //��¼
        login();
        Thread.sleep(15000);
        //1�����������б�ҳ������֤
        TestCase_TodoFlow();
        //2���ڰ������б�ҳ������֤
        TestCase_DoFlow();
        //3���Ѱ������б�ҳ������֤
        TestCase_DoneFlow();
    }

    //��¼
    public void login() throws Exception {
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
    //1�����������б�ҳ������֤
    public void TestCase_TodoFlow() throws Exception{
        driver.findElement(By.id("id_indicator_two")).click();
        driver.findElement(By.name("���̹���")).click();
        driver.findElement(By.id("action_more")).click();
        driver.findElement(By.name("����")).click();
        Thread.sleep(2000);
        //������������ҳ������֤

        //����
        List<WebElement> fanhui1 = driver.findElementsByClassName("android.widget.ImageButton");
        fanhui1.get(0).click();
        List<WebElement> fanhui0 = driver.findElementsByClassName("android.widget.ImageButton");
        fanhui0.get(0).click();
        return;

    }
    //2���ڰ������б�ҳ������֤
    public void TestCase_DoFlow() throws Exception{
        driver.findElement(By.id("id_indicator_two")).click();
        driver.findElement(By.name("���̹���")).click();
        driver.findElement(By.id("action_more")).click();
        driver.findElement(By.name("�ڰ�")).click();
        Thread.sleep(2000);
        //�ڰ���������ҳ������֤

        //����
        List<WebElement> fanhui1 = driver.findElementsByClassName("android.widget.ImageButton");
        fanhui1.get(0).click();
        List<WebElement> fanhui0 = driver.findElementsByClassName("android.widget.ImageButton");
        fanhui0.get(0).click();
        return;
    }
    //3���Ѱ������б�ҳ������֤
    public void TestCase_DoneFlow() throws Exception{
        driver.findElement(By.id("id_indicator_two")).click();
        driver.findElement(By.name("���̹���")).click();
        driver.findElement(By.id("action_more")).click();
        driver.findElement(By.name("�Ѱ�")).click();
        Thread.sleep(2000);
        //�Ѱ���������ҳ������֤

        //����
        List<WebElement> fanhui1 = driver.findElementsByClassName("android.widget.ImageButton");
        fanhui1.get(0).click();
        List<WebElement> fanhui0 = driver.findElementsByClassName("android.widget.ImageButton");
        fanhui0.get(0).click();
        return;
    }


}