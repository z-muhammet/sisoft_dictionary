import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Comparator;
import java.util.Scanner;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class App {

    @SuppressWarnings("resource")
    public static void main(String[] args) throws Exception {
        System.setOut(new java.io.PrintStream(System.out, true, StandardCharsets.UTF_8)); // utf8 destegi
        FileProcess fileProcess = new FileProcess();
        TreeProcess TreeProcess = new TreeProcess();
        List<String> matchWords = null;
        Scanner scanner = new java.util.Scanner(System.in);
        if (args.length == 0) {
            System.out.println("Kullanım: java App sozluk_dosyasi_adi");
            return;
        } else {
            String fileName = args[0].toLowerCase(Locale.ENGLISH);
            File file = fileProcess.findFileByName(fileName);
            if (file == null)
                return;

            List<String> allWords = fileProcess.readFile(file);
            if (allWords == null)
                return;

            Map<Character, Object> tree = TreeProcess.buildTree(allWords);
            if (tree == null || tree.isEmpty())
                return;

            while (true) {
                System.out.println("Bir Kelime Yazıp Enter Tuşuna Basınız:");
                String input = scanner.nextLine().toLowerCase(Locale.ENGLISH).trim();
                if (input.isEmpty()) {
                    System.out.println("Çıkılıyor...");
                    break;
                }

                matchWords = TreeProcess.search(tree, input);
                matchWords.sort(Comparator.comparingInt(String::length));

                if (tree != null && !tree.isEmpty()) {
                    System.out.println("Olası Kelimeler");
                    for (String word : matchWords) {
                        System.out.println(word.toUpperCase(Locale.ENGLISH));
                    }
                } else {
                    System.out.println("Arama sonuç bulunamadı. veya liste boş.");
                }
            }
            if (scanner != null) {
                scanner.close(); // Scanner kapatılıyor
            }
        }
    }
}
