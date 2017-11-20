package edu.towson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    private static final String FIRST_NAME_INPUT = "firstnames.txt";
    private static final String LAST_NAME_INPUT = "lastnames.txt";
    private static final String CITY_NAME_INPUT = "cities.txt";
    private static final String STREET_NAME_INPUT = "streets.txt";
    private static final String ZIP_CODE_INPUT = "zipcodes.txt";
    private static final String STATES_INPUT = "states.txt";
    private static String[] firstNameArray = new String[100];
    private static String[] lastNameArray = new String[100];
    private static String[] streetNameArray = new String[100];
    private static String[] cityNameArray = new String[432];
    private static String[] zipCodeArray = new String[432];
    private static String[] statesArray = new String[10];
    private static final SecureRandom randomNumber = new SecureRandom();

    public static void main(String[] args) {
        //Generated random data lists via this website: https://www.randomlists.com/random-names
        readFromFile(FIRST_NAME_INPUT, firstNameArray);
        readFromFile(LAST_NAME_INPUT, lastNameArray);
        readFromFile(CITY_NAME_INPUT, cityNameArray);
        readFromFile(STREET_NAME_INPUT, streetNameArray);
        readFromFile(ZIP_CODE_INPUT, zipCodeArray);
        readFromFile(STATES_INPUT, statesArray);




        System.out.println("Hello World!");
        System.out.println(getSex("Charles"));


    }

    /**
     * Function that reads in a file. Files external to project must have an associated path as part of the name
     * @param filename to read
     * @param array to populate
     */
    private static void readFromFile(String filename, String[] array) {
        BufferedReader bufferedReader;
        FileReader fileReader;

        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {

            String currentLine;
            int count = 0;

            while ((currentLine = br.readLine()) != null) {
                //System.out.println(sCurrentLine);
                array[count] = currentLine;
                count++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Method to split a string at a space
     * @param s String to split
     * @return string array with original String split at spaces
     */
    public String[] splitString(String s){
        StringBuffer sb = new StringBuffer();
        s = sb.toString();
        String result[] = s.split(" ");
        return result;
    }
    
    /**
     * Generates a random number 
     * TO USE: Pass in an arg for the length of the number. For example, a phone
     * number would have an arg of 10, or a SSN# would have arg of 9
     * @param length
     * @return generated number
     */
    public static String genRandomNumber(int length){
        String s = "";
        int first;
        for (int i = 0; i < length; i++) {
            first = 0 + randomNumber.nextInt(10);
            String newStr = s + first;
            s = newStr;
        }
        return s;
    }
    
    /**
     * Generates a random number 
     * TO USE: Pass in an arg for the low bound, and an arg for the high bound. For example, if
     * generating a date of birth, you may want to pass in 1960 for the low bound and 2000 for the high bound. 
     * This would return a string with a value corresponding to a year between 1960 and 2000.  
     * @param lowBound
     * @param highBound
     * @return generated number
     */
    public static String genRandomNumber(int lowBound, int highBound){
        String s = "";
        int first = ThreadLocalRandom.current().nextInt(lowBound, highBound + 1);
        return s = "" + first;
    }
    
    /**
     * Method to help choose an item at random from an array
     * TO USE: Pass in an array as an arg. This should return a random selection from 
     * one of the strings in the array for you to use
     * PURPOSE: Used to assemble addresses/names/etc. Would call this once to pick a first
     * name from the firstNameArray and then call this again to get a random last name from
     * the lastNameArray
     * @param array
     * @return random string from the array
     */
    public static String pickFromArray(String[] array){
        int first = 0 + randomNumber.nextInt(array.length);
        return array[first];
    }
    
    public static String generateEmailAddress(String fname, String lname){
        String[] emailProvider = new String[]{"aol", "hotmail", "msn", "yahoo", "gmail", "excite",
            "juno", "netzero", "postmark", "hushmail", "inbox", "mail", "icloud"};
        int random;
        String result = "";
        random = 0 + randomNumber.nextInt(emailProvider.length);
        result = fname + "." + lname + "@" + emailProvider[random] + ".com";
        
        return result;        
    }
    
    /**
     * Returns corresponding gender to match the first name
     * TO USE: Pass in a first name, method will return correct gender
     * @param name first name on which to base gender
     * @return corresponding gender
     */
    public static String getSex(String name){
        String result = "F";
        int position = findMatchFromArray(name, firstNameArray);
        //The first fifty entries in the array are all male names
        if (position < 50){
            result = "M";
        }
        return result;
    }
    /**
     * Internal method to search for position of matching item in an array
     * TO USE: Pass in a string to search for and the containing array 
     * @param s provided string
     * @param arry array to search for matching string
     * @return either position if found or -1 if the item does not exist in the array
     */
    private static int findMatchFromArray(String s, String[] arry){
        int res = -1;
        for(int i = 0; i < arry.length; i++){
            if(s.equals(arry[i])){
                res = i;
                break;
            }
        }
        return res;
    }
    
    /**
     * Generates a random date with given high/low bounds for a range of years
     * NOTE: To make simpler, just cuts days off at a max of 28 to avoid writing logic for
     * Feb, and 30/31 day months. 
     * TO USE: Designate what range of years to generate a date for
     * @param yrLowBound "do not generate an answer with a year earlier than this arg"
     * @param yrHighBound "do not generate an answer with a year later than this arg"
     * @return String in a date format of mm/dd/yyyy
     */
    public static String generateRandomDate(int yrLowBound, int yrHighBound){
        String result = "";
        result = genRandomNumber(1, 12);
        result = result + "/" + genRandomNumber(1,28);
        result = result + "/" + genRandomNumber(yrLowBound, yrHighBound);
        return result;
    }


}



