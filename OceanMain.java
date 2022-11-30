import java.util.*;

class OceanMain {
    public static Scanner kb = new Scanner(System.in);
    public static void main(String[] args) {
        
        System.out.print("Enter file name: ");
        String fileName = kb.nextLine();

        HandleFile file = new HandleFile(fileName);
        file.loadFile();
        file.readFile();
    }
}
