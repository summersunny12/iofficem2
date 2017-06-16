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

public class iofficeM2Logins {
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
    public void ioffceM2() throws Exception{
        //����һ
        //�߼�����
        // 1gaojisetting();
        //login();


        //����2��
        //����߼����ã�ѡ���¼IP��ַ�������ʷ��¼

        //jiluIp();
        //login();
        //�߼�����->����IPѡ�����,��ʾIP��ַ����
        cuowuIPSetting();
        login();
        Thread.sleep(1500);


    }
    //ѡ���¼IP�߼�����
    public void jiluIp() throws Exception{
        Thread.sleep(10000);
        driver.findElement(By.name("�߼�����")).click();
        driver.findElement(By.id("btnServerAddr")).click();
        driver.findElement(By.id("text1")).click();
        //������水ť
        driver.findElement(By.id("action_confirm")).click();
        return;
    }

    public  void gaojisetting() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.name("�߼�����")).click();
        driver.findElement(By.id("txtServerAddr")).sendKeys("oa.hongfan.cn:8080");
        driver.findElement(By.id("action_confirm")).click();
        Thread.sleep(10000);
        return;
    }
    //�߼�����->����IPѡ�����
    public void cuowuIPSetting() throws Exception{
        Thread.sleep(10000);
        driver.findElement(By.name("�߼�����")).click();
        driver.findElement(By.id("txtServerAddr")).sendKeys("oa.hongfan.cn:8080");
        driver.findElement(By.id("action_confirm")).click();
        Thread.sleep(10000);
        return;
    }
    //��½
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
}
