import java.awt.*;

public class updateMenu extends JFrame implements ActionListener, MouseListener{
	
	private static final long serialVersionUID = 1L;

	Font font = new Font("Bookman Old Style", Font.BOLD, 30);
	
	private JButton cancelButton = new JButton("Cancel");
	private JButton updateButton = new JButton("Update");
	
	JTable table;
	String id ="",
		   menu ="",
		   harga ="",
		   stok ="";
	
	public updateMenu() {
		initUpdate();
	}
	
	private void initUpdate() {
		setTitle("BobaCool");
		setSize(600,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setResizable(false);
		
		updateMenuTitle();
		initData();
		updateMenuComponent();
		
		setLocation(450,150);
		setVisible(true);
	}
	
	private void updateMenuTitle() {
		JLabel updateMenuTittleLabel = new JLabel("Update Menu");
		updateMenuTittleLabel.setHorizontalAlignment(JLabel.CENTER);
		updateMenuTittleLabel.setFont(font);
		add(updateMenuTittleLabel, BorderLayout.NORTH);
	}
	
	private void initData() {
		databaseController data = new databaseController();
		Vector<String> columns = new Vector<>();
		
		columns.add("id");
		columns.add("nama");
		columns.add("harga");
		columns.add("stok");
		
		
		DefaultTableModel tableModel = new DefaultTableModel(data.getMenuData(), columns) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table = new JTable(tableModel);
		table.isCellEditable(0,0);
		table.addMouseListener(this);
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane);
	}
	
	private void updateMenuComponent() {
		JPanel deleteButtonPanel = new JPanel();
		deleteButtonPanel.setLayout(new GridLayout(1,2));
		
		deleteButtonPanel.add(cancelButton);
		deleteButtonPanel.add(updateButton);
		
		cancelButton.addActionListener(this);
		updateButton.addActionListener(this);
		
		add(deleteButtonPanel, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(updateButton)) {
			if(id.equals("")) {
				JOptionPane.showMessageDialog(null, "Pilih data yang ingin diperbarui: ");
			}
			else {
				updateData then = new updateData();
				then.initForm(id, menu, harga, stok);
				setVisible(false);
				then.setVisible(true);
			}
		}
		else if(e.getSource().equals(cancelButton)){
			new Main();
			setVisible(false);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int DelId = table.getSelectedRow();
		System.out.println("Baris yang dipilih: " + DelId);
		id = table.getValueAt(DelId, 0).toString();
		menu = table.getValueAt(DelId, 1).toString();
		harga = table.getValueAt(DelId, 2).toString();
		stok = table.getValueAt(DelId, 3).toString();
		JOptionPane.showMessageDialog(null, "Selected "+ menu);
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}
}