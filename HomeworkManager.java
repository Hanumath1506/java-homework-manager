import java.util.*;

class Date {
   int year;
   int month;
   int day;

   public Date(int year, int month, int day) {
      this.year = year;
      this.month = month;
      this.day = day;
   }
   public int getYear() {
      return year;
   }
   public int getMonth() {
      return month;
   }
   public int getDay() {
      return day;
   }
   public boolean isEarlierThan(Date other) {
      if (this.year < other.year) 
         return true;
      if (this.year == other.year && this.month < other.month) 
         return true;
      if (this.year == other.year && this.month == other.month && this.day < other.day) 
         return true;
      return false;
   }
   public boolean isSameAs(Date other) {
      return this.year == other.year && this.month == other.month && this.day == other.day;
   }

   public String toString() {
      return year + "--" + String.format("%02d", month) + "--" + String.format("%02d", day);
   }
}

class Assignment {
   private String title;
   private Date duedate;

   public Assignment(String title, Date duedate) {
      this.title = title;
      this.duedate = duedate;
   }
   public String getTitle() {
      return title;
   }
   public Date getDueDate() {
      return duedate;
   }

   public String toString() {
      return "Title: " + title + ", Due Date: " + duedate.toString();
   }
}

public class HomeworkManager {
   private LinkedList<Assignment> assignments;
   public HomeworkManager() {
      assignments = new LinkedList<>();
   }

   // Add a new assignment
   public void addAssignment(String title, Date duedate) {
      assignments.add(new Assignment(title, duedate));
      System.out.println("Assignment added: " + title);
   }

   //Remove an assignment
   public void removeAssignment(String title) {
      /*Iterator<Assignment> iterator = assignments.iterator();
      while (iterator.hasNext()) {
          Assignment assignment = iterator.next();
          if (assignment.getTitle().equalsIgnoreCase(title)) {
              iterator.remove();
              System.out.println("Assignment removed: " + title);
              return;
          }
      }*/
   //Another way for this method.
      for (int i = 0; i < assignments.size(); i++) {
         if (assignments.get(i).getTitle().equalsIgnoreCase(title)) {
            assignments.remove(i);
            System.out.println("Assignment removed: " + title);
            return;
         }
      }
      System.out.println("No assignment found.");
   }

   public void listAssignments() {
      if (assignments.isEmpty()) {
         System.out.println("No assignments found.");
      } else {
         System.out.println("List of assignments: ");
         for (Assignment assignment: assignments){
            System.out.println(assignment);
         }
      }
   }

   public LinkedList<Assignment> earliestDueDate(){
      LinkedList<Assignment> earliestAssignments = new LinkedList<>();
   
      if (assignments.isEmpty()) {
         System.out.println("No assignments found.");
         return earliestAssignments; // Return an empty list
      }
   
      // Assume the first assignment has the earliest due date
      Assignment earliestAssignment = assignments.get(0);
   
      // Find the earliest due date
      for (Assignment assignment : assignments) {
         if (assignment.getDueDate().isEarlierThan(earliestAssignment.getDueDate())) {
            earliestAssignment = assignment;
         }
      }
   
      // Now that we have the earliest due date, find all assignments with this due date
      for (Assignment assignment : assignments) {
         if (assignment.getDueDate().isSameAs(earliestAssignment.getDueDate())) {
            earliestAssignments.add(assignment);
         }
      }
   
      return earliestAssignments;
   }
}
