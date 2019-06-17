package mircic.dikic;

import java.util.ArrayList;
import java.util.List;

public class MessageUtils {

	private static final List<String> happyEmoticons;
	private static final List<String> sadEmoticons;
	private static final List<String> loveEmoticons;

	static {
		happyEmoticons = new ArrayList<String>();
		happyEmoticons.add("😄");
		happyEmoticons.add("🙂");
		happyEmoticons.add("😊");
		happyEmoticons.add("😍");
		sadEmoticons = new ArrayList<String>();
		sadEmoticons.add("😢");
		sadEmoticons.add("😭");
		sadEmoticons.add("😞");
		sadEmoticons.add("👿");
		loveEmoticons = new ArrayList<String>();
		loveEmoticons.add("😍");
		loveEmoticons.add("😘");
	}

	public static final boolean containsHappy(String text) {
		for (String happy : happyEmoticons) {
			if (text.contains(happy)) {
				return true;
			}
		}

		return false;
	}

	public static final boolean containsSad(String text) {
		for (String sad : sadEmoticons) {
			if (text.contains(sad)) {
				return true;
			}
		}

		return false;
	}

	public static final boolean containsLove(String text) {
		for (String love : loveEmoticons) {
			if (text.contains(love)) {
				return true;
			}
		}

		return false;
	}

}
