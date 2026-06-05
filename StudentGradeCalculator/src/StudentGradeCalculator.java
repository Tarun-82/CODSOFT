import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the no of subject : ");
        int noOfSubject = sc.nextInt();
        double[] marks = new double[noOfSubject];
        for(int i=0; i<noOfSubject; i++) {
            while (true) {
                System.out.print("Enter the Subject " + (i + 1) + " marks : ");
                double inputMarks = sc.nextDouble();

                if(inputMarks >= 0 && inputMarks <= 100){
                    marks[i]=inputMarks;
                    break;
                } else {
                    System.out.println("❌ Invalid input! Marks must be between 0 and 100. Try again.");
                }
            }
        }

        double totalMarks = calculateTotalMarks(marks);
        double percentage = calculatePercentage(noOfSubject,totalMarks);
        String grade = calculateGrade(percentage);
        displayResult(totalMarks,percentage,grade);

    }

    static double calculateTotalMarks(double[] marks){
        double totalMarks = 0;
        for(double num : marks){
            totalMarks += num;
        }
        return totalMarks;
    }

    static double calculatePercentage(int noOfSubject,double totalMarks){
        double percentage;
        percentage = totalMarks /noOfSubject;
        return percentage;
    }

    static String calculateGrade(double percentage){
        if (percentage>=90){
            return "A+";
        } else if (percentage >= 80) {
            return "A";
        } else if (percentage >= 70){
            return "B";
        } else if (percentage >= 60) {
            return "C";
        } else if (percentage >= 50) {
            return "D";
        }
        return "F";
    }

    static void displayResult(double totalMarks , double percentage , String grade){
        System.out.println();
        System.out.println("===== RESULT =====");
        System.out.println("Total Marks : "+totalMarks);
        System.out.printf("Percentage  : %.2f%%%n", percentage);
        System.out.println("Grade       : "+grade);

    }
}
