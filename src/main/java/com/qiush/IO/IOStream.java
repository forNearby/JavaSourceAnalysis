package com.qiush.IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * IO流基本操作
 * @author qiush
 *四大最顶层抽象类:InputStream(字节输入流)、OutputStream(字节输出流)、Reader(字符输入流)、Writer(字符输出流) extends Object
 */
public class IOStream {
	
	public static void main(String[] args) throws IOException  {
		FileInputStream fis = new FileInputStream("xxx.txt");
		int b;
		//1.read()每次读取一个字节,返回给b
		//2.当文件读完到文件结束标志位-1跳出循环
		//3.read()方法读取的是一个字节,为什么返回是int,而不是byte
		//在读取文件时中间又可能遇到11111111,那么这个数在byte中代表-1,程序会停掉,如果用int接收数据,则会在前面补上24个0,
		//就变成此时就变成255了,保证数据完整性,在用输出流写的时候会去掉每次前面补的0
		while((b = fis.read())!=-1){
			System.out.println(b);
		}
		fis.close();
		//FileOutputStream在创建对象时如果没有这个文件会自动创建文件,如果有这个文件会先把文件清空,所以如果想在文件后追加,
		//需要在FileOutputStream构造方法改成FileOutputStream("yyy.txt",true),true代表追加,不会执行清空操作
		FileOutputStream fos = new FileOutputStream("yyy.txt");
		fos.write(97); //写入一个字节,97为ASCII码对应字母a
		fos.write(98);
		fos.write(99);
		fos.close();
	}
	
	public static void demo1() throws IOException{
		FileInputStream fis = new FileInputStream("xxx.txt");
		int x = fis.read();
		System.out.println(x);//输出97,从硬盘读取一个字节,并且指针会后移一位,返回的是输出结果
		int y = fis.read();
		System.out.println(y);//输出98
		int z = fis.read();//输出99
		System.out.println(z);
		int a = fis.read();
		System.out.println(a);//输出-1,说明文件结束标记是-1
		fis.close();
	}
}
