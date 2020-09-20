package mypack;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Employee {
    String name = "";
    Double baseSalary = 0.0;
    int employeeId;

    public double bonus;

    public Employee manager;
    public Accountant accountantSupport;
    public int headcount=0;

    public double bonusBudget;

    //Generate ID
    private static int lastEmployeeId = 0;
    private static AtomicInteger lastEmployeeIdAtomic = new AtomicInteger(0);

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
        //this.employeeId = generateEmployeeID();
        this.employeeId = lastEmployeeIdAtomic.incrementAndGet();
    }

    public double getBaseSalary() {
        return this.baseSalary;
    }

    public String getName() {
        return this.name;
    }

    public int getEmployeeId() {
        return this.employeeId;
    }

    private int generateEmployeeID() {
        try {
            Thread.sleep(Math.abs(new Random().nextInt()) % 50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int returnedId = lastEmployeeId + 1;
        lastEmployeeId = returnedId;
        return returnedId;
    }

    public Employee getManager(){
        return manager;//Should return a reference to the Employee object that represents this employee's manager
    }

    public Accountant getAccountantSupport() {
        return accountantSupport;
    }

    public void setManager(Employee manager){
        this.manager=manager;
    }

    public boolean equals(Employee other){
        //Should return true if the two employee IDs are the same, false otherwise
        return this.getEmployeeId()==other.getEmployeeId();
    }

    public String toString(){
        //Should return a String representation of the employee that is a combination of their id followed by their name.
        // Example: "1 Kasey"
        return getEmployeeId()+" "+getName();
    }

    public abstract String employeeStatus();

    public void getBonus(){

    }

}
}
