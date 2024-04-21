package lib;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Employee {

    private String employeeId;
    private String firstName;
    private String lastName;
    private String idNumber;
    private String address;

    private int yearJoined;
    private int monthJoined;
    private int dayJoined;
    private int monthWorkingInYear;

    private boolean isForeigner;
    private boolean isMale;

    private int monthlySalary;
    private int otherMonthlyIncome;
    private int annualDeductible;

    private List<String> childNames;
    private List<String> childIdNumbers;

    public Employee(String employeeId, String firstName, String lastName, String idNumber, String address, int yearJoined, int monthJoined, int dayJoined, boolean isForeigner, boolean isMale) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
        this.address = address;
        this.yearJoined = yearJoined;
        this.monthJoined = monthJoined;
        this.dayJoined = dayJoined;
        this.isForeigner = isForeigner;
        this.isMale = isMale;

        childNames = new LinkedList<>();
        childIdNumbers = new LinkedList<>();
    }

    public void setMonthlySalary(int grade) {
        int baseSalary;
        switch (grade) {
            case 1:
                baseSalary = 3000000;
                break;
            case 2:
                baseSalary = 5000000;
                break;
            case 3:
                baseSalary = 7000000;
                break;
            default:
                throw new IllegalArgumentException("Invalid grade");
        }

        monthlySalary = isForeigner ? (int) (baseSalary * 1.5) : baseSalary;
    }

    public void setAnnualDeductible(int deductible) {
        this.annualDeductible = deductible;
    }

    public void setAdditionalIncome(int income) {
        this.otherMonthlyIncome = income;
    }

    public void addChild(String childName, String childIdNumber) {
        childNames.add(childName);
        childIdNumbers.add(childIdNumber);
    }

    public int getAnnualIncomeTax() {
        LocalDate date = LocalDate.now();

        monthWorkingInYear = date.getYear() == yearJoined ? date.getMonthValue() - monthJoined : 12;

        return TaxFunction.calculateTax(monthlySalary, otherMonthlyIncome, monthWorkingInYear, annualDeductible, spouseIdNumber == null || spouseIdNumber.isEmpty(), childIdNumbers.size());
    }
}package lib;

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

    public enum Gender {
        LAKI_LAKI,
        PEREMPUAN
    }

    public Employee(String employeeId, String firstName, String lastName, String idNumber, String address,
                    int yearJoined, int monthJoined, int dayJoined, boolean isForeigner, Gender gender) {
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
//LOng method//
    public void setMonthlySalary(int grade) {
        switch (grade) {
            case 1:
                monthlySalary = calculateSalary(GRADE_1_SALARY);
                break;
            case 2:
                monthlySalary = calculateSalary(GRADE_2_SALARY);
                break;
            case 3:
                monthlySalary = calculateSalary(GRADE_3_SALARY);
                break;
            default:
                throw new IllegalArgumentException("Invalid grade");
        }
    }
//Duplicate code//
    private int calculateSalary(int baseSalary) {
        return isForeigner ? (int) (baseSalary * FOREIGNER_SALARY_MULTIPLIER) : baseSalary;
    }

    public void setAnnualDeductible(int deductible) {
        this.annualDeductible = deductible;
    }

    public void setAdditionalIncome(int income) {
        this.otherMonthlyIncome = income;
    }

    public void setSpouse(String spouseName, String spouseIdNumber) {
        this.spouseName = spouseName;
        this.spouseIdNumber = spouseIdNumber;
    }

    public void addChild(String childName, String childIdNumber) {
        childNames.add(childName);
        childIdNumbers.add(childIdNumber);
    }

    public int getAnnualIncomeTax() {
        int monthWorkingInYear = calculateWorkingMonthsInYear();

        return TaxFunction.calculateTax(monthlySalary, otherMonthlyIncome, monthWorkingInYear, annualDeductible,
                spouseIdNumber.equals(""), childIdNumbers.size());
    }

    private int calculateWorkingMonthsInYear() {
        LocalDate currentDate = LocalDate.now();

        if (currentDate.getYear() == yearJoined) {
            return currentDate.getMonthValue() - monthJoined;
        } else {
            return MONTHS_IN_YEAR;
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

    // ... Other getters and setters ...
}

