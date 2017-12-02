package application;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MainController {
	private Forms forms = new Forms ();
	private static int id;
	@FXML
	private TextField textfield;
	public void processInput (ActionEvent event) {
		String buttonText = ((Button)event.getSource()).getText();
		String textfieldText = textfield.getText();
		textfieldText += buttonText;
		textfield.setText(textfieldText);
	}
	public void processEnter (ActionEvent event) {
		try {
			id = new DatabaseConnection().loginPinNumber(textfield.getText());
			if (id != 0) {
				forms.callForm("/application/choose.fxml");
			} else {
				JOptionPane.showMessageDialog(null, "Invalid!");
			}
		} catch (Exception ex1) {
			
		}
	}
	public void processWithdraw (ActionEvent event) {
		forms.callForm("/application/withdraw.fxml");
	}
	public void processChequing (ActionEvent event) {
		forms.callForm("/application/amount.fxml");
	}
	public void processAmount (ActionEvent event) throws SQLException, Exception { 
		if (new DatabaseConnection().checkIfEnable(id)) {
			JOptionPane.showMessageDialog(null, "Successful");
		} else {
			JOptionPane.showMessageDialog(null, "Unsuccessful");
		}
	}
}
