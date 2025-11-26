package pj.myframe;

/**
 * MyFrame class containing utility methods for parsing JSON arrays.
 */
public class MyFrame {

    /**
     * Parses a simple textual representation of a JSON array containing integers.
     *
     * @param json a string representing a JSON array of integers, e.g., "[1, 2, 3]"
     * @return an int[] array representing the integers read from the JSON array
     * @throws NullPointerException if json is null
     * @throws NumberFormatException if any element cannot be parsed as an integer
     */
    private static int[] parseJsonIntArray(String json) {
        if (json == null) {
            throw new NullPointerException("Input json string cannot be null");
        }
        
        // Remove extra whitespace from the input string
        String content = json.trim();

        // Remove the opening square bracket from the beginning of the content, if present
        if (content.startsWith("[")) {
            content = content.substring(1);
        }

        // Remove the closing square bracket from the end of the content, if present
        if (content.endsWith("]")) {
            content = content.substring(0, content.length() - 1);
        }

        // Trim whitespace again from the beginning and end of the processed content
        content = content.trim();

        // Handle the case of an empty array
        if (content.isEmpty()) {
            return new int[0];
        }

        // Split the content into elements corresponding to subsequent numbers
        String[] parts = content.split(",");

        // Create a new int[] array with a length equal to the length of the parts array
        int[] result = new int[parts.length];

        // Convert each textual part into an integer and store it in the result array
        for (int i = 0; i < parts.length; i++) {
            result[i] = Integer.parseInt(parts[i].trim());
        }

        // Return the filled array of integers
        return result;
    }

    /**
     * Public method to parse a JSON integer array string.
     * This method exposes the private parseJsonIntArray for external use.
     *
     * @param json a string representing a JSON array of integers, e.g., "[1, 2, 3]"
     * @return an int[] array representing the integers read from the JSON array
     * @throws NullPointerException if json is null
     * @throws NumberFormatException if any element cannot be parsed as an integer
     */
    public static int[] parse(String json) {
        return parseJsonIntArray(json);
    }
}
