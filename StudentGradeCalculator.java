
import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String name;
        int subjects;
        double total = 0;

        System.out.println("==================================");
        System.out.println("     STUDENT GRADE CALCULATOR");
        System.out.println("==================================");

        // Accept student name
        System.out.print("Enter Student Name: ");
        name = sc.nextLine();

        // Accept number of subjects
        do {
            System.out.print("Enter Number of Subjects: ");

            while (!sc.hasNextInt()) {
                System.out.println("Invalid input! Enter a valid number.");
                sc.next();
                System.out.print("Enter Number of Subjects: ");
            }

            subjects = sc.nextInt();

            if (subjects <= 0) {
                System.out.println("Number of subjects must be greater than 0.");
            }

        } while (subjects <= 0);

        // Create arrays to store subject names and marks
        String[] subjectNames = new String[subjects];
        double[] marks = new double[subjects];

        // Accept subject names and marks
        for (int i = 0; i < subjects; i++) {

            System.out.print("\nEnter Subject " + (i + 1) + " Name: ");
            subjectNames[i] = sc.next();

            do {
                System.out.print("Enter Marks out of 100: ");

                while (!sc.hasNextDouble()) {
                    System.out.println("Invalid input! Enter numeric marks.");
                    sc.next();
                    System.out.print("Enter Marks out of 100: ");
                }

                marks[i] = sc.nextDouble();

                if (marks[i] < 0 || marks[i] > 100) {
                    System.out.println("Marks must be between 0 and 100.");
                }

            } while (marks[i] < 0 || marks[i] > 100);

            total += marks[i];
        }

        // Calculate average percentage
        double percentage = total / subjects;

        // Calculate grade
        String grade;

        if (percentage >= 90) {
            grade = "A+";
        }
        else if (percentage >= 80) {
            grade = "A";
        }
        else if (percentage >= 70) {
            grade = "B";
        }
        else if (percentage >= 60) {
            grade = "C";
        }
        else if (percentage >= 50) {
            grade = "D";
        }
        else if (percentage >= 40) {
            grade = "E";
        }
        else {
            grade = "F";
        }

        // Display student result
        System.out.println("\n==================================");
        System.out.println("          STUDENT RESULT");
        System.out.println("==================================");

        System.out.println("Student Name: " + name);

        System.out.println("\nSubject-wise Marks:");

        for (int i = 0; i < subjects; i++) {
            System.out.println(subjectNames[i] + " : " + marks[i]);
        }

        System.out.println("\nTotal Marks: " + total + " / " + (subjects * 100));

        System.out.printf("Average Percentage: %.2f%%\n", percentage);

        System.out.println("Grade: " + grade);

        if (percentage >= 40) {
            System.out.println("Result: PASS");
        }
        else {
            System.out.println("Result: FAIL");
        }

        System.out.println("==================================");

        sc.close();
    }
}
