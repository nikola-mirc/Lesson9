package mircic.dikic;

import java.util.ArrayList;
import java.util.List;

/* note
 * 
 *  Project took a lot of time, trials and errors, and googling. 
 *  At some point we scrapped first version and then had to re-do everything (we weren't reading resources 
 *  from got_meta_data.txt in the first version of the project.)
 *  Along the way we learned some new stuff and got more familiar with the old stuff.
 *  
 *  Project was very challenging but also very entertaining.
 *  Thanks
 */

public class Character {

	private final String name;
	private final String allegiance;
	private final List<Message> messages;

	public Character(String name, String allegiance) {
		this.name = name;
		this.allegiance = allegiance;
		messages = new ArrayList<Message>();
	}

	public String getName() {
		return name;
	}

	public String getAllegiance() {
		return allegiance;
	}

	/*
	 * method for adding messages. Each line of text consists of two parts (as can
	 * be seen in Message class): name of receiving character and message text.
	 * since every line has same formating we are using substring to split 1 and 2.
	 */

	public void addMessage(String messageDetails) {

		if (messageDetails.isBlank()) {
			return;
		}
		int separate = messageDetails.indexOf(",");
		String sentTo = messageDetails.substring(0, separate);
		String messageText = messageDetails.substring(separate + 2, messageDetails.length());
		messages.add(new Message(sentTo, messageText));
	}

	/*
	 * method for printing all messages of individual character, by going through
	 * the list with a loop.
	 */

	public void printAllMessages() {
		System.out.println(name + "'s messages:");
		for (Message message : messages) {
			System.out.println(message);
		}
	}

	// method for counting total messages sent by an individual character.

	public String getMessageCount() {
		return name + "'s total messages: " + messages.size();
	}

	/*
	 * by using methods from MessageUtils class we go through each line of text of
	 * an individual character, checking if the list contains selected emoticons, so
	 * that we can make required comparisons later on.
	 */

	public int getHappyMessagesCount() {

		int count = 0;
		for (Message message : messages) {
			if (message.isHappyMessage()) {
				count++;
			}
		}
		return count;
	}

	public int getSadMessageCount() {

		int count = 0;
		for (Message message : messages) {
			if (message.isSadMessage()) {
				count++;
			}
		}
		return count;
	}

	public int getLoveMessageCount(String sentTo) {
		int count = 0;
		for (Message message : messages) {
			if (message.gotSentTo().contentEquals(sentTo) && message.isLoveMessage()) {
				count++;
			}
		}
		return count;
	}

}
