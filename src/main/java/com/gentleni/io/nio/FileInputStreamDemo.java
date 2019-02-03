package com.gentleni.io.nio;

import java.io.*;

/**
 * Created by GentleNi
 * Date 2018/10/9.
 */
public class FileInputStreamDemo {

    static File f = new File("test.txt");

    public static void main(String[] args) throws IOException {
        //writeData();

        readData();
    }

    public static void readData() throws IOException {
        FileInputStream fis = new FileInputStream(f);
        DataInputStream dis = new DataInputStream(fis);
        byte[] buf = new byte[1024];
        int len;

        //FileInputStream
//        while ((len = fis.read(b)) != -1) {
//            System.out.println(new String(b,0,len));
//        }

        //DataInputStream
        int num = dis.readInt();
        boolean b = dis.readBoolean();
        double d = dis.readDouble();

        System.out.println("num="+num);
        System.out.println("b="+b);
        System.out.println("d="+d);


        fis.close();
        dis.close();
    }

    public static void writeData() throws IOException {
        FileOutputStream fos = new FileOutputStream(f);
        DataOutputStream dos = new DataOutputStream(fos);
        dos.writeInt(123);
        dos.writeBoolean(true);
        dos.writeDouble(9887.543);

        dos.close();
    }
}
