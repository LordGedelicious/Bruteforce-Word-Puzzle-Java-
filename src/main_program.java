package src;

import java.util.Scanner;
import java.io.*;

public class main_program {
    public static void main(String[] args) throws IOException {
        boolean file_nonexistant = true;
        char[][] word_matrix;
        String[] answer_matrix;
        int[] len_summary;
        try (Scanner readFile = new Scanner(System.in)) {
            while (file_nonexistant) {
                System.out.print("Insert your path to the textfile here (please watch the formatting) : ");
                String filename = readFile.next();
                String filepath = "C:\\Users\\Gede Prasidha\\Documents\\Kuliah Semester 4\\Startegi Algoritma\\Bruteforce-Word-Puzzle-Java-\\testfile\\";
                filepath += filename;
                File puzzlefile = new File(filepath);
                if (puzzlefile.exists()) {
                    System.out.println("File exists");
                    file_nonexistant = false;
                    word_matrix = file_processor.read_words_matrix(puzzlefile);
                    answer_matrix = file_processor.read_answers_matrix(puzzlefile);
                    len_summary = file_processor.length_word_answers(puzzlefile);
                    bruteforce.all_methods(word_matrix, answer_matrix, len_summary);
                } else {
                    System.out.println("File does not exists, try again!");
                }
            }
        }


    }
}
