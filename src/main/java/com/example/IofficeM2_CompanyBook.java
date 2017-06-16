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

public class IofficeM2_CompanyBook {
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
    public void CompanyBook_Test() throws Exception{
        //首先登录界面
        login();
        Thread.sleep(20000);
        //1、进入通讯录界面，显示公司通讯录以及个人通讯录，公司通讯录包括每一部门的公司员工的电话号码，并且可以通过关键字对公司的员工的电话号码,点击某一个部门可以查看该部门的员工的电话号码
        CompanyBook_quanbu_Test();
        //2、进入通讯录界面，就可以通过点击搜索按钮，然后输入关键字，从而显示某一个部门的通讯录或者某一个员工的通讯录
        CompanyBook_Search_Test();
        //3、进入公司通讯录界面，然后单击“常用”菜单，就可以查看到公司通讯录中常用的公司通讯录的员工有哪些
        CompanyBook_changyong_Test();
        //4、进入公司通讯录界面，然后点击下载按钮，然后自己选择自己要保存到自己手机的员工的通讯录，然后点击"完成"按钮，就可以将公司通讯录中的通讯录保存到手机的通讯录中去
        CompanyBook_MoblieBook_Test();
        //5、进入公司通讯录界面，然后点击下载按钮，再单击“搜索”按钮，然后自己选择自己要保存到自己手机的员工的通讯录，然后点击"完成"按钮，就可以将公司通讯录中的通讯录保存到手机的通讯录中去
        CompanyBook_sMoblieBook_Test();
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
    //1、进入通讯录界面，显示公司通讯录以及个人通讯录，公司通讯录包括每一部门的公司员工的电话号码，并且可以通过关键字对公司的员工的电话号码,点击某一个部门可以查看该部门的员工的电话号码
    public void CompanyBook_quanbu_Test() throws Exception{
        driver.findElement(By.id("id_indicator_three")).click();
        driver.findElement(By.name("综合部")).click();
        driver.findElement(By.name("行政部")).click();

        return;
        //可以对某一个部门的某一个员工的进行通讯以及发短信。

    }
    //2、进入通讯录界面，就可以通过点击搜索按钮，然后输入关键字，从而显示某一个部门的通讯录或者某一个员工的通讯录
    public void CompanyBook_Search_Test() throws Exception{
        driver.findElement(By.id("id_indicator_three")).click();
        //点击搜索按钮
        driver.findElement(By.id("search_button")).click();
        driver.findElement(By.id("search_src_text")).sendKeys("刘");
        //可以对某一个部门的某一个员工的进行通讯以及发短信。
        return;
    }
    //3、进入公司通讯录界面，然后单击“常用”菜单，就可以查看到公司通讯录中常用的公司通讯录的员工有哪些
    public void CompanyBook_changyong_Test() throws Exception{
        driver.findElement(By.id("id_indicator_three")).click();
        //点击搜索按钮
        driver.findElement(By.id("companyAddrBook_Often")).click();
        List<WebElement> fanhui=driver.findElementsByClassName("android.widget.ImageButton");
        fanhui.get(0).click();
        //可以对某一个部门的某一个员工的进行通讯以及发短信。
        return;
    }
    //4、进入公司通讯录界面，然后点击下载按钮，然后自己选择自己要保存到自己手机的员工的通讯录，然后点击"完成"按钮，就可以将公司通讯录中的通讯录保存到手机的通讯录中去
    public void CompanyBook_MoblieBook_Test() throws Exception {
        driver.findElement(By.id("id_indicator_three")).click();
        //点击下载按钮
        driver.findElement(By.id("action_download")).click();
        //选择综合部/行政部/林国荣、林汉洲
        driver.findElement(By.name("综合部")).click();
        driver.findElement(By.name("行政部")).click();
        driver.findElement(By.name("林国荣")).click();
        driver.findElement(By.name("林汉洲")).click();
        driver.findElement(By.name("完成")).click();
        return;
    }
    //5、进入公司通讯录界面，然后点击下载按钮，再单击“搜索”按钮，然后自己选择自己要保存到自己手机的员工的通讯录，然后点击"完成"按钮，就可以将公司通讯录中的通讯录保存到手机的通讯录中去
    public void CompanyBook_sMoblieBook_Test() throws Exception {
        driver.findElement(By.id("id_indicator_three")).click();
        //点击下载按钮
        driver.findElement(By.id("action_download")).click();
        driver.findElement(By.id("search_button")).click();
        driver.findElement(By.id("search_src_text")).sendKeys("杨");
        driver.findElement(By.name("杨嘉荣")).click();
        driver.findElement(By.name("确定")).click();
        return;
    }

}
