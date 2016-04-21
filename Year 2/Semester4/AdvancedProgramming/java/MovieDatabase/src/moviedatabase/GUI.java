package moviedatabase;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class GUI extends JFrame implements ActionListener, MouseListener{

	private static final long serialVersionUID = -4512338457582044132L;
	
	System sys = new System();
	Vector<String> v = new Vector<String>();
	
	JDesktopPane pane;
	
	//JScrollPane scrollPane = new JScrollPane();
	JMenuBar mb = new JMenuBar();
	JMenu file = new JMenu("File", true);
	JMenuItem searchMI = new JMenuItem("Search Movie");
	JMenuItem loginMI = new JMenuItem("Login");
	JMenuItem createMI = new JMenuItem("Create Account");
	JMenuItem addMovieMI = new JMenuItem("Add Movie");
	JMenuItem quitMI = new JMenuItem("Quit");
	
	JPanel base = new JPanel();
	JPanel filmbaseLogo = new JPanel(new BorderLayout());
	JPanel homeSearch = new JPanel(new BorderLayout());
	JPanel createAccount = new JPanel(new GridLayout(5,2,0,20));
	JPanel login = new JPanel(new GridLayout(3,2,0,20));
	JPanel addMovie = new JPanel(new GridLayout(6,2,0,20));
	JPanel searchResults = new JPanel();
	
	//FILMBASE LOGO PANEL
	Icon logo = new ImageIcon("res/filmbase.png");
	JLabel logoLabel = new JLabel(logo);

	//SEARCH HOME
	JTextField searchBar = new JTextField("Search...", 30);
	Icon glass = new ImageIcon("res/glass.png");
	JButton search = new JButton(glass);

	//CREATE NEW USER
	JLabel newUsernameLbl = new JLabel("USERNAME");
	JLabel newEmailLbl = new JLabel("EMAIL");
	JLabel newPasswordLbl= new JLabel("PASSWORD");
	JLabel newPasswordConfirmLbl= new JLabel("CONFIRM PASSWORD");
	JTextField newUsername = new JTextField(15);
	JTextField newEmail = new JTextField(15);
	JPasswordField newPassword = new JPasswordField(15);
	JPasswordField newPasswordConfirm = new JPasswordField(15);
	JButton createAccountBtn = new JButton("Create Account");
	
	//LOGIN
	JLabel usernameLbl = new JLabel("USERNAME");
	JLabel passwordLbl = new JLabel("PASSWORD");	
	JTextField username = new JTextField(15);
	JPasswordField password = new JPasswordField(15);
	JButton loginBtn = new JButton("LOGIN");
	
	//ADD TITLE
	JLabel newTitleLbl = new JLabel("TITLE");
	JLabel newYearLbl = new JLabel("YEAR");
	JLabel newDirectorLbl = new JLabel("DIRECTOR");
	JLabel newPlotLbl = new JLabel("PLOT");
	JLabel newCoverLbl = new JLabel("COVER");
	JTextField newTitle = new JTextField(15);
	JTextField newYear = new JTextField(15);
	JTextField newDirector = new JTextField(15);
	JTextField newPlot = new JTextField(15);
	//JFileChooser newCoverFC = new JFileChooser();
	JButton addFileBtn = new JButton("ADD COVER");
	JButton addMovieBtn = new JButton("ADD MOVIE");
	
	String searchStr = "";

	JList<String> resultList;
	JPanel listPanel;
	JScrollPane listPane;
	JPanel moviePage;
	JPanel moviePanel;
	JButton reviewButton;
	
	public static void main(String[] args){
		
		new GUI().setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public GUI(){
		
		super("FILMBASE");
		
		setJMenuBar(mb);
		mb.add(file);
		file.add(searchMI);	
		file.add(loginMI);
		file.add(createMI);
		file.add(addMovieMI);

		//ADD ACTIONLISTENERS//////////////////////
		searchMI.addActionListener(this);
		loginMI.addActionListener(this);
		createMI.addActionListener(this);
		addMovieMI.addActionListener(this);
		quitMI.addActionListener(this);
		search.addActionListener(this);
		
		//FILMBASE LOGO CONTENT
		filmbaseLogo.add(logoLabel, BorderLayout.NORTH);
		//HOME SCREEN SEARCH CONTENT
		homeSearch.add(searchBar);
		homeSearch.add(search, BorderLayout.SOUTH);
		//CREATE NEW ACCOUNT CONTENT
		createAccount.add(newUsernameLbl);
		createAccount.add(newUsername);
		createAccount.add(newEmailLbl);
		createAccount.add(newEmail);
		createAccount.add(newPasswordLbl);
		createAccount.add(newPassword);
		createAccount.add(newPasswordConfirmLbl);
		createAccount.add(newPasswordConfirm);
		createAccount.add(createAccountBtn);
		//LOGIN TO ACCOUNT
		login.add(usernameLbl);
		login.add(username);
		login.add(passwordLbl);
		login.add(password);
		login.add(loginBtn);
		//ADD MOVIE TO DATABASE
		addMovie.add(newTitleLbl);
		addMovie.add(newTitle);
		addMovie.add(newYearLbl);
		addMovie.add(newYear);
		addMovie.add(newDirectorLbl);
		addMovie.add(newDirector);
		addMovie.add(newPlotLbl);
		addMovie.add(newPlot);
		addMovie.add(newCoverLbl);
		//addMovie.add(newCoverFC);
		addMovie.add(addFileBtn);
		addMovie.add(addMovieBtn);
		
		
		//ADDING ALL THE PANELS TO THE BASE PANEL
		base.add(filmbaseLogo);
		base.add(homeSearch);
		base.add(createAccount);
		base.add(login);
		base.add(addMovie);
		
		
		getContentPane().add(base);
		//c.add(panel1, BorderLayout.NORTH);
		//c.add(panel2);
		
		//STYLE////////////////////////////////////
		base.setBackground(new Color(237,28,36));
		filmbaseLogo.setBackground(new Color(237,28,36));
		homeSearch.setBackground(new Color(237,28,36));
		search.setBackground(new Color(237,28,36));
		createAccount.setBackground(new Color(237,28,36));
		login.setBackground(new Color(237,28,36));
		addMovie.setBackground(new Color(237,28,36));
		searchResults.setBackground(new Color(237,28,36));
		mb.setBackground(new Color(237,28,36));
		file.setBackground(new Color(237,28,36));
		file.setOpaque(false);
		search.setBorderPainted(false);

		//SETTING ALL PANELS TO FALSE
		createAccount.setVisible(false);
		login.setVisible(false);
		addMovie.setVisible(false);
		searchResults.setVisible(false);
		
		setVisible(true);
		setSize(500, 600);
		setLocation(400, 100);
		setResizable(false);
		
	}
	
	public void displayResults(Vector<String> v){
		
		resultList = new JList<String>(v);
		
		resultList.setVisibleRowCount(20);
		resultList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		resultList.addMouseListener(this);
		
		listPane = new JScrollPane(resultList);
		listPanel = new JPanel();
		listPanel.add(listPane);
		
		base.add(listPanel);
		
		homeSearch.setVisible(false);
		createAccount.setVisible(false);
		login.setVisible(false);
		addMovie.setVisible(false);
		searchResults.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e){

		if(e.getSource()==(search)){
			
			searchStr = searchBar.getText();
			
			if((!(searchStr.equals("Search..."))) && (!(searchStr.equals("")))){
				
				v = sys.searchMovies(searchStr);
				
				displayResults(v);
				
			}
			
		}
		
		if(e.getSource()==searchMI)
		{
			homeSearch.setVisible(true);
			createAccount.setVisible(false);
			login.setVisible(false);
			addMovie.setVisible(false);
			listPanel.setVisible(false);
			moviePanel.setVisible(false);
		}
		
		if(e.getSource()==loginMI)
		{
			login.setVisible(true);
			homeSearch.setVisible(false);
			createAccount.setVisible(false);
			addMovie.setVisible(false);
			listPanel.setVisible(false);
			moviePanel.setVisible(false);
		}
		
		if(e.getSource()==createMI)
		{
			createAccount.setVisible(true);
			homeSearch.setVisible(false);
			login.setVisible(false);
			addMovie.setVisible(false);
			listPanel.setVisible(false);
			moviePanel.setVisible(false);
		}
		
		if(e.getSource()==addMovieMI)
		{
			addMovie.setVisible(true);
			createAccount.setVisible(false);
			homeSearch.setVisible(false);
			login.setVisible(false);
			listPanel.setVisible(false);
			moviePanel.setVisible(false);
			base.remove(reviewButton);
		}
		
		if(e.getSource()==addFileBtn)
		{
			addMovie.add(pane);
		}
		
	}
	
	public void addMoviePage(String name, String year, String description, String picUrl){
		
		ImageIcon movieImage = new ImageIcon(picUrl);
		moviePanel = new JPanel();
		JTextArea descArea = new JTextArea("Movie Name:\n" + name + "\n\nRelease Year:\n" + year + "\n\nMovie Description:\n" + description);
		JLabel picLabel = new JLabel(movieImage);
		reviewButton = new JButton("Click Here For Reviews");
		
		descArea.setLineWrap(true);
		descArea.setEditable(false);
		descArea.setBackground(null);
		descArea.setFocusable(false);
		descArea.setWrapStyleWord(true);
		descArea.setColumns(15);
		descArea.setFont(new Font("serif", Font.PLAIN, 15));
		
		moviePage = new JPanel();
		
		moviePage.add(picLabel);
		moviePage.add(descArea);
		moviePanel.add(moviePage);
		listPanel.setVisible(false);
		base.add(moviePanel, BorderLayout.CENTER);
		base.add(reviewButton);
		
	}

	public void mouseClicked(MouseEvent me){
		
		Vector<String> v = new Vector<String>();
		String selected = resultList.getSelectedValue();
		v = sys.getMoviePage(selected);
		String name = v.elementAt(0);
		String year = v.elementAt(1);
		String description = v.elementAt(2);
		String picUrl = v.elementAt(3);
		
		addMoviePage(name, year, description, picUrl);
		
	}

	public void mouseEntered(MouseEvent arg0){}

	public void mouseExited(MouseEvent arg){}

	public void mousePressed(MouseEvent arg0){}

	public void mouseReleased(MouseEvent arg0){}

}