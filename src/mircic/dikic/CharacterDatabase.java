package mircic.dikic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CharacterDatabase {

	private final Map<String, Character> characters;

	public CharacterDatabase() {
		characters = new HashMap<String, Character>();
	}

	public void put(Character character) {
		characters.put(character.getName(), character);
	}

	public Character get(String name) {
		return characters.get(name);
	}

	public List<Character> getAllCharacters() {
		return new ArrayList<Character>(characters.values());
	}

}
