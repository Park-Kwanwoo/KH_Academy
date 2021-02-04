package com.test01;

import java.io.IOException;

public class MTest01 {

    public static void main(String[] args) {

        Runtime rt = Runtime.getRuntime();

        // mac os : String[] path = {" /usr/bin/open", "-a", "/Applications/메모"}
        String[] path = {"/usr/bin/open", "-a", "/Applications/Safari.app"};

        /*
          1. Program : 응용 S/W (.exe(Window)/ .app(Mac)) -> 실행할 수 있는 파일
          2. Process : 프로그램이 실행되고 있는 객체 (메모리에 올라간 객체)
          3. Thread : 하나의 Process에서 여려개의 메소드 단위로 실행되는 모듈

         java에서 메소드 단위로 프로그램을 실행하는 방법 2가지
          1. Runnable을 implements 한다. (단순 Thread화)
          2. Theread를 extends 한다. (여러개의 Thread 기능을 사용해야 할 때)

         */
        try {
            Process prc = rt.exec(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
