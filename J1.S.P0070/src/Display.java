/*
 * Copyright 2022 DucPTMHE160517
 */


import java.util.ArrayList;

/**
 *
 * @author DucPTMHE160517
 */
class Display {

    void displayMenu() {
        ArrayList <String> languageList = new ArrayList <>();
        
        System.out.println("-------Login Program-------");
        languageList.add("1. Vietnamese");
        languageList.add("2. English");
        languageList.add("3. Exit");
        
        //Get each language in language list
        languageList.forEach(language -> {
            System.out.println(language);
        });
    }
    
}
