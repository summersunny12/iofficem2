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
 * Created by admin on 2017/6/9.
 */

public class iofficeM2_Settings_Test {
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
    public void Settings_Test() throws Exception{
        //���ȵ�¼����
        login();
        Thread.sleep(20000);
        //1\�������ý��棬Ȼ�󵥻���¼��֤��ѡ���¼��֤��ʽ���������룬ֱ�ӵ�¼��
        Easy_Login_Checked();
        Thread.sleep(2000);
        //2���������ý��棬Ȼ�󵥻���¼��֤��ѡ���¼��֤��ʽ��ʹ�õ�¼������֤��
        mima_Login_Checked();
        Thread.sleep(2000);
        //3���������ý��棬Ȼ�󵥻���¼��֤��ѡ���¼��֤��ʽ��ʹ������������֤��
        shoushi_Login_checked();
        Thread.sleep(2000);
        //4���������ý��棬Ȼ�󵥻���֤���룬������ȷ�����룬���������룬��һ�����������룬�������������һ�£����������ɹ�
        genggai_pwd_checked();
        Thread.sleep(2000);
        //5���������ý��棬Ȼ�󵥻���֤���룬�����������룬���������룬��һ�����������룬�������������һ�£��������޸�ʧ�ܣ���ʾ�������벻��ȷ����
        genggai_cuowupwd_checked();
        Thread.sleep(2000);
        //6���������ý��棬Ȼ�󵥻���֤���룬������ȷ�����룬���������룬��һ�����������룬������������벻һ�£��������޸�ʧ�ܣ���ʾ���������ȷ�����벻һ�£���
        genggai_pwd_ConfirmPwd();
        //7���������ý��棬Ȼ�󵥻�ѡ�����ã�ѡ������һ������ʽ
        shezhi_xuanrens();

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


    //1\�������ý��棬Ȼ�󵥻���¼��֤��ѡ���¼��֤��ʽ���������룬ֱ�ӵ�¼��
    public void Easy_Login_Checked() throws Exception{
        driver.findElement(By.id("id_indicator_four")).click();
        driver.findElement(By.name("����")).click();
        driver.findElement(By.name("��¼��֤")).click();
        driver.findElement(By.id("rowCheckType")).click();
        List<WebElement> Login_checkeds=driver.findElementsByClassName("android.widget.CheckedTextView");
        Login_checkeds.get(0).click();
        List<WebElement> fanhuilogin =driver.findElementsByClassName("android.widget.ImageButton");
        fanhuilogin.get(0).click();
        List<WebElement> fanhuishezi = driver.findElementsByClassName("android.widget.ImageButton");
        fanhuishezi.get(0).click();
        Thread.sleep(2000);
        return;

    }
    //2���������ý��棬Ȼ�󵥻���¼��֤��ѡ���¼��֤��ʽ��ʹ�õ�¼������֤��
    public void mima_Login_Checked() throws  Exception{
        driver.findElement(By.id("id_indicator_four")).click();
        driver.findElement(By.name("����")).click();
        driver.findElement(By.name("��¼��֤")).click();
        driver.findElement(By.id("rowCheckType")).click();
        List<WebElement> Login_checkeds=driver.findElementsByClassName("android.widget.CheckedTextView");
        Login_checkeds.get(1).click();
        List<WebElement> fanhuilogin =driver.findElementsByClassName("android.widget.ImageButton");
        fanhuilogin.get(0).click();
        List<WebElement> fanhuishezi = driver.findElementsByClassName("android.widget.ImageButton");
        fanhuishezi.get(0).click();
        Thread.sleep(2000);
        return;
    }
    //3���������ý��棬Ȼ�󵥻���¼��֤��ѡ���¼��֤��ʽ��ʹ������������֤��shoushi_Login_checked()
    public void shoushi_Login_checked() throws Exception{
        driver.findElement(By.id("id_indicator_four")).click();
        driver.findElement(By.name("����")).click();
        driver.findElement(By.name("��¼��֤")).click();
        driver.findElement(By.id("rowCheckType")).click();
        List<WebElement> Login_checkeds=driver.findElementsByClassName("android.widget.CheckedTextView");
        Login_checkeds.get(2).click();
        driver.findElement(By.name("Cancel")).click();
        Thread.sleep(2000);
        List<WebElement> fanhuilogin =driver.findElementsByClassName("android.widget.ImageButton");
        fanhuilogin.get(0).click();
        List<WebElement> fanhuishezi = driver.findElementsByClassName("android.widget.ImageButton");
        fanhuishezi.get(0).click();
        Thread.sleep(2000);
        return;
    }
    //4���������ý��棬Ȼ�󵥻���֤���룬������ȷ�����룬���������룬��һ�����������룬�������������һ�£����������ɹ� genggai_pwd_checked()
    public void genggai_pwd_checked() throws  Exception{
        driver.findElement(By.id("id_indicator_four")).click();
        driver.findElement(By.name("����")).click();
        driver.findElement(By.name("��֤����")).click();
        //�����޸�����Ľ��棺
        driver.findElement(By.name("��ʾ����")).click();
        driver.findElement(By.id("txtOldPwd")).sendKeys("58993245zyj");
        driver.findElement(By.id("txtNewPwd")).sendKeys("58993245zyjzyl");
        driver.findElement(By.id("txtConfirmPwd")).sendKeys("58993245zyjzyl");
        driver.findElement(By.id("action_confirm")).click();
        Thread.sleep(5000);
        List<WebElement> fanhuishezhi = driver.findElementsByClassName("android.widget.ImageButton");
        fanhuishezhi.get(0).click();
        return;
    }
    //5���������ý��棬Ȼ�󵥻���֤���룬�����������룬���������룬��һ�����������룬�������������һ�£��������޸�ʧ�ܣ���ʾ�������벻��ȷ���� genggai_cuowupwd_checked()
    public void genggai_cuowupwd_checked() throws  Exception{
        driver.findElement(By.id("id_indicator_four")).click();
        driver.findElement(By.name("����")).click();
        driver.findElement(By.name("��֤����")).click();
        //�����޸�����Ľ��棺
        driver.findElement(By.name("��ʾ����")).click();
        driver.findElement(By.id("txtOldPwd")).sendKeys("58993245");
        driver.findElement(By.id("txtNewPwd")).sendKeys("58993245zyjzyl");
        driver.findElement(By.id("txtConfirmPwd")).sendKeys("58993245zyjzyl");
        driver.findElement(By.id("action_confirm")).click();
        Thread.sleep(5000);
        //��ʾ�����벻��ȷ�����޸�����ʧ��
        List<WebElement> fanhuixiugai = driver.findElementsByClassName("android.widget.ImageButton");
        fanhuixiugai.get(0).click();
        List<WebElement> fanhuishezhi = driver.findElementsByClassName("android.widget.ImageButton");
        fanhuishezhi.get(0).click();
        return;
    }
    //6���������ý��棬Ȼ�󵥻���֤���룬������ȷ�����룬���������룬��һ�����������룬������������벻һ�£��������޸�ʧ�ܣ���ʾ���������ȷ�����벻һ�£��� genggai_pwd_ConfirmPwd()
    public void genggai_pwd_ConfirmPwd() throws  Exception{
        driver.findElement(By.id("id_indicator_four")).click();
        driver.findElement(By.name("����")).click();
        driver.findElement(By.name("��֤����")).click();
        //�����޸�����Ľ��棺
        driver.findElement(By.name("��ʾ����")).click();
        driver.findElement(By.id("txtOldPwd")).sendKeys("58993245");
        driver.findElement(By.id("txtNewPwd")).sendKeys("58993245zyjl");
        driver.findElement(By.id("txtConfirmPwd")).sendKeys("58993245zyjzyl");
        driver.findElement(By.id("action_confirm")).click();
        Thread.sleep(5000);
        //��ʾ���������ȷ�����벻һ�£������޸�����ʧ��
        List<WebElement> fanhuixiugai = driver.findElementsByClassName("android.widget.ImageButton");
        fanhuixiugai.get(0).click();
        List<WebElement> fanhuishezhi = driver.findElementsByClassName("android.widget.ImageButton");
        fanhuishezhi.get(0).click();
        return;
    }
    //7���������ý��棬Ȼ�󵥻�ѡ�����ã�ѡ������һ������ʽ shezhi_xuanrens
    public void shezhi_xuanrens() throws  Exception{
        driver.findElement(By.id("id_indicator_four")).click();
        driver.findElement(By.name("����")).click();
        driver.findElement(By.name("ѡ������")).click();
        driver.findElement(By.id("txtSelEmp_CommonCount")).sendKeys("20");
        //ѡ�����򷽷�
        driver.findElement(By.id("btnSelEmp_Order")).click();
        //����+ְ��
        List<WebElement> paixufangshi0=driver.findElementsByClassName("android.widget.CheckedTextView");
        paixufangshi0.get(0).click();
        //ѡ�����򷽷�
        driver.findElement(By.id("btnSelEmp_Order")).click();
        //ְ��
        List<WebElement> paixufangshi1=driver.findElementsByClassName("android.widget.CheckedTextView");
        paixufangshi1.get(1).click();
        //ѡ�����򷽷�
        driver.findElement(By.id("btnSelEmp_Order")).click();
        //����+��Ա����
        List<WebElement> paixufangshi2=driver.findElementsByClassName("android.widget.CheckedTextView");
        paixufangshi2.get(2).click();
        //ѡ�����򷽷�
        driver.findElement(By.id("btnSelEmp_Order")).click();
        //��Ա����
        List<WebElement> paixufangshi3=driver.findElementsByClassName("android.widget.CheckedTextView");
        paixufangshi3.get(3).click();
        //ѡ�����򷽷�
        driver.findElement(By.id("btnSelEmp_Order")).click();
        //����+��Ա����
        List<WebElement> paixufangshi4=driver.findElementsByClassName("android.widget.CheckedTextView");
        paixufangshi4.get(4).click();
        //ѡ�����򷽷�
        driver.findElement(By.id("btnSelEmp_Order")).click();
        //��Ա����
        List<WebElement> paixufangshi5=driver.findElementsByClassName("android.widget.CheckedTextView");
        paixufangshi5.get(5).click();
        driver.findElement(By.id("action_confirm")).click();
        List<WebElement> fanhuishezhi=driver.findElementsByClassName("android.widget.ImageButton");
        fanhuishezhi.get(0).click();
        Thread.sleep(2000);
        return;
    }
    //8���������ý��棬��������������������ť�������޸ķ�������ַ���棬�Է���������������ַ�����޸ĺ���Ӳ���
    public void shezi_wangzi() throws Exception{
        driver.findElement(By.id("id_indicator_four")).click();
        driver.findElement(By.name("����")).click();
        driver.findElement(By.name("����������")).click();
        driver.findElement(By.id("action_confirm")).click();
        driver.findElement(By.id("txtPwd")).sendKeys("oa.hongfan.cn:80");
        driver.findElement(By.name("ȷ��")).click();
        List<WebElement> fanhui1 =driver.findElementsByClassName("android.widget.ImageButton");
        fanhui1.get(0).click();
        List<WebElement> fanhui0 =driver.findElementsByClassName("android.widget.ImageButton");
        fanhui0.get(0).click();
        Thread.sleep(1000);
        return;
    }

}
