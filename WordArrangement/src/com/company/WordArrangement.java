package com.company;

/* AUTHOR ALICJA KANAFA
* created 02/03/2021*/

import java.util.Scanner; // import scanner class in order to take user input
import java.util.Arrays; // import arrays from java utilities
import java.util.Comparator; // import a comparator in order to sort an array by char length

public class WordArrangement {

    private Scanner scan; // defines scan as type scanner
    private String keyboardInput; // defines string input from user's keyboard

    private int maximumWords = 20; // putting in an output

    public static void main(String[] args) {
        WordArrangement sortWords = new WordArrangement();
        sortWords.start();
    }

    private void start() {
        this.userInput();
    }

    private void userInput() {
        scan = new Scanner(System.in); // creates a scanner instance to take keyboard input
        System.out.println("Please enter in a sentence of less than 20 words."); // asking user to write in a sentence
        String keyboardInput = scan.nextLine(); // this will assign the 'input' pointer to whatever the user enters via
        // keyboard
        this.arrangeDescending();
    }

    private void arrangeDescending() {
        String[] wordsByKeys;
        wordsByKeys = keyboardInput.split(""); // splits the sentence into individual words
        // on display
        Arrays.sort(wordsByKeys, Comparator.comparingInt(String::length));
        for (int i =0; i < wordsByKeys.length; i++) //For statement in order to print words in a new line
            {
                String wordDisplay = wordsByKeys[i];
                System.out.println(wordDisplay); // displays in order of character length to the user
            }
        }

    }
