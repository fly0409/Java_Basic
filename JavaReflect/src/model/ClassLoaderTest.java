package model;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ClassLoaderTest {

    @Test
    public void test1(){
        //對於自定義class 使用系統loader進行加載
        ClassLoader classloader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classloader);

        //呼叫getParent 獲取擴展class loader(jdk8之前)，之後為Platform Loader
        ClassLoader parentLoader = classloader.getParent();
        System.out.println(parentLoader);

        //呼叫getParent 獲取Platform Loader的parent
        //理論上是引導class loader(bootstrap classloder)
        //負責load java 的核心類庫，無法load自定義class (只給java核心core用 ex:String)
        ClassLoader grandLoader = parentLoader.getParent();
        System.out.println(grandLoader);


    }

    /**
     * properties 讀取配置文件
     *
     */
    @Test
    public void test2() throws IOException {
        Properties prop = new Properties();
        //此時的檔案默認在當前的module下(eclipse的話為當前的project下)
        //讀取配置文件方式1
//        FileInputStream fis = new FileInputStream("jdbc.properties");
//        prop.load(fis);
        //透過classLoader
        ClassLoader classloader = ClassLoaderTest.class.getClassLoader();
        //此時識別位置不在module下，是在src下
        InputStream is = classloader.getResourceAsStream("jdbc1.properties");
        prop.load(is); //此行報了null pointer exception

        String user = prop.getProperty("user");
        String password = prop.getProperty("password");
        System.out.println(user+":"+password);


    }

}
