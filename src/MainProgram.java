import java.util.Scanner;
import java.io.*;

public class MainProgram {
    public static void main(String[] args) throws IOException {
        boolean file_nonexistant = true;
        char[][] word_matrix;
        String[] answer_matrix;
        int[] len_summary;
        try (Scanner readFile = new Scanner(System.in)) {
            while (file_nonexistant) {
                System.out.print("Insert your path to the textfile here (please watch the formatting) : ");
                String filename = readFile.next();
                File puzzlefile = new File("../test/" + filename);
                if (puzzlefile.exists()) {
                    // System.out.println("File exists\n");
                    file_nonexistant = false;
                    word_matrix = FileProcessor.read_words_matrix(puzzlefile);
                    answer_matrix = FileProcessor.read_answers_matrix(puzzlefile);
                    len_summary = FileProcessor.length_word_answers(puzzlefile);
                    BruteforceMethod.all_methods(word_matrix, answer_matrix, len_summary);
                } else {
                    System.out.println("File does not exists, try again!");
                }
            }
        }


    }
}
