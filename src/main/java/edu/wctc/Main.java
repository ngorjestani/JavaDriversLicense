package edu.wctc;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("What is your first name?");
        String firstName = keyboard.nextLine();

        System.out.println("What is your middle initial?");
        String middleInitial = keyboard.nextLine();

        System.out.println("What is your last name?");
        String lastName = keyboard.nextLine();

        System.out.println("What is your birth year?");
        int birthYear = Integer.parseInt(keyboard.nextLine());

        System.out.println("What month were you born in?");
        int birthMonth = Integer.parseInt(keyboard.nextLine());

        System.out.println("What day of the month were you born?");
        int birthDay = Integer.parseInt(keyboard.nextLine());

        System.out.println("What is your gender (M/F)?");
        char genderCode = keyboard.next().charAt(0);

        try {
            DriversLicense driversLicense = new DriversLicense();

            FirstNameUtility firstNameUtility = new FirstNameUtility();
            driversLicense.setFFF(firstNameUtility.encodeFirstName(firstName, middleInitial));

            LastNameUtility lastNameUtility = new LastNameUtility();
            driversLicense.setSSSS(lastNameUtility.encodeLastName(lastName));

            MonthDayGenderUtility monthDayGenderUtility = new MonthDayGenderUtility();
            driversLicense.setDDD(monthDayGenderUtility.encodeMonthDayGender(birthYear, birthMonth, birthDay, genderCode));

            driversLicense.setYY(birthYear);

            driversLicense.setNN(0);

            WisconsinFormatter wisconsinFormatter = new WisconsinFormatter();
            FloridaFormatter floridaFormatter = new FloridaFormatter();

            System.out.printf("Your Wisconsin license # is %s%n", wisconsinFormatter.formatLicenseNumber(driversLicense));
            System.out.printf("Your Florida license # is %s%n", floridaFormatter.formatLicenseNumber(driversLicense));
        } catch (MissingNameException | UnknownGenderCodeException | InvalidBirthdayException e) {
            System.out.println(e.getMessage());
        }

    }
}
