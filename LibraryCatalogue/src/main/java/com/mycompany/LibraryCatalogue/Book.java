
package com.mycompany.LibraryCatalogue;

/**
 *
 * @author kartik.juneja
 */
public class Book {
    
    //Properties, Fields, Global Variales
    String title;
    int pageCount;
    int ISBN;
    boolean isCheckedOut;
    int dayCheckedOut = -1;
    
    //Constructor
    public Book(String bookTitle,int bookPageCount,int bookISBN){
        
        this.title = bookTitle;
        this.pageCount = bookPageCount;
        this.ISBN = bookISBN;
        isCheckedOut = false;
    }
    
    //Getters
    public String getTitle(){
        return this.title;
    }
    
    public int getPageCount(){
        return this.pageCount;
    }
    
    public int getISBN(){
        return this.ISBN;
    }
    
    public boolean getIsCheckedOut(){
        return this.isCheckedOut;
    }
    
    public int getDayCheckedOut(){
        return this.dayCheckedOut;
    }
    
    //Setters
    public void setIsCheckedOut(boolean newIsCheckedOut,int currentDayCheckedOut){
        this.isCheckedOut = newIsCheckedOut;
        setDayCheckedOut(currentDayCheckedOut);
    }
    
    public void setDayCheckedOut(int day){
        this.dayCheckedOut = day;
    }
}
