package fun.seleniumtesting.stackoverflow.util;

/**
 * Created by James on 11/3/14.
 * Basic String Utilities
 */
public abstract class Strings {

    private static final String CAPS_CASE_REGEX = "([A-Z][A-Z0-9]*_)+[A-Z0-9]+";

    public static String toTitleCase(String stringToTransform) {
        if(stringToTransform == null) {
            return null;
        }
        String[] words = splitIntoWords(stringToTransform);
        String transformedString = "";
        for(String word : words) {
            transformedString += capitalizeFirstCharacterAndMakeOthersLowercase(word) + " ";
        }
        return transformedString.trim();
    }

    public static String capitalizeFirstCharacterAndMakeOthersLowercase(String stringToCapitalize) {
        return stringToCapitalize.substring(0,1).toUpperCase() + stringToCapitalize.substring(1).toLowerCase();
    }

    public static String[] splitIntoWords(String stringToSplit) {
        if(stringToSplit.matches(CAPS_CASE_REGEX)) {
            return stringToSplit.split("_");
        } else {
            return new String[]{stringToSplit};
        }
    }

    public static int toInt(String intString) {
        if(intString == null) {
            throw new NullPointerException("The argument 'intString' in Strings.toInt() cannot be null.");
        }
        return Integer.parseInt(intString.replaceAll(",", ""));
    }
}
