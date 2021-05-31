import java.awt.*;

public class insertMenu extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 2L;
	
	Font font = new Font("Bookman Old Style", Font.BOLD, 30);
	
	JLabel namaL = new JLabel("nama menu: ");
	JTextField namaTF = new JTextField();
	
	JLabel hargaL = new JLabel("harga menu: ");
	JTextField hargaTF = new JTextField();
	
	JLabel stokL = new JLabel("stok menu: ");
	JTextField stokTF = new JTextField();
	
	JButton submitButton = new JButton("Submit");
	JButton cancelButton = new JButton ("Cancel");
	
	public insertMenu() {
		initInsertFrame();
	}
	
	private void initInsertFrame() {
		setTitle("BobaCool");
		setSize(600,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setResizable(false);
		
		initInsertMenuTitle();
		initInsertComponent();
		
		setLocation(450,150);
		setVisible(true);
	}
	
	private void initInsertMenuTitle() {
		JLabel InsertMenuTittleLabel = new JLabel("Insert New Menu");
		InsertMenuTittleLabel.setHorizontalAlignment(JLabel.CENTER);
		InsertMenuTittleLabel.setFont(font);
		add(InsertMenuTittleLabel, BorderLayout.NORTH);
	}
	
	private void initInsertComponent() {
		JPanel insertComponentPanel = new JPanel();
		insertComponentPanel.setLayout(new GridLayout(4,2));
		
		insertComponentPanel.add(namaL);
		insertComponentPanel.add(namaTF);
		
		insertComponentPanel.add(hargaL);
		insertComponentPanel.add(hargaTF);
		
		insertComponentPanel.add(stokL);
		insertComponentPanel.add(stokTF);
		
		insertComponentPanel.add(cancelButton);
		insertComponentPanel.add(submitButton);
		
		add(insertComponentPanel);
		
		submitButton.addActionListener(this);
		cancelButton.addActionListener(this);
		
	}
	
	private String createRandomCode(JTextField namaTFget) {
		
		Random randInt = new Random();
		
		String casterTextFieldtoString ="";
		casterTextFieldtoString = namaTFget.getText();
		
		int randId1 = randInt.nextInt(9);
		int randId2 = randInt.nextInt(9);
		int randId3 = randInt.nextInt(9);
		
		String id = casterTextFieldtoString.substring(0,2);
		id = id.toUpperCase();
		id = id + "-"+randId1 + randId2 + randId3;
		
		return id;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(submitButton)) {
			databaseController controller = new databaseController();
			controller.createNewElementDatabase(createRandomCode(namaTF), namaTF.getText(), hargaTF.getText(), stokTF.getText());
			namaTF.setText(null);
			hargaTF.setText(null);
			stokTF.setText(null);
		}
		else if(e.getSource().equals(cancelButton)){
			new Main();
			setVisible(false);
		}
	}

}