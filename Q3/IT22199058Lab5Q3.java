import java.util.Scanner;
 
public class IT22199058Lab5Q3 {
    static final double ROOM_CHARGE_PER_DAY = 48000.0;
    static final int MIN_DATE = 1;
    static final int MAX_DATE = 31;
    static final int TIER1_MIN_DAYS = 3;
    static final int TIER2_MIN_DAYS = 5;
    static final double TIER1_DISCOUNT = 10;
    static final double TIER2_DISCOUNT = 20;
 
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
 
        System.out.print("Enter Start Date (1-31): ");
        int startDate = input.nextInt();
 
        System.out.print("Enter End Date (1-31): ");
        int endDate = input.nextInt();
 
        if (startDate < MIN_DATE || startDate > MAX_DATE || endDate < MIN_DATE || endDate > MAX_DATE) {
            System.out.println("Error: Days must be between 1 and 31");
            input.close();
            return;
        }
 
        if (startDate >= endDate) {
            System.out.println("Error: Start Date must be less than End Date");
            input.close();
            return;
        }
 
        int daysReserved = endDate - startDate;
        double discountRate = 0;
 
        if (daysReserved >= TIER2_MIN_DAYS) {
            discountRate = TIER2_DISCOUNT;
        } else if (daysReserved >= TIER1_MIN_DAYS) {
            discountRate = TIER1_DISCOUNT;
        }
 
        double totalAmount = daysReserved * ROOM_CHARGE_PER_DAY * (1 - discountRate / 100);
 
        System.out.println();
        System.out.println("Room Charge Per Day: Rs. " + ROOM_CHARGE_PER_DAY + "/=");
        System.out.println("Number of Days Reserved: " + daysReserved);
        System.out.println("Total Amount to be Paid: " + totalAmount);
 
        input.close();
    }
}
 