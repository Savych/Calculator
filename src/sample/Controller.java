package sample;

import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    private float fNumber;
    private float sNumber;
    private String operation;
    private String value;

    public TextField input;
    public Label prom;

    public void clickNum(ActionEvent event) {
        value = input.getText();
        input.setText(value + ((Button)event.getSource()).getText());
    }
    public void clickOperator(ActionEvent event) {
        value = input.getText();
        fNumber = Float.parseFloat(value);
        input.setText("");
        operation = ((Button)event.getSource()).getText();
        prom.setText(value + " " + operation);
    }
    public void equalClick() {
        switch (operation) {
            case "+":
                equalCase();
                input.setText(String.valueOf(fNumber + sNumber));
                break;
            case "-":
                equalCase();
                input.setText(String.valueOf(fNumber - sNumber));
                break;
            case "/":
                equalCase();
                if(!(sNumber == 0))
                    input.setText(String.valueOf(fNumber / sNumber));
                else
                    input.setText("На ноль делить нельзя!");
                break;
            case "X":
                equalCase();
                input.setText(String.valueOf(fNumber * sNumber));
                break;
            case "%":
                equalCase();
                input.setText(String.valueOf(sNumber / 100 * fNumber));
                break;
        }
    }
    public void clearClick() {
        input.setText("");
        prom.setText("");
        fNumber = 0;
        sNumber = 0;
    }
    public void plusorClick() {
        value = input.getText();
        input.setText(String.valueOf(0-Float.parseFloat(value)));
    }
    public void rootClick() {
        value = input.getText();
        input.setText(String.valueOf(Math.sqrt(Float.parseFloat(value))));
        prom.setText("√" + value + " =");
    }
    private void equalCase() {
        value = input.getText();
        sNumber = Float.parseFloat(value);
        prom.setText(prom.getText() + " " + value + " =");
    }
}