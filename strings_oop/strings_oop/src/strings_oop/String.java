package strings_oop;

import java.util.Arrays;

/**
 * Each instance of this class represents a sequence of text characters.
 * 
 * @invar | toCharArray() != null
 * @invar | length() == toCharArray().length
 * 
 * @immutable
 */

public class String {
	
	
	/**
	 * We need that to store all our data
	 * Helper object (auxiliary object) helps to store the data
	 * 
	 * @representationObject
     */
	private char[] characters;
	
	
	/**
	 * @inspects | this
	 * @creates | result
	 * 
	 */
	public char[] toCharArray() {
		return this.characters.clone();
	}
	
	/**
	 * @inspects | this
	 * 
	 */
	public int length() {
        return characters.length;
    }
	
	/**
	 * @pre | 0 <= index && index < length()
	 * 
	 * 
	 * @post | result == toCharArray()[index]
	 * 
	 */
	public char charAt(int index) {
		return characters[index];
	}
	
	
	/**
	 * @pre | characters != null
	 * 
	 * @inspects | characters
	 * 
	 * @post | Arrays.equals(toCharArray(), characters)
	 */
	public String(char[] characters) {
		this.characters = characters.clone();
	}

}
