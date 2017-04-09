package auto.amazon;

import java.awt.*; // Using AWT container and component classes
import java.awt.event.*; // Using AWT event classes and listener interfaces
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

// An AWT program inherits from the top-level container java.awt.Frame
public class AutoMain extends Frame implements ActionListener {

	private Label lblCount; // Declare a Label component
	private TextField email; // Declare a TextField component
	private TextField password;
	private TextField link;

	private Button btnCount; // Declare a Button component
	private int count = 0; // Counter's value

	private Button exitBtn;

	// Constructor to setup GUI components and event handlers
	public AutoMain() {
		setLayout(new FlowLayout());

		// email
		lblCount = new Label("Email"); // construct the Label component
		add(lblCount); // "super" Frame container adds Label component
		email = new TextField("", 30); // construct the TextField component
		email.setEditable(true); // set to read-only
		add(email); // "super" Frame container adds TextField component

		// password
		lblCount = new Label("Password"); // construct the Label component
		add(lblCount);
		password = new TextField("", 30);
		email.setEditable(true);
		add(password);

		// link
		lblCount = new Label("Link"); // construct the Label component
		add(lblCount);
		link = new TextField("", 30);
		link.setEditable(true);
		add(link);

		// hit button
		btnCount = new Button("Hit !!!"); // construct the Button component
		add(btnCount); // "super" Frame container adds Button component
		btnCount.addActionListener(this);

		// window cross button
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});

		// window size and
		setTitle("Automation App"); // "super" Frame sets its title
		setSize(270, 300); // "super" Frame sets its initial window size

		setVisible(true); // "super" Frame shows

	}

	public AutoMain(String info) {

	}

	// The entry main() method
	public static void main(String[] args) {
		// Invoke the constructor to setup the GUI, by allocating an instance
		AutoMain app = new AutoMain();

	}

	// ActionEvent handler - Called back upon button-click.
	@Override
	public void actionPerformed(ActionEvent evt) {

		Scanner s = null;
		try {
			s = new Scanner(new File("/home/bappy/hello.txt"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		ArrayList<String> emailList = new ArrayList<String>();
		try {
			while (s.hasNextLine()) {
				emailList.add(s.next());
			}
		} catch (NoSuchElementException e) {
			System.out.println("No such elements");
		}
		
		s.close();
		
		for (String email : emailList) {
			System.out.println(email);
			AutoAma autoAma = new AutoAma();
			autoAma.automationTools(email, password.getText(), link.getText());
			
		}
		
		
		
		
//		AutoAma autoAma = new AutoAma();
//		String email1 = email.getText();
//		String password1 = password.getText();
//		autoAma.automationTools(email.getText(), password.getText(), link.getText());

	}

}