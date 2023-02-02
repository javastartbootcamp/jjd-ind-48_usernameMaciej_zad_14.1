import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            List<Integer> numbers = Main.readFile("liczby.txt");
            System.out.println(numbers);
            Map<Integer, Integer> occurrences = findOccurrences(numbers, "liczby.txt");
            System.out.println(occurrences);
        } catch (FileNotFoundException e) {
            System.err.println("Nie udało się odczytać pliku.");
        }

    }

    private static Map<Integer, Integer> findOccurrences(List<Integer> numbers, String fileName) throws FileNotFoundException {
        Map<Integer, Integer> occurrences = new HashMap<>();
        Scanner scanner = new Scanner(new File(fileName));
        int number = 0;
        while (scanner.hasNextLine()) {
            int line = Integer.parseInt(scanner.nextLine());
            if (numbers.contains(line)) {
                number++;
                occurrences.put(line, number);
            }
        }
        return occurrences;
    }

    private static List<Integer> readFile(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        List<Integer> numbers = new ArrayList<>();
        while (scanner.hasNextLine()) {
            int number = scanner.nextInt();
            numbers.add(number);
        }
        scanner.close();
        return numbers;
    }
}
