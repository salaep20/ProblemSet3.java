import java.util.Scanner;

public class GPAcaculator {
    private static class LoanFormulas {
        public static double gradeToPoints(String s) {

            return 0;
        }
    }

    public class TicTacToe {


        /**
         * This program predicts a person's semester GPA based on the
         * courses they want to take and grades they expect in each course.
         * At the end of the program, it will show a summary, including the name, number of hours and grade in
         * each of their courses.
         *
         * @Ethan Salazar
         *
         * October 6 2022
         */
        public class PredictGPA {
            public static void main(String[] args) {
                final int MAX_COURSES = 25;  // Nobody can take 25 courses but just want to be safe
                int numCourses = 0; //total number of actual courses for each use
                String option; //allows user to continue
                boolean isContinue; //true or false if user wants to continue
                Scanner kb = new Scanner(System.in);
                double totalHours = 0.0;
                double[] hours = new double[5];
                double gpa;
                int a = 0;
                String [] title = new String[5];
                String [] grade  = new String[5];
                double points;
                double numerator = 0;

                System.out.println("Semester GPA Predictor: Let’s see what you GPA could be this semester...\n");

                while(true) {
                    System.out.println();
                    System.out.printf("Course %d: Course title? ", numCourses + 1);
                    title[numCourses] = kb.nextLine();
                    System.out.printf("Course %d: Number of hours? ", numCourses + 1);
                    hours[numCourses] = Double.parseDouble(kb.nextLine());
                    System.out.printf("Course %d: Expected grade? ", numCourses + 1);
                    grade[numCourses] = kb.nextLine();


                    //if-else statements that assign a number value to each possible letter grade
                    // if statements in new method gradeToPoints


                    points = LoanFormulas.gradeToPoints(grade[numCourses]);


                    // Update the formula for GPA
                    totalHours += hours[numCourses];
                    numerator += points * hours[numCourses];


                    numCourses++;

                    option = "x";

                    //option to stop adding courses, will only accept "y" or "n"
                    while (!(option.equals("y") || option.equals("n")) ) {
                        System.out.print("Continue (y/n)? ");
                        option = kb.nextLine();
                    }

                    //ends program if user's input above was "n"
                    if(option.equals("n") ) {
                        break;

                    }


                }

                // Calculate the GPA
                gpa = numerator / totalHours;
                System.out.println(title[numCourses]);
                System.out.println("--------------------");
                System.out.println("Here is your summary");
                System.out.println("Title     Hours     Grade");

                for (int i = 1; i <= numCourses; i++) {
                    System.out.println(title[numCourses-i] +"     " + hours[numCourses-i]+ " " + "       " +grade[numCourses-i]);
                }
                System.out.printf("Your semester GPA would be %.2f\n", gpa);
            }


        }

    }

}
