/**
 * 
 */
package com.mabsisa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

/**
 * @author abhinab
 *
 */
public class BootLoader {

	public static void main(String[] args) throws InterruptedException {
		Properties prop = new Properties();
		InputStream inputStream = null;
		URL url;
		try {
			inputStream = new FileInputStream(System.getProperty("file.path"));
			prop.load(inputStream);
			String[] websites = prop.getProperty("sites").split(",");
			while (true) {
				for (int i = 0; i < websites.length; i++) {
					System.out.println("Initiate URL : " + websites[i]);
					try {
						url = new URL(websites[i]);
						url.openStream();
					} catch (Exception e) {
						e.printStackTrace();
					}
					System.out.println("Completed URL : " + websites[i]);
				}
				Thread.sleep(600000);
			}
		} catch (FileNotFoundException e) {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
