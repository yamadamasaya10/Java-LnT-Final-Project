import java.awt.BorderLayout;

public class updateData extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;

	Font font = new Font("Bookman Old Style", Font.BOLD, 30);

	JLabel idL = new JLabel("id menu: ");
	JTextField idTF = new JTextField();
	
	JLabel namaL = new JLabel("nama menu: ");
	JTextField namaTF = new JTextField();

	JLabel hargaL = new JLabel("harga menu: ");
	JTextField hargaTF = new JTextField();

	JLabel stokL = new JLabel("stok menu: ");
	JTextField stokTF = new JTextField();

	JButton submitButton = new JButton("Submit");
	JButton backButton = new JButton("Back");

	public updateData() {
		initUpdateData();
	}
	
	public void initForm(String id, String nama, String harga, String stok) {
		idTF.setText(id);
		namaTF.setText(nama);
		hargaTF.setText(harga);
		stokTF.setText(stok);
	}
	
	private void initUpdateData() {
		setTitle("BobaCool");
		setSize(600,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setResizable(false);
		
		updateDataTitle();
		updateDataComponent();
		
		setLocation(450,150);
		setVisible(true);
	}
	
	private void updateDataTitle() {
		JLabel updateDataTittleLabel = new JLabel("Insert New Menu");
		updateDataTittleLabel.setHorizontalAlignment(JLabel.CENTER);
		updateDataTittleLabel.setFont(font);
		add(updateDataTittleLabel, BorderLayout.NORTH);
	}
	
	private void updateDataComponent() {
		JPanel insertDataComponentPanel = new JPanel();
		insertDataComponentPanel.setLayout(new GridLayout(4,2));
		

		insertDataComponentPanel.add(namaL);
		insertDataComponentPanel.add(namaTF);
		
		insertDataComponentPanel.add(hargaL);
		insertDataComponentPanel.add(hargaTF);
		
		insertDataComponentPanel.add(stokL);
		insertDataComponentPanel.add(stokTF);
		
		insertDataComponentPanel.add(backButton);
		insertDataComponentPanel.add(submitButton);
		
		add(insertDataComponentPanel);
		
		submitButton.addActionListener(this);
		backButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(submitButton)) {
			databaseController controller = new databaseController();
			controller.updateElementDatabase(namaTF.getText(), namaTF.getText(), hargaTF.getText(), stokTF.getText());
		}
		else if(e.getSource().equals(backButton)){
			new Main();
			setVisible(false);
		}
	}
}