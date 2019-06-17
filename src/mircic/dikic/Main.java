package mircic.dikic;

import java.util.List;

import javax.swing.JOptionPane;

import org.curiousworks.lesson9.FileHelper;

public class Main {

	private static final CharacterDatabase characterDatabase = new CharacterDatabase();

	public static void main(String[] args) {

		/*
		 * first we are loading got_meta_text and than do appropriate splitting so that we
		 * get required attributes of each character. By going through each line of .txt
		 * file with a loop, we are adding characters to a map of characters.
		 */

		String metaData = FileHelper.loadMetaData();

		String[] rows = metaData.split(System.lineSeparator());

		for (int i = 1; i < rows.length; i++) {

			String[] data = rows[i].split(",");
			String name = data[0];
			String alleginace = data[1].trim();
			Character character = new Character(name, alleginace);
			characterDatabase.put(character);

			List<String> messageData = FileHelper.loadMessages(data[2].trim());
			for (int j = 1; j < messageData.size(); j++) {
				character.addMessage(messageData.get(j));
			}
		}

		// Task 2 - Print all Daenerys' messages. [20 points]

		Character daenerys = characterDatabase.get("Daenerys Stormborn");
		if (daenerys != null) {
			daenerys.printAllMessages();
		}

		// Task 3 - Create a pop up that displays the number of messages that each
		// character has sent. [20 points]

		showNumberOfMessages();

		// Task 4 - Verify that Tyrion has a positive disposition (is more happy than
		// sad). [20 points]

		tyrionDisposition();

		// Task 5 - Print the character who has the most positive and the most negative
		// disposition. [10 points]

		charDispositions();

		// Task 5 - Does Jon love Daenerys more than she loves him? [10 points]

		whoLovesWhoMore();

	}

	private static void showNumberOfMessages() {

		List<Character> allCharacters = characterDatabase.getAllCharacters();

		StringBuilder builder = new StringBuilder();

		for (Character character : allCharacters) {

			builder.append(character.getMessageCount());
			builder.append(System.lineSeparator());

		}

		JOptionPane.showMessageDialog(null, builder.toString());

	}

	private static void tyrionDisposition() {

		Character tyrion = characterDatabase.get("Tyrion Lannister");
		if (tyrion == null) {
			return;
		}

		int happy = tyrion.getHappyMessagesCount();
		int sad = tyrion.getSadMessageCount();

		if (happy > sad) {
			System.out.println("Tyrion has postive disposition.");
		} else if (happy == sad) {
			System.out.println("Tyrion is whatever.");
		} else {
			System.out.println("Tyrion has negative disposition");
		}
	}

	private static void charDispositions() {

		List<Character> allCharacters = characterDatabase.getAllCharacters();

		Character negative = null;
		Character positive = null;
		int maxNegativeDisposition = 0;
		int maxPositiveDisposition = 0;

		for (Character character : allCharacters) {

			int negativeDisposition = character.getSadMessageCount();
			int positiveDisposition = character.getHappyMessagesCount();

			if (negativeDisposition > maxNegativeDisposition) {

				maxNegativeDisposition = negativeDisposition;
				negative = character;
			}

			if (positiveDisposition > maxPositiveDisposition) {

				maxPositiveDisposition = positiveDisposition;
				positive = character;
			}

		}

		if (negative != null) {

			System.out.println("Character with most negative disposition is " + negative.getName() + ".");
		}

		if (positive != null) {

			System.out.println("Character with most positive disposition is " + positive.getName() + ".");
		}
	}

	private static void whoLovesWhoMore() {

		Character jon = characterDatabase.get("Jon Snow");
		Character dany = characterDatabase.get("Daenerys Stormborn");

		if (jon == null || dany == null) {
			return;
		}

		int jonToDany = jon.getLoveMessageCount(dany.getName());
		int danyToJon = dany.getLoveMessageCount(jon.getName());

		if (jonToDany > danyToJon) {
			System.out.println("Jon loves Dany more than she loves him.");
		} else if (jonToDany == danyToJon) {
			System.out.println("Jon and Dany love eachother equaly.");
		} else {
			System.out.println("Dany loves Jon more than he loves her.");
		}

	}

}
