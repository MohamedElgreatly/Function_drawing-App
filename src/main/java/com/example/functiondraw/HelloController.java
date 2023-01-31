package com.example.functiondraw;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController {
    @FXML
    private LineChart<?, ?> lineChart;
    @FXML
    private TextField TextResult;


    @FXML
    public void Evaluate(ActionEvent event) throws Exception {
        String function =TextResult.getText();
        String Expression="";
        XYChart.Series series = new XYChart.Series();
        for(int i=0;i<100;i++)
        {
            for(int j=0;j<function.length();j++)
            {
               if(function.charAt(j)=='x'||function.charAt(j)=='X')
               {
                   Expression+=String.valueOf(i);
               }
               else if(function.charAt(j)=='*')
               {
                   Expression+="x";
               }
               else {
                   Expression += function.charAt(j);
               }
            }
            String result =Main_Algorithm.Calculator(Expression);
            if(result=="Error")
            {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.show();
            }else {
                int y = Integer.parseInt(result);
                series.getData().add(new XYChart.Data(String.valueOf(i), y));
                lineChart.getData().add(series);
            }
            Expression="";
        }
        lineChart.getData().add(series);
    }

}


