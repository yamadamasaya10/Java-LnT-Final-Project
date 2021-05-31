import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Database.databaseController;

public class viewMenu extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	Font font = new Font("Bookman Old Style", Font.BOLD, 30);
	
	JButton backButton = new JButton("Back"); 
	
	public viewMenu(){
		initView();
	}
	
	private void initView() {
		setTitle("BobaCool");
		setSize(600,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setResizable(false);
		
		initViewTitle();
		initData();
		initButton();
		
		setLocation(450,150);
		setVisible(true);
	}
	
	private void initViewTitle() {
		JLabel viewTitleLabel = new JLabel("View Data");
		viewTitleLabel.setHorizontalAlignment(JLabel.CENTER);
		viewTitleLabel.setFont(font);
		add(viewTitleLabel, BorderLayout.NORTH);
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
		JTable table = new JTable(tableModel);
		table.isCellEditable(0,0);
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane);
	}
	
	private void initButton() {
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1,1));
		buttonPanel.add(backButton);
		add(buttonPanel, BorderLayout.SOUTH);
		backButton.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(backButton)){
			new Main();
			setVisible(false);
		}
	}
}