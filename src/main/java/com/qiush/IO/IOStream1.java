package com.qiush.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 
 * @author qiush
 *
 */
public class IOStream1 {
	public static void main(String[] args) throws IOException {
		//IO流核心六行代码,之后IO都是在这六行修改,每次读一个字节
		demo1();
	}

	private static void demo1() throws FileNotFoundException, IOException {
		FileInputStream fis =new FileInputStream("双元.jpg");
		FileOutputStream fos = new FileOutputStream("copy.jpg");
		int b;
		while((b = fis.read())!=-1){
			fos.write(b);
		}
		fis.close();
		fos.close();
	}
}
