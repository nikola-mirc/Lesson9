package org.curiousworks.lesson9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHelper {

	public static String loadMetaData() {
		StringBuffer reviews = new StringBuffer();
		File file = new File("resource/got_meta_data.txt");

		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String aLine;
			while ((aLine = br.readLine()) != null) {
				reviews.append(aLine);
				reviews.append(System.lineSeparator());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return reviews.toString();
	}

	public static List<String> loadMessages(String fileName) {
		List<String> messages = new ArrayList<String>();
		File file = new File("resource/message_logs/" + fileName);

		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String aLine;
			while ((aLine = br.readLine()) != null) {
				messages.add(aLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return messages;
	}


}
