package transactions;

import java.util.Arrays;

public class Carrier {

    private String carrierName;
    private String[] regionNames;

    public Carrier(String carrierName, String[] regionNames) {
        this.carrierName = carrierName;
        this.regionNames = regionNames;
    }

    public String getCarrierName() {
        return carrierName;
    }

    public String[] getRegionNames() {
        return regionNames;
    }

    @Override
    public String toString() {
        return "Carrier{" +
                "carrierName='" + carrierName + '\'' +
                ", regionNames=" + Arrays.toString(regionNames) +
                '}';
    }
}
