package src;

import java.util.*;
import java.io.*;

public class file_processor {
    public static char[][] read_words_matrix(File src_file) throws IOException, FileNotFoundException {
        // Buat dan Modifikasi Matriks (+ Padding untuk Cek Out-of-Bounds)
        char[][] word_matrix = new char[38][36];
        for (int i = 0; i < 38; i++) {
            for (int j = 0; j < 36; j++) {
                if (i == 0 || i == 37 || j == 0 || j == 35) {
                    word_matrix[i][j] = '#';
                } else {
                    word_matrix[i][j] = '@';
                }
            }
        }
        
        try (BufferedReader br = new BufferedReader(new FileReader(src_file))) {
            int i = 1;
            String line;
            while ((line = br.readLine()) != "" && i < 37) {
                int j = 1;
                StringTokenizer tokens = new StringTokenizer(line," ");
                if (tokens.countTokens() == 0) {
                    break;
                } else {
                    while (tokens.hasMoreTokens() && j < 35) {
                        word_matrix[i][j] = tokens.nextToken().charAt(0);
                        j += 1;
                    }
                    i += 1;
                }
            }
        }

        for (int i = 0; i < 38; i++) {
            for (int j = 0; j < 36; j++) {
                if (word_matrix[i][j] == '@') {
                    word_matrix[i][j] = '#';
                }
            }
        }
        int eff_width = 1;
        int eff_height = 1;
        int edge_warning_width = 0;
        for (int i = 1; i < 38; i++) {
            if (word_matrix[i][1] == '#') {
                eff_height += 1;
                break;
            } else {
                for (int j = 0; j < 36; j++) {
                    if (word_matrix[i][j] == '#' && edge_warning_width == 1) {
                        break;
                    } else if (word_matrix[i][j] == '#' && edge_warning_width == 0) {
                        edge_warning_width += 1;
                        eff_width += 1;
                    } else {
                        eff_width += 1;
                    }
                }
                eff_height += 1;
            }
        }
        char[][] word_matrix_final = new char[eff_height][eff_width];
        for (int i = 0; i < eff_height; i++) {
            for (int j = 0; j < eff_width; j++) {
                word_matrix_final[i][j] = word_matrix[i][j];
                // System.out.print(word_matrix_final[i][j]);
            }
            // System.out.println();
        }
        return word_matrix_final;
    }

    public static String[] read_answers_matrix(File src_file) throws IOException, FileNotFoundException{
        String[] temp_answers = new String[100];
        try (BufferedReader br = new BufferedReader(new FileReader(src_file))) {
            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer tokens = new StringTokenizer(line," ");
                if (tokens.countTokens() == 0) {
                    break;
                }
            }
            int i = 0;
            while ((line = br.readLine()) != null && i < 100) {
                temp_answers[i] = line;
                i += 1;
            }
        }
        int eff_len = 0;
        for (int i = 0; i < 100; i++) {
            if (temp_answers[i] == "" || temp_answers[i] == null) {
                break;
            } else {
                eff_len += 1;
            }
        }
        String[] answers = new String[eff_len];
        for (int i = 0; i < eff_len; i++) {
            answers[i] = temp_answers[i];
        }
        return answers;
    }

    public static int[] length_word_answers(File src_file) throws IOException, FileNotFoundException {
        // urutannya word_matrix_length, word_matrix_width, answers_length
        char[][] word_matrix = read_words_matrix(src_file);
        String[] answers_matrix = read_answers_matrix(src_file);
        int[] length_summary = new int[3];
        length_summary[1] = word_matrix[0].length;
        length_summary[0] = word_matrix.length;
        length_summary[2] = answers_matrix.length;
        System.out.println("Word Matrix Height : " + length_summary[0]);
        System.out.println("Word Matrix Width : " + length_summary[1]);
        System.out.println("Answers Matrix Length : " + length_summary[2]);
        return length_summary;
    }
}
