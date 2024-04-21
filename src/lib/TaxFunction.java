package lib;

public class TaxFunction {

 //Menghapus komen berlebihan//
 
 //Memperbaiki logika fungsinya
    public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible, boolean isMarried, int numberOfChildren) {
        
        if (numberOfMonthWorking > 12) {
            System.err.println("More than 12 months working per year");
            numberOfMonthWorking = 12; 
        }
        

        if (numberOfChildren > 3) {
            numberOfChildren = 3;
        }
        
        int tax;
        int totalIncome = (monthlySalary + otherMonthlyIncome) * numberOfMonthWorking;
        
        if (isMarried) {
            int childrenDeduction = numberOfChildren * 1500000;
            int totalDeduction = deductible + 54000000 + 4500000 + childrenDeduction;
            tax = (int) Math.round(0.05 * (totalIncome - totalDeduction));
        } else {
            int totalDeduction = deductible + 54000000;
            tax = (int) Math.round(0.05 * (totalIncome - totalDeduction));
        }

        if (tax < 0) {
            return 0;
        } else {
            return tax;
        }
    }
}
