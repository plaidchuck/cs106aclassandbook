import acm.gui.*;
import acm.program.*;
import acm.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends Program {
	
	public void init() {
		setLayout(new TableLayout(5, 4));
		display = new CalculatorDisplay();
		add(display, "gridwidth=4 height=" + BUTTON_SIZE);
		addButtons();
		addActionListeners();
	}
	
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source instanceof CalculatorButton) {
			((CalculatorButton) source).action(display);
		}
	}
	
	private void addButtons() {
		String constraint = "width=" + BUTTON_SIZE + " height=" + BUTTON_SIZE;
		add(new DigitButton(7), constraint);
		add(new DigitButton(8), constraint);
		add(new DigitButton(9), constraint);
		add(new AddButton(), constraint);
		add(new DigitButton(4), constraint);
		add(new DigitButton(5), constraint);
		add(new DigitButton(6), constraint);
		add(new SubtractButton(), constraint);
		add(new DigitButton(1), constraint);
		add(new DigitButton(2), constraint);
		add(new DigitButton(3), constraint);
		add(new MultiplyButton(), constraint);
		add(new ClearButton(), constraint);
		add(new DigitButton(0), constraint);
		add(new EqualsButton(), constraint);
		add(new DivideButton(), constraint);
	}
	
	private static final int BUTTON_SIZE = 60;
	private CalculatorDisplay display;
}

class CalculatorDisplay extends IntField {
	
	public CalculatorDisplay() {
		setEditable(false);
		setFont(new Font("Arial", Font.PLAIN, 24));
		setValue(0);
		startNewValue = false;
		op = null;
	}
	
	public void addDigit(int digit) {
		int value = (startNewValue) ? 0 : getValue();
		setValue(10 * value + digit);
		startNewValue = false;
	}

	public void setOperator(OperatorButton button) {
		if (op == null ) {
			memory = getValue();
		} else {
			memory = op.apply(memory, getValue());
			setValue(memory);
		}
		op = button;
		startNewValue = true;
	}
	
	private OperatorButton op;
	private int memory;
	private boolean startNewValue;
}

abstract class CalculatorButton extends JButton {
	
	public CalculatorButton(String name) {
		super(name);
		setFont(new Font ("SansSerif", Font.PLAIN, 24));
	}
	
	public abstract void action(CalculatorDisplay display);
}

class DigitButton extends CalculatorButton {
	
	public DigitButton(int n) {
		super("" + n);
	}
	
	public void action(CalculatorDisplay display) {
		display.addDigit(Integer.parseInt(getText()));
	}
}

abstract class OperatorButton extends CalculatorButton {
	
	public OperatorButton(String name) {
		super(name);
	}
	

	public void action(CalculatorDisplay display) {
		display.setOperator(this);
	}

	public abstract int apply(int lhs, int rhs);
	
}

class AddButton extends OperatorButton {
	
	public AddButton() {
		super("+");
	}
	
	public int apply(int lhs, int rhs) {
		return lhs + rhs;
	}
}

class SubtractButton extends OperatorButton {
	
	public SubtractButton() {
		super("-");
	}
	
	public int apply(int lhs, int rhs) {
		return lhs - rhs;
	}
}

class MultiplyButton extends OperatorButton {
	
	public MultiplyButton() {
		super("x");
	}
	
	public int apply(int lhs, int rhs) {
		return lhs * rhs;
	}
}

class DivideButton extends OperatorButton {
	
	public DivideButton() {
		super("/");
	}
	
	public int apply(int lhs, int rhs) {
		return lhs / rhs;
	}
}

class EqualsButton extends CalculatorButton {
	
	public EqualsButton() {
		super("=");
	}

	@Override
	public void action(CalculatorDisplay display) {
		display.setOperator(null);
		
	}
}

class ClearButton extends CalculatorButton {
	
	public ClearButton() {
		super("C");
	}
	
	@Override
	public void action(CalculatorDisplay display) {
		display.setOperator(null);
		display.setValue(0);
	}
}
