import java.util.LinkedList;
import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
      HomeworkManager manager = new HomeworkManager();
      Scanner scan = new Scanner(System.in);
      while(true) {
         System.out.println("Choose an option:");
         System.out.println("1. Add an assignment");
         System.out.println("2. Remove an assignment");
         System.out.println("3. List assignments");
         System.out.println("4. Find assignment(s) with the earliest due date: ");
         System.out.println("5. Exit");
         System.out.print("Enter your choice: ");
         int option = scan.nextInt();
         scan.nextLine();
         System.out.println("-------------------------------------");
      
         switch(option) {
            case 1:
               System.out.println("Enter assignment title: ");
               String title = scan.nextLine();
            
               System.out.println("Enter due date year: ");
               int year = scan.nextInt();
               System.out.println("Enter due date month(number)(1-12): ");
               int month = scan.nextInt();
               System.out.println("Enter due date day(number)(1-31): ");
               int day = scan.nextInt();
               Date duedate = new Date(year, month, day);
               manager.addAssignment(title, duedate);
               System.out.println("-------------------------------------");
               break;
            case 2:
               System.out.println("Enter assignment title: ");
               String removeTitle = scan.nextLine();
               manager.removeAssignment(removeTitle);
               System.out.println("-------------------------------------");
               break;
            case 3:
               manager.listAssignments();
               System.out.println("-------------------------------------");
               break;
            case 4:
               LinkedList<Assignment> earliestAssignments = manager.earliestDueDate();
               if (!earliestAssignments.isEmpty()){
                  System.out.println("Assignment(s) with the earliest due date: \n");
                  for (Assignment assignment: earliestAssignments) {
                     System.out.println(assignment);
                  }
               }
               System.out.println("-------------------------------------");
               break;
            case 5:
               System.out.println("Exiting...");
               scan.close();
               System.out.println("-------------------------------------");
               return;
            default:
               System.out.println("Invalid choice. Please try again.");
               System.out.println("-------------------------------------");
         }
      }
   }
}
