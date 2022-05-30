package com.codewage;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;

public class ImageToBase64 {

	public static void main(String[] args) throws Exception {
		String imagePath = "C:\\Users\\Codewage\\OneDrive\\Desktop\\Pics\\Java.jpg";
		imageEncoder(imagePath);
	}

	public static void imageEncoder(String imagePath) throws IOException {

		/*
		 * Read the image passed as an input to the method
		 */
		FileInputStream stream = new FileInputStream(imagePath);


		/*
		 * Get the byte array from the image stream
		 */
		int bufLength = 2048;
		byte[] buffer = new byte[2048];
		byte[] data;

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		int readLength;
		while ((readLength = stream.read(buffer, 0, bufLength)) != -1) {
			out.write(buffer, 0, readLength);
		}

		data = out.toByteArray();

		/*
		 * Using the java.util.Base64 getEncoder method to get the Base64 String
		 */
		String imageString = Base64.getEncoder().withoutPadding().encodeToString(data);

		out.close();
		stream.close();

		/*
		 * Printing the Base64 String to console
		 */

		System.out.println("Encode Image Result : " + imageString);
	}
}


