import java.awt.*;

public class Main extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;

	Font font = new Font("Bookman Old Style", Font.BOLD, 30);
	
	JButton insertButton = new JButton("Insert New 	Menu");
	JButton viewButton = new JButton("View Menu");
	JButton updateButton = new JButton("Update Menu");
	JButton deleteButton = new JButton("Delete Menu");
	JButton exitButton = new JButton("Exit");
	
	public Main() {
		initMenu();
	}
	
	private void initMenu() {
		setTitle("BobaCool");
		setSize(600,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setResizable(false);
		
		initMenuTitle();
		initMenuElement();
		
		setLocation(450,150);
		setVisible(true);
	}
	
	private void initMenuTitle() {
		JLabel MenuTittleLabel = new JLabel("BobaCool");
		MenuTittleLabel.setHorizontalAlignment(JLabel.CENTER);
		MenuTittleLabel.setFont(font);
		add(MenuTittleLabel, BorderLayout.NORTH);
	}
	
	private void initMenuElement() {
		JPanel MenuElementPanel = new JPanel();
		MenuElementPanel.setLayout(new GridLayout(3,1));
		
		JPanel Menu1 = new JPanel();
		Menu1.setLayout(new GridLayout(1,2));
		Menu1.add(insertButton);
		Menu1.add(viewButton);
		
		JPanel Menu2 = new JPanel();
		Menu2.setLayout(new GridLayout(1,2));
		Menu2.add(updateButton);
		Menu2.add(deleteButton);
		
		JPanel Menu3 = new JPanel();
		Menu3.setLayout(new GridLayout(1,0));
		Menu3.add(exitButton);
		
		MenuElementPanel.add(Menu1);
		MenuElementPanel.add(Menu2);
		MenuElementPanel.add(Menu3);
		
		insertButton.addActionListener(this);
		viewButton.addActionListener(this);
		updateButton.addActionListener(this);
		deleteButton.addActionListener(this);
		exitButton.addActionListener(this);
		
		add(MenuElementPanel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(insertButton)){
			new insertMenu();
			setVisible(false);
		}
		else if(e.getSource().equals(viewButton)){
			new viewMenu();
			setVisible(false);
		}
		else if(e.getSource().equals(updateButton)){
			new updateMenu();
			setVisible(false);
		}
		else if(e.getSource().equals(deleteButton)){
			new deleteMenu();
			setVisible(false);
		}
		else if(e.getSource().equals(exitButton)){
			System.exit(0);
		}
	}
}