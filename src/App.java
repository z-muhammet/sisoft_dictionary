public class App {

    public static void main(String[] args) throws Exception {
        FileProcess fileProcess = new FileProcess();
        StringProcess stringProcess = new StringProcess();
        String fileName = "sozluk";
        stringProcess.buildTree(fileProcess.readFile(fileProcess.findFileByName(fileName)));

    }
}
