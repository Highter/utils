package com.yjw.utils.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *0005:文件流处理类
 *@author Higher
 *@date 下午1:54:17,2016年6月29日
 *@vesion 1.0
 *@see yjwsmileatlife@126.com
 */

public class FileUtils {
	
	/**
	 * 00050001:往文件写入内容
	 * @param path
	 * @param writeMsg
	 * @return
	 */
	public static boolean writeFile(String path,String writeMsg){
		
		File file = new File(path);
		FileWriter fw = null;
		BufferedWriter writer = null;
		try {
			if(!file.exists())//check if the file already exists
				file.createNewFile();
			
			fw = new FileWriter(file);
			writer = new BufferedWriter(fw);
			writer.write(writeMsg);
			writer.flush();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally{
			try {
				writer.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 00050002:往文件写入内容（拼接内容）
	 * @param path
	 * @param writeMsg
	 * @return
	 */
	public static boolean writeAppendFile(String path,String writeMsg){
		
		File file = new File(path);
		FileWriter fw = null;
		FileReader fr = null;
		BufferedWriter bw = null;
		BufferedReader br = null;
		try {
			if(!file.exists())//check if the file already exists
				file.createNewFile();
			
			//获取文件 内容
			String result = "";
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			
			for(String line; (line = br.readLine()) != null; ) {
		        // process the line.
				result = result + line + "\n";
		    }
			br.close();
			
			//拼接写入
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			bw.write(result+writeMsg);
			bw.flush();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally{
			try {
				bw.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 00050003:读取文件内容
	 * @param path
	 * @return
	 */
	public static String readFile(String path){
		
		//Read File Line By Line
		File file = new File(path);
		FileReader fr = null;
		BufferedReader br = null;
		
		String result = "";//文件内容
		try {
			if(!file.exists())//check if the file already exists
				file.createNewFile();
			
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			
			for(String line; (line = br.readLine()) != null; ) {
		        // process the line.
				result = result + line + "\n";
		    }
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				if(br != null){
					br.close();
				}
				if(fr != null){
					fr.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
}
