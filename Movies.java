package com.mycompany.movies;

public class Movies {

    //Attributes
    private String Code;
    private String Title;
    private String RYear;
    private String Duration;
    private String Director;
    private String Category;
    
    //setters
    public void setCode(String Code){
        this.Code = Code;
    }
    public void setTitle(String Title){
        this.Title = Title;
    }
    public void setRYear(String RYear){
        this.RYear = RYear;
    }
    public void setDuration(String Duration){
        this.Duration = Duration;
    }
    public void setDirector(String Director){
        this.Director = Director;
    }
    public void setCategory(String Category){
        this.Category = Category;
    }
    
    //getters
    public String getCode(){
        return this.Code;
    }
    public String getTitle(){
        return this.Title;
    }
    public String getRYear(){
        return this.RYear;
    }
    public String getDuration(){
        return this.Duration;
    }
    public String getDirector(){
        return this.Director;
    }
    public String getCategory(){
        return this.Category;
    }
}
