import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;
import java.util.ArrayList;

public class TreeProcess {

  @SuppressWarnings("unchecked")
  public Map<Character, Object> buildTree(List<String> allWords) {
    System.out.println("Sözlük Yükleniyor. Lütfen Bekleyin...");
    Map<Character, Object> root = new HashMap<>();
    if (allWords == null || allWords.isEmpty()) {
      System.out.println("kelime bulunamadi veya boş liste verildi.");
      return null;
    } else {
      for (String word : allWords) {
        Map<Character, Object> currentMap = root;
        for (char c : word.toCharArray()) {
          if (!currentMap.containsKey(c)) {
            currentMap.put(c, new HashMap<Character, Object>());
          }
          currentMap = (Map<Character, Object>) currentMap.get(c);
        }
        currentMap.put('*', null);
      }
      System.out.println("Sözlük Yüklendi.");
      return root;
    }
  }

  @SuppressWarnings("unchecked")
  public List<String> search(Map<Character, Object> root, String searchWord) {
    Map<Character, Object> currentMap = root;
    for (char c : searchWord.toCharArray()) {
      if (!currentMap.containsKey(c)) {
        return Collections.emptyList();
      }
      currentMap = (Map<Character, Object>) currentMap.get(c);
    }

    List<String> results = new ArrayList<>();
    findAllWords(currentMap, searchWord, results);
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
