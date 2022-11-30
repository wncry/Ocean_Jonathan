import java.util.*;

class Data {
    // attributes
    private ArrayList<AcidityRecord> acidityRecords = new ArrayList<>();
    
    // constructors
    public Data() {}

    // mutators
    public void addData(String yearTimestamp, double oceanCO2, double oceanPH, double atmosphericCO2) {
        AcidityRecord record = new AcidityRecord(yearTimestamp, oceanCO2, oceanPH, atmosphericCO2);
        acidityRecords.add(record);
    }

    // accessors
    public String getRecordYearTimestamp(int index) {return acidityRecords.get(index).getYearTimestamp();}
    public double getRecordOceanCO2(int index) {return acidityRecords.get(index).getOceanCO2();}
    public double getRecordOceanPH(int index) {return acidityRecords.get(index).getOceanPH();}
    public double getRecordAtmosphericCO2(int index) {return acidityRecords.get(index).getAtmosphericCO2();}
    public int getDataCount() {return acidityRecords.size();}

    // helpers

    // to print
    public String printData() {
        StringBuilder returnString = new StringBuilder();
        returnString.append(String.format("\n\n%-17s%-12s%-11s%-17s\n", "Year Timestamp", "Ocean CO2", "Ocean PH", "Atmospheric CO2"));
        returnString.append("---- ---------   ----- ---   ----- --   ----------- ---\n");
        for (AcidityRecord record: acidityRecords) {
            returnString.append(record);
            returnString.append("\n");
        }
        returnString.append("---- ---------   ----- ---   ----- --   ----------- ---\n");
        return returnString.toString();
    }

    public String oceanC02Stats() {
        return "--- OCEAN C02 STATS ---\n"
            + String.format("Average (First 10): %3.2f\n", avgFirst10OceanCO2())
            + String.format("Average (Last 10):  %3.2f\n", avgLast10OceanCO2())
            + "--- ----- --- ----- ---\n";
    }

    public String oceanPHStats() {
        return "--- OCEAN PH STATS ---\n"
            + String.format("Average (First 10): %3.2f\n", avgFirst10OceanPH())
            + String.format("Average (Last 10):  %3.2f\n", avgLast10OceanPH())
            + "--- ----- -- ----- ---\n";
    }

    public String atmosphericC02Stats() {
        return "--- ATMOSPHERIC C02 STATS ---\n"
            + String.format("Average (First 10): %3.2f\n", avgFirst10AtmosphericCO2())
            + String.format("Average (Last 10):  %3.2f\n", avgLast10AtmosphericCO2())
            + "--- ----------- --- ----- ---\n";
    }

    public String printIndexData(int index) {
        return String.format("%s, %d, %d, %d",
            getRecordYearTimestamp(index),
            getRecordOceanCO2(index),
            getRecordOceanPH(index),
            getRecordAtmosphericCO2(index));
    }

    // avg
    public double avgOceanCO2() {
        double oceanCO2 = 0;
        for (AcidityRecord record: acidityRecords) {
            oceanCO2 = record.getOceanCO2();
        }
        return oceanCO2/getDataCount();
    }

    public double avgOceanPH() {
        double oceanPH = 0;
        for (AcidityRecord record: acidityRecords) {
            oceanPH = record.getOceanPH();
        }
        return oceanPH/getDataCount();
    }

    public double avgAtmosphericCO2() {
        double atmosphericCO2 = 0;
        for (AcidityRecord record: acidityRecords) {
            atmosphericCO2 = record.getAtmosphericCO2();
        }
        return atmosphericCO2/getDataCount();
    }

    public double avgFirst10OceanCO2() {
        double oceanCO2 = 0;
        for (int i=0; i<10; i++) {
            oceanCO2 = acidityRecords.get(i).getOceanCO2();
        }
        return oceanCO2/10;
    }

    public double avgFirst10OceanPH() {
        double oceanPH = 0;
        for (int i=0; i<10; i++) {
            oceanPH = acidityRecords.get(i).getOceanPH();
        }
        return oceanPH/10;
    }

    public double avgFirst10AtmosphericCO2() {
        double atmosphericCO2 = 0;
        for (int i=0; i<10; i++) {
            atmosphericCO2 = acidityRecords.get(i).getAtmosphericCO2();
        }
        return atmosphericCO2/10;
    }
    
    public double avgLast10OceanCO2() {
        double oceanCO2 = 0;
        for (int i=getDataCount()-1; i>getDataCount()-10; i--) {
            oceanCO2 = acidityRecords.get(i).getOceanCO2();
        }
        return oceanCO2/10;
    }

    public double avgLast10OceanPH() {
        double oceanPH = 0;
        for (int i=getDataCount()-1; i>getDataCount()-10; i--) {
            oceanPH = acidityRecords.get(i).getOceanPH();
        }
        return oceanPH/10;
    }

    public double avgLast10AtmosphericCO2() {
        double atmosphericCO2 = 0;
        for (int i=getDataCount()-1; i>getDataCount()-10; i--) {
            atmosphericCO2 = acidityRecords.get(i).getAtmosphericCO2();
        }
        return atmosphericCO2/10;
    }
}
