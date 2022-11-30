import java.util.*;
import java.io.*;

class HandleFile {
    // attributes
    private Data data = new Data();
    private String fileName = "null";
    private boolean err = false;
    private static int fileCount = 0;
    private int fileIndex = 0;
    
    // constructors
    public HandleFile(String fileName) {
        this.fileName = fileName;
    }

    // accessors
    public int getFileCount() {return this.fileCount;}
    public int getFileIndex() {return this.fileIndex;}

    // helpers
    public Data loadFile() {
        try {
            File file = new File(this.fileName);
            Scanner fileRead = new Scanner(file);
            System.out.printf("\nFile name: %s is now open.\n", this.fileName);
            System.out.printf("File size in bytes: %d\n", file.length());
            
            if (!fileRead.hasNext()) {
                throw new Exception();
            } else {
                System.out.println("There is data to read in this file\n");
            }

            while (fileRead.hasNextLine()) {
                String ln = fileRead.nextLine();
                String[] line = ln.split(",");

                if (line.length!=4) {
                    System.out.println("Error: Bad file data");
                    continue;  // skip
                }
                String yearTimestamp = line[0];
                double oceanCO2 = Double.parseDouble(line[1]);
                double oceanPH = Double.parseDouble(line[2]);
                double atmosphericCO2 = Double.parseDouble(line[3]);

                data.addData(yearTimestamp, oceanCO2, oceanPH, atmosphericCO2);

                if (data.getDataCount()==1) {
                    System.out.println(ln);
                }
            }

            System.out.printf("%d record%s have been read from the file.\n", data.getDataCount(), (data.getDataCount()!=1)?"s":"");

            fileRead.close();
            System.out.printf("File name: %s is now closed.\n", this.fileName);

        } catch (FileNotFoundException e) {
            System.out.printf("ERROR:\nYour file: %s does not exist.\n", this.fileName);
            this.err = true;
        } catch (Exception e) {
            System.out.println("Error: File is empty\n");
            this.err = true;
        }

        fileCount++;
        fileIndex+=fileCount;
        return data;
    }

    public void readFile() {
        if (!err) {
            System.out.printf("%s\n%s\n%s\n%s\n",
                data.printData(),
                data.oceanC02Stats(),
                data.oceanPHStats(),
                data.atmosphericC02Stats());
        }
    }
}
