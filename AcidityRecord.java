import java.util.*;

class AcidityRecord {
    // attributes
    private String yearTimestamp;
    private double oceanCO2;
    private double oceanPH;
    private double atmosphericCO2;
    private static int recordCount;
    private int recordIndex;

    // constructors
    public AcidityRecord(String yearTimestamp, double oceanCO2, double oceanPH, double atmosphericCO2) {
        this.yearTimestamp = yearTimestamp;
        this.oceanCO2 = oceanCO2;
        this.oceanPH = oceanPH;
        this.atmosphericCO2 = atmosphericCO2;
        recordCount++;
        recordIndex=recordCount;
    }

    // accessors
    public String getYearTimestamp() {return this.yearTimestamp;}
    public double getOceanCO2() {return this.oceanCO2;}
    public double getOceanPH() {return this.oceanPH;}
    public double getAtmosphericCO2() {return this.atmosphericCO2;}
    public int getRecordCount() {return this.recordCount;}
    public int getRecordIndex() {return this.recordIndex;}

    // helpers
    public String toString() {
        return String.format("%-17s%-12.1f%-11.4f%-17.2f", yearTimestamp, oceanCO2, oceanPH, atmosphericCO2);
    }
}
