package SimpleSyntax;
import java.util.ArrayList;
public class CalendarArrTraversal {
    public static void main(String[] args) {
        String[][] calendar = {{"volunteer", "delivery", null, null, "doctor", null, "soccer"},
                                {null, "exam 1", null, "mechanic", null, null, "soccer"},
                                {"volunteer", "off work", null, "birthday", null, "concert", null},
                                {null, "exam 2", null, null, "doctor", null, "soccer"},
                                {"visit family", null, null, null, null, null, null}
        };

        String[] days = {"Sundays", "Mondays", "Tuesdays", "Wednesdays", "Thursdays", "Fridays", "Saturdays"};

        //Row-major traversal (iterating through rows)
        for(int i = 0; i < calendar.length; i++) {
            int numberOfEventsPerWeek = 0;
            //Every 'column' in each row
            for(int j = 0; j < calendar[i].length; j++) {
                // We need conditional logic to ensure that we do not count the empty days
                String event = calendar[i][j];
                if(event!=null && !event.isEmpty()) {
                    // If the day does not have a null value and an empty string
                    // for an event, then we print it and count it
                    System.out.println("Week: " + (i+1) + ", Day: " + days[j] + ", Event: " + event);
                    numberOfEventsPerWeek++;
                }
            }
            System.out.println("Total number of events for week "+ (i+1) +": " + numberOfEventsPerWeek + "\n");
        }


        int numberOfEventsPerWeekday = 0;

        for(int i = 0; i < calendar[0].length; i++) {
            numberOfEventsPerWeekday = 0;
            for(int j = 0; j < calendar.length; j++) {
                // Don't forget to flip the iterators in the accessor since
                // we are flipping the direction we are navigating.
                // Remember, i now controls columns and j now controls rows
                String event = calendar[j][i];
                if(event!=null && !event.isEmpty()) {
                    // Make sure we have an event for the day before counting it
                    numberOfEventsPerWeekday++;
                }
            }
            // Use the days string array from earlier to convert the day index to a real weekday string
            System.out.println("Number of events on " + days[i] + ": " + numberOfEventsPerWeekday);
        }



    }
}
