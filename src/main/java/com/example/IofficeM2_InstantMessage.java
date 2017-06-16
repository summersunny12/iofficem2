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

public class IofficeM2_InstantMessage {
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
    public void InMessaging_Test() throws Exception{
        //���ȵ�¼����
        login();
        Thread.sleep(20000);
        // 1�����뼴ʱ��Ϣ����,����Ϣ�б�
        Receive_Messages();
        //2�����뼴ʱ��Ϣ���棬�����������������ؼ��֣�������ؼ�����صļ�ʱ��Ϣ���б��Լ����£�Ȼ��鿴����������
        ReMessages_Search();
        //3���Լ����ͼ�ʱ��Ϣ ,ѡ���ռ��˵ķ�ʽ�ǳ���
        Fasongcy_InMessage();
        //4���Լ����ͼ�ʱ��Ϣ ,ѡ���ռ��˵ķ�ʽ���Զ���
        Fasongdy_InMessage();
        //5���Լ����ͼ�ʱ��Ϣ ,ѡ���ռ��˵ķ�ʽ�ǻ���
        Fasongjg_InMessage();
        //6���Լ����ͼ�ʱ��Ϣ ,ѡ���ռ��˵ķ�ʽ�ǻ���,��ȡ������ť
        Fasongjg_InMessage_Search();


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

    // 1�����뼴ʱ��Ϣ����,����Ϣ�б�
    public void Receive_Messages() throws Exception{
        //����칫
        driver.findElement(By.id("id_indicator_two")).click();
        //������뼴ʱ��Ϣ����
        driver.findElement(By.name("��ʱ��Ϣ")).click();
        //�����û��յ��ļ�ʱ��Ϣ�б�
        //��һ����Ϣ
        List<WebElement> ReMessages=driver.findElementsByClassName("android.widget.RelativeLayout");
        ReMessages.get(1).click();
        List<WebElement> fanhui_ReMessage1=driver.findElementsByClassName("android.widget.ImageButton");
        fanhui_ReMessage1.get(0).click();
        //�ڶ�����Ϣ
        ReMessages.get(2).click();
        List<WebElement> fanhui_ReMessage2=driver.findElementsByClassName("android.widget.ImageButton");
        fanhui_ReMessage2.get(0).click();
        //��������Ϣ
        ReMessages.get(3).click();
        List<WebElement> fanhui_ReMessage3=driver.findElementsByClassName("android.widget.ImageButton");
        fanhui_ReMessage3.get(0).click();

        //�˳���ʱ��Ϣ����
        List<WebElement> fanhui=driver.findElementsByClassName("android.widget.ImageButton");
        fanhui.get(0).click();
        return;
    }
    //2�����뼴ʱ��Ϣ���棬�����������������ؼ��֣�������ؼ�����صļ�ʱ��Ϣ���б��Լ����£�Ȼ��鿴����������
    public void ReMessages_Search() throws Exception{
        //����칫
        driver.findElement(By.id("id_indicator_two")).click();
        //������뼴ʱ��Ϣ����
        driver.findElement(By.name("��ʱ��Ϣ")).click();
        //���������ť
        driver.findElement(By.id("search_button")).click();
        driver.findElement(By.id("search_src_text")).sendKeys("f");
        List<WebElement> SInMessages=driver.findElementsByClassName("android.widget.RelativeLayout");
        //��һ����ʱ��Ϣ
        SInMessages.get(1).click();
        Thread.sleep(3000);
        //����
        List<WebElement> fanhui1=driver.findElementsByClassName("android.widget.ImageButton");
        fanhui1.get(0).click();
        //�ڶ�����ʱ��Ϣ
        SInMessages.get(2).click();
        Thread.sleep(3000);
        //����
        List<WebElement> fanhui2=driver.findElementsByClassName("android.widget.ImageButton");
        fanhui2.get(0).click();
        //t�˳���ʱ��Ϣ����

        List<WebElement> fanhui=driver.findElementsByClassName("android.widget.ImageButton");
        fanhui.get(0).click();
        return;
    }

    //3���Լ����ͼ�ʱ��Ϣ ,ѡ���ռ��˵ķ�ʽ�ǳ���
    public void Fasongcy_InMessage() throws Exception{
        //����칫
        driver.findElement(By.id("id_indicator_two")).click();
        //������뼴ʱ��Ϣ����
        driver.findElement(By.name("��ʱ��Ϣ")).click();
        //�����Ӱ�ť
        driver.findElement(By.id("action_add")).click();
        //����ռ���
        driver.findElement(By.id("btnIMAddReceiver")).click();
        //���������ϵ�˵Ľ���
        //1���ڳ�����ϵ�������û���Ҫ���ռ���
        List<WebElement> receiverers = driver.findElementsByClassName("android.support.v7.app.ActionBar$Tab");
        //�������������
        receiverers.get(0).click();
        List<WebElement> cyReceiverers = driver.findElementsByClassName("android.widget.RelativeLayout");
        cyReceiverers.get(0).click();
        cyReceiverers.get(2).click();
        receiverers.get(4).click();
        driver.findElement(By.name("ȷ��")).click();
        driver.findElement(By.id("txtIMDetailSendContent")).sendKeys("��ã�");
        driver.findElement(By.name("����")).click();
        Thread.sleep(5000);
        //���س����͵���Ϣ����
        List<WebElement> fanhuifs=driver.findElementsByClassName("android.widget.ImageButton");
        fanhuifs.get(0).click();
        //�˳���ʱ��Ϣ����
        List<WebElement> fanhuijs = driver.findElementsByClassName("android.widget.ImageButton");
        fanhuijs.get(0).click();
        return;
    }
    //4���Լ����ͼ�ʱ��Ϣ ,ѡ���ռ��˵ķ�ʽ���Զ���
    public void Fasongdy_InMessage() throws Exception{
        //����칫
        driver.findElement(By.id("id_indicator_two")).click();
        //������뼴ʱ��Ϣ����
        driver.findElement(By.name("��ʱ��Ϣ")).click();
        //�����Ӱ�ť
        driver.findElement(By.id("action_add")).click();
        //����ռ���
        driver.findElement(By.id("btnIMAddReceiver")).click();
        //���������ϵ�˵Ľ���
        //1���ڳ�����ϵ�������û���Ҫ���ռ���
        List<WebElement> receiverers = driver.findElementsByClassName("android.support.v7.app.ActionBar$Tab");
        //����Զ����ռ���
        receiverers.get(1).click();
        List<WebElement> cyReceiverers = driver.findElementsByClassName("android.widget.RelativeLayout");
        cyReceiverers.get(0).click();
        cyReceiverers.get(2).click();
        receiverers.get(4).click();
        driver.findElement(By.name("ȷ��")).click();
        driver.findElement(By.id("txtIMDetailSendContent")).sendKeys("��ã�");
        driver.findElement(By.name("����")).click();
        Thread.sleep(5000);
        //���س����͵���Ϣ����
        List<WebElement> fanhuifs=driver.findElementsByClassName("android.widget.ImageButton");
        fanhuifs.get(0).click();
        //�˳���ʱ��Ϣ����
        List<WebElement> fanhuijs = driver.findElementsByClassName("android.widget.ImageButton");
        fanhuijs.get(0).click();
        return;
    }

    //5���Լ����ͼ�ʱ��Ϣ ,ѡ���ռ��˵ķ�ʽ�ǻ���
    public void Fasongjg_InMessage() throws Exception{
        //����칫
        driver.findElement(By.id("id_indicator_two")).click();
        //������뼴ʱ��Ϣ����
        driver.findElement(By.name("��ʱ��Ϣ")).click();
        //�����Ӱ�ť
        driver.findElement(By.id("action_add")).click();
        //����ռ���
        driver.findElement(By.id("btnIMAddReceiver")).click();
        //���������ϵ�˵Ľ���
        //1���ڳ�����ϵ�������û���Ҫ���ռ���
        List<WebElement> receiverers = driver.findElementsByClassName("android.support.v7.app.ActionBar$Tab");
        //�������������
        receiverers.get(2).click();
        driver.findElement(By.name("�췫�Ƽ�")).click();
        driver.findElement(By.name("��������Ʒ��")).click();
        driver.findElement(By.name("�ƶ��ͻ�����")).click();
        driver.findElement(By.name("��Ӣ��")).click();
        receiverers.get(4).click();

        driver.findElement(By.name("ȷ��")).click();
        driver.findElement(By.id("txtIMDetailSendContent")).sendKeys("��ã�");
        driver.findElement(By.name("����")).click();
        Thread.sleep(5000);
        //���س����͵���Ϣ����
        List<WebElement> fanhuifs=driver.findElementsByClassName("android.widget.ImageButton");
        fanhuifs.get(0).click();
        //�˳���ʱ��Ϣ����
        List<WebElement> fanhuijs = driver.findElementsByClassName("android.widget.ImageButton");
        fanhuijs.get(0).click();
        return;
    }
    //6���Լ����ͼ�ʱ��Ϣ ,ѡ���ռ��˵ķ�ʽ�ǻ���,��ȡ������ť
    public void Fasongjg_InMessage_Search() throws Exception{
        //����칫
        driver.findElement(By.id("id_indicator_two")).click();
        //������뼴ʱ��Ϣ����
        driver.findElement(By.name("��ʱ��Ϣ")).click();
        //�����Ӱ�ť
        driver.findElement(By.id("action_add")).click();
        //����ռ���
        driver.findElement(By.id("btnIMAddReceiver")).click();
        //���������ϵ�˵Ľ���
        //1���ڳ�����ϵ�������û���Ҫ���ռ���
        List<WebElement> receiverers = driver.findElementsByClassName("android.support.v7.app.ActionBar$Tab");
        //�������������
        receiverers.get(2).click();
        //���������ť
        driver.findElement(By.id("search_button")).click();
        //����������д�ؼ���
        driver.findElement(By.id("search_src_text")).sendKeys("�ƶ��ͻ�����");
        driver.findElement(By.id("btnSelectEmpBranchDep")).click();
        driver.findElement(By.name("��Ӣ��")).click();

        receiverers.get(4).click();


        driver.findElement(By.name("ȷ��")).click();
        driver.findElement(By.id("txtIMDetailSendContent")).sendKeys("��ã�");
        driver.findElement(By.name("����")).click();
        Thread.sleep(5000);
        //���س����͵���Ϣ����
        List<WebElement> fanhuifs=driver.findElementsByClassName("android.widget.ImageButton");
        fanhuifs.get(0).click();
        //�˳���ʱ��Ϣ����
        List<WebElement> fanhuijs = driver.findElementsByClassName("android.widget.ImageButton");
        fanhuijs.get(0).click();
        return;
    }


}
