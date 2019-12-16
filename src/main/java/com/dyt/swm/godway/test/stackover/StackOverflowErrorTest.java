package com.dyt.swm.godway.test.stackover;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author weiming.sun
 * @version 1.0
 * @date 2019/9/19 9:26
 */
public class StackOverflowErrorTest {

    private static int index = 0;
    public static void call()
    {
        index++;
        call();
    }
    public static void main(String[] args)
    {
      //  stackTrace();
        PermGen();
    }

    private static void PermGen() {
        URL url = null;
        List classLoaderList = new ArrayList();
        try {
            url = new File("/tmp").toURI().toURL();
            URL[] urls = {url};
            while (true){
                System.out.println("11");
                ClassLoader loader = new URLClassLoader(urls);
                classLoaderList.add(loader);
                loader.loadClass("com.dyt.swm.godway.test.Test");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void stackTrace() {
        try
        {
            call();
        }
        catch (Throwable e)
        {
            e.printStackTrace();
            System.out.println("Index->>>>" + index);
        }
    }


}
