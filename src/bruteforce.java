package src;
public class bruteforce {
    public static void all_methods (char[][] word_matrix, String[] answer_matrix) {

    }

    public static char[] str_to_char_arr (String keyword) {
        char[] char_keyword = new char[keyword.length()];
        for (int i = 0; i < keyword.length(); i++) {
            char_keyword[i] = keyword.charAt(i);
        }
        return char_keyword;
    }

    public static void north_direction (char[][] word_matrix, char[] char_keyword, int[] len_summary) {
        boolean flag = false;
        for (int i = 1; i < len_summary[0] - 1; i++) {
            for (int j = 1; j < len_summary[1] - 1; j++) {
                int k = 0;
                while (k < char_keyword.length && flag) {

                }
            }
        }
    }

    public static void northeast_direction (char[][] word_matrix, char[] char_keyword) {
        
    }
    
    public static void east_direction (char[][] word_matrix, char[] char_keyword) {
        
    }

    public static void southeast_direction (char[][] word_matrix, char[] char_keyword) {
        
    }

    public static void south_direction (char[][] word_matrix, char[] char_keyword) {
        
    }

    public static void southwest_direction (char[][] word_matrix, char[] char_keyword) {
        
    }

    public static void west_direction (char[][] word_matrix, char[] char_keyword) {
        
    }

    public static void northwest_direction (char[][] word_matrix, char[] char_keyword) {
        
    }
}
