import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class StringProcess {

  @SuppressWarnings("unchecked")
  public Map<Character, Object> buildTree(List<String> allWords) {
    int i = 0;
    Map<Character, Object> root = new HashMap<>();
    if (allWords == null || allWords.isEmpty()) {
      System.out.println("kelime bulunamadi veya boş liste verildi.");
      return null;
    }

    for (String word : allWords) {
      i++;
      Map<Character, Object> currentMap = root;
      for (char c : word.toCharArray()) {
        if (!currentMap.containsKey(c)) {
          currentMap.put(c, new HashMap<Character, Object>());
        }
        currentMap = (Map<Character, Object>) currentMap.get(c);
      }
      currentMap.put('*', null);
      if (i % 5000 == 0) {
        System.out.println("İşlenen kelime sayısı: " + i);
      }
    }

    return root;
  }

}
