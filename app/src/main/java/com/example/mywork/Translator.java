package com.example.mywork;

public class Translator {



    private String name;
    private int rate;
    private String language;
    private String field;
    private String bio;
    private String education;
    private String phone ;
    private String email ;
    private String providedLanguage;


    public Translator() { }


    public Translator(String name, int rate, String language, String field, String bio, String education, String providedLanguage,String email,String phone) {

        this.name = name;
        this.rate = rate;
        this.language = language;
        this.field = field;
        this.bio = bio;
        this.education = education;
        this.providedLanguage = providedLanguage;
        this.email=email ;
        this.phone=phone ;



    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getProvidedLanguage() {
        return providedLanguage;
    }

    public void setProvidedLanguage(String providedLanguage) {
        this.providedLanguage = providedLanguage;
    }
}
