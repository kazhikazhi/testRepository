package com.htdw.el;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
	public static void main(String[] args) {
		Reader reader = null;
		BufferedReader br = null;
		Writer writer = null;
		BufferedWriter bw = null;
		try {
			reader = new FileReader(new File("crawler21.log"));
			writer = new FileWriter(new File("crawler21copy.log"));
			br = new BufferedReader(reader);
			bw = new BufferedWriter(writer);
			String lineText = null;
			while((lineText=br.readLine())!=null) {
				Pattern p = Pattern.compile("\\d{6}_\\d+_\\d+\\.htm访问失败，已重试次数：10，不再继续重试！");
				Matcher m = p.matcher(lineText);
				Set<String> result = new HashSet();
//				StringBuffer sb = new StringBuffer();
				while(m.find()) {
					//result.add(m.group());
//					sb.append(m.group());
					bw.write(m.group()+"\r\n");
					bw.flush();
				}
				/*for (String string : result) {
					System.out.println(string);
				}*/
//				System.out.println(sb);
			 }
			 
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(writer!=null) {
					writer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if(bw!=null) {
					bw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if(reader!=null) {
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if(br!=null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
