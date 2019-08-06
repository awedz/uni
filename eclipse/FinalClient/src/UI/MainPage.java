package UI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import Entities.UserType;

public class MainPage {
	//main components
	private JFrame f_mainFrame;
	private JTabbedPane tp_tabbed;//tab component
	private UserType ENUM_user;
	
	//monthly components
	private JPanel pnl_monthly;
	private JTable t_monthData;
	private JScrollPane sp_monthly;
	
	//monthly sum components
	private JPanel pnl_monthlySum;
	private JTable t_monthlySumData;
	private JScrollPane sp_monthlySum;
	
	
	
	public MainPage()
	{
		//user type from enum to determine if resident or committee
		//init main frame
		f_mainFrame = new JFrame();
		f_mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f_mainFrame.setMinimumSize(new Dimension(600, 600));
		
		tp_tabbed = new JTabbedPane();
		UserIsValidated(new IValidatedUser() {
			public boolean IsValidated()
			{
				return true;
			}
		});
		f_mainFrame.add(tp_tabbed,BorderLayout.CENTER);
	}
	
	
	
	
	
	
	
	
	
	
	
	public void InitResidentData()
	{
		
	}
	
	public void InitCommitteeData()
	{
		String[] monthlySumHeader = { "apt num", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
		String[][] monthlyData = { { "101", "Amit", "670000" }, { "102", "Jai", "780000" }, { "101", "Sachin", "700000" } };
		
				
		String monthlyHeader[] = { "ID", "NAME", "SALARY" };
		String monthlySumData[][] = ComData();
		
		t_monthData = new JTable(monthlyData,monthlyHeader);
		
		sp_monthly = new JScrollPane(t_monthData);
		pnl_monthly = new JPanel(new BorderLayout(1, 1));
		pnl_monthly.add(sp_monthly);
		tp_tabbed.addTab("monthly", pnl_monthly);
		
		t_monthlySumData = new JTable(monthlySumData,monthlySumHeader);
		sp_monthlySum = new JScrollPane(t_monthlySumData,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		t_monthlySumData.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		t_monthlySumData.setEnabled(false);
		pnl_monthlySum = new JPanel(new BorderLayout(1, 1));
		pnl_monthlySum.add(sp_monthlySum);
		
		
		tp_tabbed.addTab("monthly sum", pnl_monthlySum);
		

	}
	
	
	public void UserIsValidated(IValidatedUser callback)
	{

		InitCommitteeData();

		f_mainFrame.pack();
		f_mainFrame.setVisible(callback.IsValidated());
		//f_mainFrame.setVisible(true);
	}
	
	public String[][] ComData()
	{
		return new String[][]{
			{ "101", "1234324", "670000", "42345", "7458", "670000", "42345", "7458", "670000", "42345", "7458" },
			{ "101", "1234324", "670000", "42345", "7458", "670000", "42345", "7458", "670000", "42345", "7458" },
			{ "101", "1234324", "670000", "42345", "7458", "670000", "42345", "7458", "670000", "42345", "7458" },
			{ "101", "1234324", "670000", "42345", "7458", "670000", "42345", "7458", "670000", "42345", "7458" },
			{ "101", "1234324", "670000", "42345", "7458", "670000", "42345", "7458", "670000", "42345", "7458" },
			{ "101", "1234324", "670000", "42345", "7458", "670000", "42345", "7458", "670000", "42345", "7458" },
			{ "101", "1234324", "670000", "42345", "7458", "670000", "42345", "7458", "670000", "42345", "7458" },
			{ "101", "1234324", "670000", "42345", "7458", "670000", "42345", "7458", "670000", "42345", "7458" },
			{ "101", "1234324", "670000", "42345", "7458", "670000", "42345", "7458", "670000", "42345", "7458" },
			{ "101", "1234324", "670000", "42345", "7458", "670000","42345", "7458", "670000", "42345", "7458" },
			{ "101", "1234324", "670000", "42345", "7458", "670000", "42345", "7458", "670000", "42345", "7458" },
			{ "101", "1234324", "670000", "42345", "7458", "670000", "42345", "7458", "670000", "42345", "7458" },
			{ "101", "1234324", "670000", "42345", "7458", "670000", "42345", "7458", "670000", "42345", "7458" },
			{ "101", "1234324", "670000", "42345", "7458", "670000", "42345", "7458", "670000", "42345", "7458" },
			{ "101", "1234324", "670000", "42345", "7458", "670000", "42345", "7458", "670000", "42345", "7458" },
			{ "101", "1234324", "670000", "42345", "7458", "670000", "42345", "7458", "670000", "42345", "7458" },
			{ "101", "1234324", "670000", "42345", "7458", "670000", "42345", "7458", "670000", "42345", "7458" },
			{ "101", "1234324", "670000", "42345", "7458", "670000", "42345", "7458", "670000", "42345", "7458" },
			{ "101", "1234324", "670000", "42345", "7458", "670000", "42345", "7458", "670000", "42345", "7458" },
			{ "101", "1234324", "670000", "42345", "7458", "670000", "42345", "7458", "670000", "42345", "7458" },
			{ "101", "1234324", "670000", "42345", "7458", "670000", "42345", "7458", "670000", "42345", "7458" },
			{ "101", "1234324", "670000", "42345", "7458", "670000", "42345", "7458", "670000", "42345", "7458" },
			{ "101", "1234324", "670000", "42345", "7458", "670000", "42345", "7458", "670000", "42345", "7458" },
			{ "101", "1234324", "670000", "42345", "7458", "670000", "42345", "7458", "670000", "42345", "7458" },
			{ "101", "1234324", "670000", "42345", "7458", "670000", "42345", "7458", "670000", "42345", "7458" },
			{ "101", "1234324", "670000", "42345", "7458", "670000", "42345", "7458", "670000", "42345", "7458" },
			{ "101", "1234324", "670000", "42345", "7458", "670000", "42345", "7458", "670000", "42345", "7458" },
			{ "101", "1234324", "670000", "42345", "7458", "670000", "42345", "7458", "670000", "42345", "7458" } };
	}
	
}
