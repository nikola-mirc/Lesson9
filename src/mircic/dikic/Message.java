package mircic.dikic;

public class Message {

	private final String sentTo;
	private final String text;

	public Message(String sentTo, String text) {
		this.sentTo = sentTo;
		this.text = text;
	}

	public boolean isHappyMessage() {
		return MessageUtils.containsHappy(text);
	}

	public boolean isSadMessage() {
		return MessageUtils.containsSad(text);
	}

	public boolean isLoveMessage() {
		return MessageUtils.containsLove(text);
	}

	public String gotSentTo() {
		return sentTo;
	}

	@Override
	public String toString() {
		return "To " + sentTo + " - " + text;
	}
}
