package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.*;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Utility {
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String POSTCODE_FORMAT = "AA99 9AA";
    private static final String[] STREET_NAMES = {
            "Main St", "Oak Ave", "Maple Dr", "Pine Rd", "Elm St", "Cedar Ln",
            "Willow St", "Birch Dr", "Park Ave", "Lakeview Dr"
    };
    private static final String[] CITIES = {
            "New York", "Los Angeles", "Chicago", "Houston", "Phoenix",
            "Philadelphia", "San Antonio", "San Diego", "Dallas", "Austin"
    };
    private static final String[] STATES = {
            "CA", "NY", "TX", "FL", "IL", "PA", "OH", "GA", "NC", "MI"
    };
    private static final List<String> cities = Arrays.asList(
            "New York", "Los Angeles", "Chicago", "Houston", "Phoenix",
            "Philadelphia", "San Antonio", "San Diego", "Dallas", "Austin",
            "Jacksonville", "Fort Worth", "Columbus", "Charlotte", "San Jose",
            "Indianapolis", "Seattle", "Denver", "Washington", "Boston",
            "El Paso", "Nashville", "Detroit", "Oklahoma City", "Portland",
            "Las Vegas", "Memphis", "Louisville", "Baltimore", "Milwaukee"
    );

    // generate random first name
    public static String generateRandomFirstName() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(10);

        for (int i = 0; i < 10; i++) {
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        }

        return sb.toString();
    }

    // generate random mobile number
    public static String generateRandomPhoneNumber() {
        String countryCode = "966"; // Saudi Arabia country code
        Random random = new Random();
        StringBuilder phoneNumber = new StringBuilder(countryCode);
        // Generate 9 more digits
        for (int i = 0; i < 9; i++) {
            phoneNumber.append(random.nextInt(10));
        }
        return phoneNumber.toString();
    }

    // generate random int
    public static int generateRandomInt(int max) {
        Random random = new Random();
        return random.nextInt(max);
    }

    public static void selectRandomDropDownList(WebDriver driver, WebElement listElement) {
        List<WebElement> itemsInDropdown = listElement.findElements(By.tagName("li"));
        int size = itemsInDropdown.size();
        int randomNumber = ThreadLocalRandom.current().nextInt(0, size);
        itemsInDropdown.get(randomNumber).click();
    }

    public static String generateRandomPostcode() {
        Random random = new Random();
        StringBuilder postcode = new StringBuilder(POSTCODE_FORMAT);
        for (int i = 0; i < postcode.length(); i++) {
            char c = postcode.charAt(i);
            if (Character.isUpperCase(c)) {
                postcode.setCharAt(i, ALPHABET.charAt(random.nextInt(ALPHABET.length())));
            }
        }
        return postcode.toString();
    }

    public static String generateRandomAddress() {
        Random rand = new Random();
        return String.format("%d %s, %s, %s %05d",
                rand.nextInt(1000) + 1, // House number
                STREET_NAMES[rand.nextInt(STREET_NAMES.length)],
                CITIES[rand.nextInt(CITIES.length)],
                STATES[rand.nextInt(STATES.length)],
                rand.nextInt(100000)); // Zip code
    }

    public static String generateRandomCity() {
        Collections.shuffle(cities);
        return cities.get(0);
    }

    public static void selectRandomOptionFromDropdown(WebDriver driver, WebElement dropdownElement) {
        Select select = new Select(dropdownElement);
        List<WebElement> options = select.getOptions();
        if (!options.isEmpty()) {
            int randomIndex = new Random().nextInt(options.size());
            select.selectByIndex(randomIndex);
        }
    }
}