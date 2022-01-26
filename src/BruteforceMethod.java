// Notes untuk where_and_how :
// where_and_how adalah matriks 2D dengan isi:
// kolom pertama : posisi secara height (+ padding)
// kolom kedua : posisi secara width (+ padding)
// kolom ketiga : notasi apakah dia ditemukan dengan cara apa : 0 untuk north, 1 untuk northeast, dst sampai 7 untuk northwest. 8 jika tidak ditemukan.

public class BruteforceMethod {
    private static int total_comparison = 0;

    public static void all_methods (char[][] word_matrix, String[] answer_matrix, int[] len_summary) {
        int[][] where_and_how = new int[len_summary[2]][3];
        long start_time = System.nanoTime();
        for (int i = 0; i < answer_matrix.length; i++) {
            char[] char_keyword =  str_to_char_arr(answer_matrix[i]);
            if (!north_direction(word_matrix, char_keyword, len_summary, where_and_how, i)) {
                if (!northeast_direction(word_matrix, char_keyword, len_summary, where_and_how, i)) {
                    if (!east_direction(word_matrix, char_keyword, len_summary, where_and_how, i)) {
                        if (!southeast_direction(word_matrix, char_keyword, len_summary, where_and_how, i)) {
                            if (!south_direction(word_matrix, char_keyword, len_summary, where_and_how, i)) {
                                if (!southwest_direction(word_matrix, char_keyword, len_summary, where_and_how, i)) {
                                    if (!west_direction(word_matrix, char_keyword, len_summary, where_and_how, i)) {
                                        if (!northwest_direction(word_matrix, char_keyword, len_summary, where_and_how, i)) {
                                            System.out.println("Kata " + answer_matrix[i] + " tidak ditemukan di dalam matriks!");
                                            where_and_how[i][0] = -1;
                                            where_and_how[i][1] = -1;
                                            where_and_how[i][2] = 8;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        long end_time = System.nanoTime();
        System.out.println();
        printResults(word_matrix, answer_matrix, len_summary, where_and_how);
        System.out.println("\nElapsed Processing Time in microseconds : " + ((end_time - start_time) / Math.pow(10, 6)) + "\n");
        System.out.println("Total comparisons made to find all words : " + total_comparison);
    }

    public static char[] str_to_char_arr (String keyword) {
        char[] char_keyword = new char[keyword.length()];
        for (int i = 0; i < keyword.length(); i++) {
            char_keyword[i] = keyword.charAt(i);
        }
        return char_keyword;
    }

    public static boolean north_direction (char[][] word_matrix, char[] char_keyword, int[] len_summary, int[][] where_and_how, int idx) {
        boolean flag = false;
        check_north:
        for (int i = 1; i < len_summary[0]; i++) {
            for (int j = 1; j < len_summary[1]; j++) {
                total_comparison += 1;
                if (word_matrix[i][j] == char_keyword[0]) {
                    finish_check_north:
                    for (int k = 1; k < char_keyword.length; k++) {
                        total_comparison += 1;
                        if (word_matrix[i - k][j] != char_keyword[k]) {
                            flag = false;
                            break finish_check_north;
                        }
                        flag = true;
                        where_and_how[idx][0] = i - 1;
                        where_and_how[idx][1] = j - 1;
                        where_and_how[idx][2] = 0;
                    }
                }
                if (flag) {
                    String keyword = String.valueOf(char_keyword);
                    // System.out.println("Found " + keyword + " by checking north at (" + where_and_how[idx][0] + "," + where_and_how[idx][1] +")");
                    break check_north;
                }
            }
        }
        return flag;
    }

    public static boolean northeast_direction (char[][] word_matrix, char[] char_keyword, int[] len_summary, int[][] where_and_how, int idx) {
        boolean flag = false;
        check_northeast:
        for (int i = 1; i < len_summary[0] - 1; i++) {
            for (int j = 1; j < len_summary[1] - 1; j++) {
                total_comparison += 1;
                if (word_matrix[i][j] == char_keyword[0]) {
                    finish_check_northeast:
                    for (int k = 1; k < char_keyword.length; k++) {
                        total_comparison += 1;
                        if (word_matrix[i - k][j + k] != char_keyword[k]) {
                            flag = false;
                            break finish_check_northeast;
                        }
                        flag = true;
                        where_and_how[idx][0] = i - 1;
                        where_and_how[idx][1] = j - 1;
                        where_and_how[idx][2] = 1;
                    }
                }
                if (flag) {
                    String keyword = String.valueOf(char_keyword);
                    // System.out.println("Found " + keyword + " by checking northeast at (" + where_and_how[idx][0] + "," + where_and_how[idx][1] +")");
                    break check_northeast;
                }
            }
        }
        return flag;
    }
    
    public static boolean east_direction (char[][] word_matrix, char[] char_keyword, int[] len_summary, int[][] where_and_how, int idx) {
        boolean flag = false;
        check_east:
        for (int i = 1; i < len_summary[0] - 1; i++) {
            for (int j = 1; j < len_summary[1] - 1; j++) {
                total_comparison += 1;
                if (word_matrix[i][j] == char_keyword[0]) {
                    finish_check_east:
                    for (int k = 1; k < char_keyword.length; k++) {
                        total_comparison += 1;
                        if (word_matrix[i][j + k] != char_keyword[k]) {
                            flag = false;
                            break finish_check_east;
                        }
                        flag = true;
                        where_and_how[idx][0] = i - 1;
                        where_and_how[idx][1] = j - 1;
                        where_and_how[idx][2] = 2;
                    }
                }
                if (flag) {
                    String keyword = String.valueOf(char_keyword);
                    // System.out.println("Found " + keyword + " by checking east at (" + where_and_how[idx][0] + "," + where_and_how[idx][1] +")");
                    break check_east;
                }
            }
        }
        return flag;
    }

    public static boolean southeast_direction (char[][] word_matrix, char[] char_keyword, int[] len_summary, int[][] where_and_how, int idx) {
        boolean flag = false; 
        check_southeast:
        for (int i = 1; i < len_summary[0] - 1; i++) {
            for (int j = 1; j < len_summary[1] - 1; j++) {
                total_comparison += 1;
                if (word_matrix[i][j] == char_keyword[0]) {
                    finish_check_southeast:
                    for (int k = 1; k < char_keyword.length; k++) {
                        total_comparison += 1;
                        if (word_matrix[i + k][j + k] != char_keyword[k]) {
                            flag = false;
                            break finish_check_southeast;
                        }
                        flag = true;
                        where_and_how[idx][0] = i - 1;
                        where_and_how[idx][1] = j - 1;
                        where_and_how[idx][2] = 3;
                    }
                }
                if (flag) {
                    String keyword = String.valueOf(char_keyword);
                    // System.out.println("Found " + keyword + " by checking southeast at (" + where_and_how[idx][0] + "," + where_and_how[idx][1] +")");
                    break check_southeast;
                }
            }
        }
        return flag;
    }

    public static boolean south_direction (char[][] word_matrix, char[] char_keyword, int[] len_summary, int[][] where_and_how, int idx) {
        boolean flag = false;
        check_south:
        for (int i = 1; i < len_summary[0] - 1; i++) {
            for (int j = 1; j < len_summary[1] - 1; j++) {
                total_comparison += 1;
                if (word_matrix[i][j] == char_keyword[0]) {
                    finish_check_south:
                    for (int k = 1; k < char_keyword.length; k++) {
                        total_comparison += 1;
                        if (word_matrix[i + k][j] != char_keyword[k]) {
                            flag = false;
                            break finish_check_south;
                        }
                        flag = true;
                        where_and_how[idx][0] = i - 1;
                        where_and_how[idx][1] = j - 1;
                        where_and_how[idx][2] = 4;
                    }
                }
                if (flag) {
                    String keyword = String.valueOf(char_keyword);
                    // System.out.println("Found " + keyword + " by checking south at (" + where_and_how[idx][0] + "," + where_and_how[idx][1] +")");
                    break check_south;
                }
            }
        }
        return flag;
    }

    public static boolean southwest_direction (char[][] word_matrix, char[] char_keyword, int[] len_summary, int[][] where_and_how, int idx) {
        boolean flag = false;
        check_southwest:
        for (int i = 1; i < len_summary[0] - 1; i++) {
            for (int j = 1; j < len_summary[1] - 1; j++) {
                total_comparison += 1;
                if (word_matrix[i][j] == char_keyword[0]) {
                    finish_check_southwest:
                    for (int k = 1; k < char_keyword.length; k++) {
                        total_comparison += 1;
                        if (word_matrix[i + k][j - k] != char_keyword[k]) {
                            flag = false;
                            break finish_check_southwest;
                        }
                        flag = true;
                        where_and_how[idx][0] = i - 1;
                        where_and_how[idx][1] = j - 1;
                        where_and_how[idx][2] = 5;
                    }
                }
                if (flag) {
                    String keyword = String.valueOf(char_keyword);
                    // System.out.println("Found " + keyword + " by checking southwest at (" + where_and_how[idx][0] + "," + where_and_how[idx][1] +")");
                    break check_southwest;
                }
            }
        }
        return flag;
    }

    public static boolean west_direction (char[][] word_matrix, char[] char_keyword, int[] len_summary, int[][] where_and_how, int idx) {
        boolean flag = false;
        check_west:
        for (int i = 1; i < len_summary[0] - 1; i++) {
            for (int j = 1; j < len_summary[1] - 1; j++) {
                total_comparison += 1;
                if (word_matrix[i][j] == char_keyword[0]) {
                    finish_check_west:
                    for (int k = 1; k < char_keyword.length; k++) {
                        total_comparison += 1;
                        if (word_matrix[i][j - k] != char_keyword[k]) {
                            flag = false;
                            break finish_check_west;
                        }
                        flag = true;
                        where_and_how[idx][0] = i - 1;
                        where_and_how[idx][1] = j - 1;
                        where_and_how[idx][2] = 6;
                    }
                }
                if (flag) {
                    String keyword = String.valueOf(char_keyword);
                    // System.out.println("Found " + keyword + " by checking west at (" + where_and_how[idx][0] + "," + where_and_how[idx][1] +")");
                    break check_west;
                }
            }
        }
        return flag;
    }

    public static boolean northwest_direction (char[][] word_matrix, char[] char_keyword, int[] len_summary, int[][] where_and_how, int idx) {
        boolean flag = false;
        check_northwest:
        for (int i = 1; i < len_summary[0] - 1; i++) {
            for (int j = 1; j < len_summary[1] - 1; j++) {
                total_comparison += 1;
                if (word_matrix[i][j] == char_keyword[0]) {
                    finish_check_northwest:
                    for (int k = 1; k < char_keyword.length; k++) {
                        total_comparison += 1;
                        if (word_matrix[i - k][j - k] != char_keyword[k]) {
                            flag = false;
                            break finish_check_northwest;
                        }
                        flag = true;
                        where_and_how[idx][0] = i - 1;
                        where_and_how[idx][1] = j - 1;
                        where_and_how[idx][2] = 7;
                    }
                }
                if (flag) {
                    String keyword = String.valueOf(char_keyword);
                    // System.out.println("Found " + keyword + " by checking northwest at (" + where_and_how[idx][0] + "," + where_and_how[idx][1] +")");
                    break check_northwest;
                }
            }
        }
        return flag;
    }

    public static void printResults (char[][] word_matrix, String[] answer_matrix, int[] len_summary, int[][] where_and_how) {
        // Menghilangkan padding dari word_matriks untuk ditampilkan
        // System.out.println(word_matrix.length);
        // System.out.println(word_matrix[0].length);
        // for (int i = 0; i < where_and_how.length; i++) {
        //     System.out.println(where_and_how[i][0] + " " + where_and_how[i][1] + " " + where_and_how[i][2]);
        // }
        int starting_direction, starting_height, starting_width;
        char[] char_keyword;
        char[][] new_word_matrix = new char[len_summary[0] - 2][len_summary[1] - 2];
        for (int i = 0; i < len_summary[0] - 2; i++) {
            for (int j = 0; j < len_summary[1] - 2; j++) {
                new_word_matrix[i][j] = word_matrix[i + 1][j + 1];
            }
        }
        for (int i = 0; i < answer_matrix.length; i++) {
            char[][] results_matrix = new char[len_summary[0] - 2][len_summary[1] - 2];
            for (int j = 0; j < results_matrix.length; j++) {
                for (int k = 0; k < results_matrix[0].length; k++) {
                    results_matrix[j][k] = '-';
                }
            }
            starting_height = where_and_how[i][0];
            starting_width = where_and_how[i][1];
            starting_direction = where_and_how[i][2];
            char_keyword = str_to_char_arr(answer_matrix[i]);
            switch (starting_direction) {
                case 0:
                    for (int k = 0; k < char_keyword.length; k++) {
                        if (word_matrix[starting_height + 1][starting_width + 1] == char_keyword[k]) {
                            results_matrix[starting_height][starting_width] = word_matrix[starting_height + 1][starting_width + 1];
                            starting_height -= 1;
                        }
                    }
                    System.out.println("Found word " + answer_matrix[i] + " by checking north at : ");
                    System.out.println();
                    for (int l = 0; l < results_matrix.length; l++) {
                        for (int m = 0; m < results_matrix[0].length; m++) {
                            System.out.print(results_matrix[l][m]);
                        }
                        System.out.println();
                    }
                    System.out.println();
                    break;
                case 1:
                    for (int k = 0; k < char_keyword.length; k++) {
                        if (word_matrix[starting_height + 1][starting_width + 1] == char_keyword[k]) {
                            results_matrix[starting_height][starting_width] = word_matrix[starting_height + 1][starting_width + 1];
                            starting_height -= 1;
                            starting_width += 1;
                        }
                    }
                    System.out.println("Found word " + answer_matrix[i] + " by checking northeast at : ");
                    System.out.println();
                    for (int l = 0; l < results_matrix.length; l++) {
                        for (int m = 0; m < results_matrix[0].length; m++) {
                            System.out.print(results_matrix[l][m]);
                        }
                        System.out.println();
                    }
                    System.out.println();
                    break;
                case 2:
                    for (int k = 0; k < char_keyword.length; k++) {
                        if (word_matrix[starting_height + 1][starting_width + 1] == char_keyword[k]) {
                            results_matrix[starting_height][starting_width] = word_matrix[starting_height + 1][starting_width + 1];
                            starting_width += 1;
                        }
                    }
                    System.out.println("Found word " + answer_matrix[i] + " by checking east at : ");
                    System.out.println();
                    for (int l = 0; l < results_matrix.length; l++) {
                        for (int m = 0; m < results_matrix[0].length; m++) {
                            System.out.print(results_matrix[l][m]);
                        }
                        System.out.println();
                    }
                    System.out.println();
                    break;
                case 3:
                    for (int k = 0; k < char_keyword.length; k++) {
                        if (word_matrix[starting_height + 1][starting_width + 1] == char_keyword[k]) {
                            results_matrix[starting_height][starting_width] = word_matrix[starting_height + 1][starting_width + 1];
                            starting_height += 1;
                            starting_width += 1;
                        }
                    }
                    System.out.println("Found word " + answer_matrix[i] + " by checking southeast at : ");
                    System.out.println();
                    for (int l = 0; l < results_matrix.length; l++) {
                        for (int m = 0; m < results_matrix[0].length; m++) {
                            System.out.print(results_matrix[l][m]);
                        }
                        System.out.println();
                    }
                    System.out.println();
                    break;
                case 4:
                    for (int k = 0; k < char_keyword.length; k++) {
                        if (word_matrix[starting_height + 1][starting_width + 1] == char_keyword[k]) {
                            results_matrix[starting_height][starting_width] = word_matrix[starting_height + 1][starting_width + 1];
                            starting_height += 1;
                        }
                    }
                    System.out.println("Found word " + answer_matrix[i] + " by checking south at : ");
                    System.out.println();
                    for (int l = 0; l < results_matrix.length; l++) {
                        for (int m = 0; m < results_matrix[0].length; m++) {
                            System.out.print(results_matrix[l][m]);
                        }
                        System.out.println();
                    }
                    System.out.println();
                    break;
                case 5:
                    for (int k = 0; k < char_keyword.length; k++) {
                        if (word_matrix[starting_height + 1][starting_width + 1] == char_keyword[k]) {
                            results_matrix[starting_height][starting_width] = word_matrix[starting_height + 1][starting_width + 1];
                            starting_height += 1;
                            starting_width -= 1;
                        }
                    }
                    System.out.println("Found word " + answer_matrix[i] + " by checking southwest at :");
                    System.out.println();
                    for (int l = 0; l < results_matrix.length; l++) {
                        for (int m = 0; m < results_matrix[0].length; m++) {
                            System.out.print(results_matrix[l][m]);
                        }
                        System.out.println();
                    }
                    System.out.println();
                    break;
                case 6:
                    for (int k = 0; k < char_keyword.length; k++) {
                        if (word_matrix[starting_height + 1][starting_width + 1] == char_keyword[k]) {
                            results_matrix[starting_height][starting_width] = word_matrix[starting_height + 1][starting_width + 1];
                            starting_width -= 1;
                        }
                    }
                    System.out.println("Found word " + answer_matrix[i] + " by checking west at :");
                    System.out.println();
                    for (int l = 0; l < results_matrix.length; l++) {
                        for (int m = 0; m < results_matrix[0].length; m++) {
                            System.out.print(results_matrix[l][m]);
                        }
                        System.out.println();
                    }
                    System.out.println();
                    break;
                case 7:
                    for (int k = 0; k < char_keyword.length; k++) {
                        if (word_matrix[starting_height + 1][starting_width + 1] == char_keyword[k]) {
                            results_matrix[starting_height][starting_width] = word_matrix[starting_height + 1][starting_width + 1];
                            starting_height -= 1;
                            starting_width -= 1;
                        }
                    }
                    System.out.println("Found word " + answer_matrix[i] + " by checking northwest at :");
                    System.out.println();
                    for (int l = 0; l < results_matrix.length; l++) {
                        for (int m = 0; m < results_matrix[0].length; m++) {
                            System.out.print(results_matrix[l][m]);
                        }
                        System.out.println();
                    }
                    System.out.println();
                    break;
                case 8:
                    System.out.println("Word " + answer_matrix[i] + " is not found\n");
            }
        }
    }
}
