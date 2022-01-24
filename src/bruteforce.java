package src;

// Notes untuk where_and_how :
// where_and_how adalah matriks 2D dengan isi:
// kolom pertama : posisi secara height (+ padding)
// kolom kedua : posisi secara width (+ padding)
// kolom ketiga : notasi apakah dia ditemukan dengan cara apa : 0 untuk north, 1 untuk northeast, dst sampai 7 untuk northwest

public class bruteforce {
    public static void all_methods (char[][] word_matrix, String[] answer_matrix, int[] len_summary) {
        int[][] where_and_how = new int[len_summary[2]][3];
        long start_time = System.currentTimeMillis();
        for (int i = 0; i < answer_matrix.length; i++) {
            char[] char_keyword =  str_to_char_arr(answer_matrix[i]);
            north_direction(word_matrix, char_keyword, len_summary, where_and_how, i);
            northeast_direction(word_matrix, char_keyword, len_summary, where_and_how, i);
            east_direction(word_matrix, char_keyword, len_summary, where_and_how, i);
            southeast_direction(word_matrix, char_keyword, len_summary, where_and_how, i);
            south_direction(word_matrix, char_keyword, len_summary, where_and_how, i);
            southwest_direction(word_matrix, char_keyword, len_summary, where_and_how, i);
            west_direction(word_matrix, char_keyword, len_summary, where_and_how, i);
            northwest_direction(word_matrix, char_keyword, len_summary, where_and_how, i);
        }
        long end_time = System.currentTimeMillis();
        System.out.println("Elapsed Processing Time in miliseconds : " + (end_time - start_time));
    }

    public static char[] str_to_char_arr (String keyword) {
        char[] char_keyword = new char[keyword.length()];
        for (int i = 0; i < keyword.length(); i++) {
            char_keyword[i] = keyword.charAt(i);
        }
        return char_keyword;
    }

    public static void north_direction (char[][] word_matrix, char[] char_keyword, int[] len_summary, int[][] where_and_how, int idx) {
        boolean flag = false;
        check_north:
        for (int i = 1; i < len_summary[0]; i++) {
            for (int j = 1; j < len_summary[1]; j++) {
                if (word_matrix[i][j] == char_keyword[0]) {
                    finish_check_north:
                    for (int k = 1; k < char_keyword.length; k++) {
                        if (word_matrix[i - k][j] != char_keyword[k]) {
                            flag = false;
                            break finish_check_north;
                        }
                        flag = true;
                        where_and_how[idx][0] = i;
                        where_and_how[idx][1] = j;
                        where_and_how[idx][2] = 0;
                    }
                }
                if (flag) {
                    String keyword = String.valueOf(char_keyword);
                    System.out.println("Found " + keyword + " by checking north at (" + where_and_how[idx][0] + "," + where_and_how[idx][1] +")");
                    break check_north;
                }
            }
        }
    }

    public static void northeast_direction (char[][] word_matrix, char[] char_keyword, int[] len_summary, int[][] where_and_how, int idx) {
        boolean flag = false;
        check_northeast:
        for (int i = 1; i < len_summary[0] - 1; i++) {
            for (int j = 1; j < len_summary[1] - 1; j++) {
                if (word_matrix[i][j] == char_keyword[0]) {
                    finish_check_northeast:
                    for (int k = 1; k < char_keyword.length; k++) {
                        if (word_matrix[i - k][j + k] != char_keyword[k]) {
                            flag = false;
                            break finish_check_northeast;
                        }
                        flag = true;
                        where_and_how[idx][0] = i;
                        where_and_how[idx][1] = j;
                        where_and_how[idx][2] = 1;
                    }
                }
                if (flag) {
                    String keyword = String.valueOf(char_keyword);
                    System.out.println("Found " + keyword + " by checking northeast at (" + where_and_how[idx][0] + "," + where_and_how[idx][1] +")");
                    break check_northeast;
                }
            }
        }
    }
    
    public static void east_direction (char[][] word_matrix, char[] char_keyword, int[] len_summary, int[][] where_and_how, int idx) {
        boolean flag = false;
        check_east:
        for (int i = 1; i < len_summary[0] - 1; i++) {
            for (int j = 1; j < len_summary[1] - 1; j++) {
                if (word_matrix[i][j] == char_keyword[0]) {
                    finish_check_east:
                    for (int k = 1; k < char_keyword.length; k++) {
                        if (word_matrix[i][j + k] != char_keyword[k]) {
                            flag = false;
                            break finish_check_east;
                        }
                        flag = true;
                        where_and_how[idx][0] = i;
                        where_and_how[idx][1] = j;
                        where_and_how[idx][2] = 2;
                    }
                }
                if (flag) {
                    String keyword = String.valueOf(char_keyword);
                    System.out.println("Found " + keyword + " by checking east at (" + where_and_how[idx][0] + "," + where_and_how[idx][1] +")");
                    break check_east;
                }
            }
        }
    }

    public static void southeast_direction (char[][] word_matrix, char[] char_keyword, int[] len_summary, int[][] where_and_how, int idx) {
        boolean flag = false; 
        check_southeast:
        for (int i = 1; i < len_summary[0] - 1; i++) {
            for (int j = 1; j < len_summary[1] - 1; j++) {
                if (word_matrix[i][j] == char_keyword[0]) {
                    finish_check_southeast:
                    for (int k = 1; k < char_keyword.length; k++) {
                        if (word_matrix[i + k][j + k] != char_keyword[k]) {
                            flag = false;
                            break finish_check_southeast;
                        }
                        flag = true;
                        where_and_how[idx][0] = i;
                        where_and_how[idx][1] = j;
                        where_and_how[idx][2] = 3;
                    }
                }
                if (flag) {
                    String keyword = String.valueOf(char_keyword);
                    System.out.println("Found " + keyword + " by checking southeast at (" + where_and_how[idx][0] + "," + where_and_how[idx][1] +")");
                    break check_southeast;
                }
            }
        }
    }

    public static void south_direction (char[][] word_matrix, char[] char_keyword, int[] len_summary, int[][] where_and_how, int idx) {
        boolean flag = false;
        check_south:
        for (int i = 1; i < len_summary[0] - 1; i++) {
            for (int j = 1; j < len_summary[1] - 1; j++) {
                if (word_matrix[i][j] == char_keyword[0]) {
                    finish_check_south:
                    for (int k = 1; k < char_keyword.length; k++) {
                        if (word_matrix[i + k][j] != char_keyword[k]) {
                            flag = false;
                            break finish_check_south;
                        }
                        flag = true;
                        where_and_how[idx][0] = i;
                        where_and_how[idx][1] = j;
                        where_and_how[idx][2] = 4;
                    }
                }
                if (flag) {
                    String keyword = String.valueOf(char_keyword);
                    System.out.println("Found " + keyword + " by checking south at (" + where_and_how[idx][0] + "," + where_and_how[idx][1] +")");
                    break check_south;
                }
            }
        }
    }

    public static void southwest_direction (char[][] word_matrix, char[] char_keyword, int[] len_summary, int[][] where_and_how, int idx) {
        boolean flag = false;
        check_southwest:
        for (int i = 1; i < len_summary[0] - 1; i++) {
            for (int j = 1; j < len_summary[1] - 1; j++) {
                if (word_matrix[i][j] == char_keyword[0]) {
                    finish_check_southwest:
                    for (int k = 1; k < char_keyword.length; k++) {
                        if (word_matrix[i + k][j - k] != char_keyword[k]) {
                            flag = false;
                            break finish_check_southwest;
                        }
                        flag = true;
                        where_and_how[idx][0] = i;
                        where_and_how[idx][1] = j;
                        where_and_how[idx][2] = 5;
                    }
                }
                if (flag) {
                    String keyword = String.valueOf(char_keyword);
                    System.out.println("Found " + keyword + " by checking southwest at (" + where_and_how[idx][0] + "," + where_and_how[idx][1] +")");
                    break check_southwest;
                }
            }
        }
    }

    public static void west_direction (char[][] word_matrix, char[] char_keyword, int[] len_summary, int[][] where_and_how, int idx) {
        boolean flag = false;
        check_west:
        for (int i = 1; i < len_summary[0] - 1; i++) {
            for (int j = 1; j < len_summary[1] - 1; j++) {
                if (word_matrix[i][j] == char_keyword[0]) {
                    finish_check_west:
                    for (int k = 1; k < char_keyword.length; k++) {
                        if (word_matrix[i][j - k] != char_keyword[k]) {
                            flag = false;
                            break finish_check_west;
                        }
                        flag = true;
                        where_and_how[idx][0] = i;
                        where_and_how[idx][1] = j;
                        where_and_how[idx][2] = 6;
                    }
                }
                if (flag) {
                    String keyword = String.valueOf(char_keyword);
                    System.out.println("Found " + keyword + " by checking west at (" + where_and_how[idx][0] + "," + where_and_how[idx][1] +")");
                    break check_west;
                }
            }
        }
    }

    public static void northwest_direction (char[][] word_matrix, char[] char_keyword, int[] len_summary, int[][] where_and_how, int idx) {
        boolean flag = false;
        check_northwest:
        for (int i = 1; i < len_summary[0] - 1; i++) {
            for (int j = 1; j < len_summary[1] - 1; j++) {
                if (word_matrix[i][j] == char_keyword[0]) {
                    finish_check_northwest:
                    for (int k = 1; k < char_keyword.length; k++) {
                        if (word_matrix[i - k][j - k] != char_keyword[k]) {
                            flag = false;
                            break finish_check_northwest;
                        }
                        flag = true;
                        where_and_how[idx][0] = i;
                        where_and_how[idx][1] = j;
                        where_and_how[idx][2] = 1;
                    }
                }
                if (flag) {
                    String keyword = String.valueOf(char_keyword);
                    System.out.println("Found " + keyword + " by checking northwest at (" + where_and_how[idx][0] + "," + where_and_how[idx][1] +")");
                    break check_northwest;
                }
            }
        }
    }

    public static void printResults (char[][] word_matrix, char[] char_keyword, int[] len_summary, int[][] where_and_how) {

    }
}
