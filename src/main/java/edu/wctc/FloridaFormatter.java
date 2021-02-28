package edu.wctc;

public class FloridaFormatter implements DriversLicenseFormatter{
    @Override
    public String formatLicenseNumber(DriversLicense driversLicense) {
        String number = "";
        number += driversLicense.getSSSS() + "-";
        number += String.format("%03d", driversLicense.getFFF()) + "-";
        number += Integer.toString(driversLicense.getYY()).substring(2,4) + "-";
        number += String.format("%03d", driversLicense.getDDD()) + "-";
        number += driversLicense.getNN();

        return number;
    }
}
