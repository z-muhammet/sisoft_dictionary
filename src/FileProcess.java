import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class FileProcess {

  public File findFileByName(String fileName) {
    File directory = new File("src/data/");
    File[] files = directory.listFiles((dir, name) -> name.toLowerCase().equals(fileName.toLowerCase() + ".txt"));

    if (files == null || files.length == 0) {
      directory = new File("data/");
      files = directory.listFiles((dir, name) -> name.toLowerCase().equals(fileName.toLowerCase() + ".txt"));
    }

    try {
      // Eğer birden fazla dosaa varsa ilkini döndür
      if (files != null && files.length > 0) {
        return files[0];
      } else {
        System.out.println("Dosya bulunamadı: " + fileName + ".txt");
        return null;
      }
    } catch (Exception e) {
      System.out.println("Dosya arama sırasında bir hata oluştu: " + e.getMessage());
    }
    return null;
  }

  public List<String> readFile(File file) {
    List<String> lines = new ArrayList<>();

    if (file != null) {
      try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        String line;
        while ((line = br.readLine()) != null) {
          if (!line.trim().isEmpty()) { // Boş satırları kontrol et
            lines.add(line.toLowerCase(Locale.ENGLISH));
          }
        }
        if (lines.isEmpty()) {
          System.out.println("Dosya içi boş.");
          return null;
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    } else {
      System.out.println("Dosya bulunamadı.");
    }

    return lines;
  }

}
