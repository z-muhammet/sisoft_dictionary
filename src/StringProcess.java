import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;
import java.util.ArrayList;

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
    System.out.println("Toplam işlenen kelime sayısı: " + i);
    return root;
  }

  @SuppressWarnings("unchecked")
  public List<String> search(Map<Character, Object> root, String prefix) {
    Map<Character, Object> currentMap = root;
    for (char c : prefix.toCharArray()) {
      if (!currentMap.containsKey(c)) {
        return Collections.emptyList();
      }
      currentMap = (Map<Character, Object>) currentMap.get(c);
    }

    List<String> results = new ArrayList<>();
    findAllWords(currentMap, prefix, results);
    return results;
  }

  @SuppressWarnings("unchecked")
  private void findAllWords(Map<Character, Object> node, String currentWord, List<String> results) {
    for (Map.Entry<Character, Object> entry : node.entrySet()) {
      char key = entry.getKey();

      if (key == '*') {
        results.add(currentWord);
      } else {
        Map<Character, Object> nextNode = (Map<Character, Object>) entry.getValue();
        findAllWords(nextNode, currentWord + key, results);
      }
    }
  }

}
