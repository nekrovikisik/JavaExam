package com.example.javafx_demo.controller;
import com.example.javafx_demo.DataBase.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class RouteController {
    @FXML
    private TextField pathInput;
    @FXML
    private Text outputText;
    @FXML

    protected void handleSubmitButtonAction(ActionEvent event) {
        String filename = pathInput.getText();
        String outputStr;

        try {
            File file = new File(filename);
            Scanner fileScanner = new Scanner(file);

            double sum = 0;
            int count = 0;

            while (fileScanner.hasNextDouble()) {
                double number = fileScanner.nextDouble();
                sum += number;
                count++;
            }

            if (count > 0) {
                double average = sum / count;
//                System.out.println("Среднее арифметическое: " + average);
                outputStr = "Среднее арифметическое: " + String.valueOf(average);
            } else {
                System.out.println("Файл пуст или не содержит чисел.");
                outputStr = "Файл пуст или не содержит чисел.";
            }

            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + filename);
            outputStr = "Файл не найден";
        }
        outputText.setText(outputStr);

    }

}

