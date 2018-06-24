package com.company.project.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

	private MD5Util() {
		
	}
	
	public static String getMD5(String str){
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update( str.getBytes() );			// 一般对密码加密
			byte[] toChapter1Digest = md.digest();				// 16 个byte(8bit)
			StringBuffer sb = new StringBuffer();
			for(int i=0; i<toChapter1Digest.length; i++) {	
				Integer tmp = 0xff & toChapter1Digest[i];		// byte -> Integer(32bit)
				String hex = Integer.toHexString(tmp);			// Integer -> hex(前24bit为0,实为8bit)
				if(tmp<16)
					sb.append("0");
				sb.append(hex.toUpperCase());	
			}													// 16 * 2 * 0~9A~F(16进制数/4bit)
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String getMD5_salt(String str, String salt){
		return getMD5(str+salt);
	}
}
