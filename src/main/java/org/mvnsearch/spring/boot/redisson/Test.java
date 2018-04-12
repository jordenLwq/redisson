package org.mvnsearch.spring.boot.redisson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Test {
	
	
	
	public static void main(String[] args) {
		
//		data:image/jpeg;base64,
//		StringBuffer sBuffer= readFileByLines("C://Users//HP//Desktop//4830022018011610004820.txt");
		StringBuffer sBuffer= readFileByLines("C://Users//HP//Desktop//4830022018031300005135_01.txt");
		String temp=sBuffer.toString();
		System.out.println(temp);
//		String strTo16= strTo16(temp);
//		System.out.println(strTo16);
//		System.err.println("data:image/png;base64,/"+temp);
		
//		String hexStringToString= hexStringToString(temp);
//		System.out.println(hexStringToString);
		
	}
	
	

	
	/**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     */
    public  static StringBuffer  readFileByLines(String fileName) {
        File file = new File(fileName);
        StringBuffer sBuffer=new StringBuffer();
        		
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
//                System.out.println("line " + line + ": " + tempString);
//                line++;
            	sBuffer.append(tempString);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        
        return sBuffer;
    }
    
    
    /**
     * 字符串转化成为16进制字符串
     * @param s
     * @return
     */
    public static String strTo16(String s) {
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            int ch = (int) s.charAt(i);
            String s4 = Integer.toHexString(ch);
            str = str + s4;
        }
        return str;
    }

    
    /**
     * 16进制转换成为string类型字符串
     * @param s
     * @return
     */
    public static String hexStringToString(String s) {
        if (s == null || s.equals("")) {
            return null;
        }
        s = s.replace(" ", "");
        byte[] baKeyword = new byte[s.length() / 2];
        for (int i = 0; i < baKeyword.length; i++) {
            try {
                baKeyword[i] = (byte) (0xff & Integer.parseInt(s.substring(i * 2, i * 2 + 2), 16));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            s = new String(baKeyword, "UTF-8");
            new String();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return s;
    }
}
