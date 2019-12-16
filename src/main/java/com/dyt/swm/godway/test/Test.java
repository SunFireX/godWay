package com.dyt.swm.godway.test;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author weiming.sun
 * @version 1.0
 * @date 2019/8/27 13:40
 */
public class Test {
    /*public static void main(String[] args) {
        Map<String,String> map = new HashMap<>(16);
        String key = "美团";
        String value= "mt";
        Object a = new Object();
        Integer b = 1;
        System.out.println("key="+key.hashCode());

        int i = 234 & 7;
        System.out.println("i>>"+i);

    }*/

    public static void main(String[] args) {
        Object a = new Object();
        Thread thread = new Thread();
        ArrayList list = new ArrayList();
        Hashtable hashtable = new Hashtable();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        AtomicInteger auto = new AtomicInteger();
        Map<String,String>  map = new HashMap<>();//无参初始化 size=16
        String keyMT = "美团";
        String keyELM = "饿了么";
        String keyBD = "百度";
        map.put(keyMT,"MT");
        map.put(keyELM,"ELM");
        map.put(keyBD,"BD");
        System.out.println("美团="+keyMT.hashCode());
        System.out.println("饿了么="+keyELM.hashCode());
        System.out.println("百度="+keyBD.hashCode());
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
        long maxValue = Long.MAX_VALUE;
        long minValue = Long.MIN_VALUE;
        String i = (264)+"";
        System.out.println(i);
        System.out.println(minValue);
        int intVa = Integer.MAX_VALUE;
        float maxValue1 = Float.MAX_VALUE;
        System.out.println(maxValue);
        System.out.println(intVa);
        System.out.println(maxValue1);
        Thread thread1 = new Thread();
    }




            /**
              * 
              * 直接【求余】和【按位】运算的差别验证
              */
   /* public static void main(String[] args) {
        
        long currentTimeMillis = System.currentTimeMillis();
        int a=0;
        float times = 10000*10000;
        for (float i = 0; i < times; i++) {
                 a=999999%(1024-1);
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        
        int b=0;
        for (float i = 0; i < times; i++) {
                 b=999999&(1024-1);
        }
        
        long currentTimeMillis3 = System.currentTimeMillis();
        System.out.println(a+","+b);
        System.out.println("%: "+(currentTimeMillis2-currentTimeMillis));
        System.out.println("&: "+(currentTimeMillis3-currentTimeMillis2));
    }*/


}
