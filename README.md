
# Sisoft Dictionary

Bu proje, kullanıcıdan alınan bir kelimeye göre sözlükteki olası kelimeleri listeleyen bir Java uygulamasıdır. Konsol tabanlı çalışan bu program, bir `Trie` veri yapısı kullanarak hızlı arama yapar.

## Özellikler

- Trie veri yapısı ile hızlı kelime arama
- UTF-8 destekli terminal çıktısı
- Kelime tahminleme ve tamamlama
- Konsoldan etkileşimli giriş

## Başlatma

### 1. Ortam Ayarları

Windows PowerShell kullanıyorsanız, UTF-8 karakter desteğini etkinleştirin:

```powershell
chcp 65001
$OutputEncoding = [Console]::OutputEncoding = [Text.UTF8Encoding]::UTF8
```

### 2. Derleme

```bash
javac App.java
```

### 3. Çalıştırma

```bash
java App sozluk
```

## Sözlük Verisi

Program, `src/data` klasöründe yer alan `.txt` uzantılı dosyaları kullanır. Kullanmak istediğiniz sözlük dosyasını bu klasöre yerleştirin. Örneğin:

```
src/
├── App.java
├── data/
│   └── sozluk.txt
```

Programı çalıştırırken sözlük adı parametre olarak verilir. Örneğin:

```bash
java App sozluk
```

Bu komut, `data/sozluk.txt` dosyasını yükler.

## Kullanım

Program başlatıldıktan sonra sizden bir kelime girmeniz istenir. Girilen kelimeye göre Trie üzerinden eşleşen olası kelimeler sıralanır:

![Uygulama Çalışma Görüntüsü](https://i.imgur.com/T695ojM.jpeg)

## Geliştirici Notları

- Kodlar `App.java` içinde yer almaktadır.
- Trie yapısı ile büyük verilerde dahi hızlı arama yapılabilir.
- Sözlük dosyasının her satırı bir kelime içermelidir.

## Lisans

MIT Lisansı
