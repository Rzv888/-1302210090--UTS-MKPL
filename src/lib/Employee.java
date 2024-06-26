package lib;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Employee {

    private static final int GRADE_1_SALARY = 3_000_000;
    private static final int GRADE_2_SALARY = 5_000_000;
    private static final int GRADE_3_SALARY = 7_000_000;
    private static final double FOREIGNER_SALARY_MULTIPLIER = 1.5;
    private static final int MONTHS_IN_YEAR = 12;

    private String employeeId;
    private String firstName;
    private String lastName;
    private String idNumber;
    private String address;

    private int yearJoined;
    private int monthJoined;
    private int dayJoined;

    private boolean isForeigner;
    private Gender gender;

    private int monthlySalary;
    private int otherMonthlyIncome;
    private int annualDeductible;

    private String spouseName;
    private String spouseIdNumber;

    private List<String> childNames;
    private List<String> childIdNumbers;

    public Employee(String employeeId, String firstName, String lastName, String idNumber, String address, int yearJoined, int monthJoined, int dayJoined, boolean isForeigner, boolean gender) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
        this.address = address;
        this.yearJoined = yearJoined;
        this.monthJoined = monthJoined;
        this.dayJoined = dayJoined;
        this.isForeigner = isForeigner;
        this.gender = gender;

        childNames = new LinkedList<>();
        childIdNumbers = new LinkedList<>();
    }

    // (Comment): setMonthlySalary
    public void setMonthlySalary(int grade) {
        monthlySalary = calculateMonthlySalary(grade);
    }

    // (long code) Method: getBaseSalary
    private int getBaseSalary(int grade) {
        switch (grade) {
            case 1:
                return 3000000;
            case 2:
                return 5000000;
            case 3:
                return 7000000;
            default:
                throw new IllegalArgumentException("Invalid grade");
        }
    }

    // (Duplicate code) Method: adjustForForeigner
    private int adjustForForeigner(int baseSalary) {
        return isForeigner ? (int) (baseSalary * 1.5) : baseSalary;
    }

    //calculateMonthlySalary
    private int calculateMonthlySalary(int grade) {
        int baseSalary = getBaseSalary(grade);
        return adjustForForeigner(baseSalary);
    }

    public void setAnnualDeductible(int deductible) {
        this.annualDeductible = deductible;
    }

    public void setAdditionalIncome(int income) {
        this.otherMonthlyIncome = income;
    }

    public void setSpouse(String spouseName, String spouseIdNumber) {
        this.spouseName = spouseName;
        this.spouseIdNumber = idNumber;
    }

    public void addChild(String childName, String childIdNumber) {
        childNames.add(childName);
        childIdNumbers.add(childIdNumber);
    }

    public int getAnnualIncomeTax() {
        LocalDate date = LocalDate.now();

        if (date.getYear() == yearJoined) {
            monthWorkingInYear = date.getMonthValue() - monthJoined;
        } else {
            monthWorkingInYear = 12;
        }
    }

    // Getters and setters for firstName, lastName, and employeeId
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
//Format penulisan kode //
