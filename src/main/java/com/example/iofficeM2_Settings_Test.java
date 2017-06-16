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
        System.out.println("appium连接成功！");

    }
    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
        //driver.closeApp();
    }
    @Test
    public void Settings_Test() throws Exception{
        //首先登录界面
        login();
        Thread.sleep(20000);
        //1\进入设置界面，然后单击登录验证，选择登录验证方式“保存密码，直接登录”
        Easy_Login_Checked();
        Thread.sleep(2000);
        //2、进入设置界面，然后单击登录验证，选择登录验证方式“使用登录密码验证”
        mima_Login_Checked();
        Thread.sleep(2000);
        //3、进入设置界面，然后单击登录验证，选择登录验证方式“使用手势密码验证”
        shoushi_Login_checked();
        Thread.sleep(2000);
        //4、进入设置界面，然后单击验证密码，输入正确旧密码，输入新密码，再一次输入新密码，如果两次新密码一致，则更改密码成功
        genggai_pwd_checked();
        Thread.sleep(2000);
        //5、进入设置界面，然后单击验证密码，输入错误旧密码，输入新密码，再一次输入新密码，如果两次新密码一致，则密码修改失败，提示“旧密码不正确！”
        genggai_cuowupwd_checked();
        Thread.sleep(2000);
        //6、进入设置界面，然后单击验证密码，输入正确旧密码，输入新密码，再一次输入新密码，如果两次新密码不一致，则密码修改失败，提示“新密码和确认密码不一致！”
        genggai_pwd_ConfirmPwd();
        //7、进入设置界面，然后单击选人设置，选择其中一种排序方式
        shezhi_xuanrens();

    }
    //登录的自动化实现
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


    //1\进入设置界面，然后单击登录验证，选择登录验证方式“保存密码，直接登录”
    public void Easy_Login_Checked() throws Exception{
        driver.findElement(By.id("id_indicator_four")).click();
        driver.findElement(By.name("设置")).click();
        driver.findElement(By.name("登录验证")).click();
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
    //2、进入设置界面，然后单击登录验证，选择登录验证方式“使用登录密码验证”
    public void mima_Login_Checked() throws  Exception{
        driver.findElement(By.id("id_indicator_four")).click();
        driver.findElement(By.name("设置")).click();
        driver.findElement(By.name("登录验证")).click();
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
    //3、进入设置界面，然后单击登录验证，选择登录验证方式“使用手势密码验证”shoushi_Login_checked()
    public void shoushi_Login_checked() throws Exception{
        driver.findElement(By.id("id_indicator_four")).click();
        driver.findElement(By.name("设置")).click();
        driver.findElement(By.name("登录验证")).click();
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
    //4、进入设置界面，然后单击验证密码，输入正确旧密码，输入新密码，再一次输入新密码，如果两次新密码一致，则更改密码成功 genggai_pwd_checked()
    public void genggai_pwd_checked() throws  Exception{
        driver.findElement(By.id("id_indicator_four")).click();
        driver.findElement(By.name("设置")).click();
        driver.findElement(By.name("验证密码")).click();
        //进入修改密码的界面：
        driver.findElement(By.name("显示密码")).click();
        driver.findElement(By.id("txtOldPwd")).sendKeys("58993245zyj");
        driver.findElement(By.id("txtNewPwd")).sendKeys("58993245zyjzyl");
        driver.findElement(By.id("txtConfirmPwd")).sendKeys("58993245zyjzyl");
        driver.findElement(By.id("action_confirm")).click();
        Thread.sleep(5000);
        List<WebElement> fanhuishezhi = driver.findElementsByClassName("android.widget.ImageButton");
        fanhuishezhi.get(0).click();
        return;
    }
    //5、进入设置界面，然后单击验证密码，输入错误旧密码，输入新密码，再一次输入新密码，如果两次新密码一致，则密码修改失败，提示“旧密码不正确！” genggai_cuowupwd_checked()
    public void genggai_cuowupwd_checked() throws  Exception{
        driver.findElement(By.id("id_indicator_four")).click();
        driver.findElement(By.name("设置")).click();
        driver.findElement(By.name("验证密码")).click();
        //进入修改密码的界面：
        driver.findElement(By.name("显示密码")).click();
        driver.findElement(By.id("txtOldPwd")).sendKeys("58993245");
        driver.findElement(By.id("txtNewPwd")).sendKeys("58993245zyjzyl");
        driver.findElement(By.id("txtConfirmPwd")).sendKeys("58993245zyjzyl");
        driver.findElement(By.id("action_confirm")).click();
        Thread.sleep(5000);
        //提示旧密码不正确！，修改密码失败
        List<WebElement> fanhuixiugai = driver.findElementsByClassName("android.widget.ImageButton");
        fanhuixiugai.get(0).click();
        List<WebElement> fanhuishezhi = driver.findElementsByClassName("android.widget.ImageButton");
        fanhuishezhi.get(0).click();
        return;
    }
    //6、进入设置界面，然后单击验证密码，输入正确旧密码，输入新密码，再一次输入新密码，如果两次新密码不一致，则密码修改失败，提示“新密码和确认密码不一致！” genggai_pwd_ConfirmPwd()
    public void genggai_pwd_ConfirmPwd() throws  Exception{
        driver.findElement(By.id("id_indicator_four")).click();
        driver.findElement(By.name("设置")).click();
        driver.findElement(By.name("验证密码")).click();
        //进入修改密码的界面：
        driver.findElement(By.name("显示密码")).click();
        driver.findElement(By.id("txtOldPwd")).sendKeys("58993245");
        driver.findElement(By.id("txtNewPwd")).sendKeys("58993245zyjl");
        driver.findElement(By.id("txtConfirmPwd")).sendKeys("58993245zyjzyl");
        driver.findElement(By.id("action_confirm")).click();
        Thread.sleep(5000);
        //提示“新密码和确认密码不一致！”，修改密码失败
        List<WebElement> fanhuixiugai = driver.findElementsByClassName("android.widget.ImageButton");
        fanhuixiugai.get(0).click();
        List<WebElement> fanhuishezhi = driver.findElementsByClassName("android.widget.ImageButton");
        fanhuishezhi.get(0).click();
        return;
    }
    //7、进入设置界面，然后单击选人设置，选择其中一种排序方式 shezhi_xuanrens
    public void shezhi_xuanrens() throws  Exception{
        driver.findElement(By.id("id_indicator_four")).click();
        driver.findElement(By.name("设置")).click();
        driver.findElement(By.name("选人设置")).click();
        driver.findElement(By.id("txtSelEmp_CommonCount")).sendKeys("20");
        //选择排序方法
        driver.findElement(By.id("btnSelEmp_Order")).click();
        //部门+职务
        List<WebElement> paixufangshi0=driver.findElementsByClassName("android.widget.CheckedTextView");
        paixufangshi0.get(0).click();
        //选择排序方法
        driver.findElement(By.id("btnSelEmp_Order")).click();
        //职务
        List<WebElement> paixufangshi1=driver.findElementsByClassName("android.widget.CheckedTextView");
        paixufangshi1.get(1).click();
        //选择排序方法
        driver.findElement(By.id("btnSelEmp_Order")).click();
        //部门+人员编码
        List<WebElement> paixufangshi2=driver.findElementsByClassName("android.widget.CheckedTextView");
        paixufangshi2.get(2).click();
        //选择排序方法
        driver.findElement(By.id("btnSelEmp_Order")).click();
        //人员编码
        List<WebElement> paixufangshi3=driver.findElementsByClassName("android.widget.CheckedTextView");
        paixufangshi3.get(3).click();
        //选择排序方法
        driver.findElement(By.id("btnSelEmp_Order")).click();
        //部门+人员姓名
        List<WebElement> paixufangshi4=driver.findElementsByClassName("android.widget.CheckedTextView");
        paixufangshi4.get(4).click();
        //选择排序方法
        driver.findElement(By.id("btnSelEmp_Order")).click();
        //人员姓名
        List<WebElement> paixufangshi5=driver.findElementsByClassName("android.widget.CheckedTextView");
        paixufangshi5.get(5).click();
        driver.findElement(By.id("action_confirm")).click();
        List<WebElement> fanhuishezhi=driver.findElementsByClassName("android.widget.ImageButton");
        fanhuishezhi.get(0).click();
        Thread.sleep(2000);
        return;
    }
    //8、进入设置界面，单击“服务器关联”按钮，进入修改服务器网址界面，对服务器所关联的网址进行修改和添加操作
    public void shezi_wangzi() throws Exception{
        driver.findElement(By.id("id_indicator_four")).click();
        driver.findElement(By.name("设置")).click();
        driver.findElement(By.name("服务器关联")).click();
        driver.findElement(By.id("action_confirm")).click();
        driver.findElement(By.id("txtPwd")).sendKeys("oa.hongfan.cn:80");
        driver.findElement(By.name("确定")).click();
        List<WebElement> fanhui1 =driver.findElementsByClassName("android.widget.ImageButton");
        fanhui1.get(0).click();
        List<WebElement> fanhui0 =driver.findElementsByClassName("android.widget.ImageButton");
        fanhui0.get(0).click();
        Thread.sleep(1000);
        return;
    }

}
