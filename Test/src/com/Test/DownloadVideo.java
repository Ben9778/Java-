package com.Test;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadVideo {
	private static String videoUrl = "http://vt1.doubanio.com/201904172205/6db4e789a83a0999817fdbaf86d33fa5/view/movie/M/402370731.mp4";
	private static final int MAX_BUFFER_SIZE = 1000000;

	// ������
	public static void main(String[] args) {
		HttpURLConnection connection = null;
		InputStream inputStream = null;
		RandomAccessFile randomAccessFile = null;
		try {
			// 1.��ȡ���Ӷ���
			URL url = new URL(videoUrl);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestProperty("Range", "bytes=0-");
			connection.connect();
			if (connection.getResponseCode() / 100 != 2) {
				System.out.println("����ʧ��...");
				return;
			}
			// 2.��ȡ���Ӷ������
			inputStream = connection.getInputStream();
			// �����صĴ�С
			int downloaded = 0;
			// ���ļ��Ĵ�С
			int fileSize = connection.getContentLength();
			String fileName = url.getFile();
			fileName = fileName.substring(fileName.lastIndexOf("/") + 1);
			// 3.����Դд���ļ�
			randomAccessFile = new RandomAccessFile(fileName, "rw");
			while (downloaded < fileSize) {
				// 3.1���û������Ĵ�С
				byte[] buffer = null;
				if (fileSize - downloaded >= MAX_BUFFER_SIZE) {
					buffer = new byte[MAX_BUFFER_SIZE];
				} else {
					buffer = new byte[fileSize - downloaded];
				}
				// 3.2��ÿһ�λ��������д���ļ�
				int read = -1;
				int currentDownload = 0;
				long startTime = System.currentTimeMillis();
				while (currentDownload < buffer.length) {
					read = inputStream.read();
					buffer[currentDownload++] = (byte) read;
				}
				long endTime = System.currentTimeMillis();
				double speed = 0.0;
				if (endTime - startTime > 0) {
					speed = currentDownload / 1024.0 / ((double) (endTime - startTime) / 1000);
				}
				randomAccessFile.write(buffer);
				downloaded += currentDownload;
				randomAccessFile.seek(downloaded);
				System.out.printf("�����˽���:%.2f%%,�����ٶȣ�%.1fkb/s(%.1fM/s)%n", downloaded * 1.0 / fileSize * 10000 / 100,
						speed, speed / 1000);
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.disconnect();
				inputStream.close();
				randomAccessFile.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static void demo() {
		try {
			URL url = new URL(videoUrl);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
