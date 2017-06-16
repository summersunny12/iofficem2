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

public class iofficeM2_chuanyue_Test {
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
        System.out.println("appium��¼�ɹ���");

    }
    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
        //driver.closeApp();
    }
    @Test
    public void zhucaidan_Test() throws Exception{
        //���ȵ�¼
        login();
        Thread.sleep(15000);
        //1�����뷢�ʹ���->δ/��ʼ�б�ҳ��
        TestCase_SendMessage_List_Begin();
        //2�����뷢�ʹ���->�������б�ҳ��
        TestCase_SendMessage_List_Sending();
        //3�����뷢�ʹ���->ȫ�������б�ҳ��
        TestCase_SendMessage_List_All();
        //4���յ�����->δȷ���б�������֤
        TestCase_ReceiveMessage_List_NotConfirm();
        //5�������յ�����->��ȷ���б�ҳ��

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
    //1�����뷢�ʹ���->δ/��ʼ�б�ҳ��
    public void TestCase_SendMessage_List_Begin() throws Exception{
        driver.findElement(By.id("id_indicator_two")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("��ͨ����")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("action_more")).click();

        driver.findElement(By.name("δ��")).click();
        Thread.sleep(2000);
        //����
        List<WebElement> fanhui1 = driver.findElementsByClassName("android.widget.ImageButton");
        fanhui1.get(0).click();
        return;
    }

    //2�����뷢�ʹ���->�������б�ҳ��TestCase_SendMessage_List_Sending
    public void TestCase_SendMessage_List_Sending() throws Exception{
        driver.findElement(By.id("id_indicator_two")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("��ͨ����")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("action_more")).click();

        driver.findElement(By.name("������")).click();
        Thread.sleep(2000);
        //����
        List<WebElement> fanhui1 = driver.findElementsByClassName("android.widget.ImageButton");
        fanhui1.get(0).click();
        return;
    }

    //3�����뷢�ʹ���->ȫ�������б�ҳ��
    public  void TestCase_SendMessage_List_All() throws Exception{
        driver.findElement(By.id("id_indicator_two")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("��ͨ����")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("action_more")).click();

        driver.findElement(By.name("ȫ��")).click();
        Thread.sleep(2000);
        //����
        List<WebElement> fanhui1 = driver.findElementsByClassName("android.widget.ImageButton");
        fanhui1.get(0).click();
        return;
    }

    //4���յ�����->δȷ���б�������֤
    public void TestCase_ReceiveMessage_List_NotConfirm() throws Exception{
        driver.findElement(By.id("id_indicator_two")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("��ͨ����")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("action_more")).click();

        driver.findElement(By.name("δȷ��")).click();
        Thread.sleep(2000);
        //����
        List<WebElement> fanhui1 = driver.findElementsByClassName("android.widget.ImageButton");
        fanhui1.get(0).click();
    }

    //5�������յ�����->��ȷ���б�ҳ��
    public void TestCase_ReceiveMessage_List_Confirm() throws Exception{
        driver.findElement(By.id("id_indicator_two")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("��ͨ����")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("action_more")).click();

        driver.findElement(By.name("�����")).click();
        Thread.sleep(2000);
        //����
        List<WebElement> fanhui1 = driver.findElementsByClassName("android.widget.ImageButton");
        fanhui1.get(0).click();
        return;
    }


    public void chuangyue_Test() throws Exception{
        driver.findElement(By.id("id_indicator_two")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("��ͨ����")).click();
        Thread.sleep(5000);
        //�����Ӵ���
        driver.findElement(By.name("�ռ���")).click();

        List<WebElement> shoujianxiangs=  driver.findElementsByClassName("android.widget.RelativeLayout");
        //�����һ�����ĵ��ռ�����ļ�
        shoujianxiangs.get(0).click();
        Thread.sleep(5000);
        List<WebElement> fanhui0 = driver.findElementsByClassName("android.widget.ImageButton");
        fanhui0.get(0).click();
        //����ڶ������ĵ��ռ�����ļ�
        shoujianxiangs.get(1).click();
        Thread.sleep(5000);
        List<WebElement> fanhui1 = driver.findElementsByClassName("android.widget.ImageButton");
        fanhui1.get(0).click();

        return;

    }

    //������Ҫ�����Ĵ�������
    public void  TestCase_SendMessage_baocun() throws Exception{
        driver.findElement(By.id("fabAddUp")).click();
        driver.findElement(By.id("txtMsgTitle")).sendKeys("���ڸ�Ů�ڵķżٵİ���");
        driver.findElement(By.id("txtMsgContent")).sendKeys("��Ů�ڰ��Ŵ�3.8���翪ʼ������һ������ļ٣�");
        driver.findElement(By.id("msg_emp")).click();
        //ѡ���ĸ�˭
        List<WebElement> caidans =driver.findElementsByClassName("android.support.v7.app.ActionBar$Tab");
        caidans.get(0).click();
        caidans.get(1).click();
        caidans.get(2).click();
        driver.findElement(By.id("btnSelectEmpBranchDep")).click();
        List<WebElement> receivers = driver.findElementsByClassName("android.widget.RelativeLayout");
        receivers.get(3).click();
        receivers.get(4).click();
        //caidans.get(3).click();
        caidans.get(4).click();
        driver.findElement(By.name("ȷ��")).click();
        driver.findElement(By.name("����")).click();
        List<WebElement> fanhui1 = driver.findElementsByClassName("android.widget.ImageButton");
        fanhui1.get(0).click();
        return;
    }

}
