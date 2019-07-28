
package com.mycompany.LibraryCatalogue;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author kartik.juneja
 */
public class LibraryCatalogue {
    
    //Properties/Fields/GlobalVariables
    Map<String,Book> bookCollection = new HashMap<String,Book>();
    int currentDay = 0;
    int lengthOfCheckoutPeriod = 7;
    double initialLateFee = 0.50;
    double feePerLateDay = 1.00;
    
    //Constructors
    public LibraryCatalogue(Map<String,Book> collection){
        this.bookCollection = collection;
    }
    
    public LibraryCatalogue(Map<String,Book> collection,int lengthOfCheckOutPeriod,
            double initialLateFee,double feePerLateDay){
        this.bookCollection = collection;
        this.lengthOfCheckoutPeriod = lengthOfCheckOutPeriod;
        this.initialLateFee = initialLateFee;
        this.feePerLateDay = feePerLateDay;
    }
    
    //Getters
    public int getCurrentDay(){
        return this.currentDay;
    }
    
    public Map<String,Book> getBookCollection(){
        return this.bookCollection;
    }
    
    public Book getBook(String bookTitle){
        return getBookCollection().get(bookTitle);
    }
    
    public int getLengthOfCheckoutPeriod(){
        return this.lengthOfCheckoutPeriod;
    }
    
    public double getInitialLateFee(){
        return this.initialLateFee;
    }
    
    public double getFeePerLateDay(){
        return this.feePerLateDay;
    }
    
    //Setters
    public void nextDay(){
        currentDay++;
    }
    
    public void setDay(int day){
        currentDay = day;
    }
    
    //INSTANCE_METHODS
    
    public void checkOutBook(String title){
        Book book = getBook(title);
        if(book.getIsCheckedOut()){
            sorryBookAlreadyCheckedOut(book);
        } else {
            book.setIsCheckedOut(true, currentDay);
            System.out.println("You Just Checked Out " + title + ". It is due on day " + 
                    (getCurrentDay()+getLengthOfCheckoutPeriod()) + ".");
        }
    }
    
    public void returnBook(String title){
        Book book = getBook(title);
        int daysLate = currentDay - (book.getDayCheckedOut() + getLengthOfCheckoutPeriod());
        if(daysLate > 0){
           System.out.println("You owe the library $ " +(getInitialLateFee() + daysLate * getFeePerLateDay()) 
                   + " because your book is " + daysLate + " days overdue.");
        } else {
            System.out.println("Book Returned . Thank you.");
        }
        book.setIsCheckedOut(false, -1);
    }
    
    public void sorryBookAlreadyCheckedOut(Book book){
        System.out.println("Sorry " + book.getTitle() + " is already checked out. " 
        + "It should be back on day " + (book.getDayCheckedOut() + getLengthOfCheckoutPeriod()) + ".");
    }
    
    //MAIN_METHOD
    public static void main(String[] args){
        
        Map<String,Book> bookCollection = new HashMap<>();
        Book book = new Book("Harry Potter", 76000 , 740700);
        bookCollection.put("Harry Potter", book);
        LibraryCatalogue lib = new LibraryCatalogue(bookCollection);
        lib.checkOutBook("Harry Potter");
        lib.nextDay();
        lib.nextDay();
        lib.nextDay();
        lib.checkOutBook("Harry Potter");
        lib.setDay(17);
        lib.returnBook("Harry Potter");
        lib.checkOutBook("Harry Potter");
    }
}
