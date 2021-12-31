import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

	// Initialize the variables {
	JFrame frame;
	JTextField textField;
	JButton[] numbers = new JButton[10];
	JButton[] operators = new JButton[6];
	JButton[] functions = new JButton[8];
	JButton addBtn, subBtn, mulBtn, divBtn, negBtn, decBtn;
	JButton entrBtn, delBtn, caBtn, ceBtn, maBtn, mrBtn, msBtn, mcBtn;
	JPanel numPanel;
	JPanel funcPanel;
	
	Font font = new Font("Ink Free", Font.BOLD, 30);
	
	double num1 = 0, num2 = 0, result = 0;
	char operator;
	double memory;
	// }
	
	Calculator() {
		
		// Set up the window {
		frame = new JFrame("Java Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(670, 550);
		frame.setLayout(null);
		// }
		
		// Set up the display {
		textField = new JTextField();
		textField.setBounds(50, 25, 550, 50);
		textField.setFont(font);
		textField.setEditable(false);
		frame.add(textField);
		// }
		
		// Set up the operator buttons {
		addBtn = new JButton("+");
		subBtn = new JButton("-");
		mulBtn = new JButton("*");
		divBtn = new JButton("/");
		negBtn = new JButton("(-)");
		decBtn = new JButton(".");
		
		operators[0] = addBtn;
		operators[1] = subBtn;
		operators[2] = mulBtn;
		operators[3] = divBtn;
		operators[4] = negBtn;
		operators[5] = decBtn;
		
		for (int i = 0; i < 6; i++) {
			operators[i].addActionListener(this);
			operators[i].setFont(font);
			operators[i].setFocusable(false);
		}
		// }
		
		// Set up the number buttons {
		for (int i = 0; i < 10; i++) {
			
			numbers[i] = new JButton(String.valueOf(i));
			numbers[i].addActionListener(this);
			numbers[i].setFont(font);
			numbers[i].setFocusable(false);
		}
		// }
		
		// Set up the function buttons {
		entrBtn = new JButton("=");
		delBtn = new JButton("Del");
		caBtn = new JButton("CA");
		ceBtn = new JButton("CE");
		maBtn = new JButton("MA");
		mrBtn = new JButton("MR");
		msBtn = new JButton("MS");
		mcBtn = new JButton("MC");
		
		functions[0] = entrBtn;
		functions[1] = delBtn;
		functions[2] = caBtn;
		functions[3] = ceBtn;
		functions[4] = maBtn;
		functions[5] = mrBtn;
		functions[6] = msBtn;
		functions[7] = mcBtn;
		
		for (int i = 0; i < 8; i++) {
			functions[i].addActionListener(this);
			functions[i].setFont(font);
			functions[i].setFocusable(false);
		}
		// }
		
		// Add the buttons to the window {
		numPanel = new JPanel();
		numPanel.setBounds(50, 100, 550, 300);
		numPanel.setLayout(new GridLayout(4, 6, 10, 10));
		
		numPanel.add(numbers[1]);
		numPanel.add(numbers[2]);
		numPanel.add(numbers[3]);
		numPanel.add(addBtn);
		numPanel.add(maBtn);
		numPanel.add(msBtn);
		numPanel.add(numbers[4]);
		numPanel.add(numbers[5]);
		numPanel.add(numbers[6]);
		numPanel.add(subBtn);
		numPanel.add(mrBtn);
		numPanel.add(mcBtn);
		numPanel.add(numbers[7]);
		numPanel.add(numbers[8]);
		numPanel.add(numbers[9]);
		numPanel.add(mulBtn);
		numPanel.add(entrBtn);
		numPanel.add(delBtn);
		numPanel.add(decBtn);
		numPanel.add(numbers[0]);
		numPanel.add(negBtn);
		numPanel.add(divBtn);
		numPanel.add(ceBtn);
		numPanel.add(caBtn);
		
		frame.add(numPanel);
		// }
		
		// Shows the final window {
		frame.setVisible(true);
		// }
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for (int i = 0; i < 10; i++) {
			if (e.getSource() == numbers[i]) {
				textField.setText(textField.getText().concat(String.valueOf(i)));
			}
		}
		
		if (e.getSource() == decBtn) {
			int decNum = 0;
			
			for (int i = 0; i < textField.getText().length(); i++) {
				if (textField.getText().split("")[i] == ".") {
					decNum++;
				}
			}
			
			if (decNum == 0) {
				textField.setText(textField.getText().concat("."));
			}
		}
		
		if (e.getSource() == negBtn) {
			textField.setText(textField.getText().concat("-"));
		}
		
		if (e.getSource() == addBtn) {
			num1 = Double.parseDouble(textField.getText());
			operator = '+';
			textField.setText("");
		}
		
		if (e.getSource() == subBtn) {
			num1 = Double.parseDouble(textField.getText());
			operator = '-';
			textField.setText("");
		}
		
		if (e.getSource() == mulBtn) {
			num1 = Double.parseDouble(textField.getText());
			operator = '*';
			textField.setText("");
		}
		
		if (e.getSource() == divBtn) {
			num1 = Double.parseDouble(textField.getText());
			operator = '/';
			textField.setText("");
		}
		
		if (e.getSource() == entrBtn) {
			num2 = Double.parseDouble(textField.getText());
			
			switch (operator) {
			case '+':
				result = num1 + num2;
				break;
			case '-':
				result = num1 - num2;
				break;
			case '*':
				result = num1 * num2;
				break;
			case '/':
				result = num1 / num2;
				break;
			}
			
			textField.setText(String.valueOf(result));
			num1 = result;
		}
		
		if (e.getSource() == caBtn) {
			textField.setText("");
			num1 = 0;
			num2 = 0;
		}
		
		if (e.getSource() == ceBtn) {
			textField.setText("");
		}
		
		if (e.getSource() == maBtn) {
			memory += result;
		}
		
		if (e.getSource() == msBtn) {
			memory -= result;
		}
		
		if (e.getSource() == mrBtn) {
			textField.setText(String.valueOf(memory));
		}
		
		if (e.getSource() == mcBtn) {
			memory = 0;
		}
		
		if (e.getSource() == delBtn) {
			String string = textField.getText();
			textField.setText("");
			
			for (int i = 0; i < string.length() - 1; i++) {
				textField.setText(textField.getText() + string.charAt(i));
			}
		}
		
	}

}
