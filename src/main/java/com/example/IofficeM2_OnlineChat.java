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
 * Created by admin on 2017/6/14.
 */

public class IofficeM2_OnlineChat {
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
    public void OnlineChat_Test() throws Exception{
        //���ȵ�¼����
        login();
        Thread.sleep(20000);
        // 1���������߶Ի������б�


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
    //1���������߶Ի��б����
    public void OnlineChat_List_Test() throws Exception{
        //����칫
        driver.findElement(By.id("id_indicator_two")).click();
        //����������߶Ի�����
        driver.findElement(By.name("���߶Ի�")).click();
        Thread.sleep(5000);
        //�������߶Ի��Ļ����б�
        //�˳����߶Ի�����
        List<WebElement> fanhuiOC = driver.findElementsByClassName("android.widget.ImageButton");
        fanhuiOC.get(0).click();
        return;
    }
    //2���������߶Ի����棬�鿴���߶Ի��б������ˢ�¡�
    public void OnlineChat_List_Reflush() throws Exception{
        //����칫
        driver.findElement(By.id("id_indicator_two")).click();
        //����������߶Ի�����
        driver.findElement(By.name("���߶Ի�")).click();
        Thread.sleep(5000);
        //�������߶Ի��Ļ����б�
        //���ˢ�°�ť��ˢ�����߶Ի��б�
        List<WebElement> gongnengs = driver.findElementsByClassName("android.widget.ImageView");
        gongnengs.get(0).click();
        Thread.sleep(2000);
        driver.findElement(By.name("ˢ��")).click();
        Thread.sleep(5000);
        //�˳����߶Ի�����
        List<WebElement> fanhuiOC = driver.findElementsByClassName("android.widget.ImageButton");
        fanhuiOC.get(0).click();
        return;
    }
    //3���������߶Ի����棬�鿴���߶Ի��б������������
    public void OnlineChat_List_Search() throws Exception{
        //����칫
        driver.findElement(By.id("id_indicator_two")).click();
        //����������߶Ի�����
        driver.findElement(By.name("���߶Ի�")).click();
        Thread.sleep(5000);
        //�������߶Ի��Ļ����б�
        //���ˢ�°�ť��ˢ�����߶Ի��б�
        List<WebElement> gongnengs = driver.findElementsByClassName("android.widget.ImageView");
        gongnengs.get(0).click();
        Thread.sleep(2000);
        driver.findElement(By.name("����")).click();

        Thread.sleep(5000);
        //�˳����߶Ի�����
        List<WebElement> fanhuiOC = driver.findElementsByClassName("android.widget.ImageButton");
        fanhuiOC.get(0).click();
        return;
    }
}
