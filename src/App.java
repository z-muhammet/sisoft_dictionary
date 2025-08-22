import java.nio.charset.StandardCharsets; // BEGIN: Import for charset
import java.util.List;
import java.util.Locale; // BEGIN: Import for Locale
import java.util.Comparator; // BEGIN: Import for Comparator

public class App {

    public static void main(String[] args) throws Exception {
        System.setOut(new java.io.PrintStream(System.out, true, StandardCharsets.UTF_8)); // BEGIN: Set console output
                                                                                          // to UTF-8
        FileProcess fileProcess = new FileProcess();
        StringProcess stringProcess = new StringProcess();
        String fileName = "sozluk";

        List<String> result1 = stringProcess.search(
                stringProcess.buildTree(fileProcess.readFile(fileProcess.findFileByName(fileName))),
                "botch".toLowerCase(Locale.ENGLISH));

        result1.sort(Comparator.comparingInt(String::length));
        if (result1 != null && !result1.isEmpty()) {
            System.out.println("Arama sonuçları:");
            for (String word : result1) {
                System.out.println(word);
            }
        } else {
            System.out.println("Arama sonuç bulunamadı.");
        }
    }
}
