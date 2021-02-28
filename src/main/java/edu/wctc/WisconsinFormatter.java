package edu.wctc;

public class WisconsinFormatter implements DriversLicenseFormatter{
    @Override
    public String formatLicenseNumber(DriversLicense driversLicense) {
        String number = "";
        number += driversLicense.getSSSS() + "-";
        number += String.format("%03d", driversLicense.getFFF());
        number += Integer.toString(driversLicense.getYY()).charAt(2) + "-" + Integer.toString(driversLicense.getYY()).charAt(3);
        number += String.format("%03d", driversLicense.getDDD()) + "-";
        number += String.format("%02d", driversLicense.getNN());

        return number;
    }
}
