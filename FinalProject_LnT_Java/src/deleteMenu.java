import java.awt.*;

public class deleteMenu extends JFrame implements ActionListener, MouseListener{
	
	private static final long serialVersionUID = 1L;

	Font font = new Font("Bookman Old Style", Font.BOLD, 30);
	
	private JButton cancelButton = new JButton("Cancel");
	private JButton deleteButton = new JButton("Delete");
	
	JTable table;
	JButton buttonDelete;
	String id ="",
		   menu ="";
		
	public deleteMenu() {
		initDelete();
	}
	
	private void initDelete() {
		setTitle("BobaCool");
		setSize(600,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setResizable(false);
		
		initDeleteTitle();
		initData();
		initComponent();
		
		setLocation(450,150);
		setVisible(true);
	}
	
	private void initDeleteTitle() {
		JLabel deleteTittleLabel = new JLabel("Delete Menu");
		deleteTittleLabel.setHorizontalAlignment(JLabel.CENTER);
		deleteTittleLabel.setFont(font);
		add(deleteTittleLabel, BorderLayout.NORTH);
	}
	
	private void initData() {
		databaseController data = new databaseController();
		Vector<String> columns = new Vector<>();
		
		columns.add("kode");
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
	
	private void initComponent() {
		JPanel deleteButtonPanel = new JPanel();
		deleteButtonPanel.setLayout(new GridLayout(1,2));
		
		deleteButtonPanel.add(cancelButton);
		deleteButtonPanel.add(deleteButton);
		
		cancelButton.addActionListener(this);
		deleteButton.addActionListener(this);
		
		add(deleteButtonPanel, BorderLayout.SOUTH);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(deleteButton)) {
			if(id.equals("")) {
				JOptionPane.showMessageDialog(null, "Pilih data yang ingin dihapus: ");
			}
			else {
				databaseController controller = new databaseController();
				controller.deleteElementDatabase(id);
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