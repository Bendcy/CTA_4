import java.util.ArrayList;
import java.util.Scanner;

public class WeeklyTemps {
    public static void main(String[] args) {

        ArrayList<String> daysOfWeek = new ArrayList<>();
        ArrayList<Double> dailyTemps = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        for (String day : days) {
            System.out.println("Enter the temperature for " + day + ": ");
            double temp = scanner.nextDouble();
            daysOfWeek.add(day);
            dailyTemps.add(temp);
        }
        while (true) {
            System.out.println("\nEnter a day of the week to display its temperature, 'week' for weekly average, or 'exit' to quit: ");
            String userInput = scanner.next();
            if (userInput.equalsIgnoreCase("exit")) {
                break;
            } else if (userInput.equalsIgnoreCase("week")) {
                double total = 0;
                for (int i = 0; i < daysOfWeek.size(); i++) {
                    System.out.println(daysOfWeek.get(i) + ": " + dailyTemps.get(i) + "°F");
                    total += dailyTemps.get(i);
                }
                double average = total / dailyTemps.size();
                System.out.printf("Weekly average temperature: %.2f\n", average);
            } else {
                int index = daysOfWeek.indexOf(userInput);
                if (index != -1) {
                    System.out.println(userInput + ": " + dailyTemps.get(index) + "°F");
                } else {
                    System.out.println("Invalid input. Please enter a valid day of the week, 'week', or 'exit'.");
                }
            }
        }
        scanner.close();
    }
}