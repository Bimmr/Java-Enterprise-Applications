package prog3060.assignment2;

public class Utils {
	
	/**
	 * Check if the string is not null, and if it is not empty
	 * @param string the string in question
	 * @return if it is a valid string
	 */
	public static boolean isValid(String string) {
		return string != null && string.length() != 0;
	}

}
