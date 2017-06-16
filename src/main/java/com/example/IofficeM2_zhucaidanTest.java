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
        System.out.println("appium���ӳɹ���");

    }
    @AfterMethod
    public void tearDown() throws Exception {
         driver.quit();
        //driver.closeApp();
    }
    @Test
    public void zhucaidan_Test() throws Exception{
        //�ȵ�¼�ٽ���֪ͨ���湦����
        login();
        Thread.sleep(20000);
        //1.����֪ͨ���湦����
        tongzhigonggao_Test();
        //2����¼ϵͳ��������칫�����ڵ�������̹����˵�
        liuchengs_Test();
        //3����¼ϵͳ��������칫�����ٵ������ͨ���ġ��˵�
        chuangyue_Test();
        //4����¼ϵͳ��������ҡ����ٵ�������á��˵�
        Settings_Test();
        //5����¼ϵͳ�������ͨ��¼���˵�
        tongxunlu_Text();
        //6����¼ϵͳ�������ͨ��¼�����ٵ�������ˡ��˵�
        Gertongxunlu_Text();
        //7����¼ϵͳ���ȵ�����칫�����ٵ������ʱ��Ϣ���˵�
        instantmessage_Test();
        //8����¼ϵͳ���ȵ�����칫�����ٵ�������߶Ի����˵�
        onlineChat_Test();
        //9����¼ϵͳ���ȵ�����ҡ����ٵ�������ڡ��˵�
        guanyu_Test();

    }

    //��¼
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
    //����֪ͨ���湦����
    public  void tongzhigonggao_Test() throws Exception{
        driver.findElement(By.id("id_indicator_two")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("֪ͨ����")).click();
        Thread.sleep(1000);
        List<WebElement> sqnrfanhui =driver.findElementsByClassName("android.widget.ImageButton");
        sqnrfanhui.get(0).click();
        Thread.sleep(5000);
        //������֪ͨ����Ĺ�����
        return;
    }
    //2����¼ϵͳ��������칫�����ڵ�������̹����˵�
    public void liuchengs_Test() throws Exception{
        driver.findElement(By.id("id_indicator_two")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("���̹���")).click();
        Thread.sleep(1000);
        List<WebElement> sqnrfanhui =driver.findElementsByClassName("android.widget.ImageButton");
        sqnrfanhui.get(0).click();
        Thread.sleep(5000);
        //�������̹���Ĺ�����
        return;

    }
    //3����¼ϵͳ��������칫�����ٵ������ͨ���ġ��˵�
    public void chuangyue_Test() throws Exception{
        driver.findElement(By.id("id_indicator_two")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("��ͨ����")).click();
        Thread.sleep(1000);
        //������ͨ���ĵĹ�����
        List<WebElement> sqnrfanhui =driver.findElementsByClassName("android.widget.ImageButton");
        sqnrfanhui.get(0).click();
        Thread.sleep(5000);

        return;

    }
    //4����¼ϵͳ��������ҡ����ٵ�������á��˵�
    public void Settings_Test() throws Exception{
        driver.findElement(By.id("id_indicator_four")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("����")).click();
        Thread.sleep(1000);
        //�������õĹ�����
        List<WebElement> sqnrfanhui =driver.findElementsByClassName("android.widget.ImageButton");
        sqnrfanhui.get(0).click();
        Thread.sleep(5000);
        return;

    }
    //5����¼ϵͳ�������ͨ��¼���˵�
    public void tongxunlu_Text() throws Exception{
        driver.findElement(By.id("id_indicator_three")).click();
        Thread.sleep(1000);

        //����ͨ��¼�Ĺ�����

        Thread.sleep(5000);
        return;

    }
    //6����¼ϵͳ�������ͨ��¼�����ٵ�������ˡ��˵�
    public void Gertongxunlu_Text() throws Exception{
        driver.findElement(By.id("id_indicator_three")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("����")).click();
        Thread.sleep(1000);
        //�������ͨ��¼�Ĺ�����
        List<WebElement> sqnrfanhui =driver.findElementsByClassName("android.widget.ImageButton");
        sqnrfanhui.get(0).click();
        Thread.sleep(5000);
        return;

    }
    //7����¼ϵͳ���ȵ�����칫�����ٵ������ʱ��Ϣ���˵�
    public void instantmessage_Test() throws Exception{
        driver.findElement(By.id("id_indicator_two")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("��ʱ��Ϣ")).click();
        Thread.sleep(1000);
        //���뼴ʱ��Ϣ�Ĺ�����
        List<WebElement> sqnrfanhui =driver.findElementsByClassName("android.widget.ImageButton");
        sqnrfanhui.get(0).click();
        Thread.sleep(5000);
        return;

    }
    //8����¼ϵͳ���ȵ�����칫�����ٵ�������߶Ի����˵�
    public void onlineChat_Test() throws Exception{
        driver.findElement(By.id("id_indicator_two")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("���߶Ի�")).click();
        Thread.sleep(5000);
        //�������߶Ի��Ĺ�����
        List<WebElement> sqnrfanhui =driver.findElementsByClassName("android.widget.ImageButton");
        sqnrfanhui.get(0).click();
        Thread.sleep(5000);
        return;

    }
    //9����¼ϵͳ���ȵ�����ҡ����ٵ�������ڡ��˵�

    public void guanyu_Test() throws Exception{
        driver.findElement(By.id("id_indicator_four")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("����")).click();
        Thread.sleep(1000);
        //������ڵĹ�����
        List<WebElement> sqnrfanhui =driver.findElementsByClassName("android.widget.ImageButton");
        sqnrfanhui.get(0).click();
        Thread.sleep(5000);
        return;

    }




}
