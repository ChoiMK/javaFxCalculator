package application;

import java.net.URL;
import java.sql.Savepoint;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MainController implements Initializable{

	@FXML private Button button_1;
	@FXML private Button button_2;
	@FXML private Button button_3;
	@FXML private Button button_4;
	@FXML private Button button_5;
	@FXML private Button button_6;
	@FXML private Button button_7;
	@FXML private Button button_8;
	@FXML private Button button_9;
	@FXML private Button button_0;
	@FXML private Button button_dot;
	@FXML private Button button_divide;
	@FXML private Button button_multiple;
	@FXML private Button button_minus;
	@FXML private Button button_plus;
	@FXML private Button button_clear;
	@FXML private Button button_equal;
	@FXML private TextField textField_calculator;
	
	private boolean isInitialize = true;
	private double saveNumber;
	private String saveOperator;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
	@FXML
	public void onclickButton(ActionEvent event){

		String btnText = ((Button)event.getTarget()).getText();
		
		switch(btnText){
		case "0" :
		case "1" :
		case "2" :
		case "3" :
		case "4" :
		case "5" :
		case "6" :
		case "7" :
		case "8" :
		case "9" :
		case "." :
				addNumber(btnText);
				break;
		case "/" :
		case "*" :
		case "+" :
		case "-" :
		case "=" :
				calculate(btnText);
				break;
		case "c" :
			 isInitialize = true;
			 saveNumber=0;
			 saveOperator=null;
			 textField_calculator.setText("");
		
		}
		
}
	
	public void addNumber(String btnText){
		if(isInitialize){
			textField_calculator.setText(btnText);
		}else{
			textField_calculator.setText(textField_calculator.getText()+btnText);
		}
		isInitialize = false;
		
	}
	
	public void calculate(String opt){
		if(saveOperator!=null){
		
		switch(saveOperator){
		case  "/":
			saveNumber=saveNumber / Double.parseDouble(textField_calculator.getText());
			break;
		case  "*":
			saveNumber=saveNumber * Double.parseDouble(textField_calculator.getText());
			break;
		case  "+":
			saveNumber=saveNumber + Double.parseDouble(textField_calculator.getText());
			break;
		case  "-":
			saveNumber=saveNumber - Double.parseDouble(textField_calculator.getText());
			break;
		}
		
		long a = (long)saveNumber;
		if(saveNumber-a!=0){
			textField_calculator.setText(saveNumber+"");
		}else{
			textField_calculator.setText(a+"");
		}
		
	}
		
		saveNumber=Double.parseDouble(textField_calculator.getText());	
		saveOperator = opt;
		isInitialize = true;
		
	}
		
}
