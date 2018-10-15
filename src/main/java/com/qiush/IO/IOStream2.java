package com.qiush.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOStream2 {
	public static void main(String[] args) throws IOException {
		demo1();
	}

	private static void demo1() throws FileNotFoundException, IOException {
		//通过创建字节数组写文件
		//1.fis.read(arr)会把读取到的数据存储到arr数组中,返回值是读取到的实际长度
		//2.当文件读取到结束时返回值或者说长度时-1
		//3.写文件时fos.write(arr,0,len),其中意思是读取arr数组,从下标0开始偏移量是读取到的实际长度,之所以这样设置偏移量
		//是因为读取到最后时,字节数组可能装不满,设置了偏移量会只读实际长度
		FileInputStream fis = new FileInputStream("xxx.txt");
		FileOutputStream fos = new FileOutputStream("yyy.txt");
		byte [] arr = new byte[1024*8];
		int len;
		while((len = fis.read(arr))!=-1){
			fos.write(arr,0,len);
		}
		fis.close();
		fos.close();
	}
}
