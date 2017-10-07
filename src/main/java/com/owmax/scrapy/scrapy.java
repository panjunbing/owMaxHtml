package com.owmax.scrapy;

/*
 * Created by panpan on 2017/6/2    ^_^
 */

import java.io.*;

public class scrapy {
    static String filepath = "B:/ScrapyProject/owMax/owMax";
    static String cmd = "cmd /c B: && cd " + filepath + " && scrapy crawl owMax";
    public static void scrapy() {
        try {
            System.out.println("--------------------------------start--------------------------------");
            Process process = Runtime.getRuntime().exec(cmd);
            //防止进程阻塞，把标准流和错误流分开输出
            printMessage(process.getInputStream());
            printMessage(process.getErrorStream());
            process.waitFor();
            System.out.println("--------------------------------end--------------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printMessage(final InputStream input) {
        new Thread(new Runnable() {
            public void run() {
                Reader reader = new InputStreamReader(input);
                BufferedReader bf = new BufferedReader(reader);
                String line = null;
                try {
                    while ((line = bf.readLine()) != null) {
                        System.out.println(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
