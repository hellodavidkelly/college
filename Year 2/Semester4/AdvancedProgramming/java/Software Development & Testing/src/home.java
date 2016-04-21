import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

public class home extends JFrame implements ActionListener
{

	Container c = getContentPane();
	JInternalFrame cover;
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
	
	//FILMBASE LOGO PANEL
	Icon logo = new ImageIcon(System.getProperty("user.dir") + "/images/" + "filmbase.png");
	JLabel logoLabel = new JLabel(logo);

	//SEARCH HOME
	JTextField searchBar = new JTextField("Search...", 30);
	Icon glass = new ImageIcon(System.getProperty("user.dir") + "/images/" + "glass.png");
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

	
	public static void main(String[] args) 
	{
		home filmbaseHome = new home();
		filmbaseHome.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public home()
	{
		super("FILMBASE");
		
		setJMenuBar(mb);
		mb.add(file);
		file.add(searchMI);	
		file.add(loginMI);
		file.add(createMI);
		file.add(addMovieMI);
		file.add(quitMI);

		//ADD ACTIONLISTENERS//////////////////////
		searchMI.addActionListener(this);
		loginMI.addActionListener(this);
		createMI.addActionListener(this);
		addMovieMI.addActionListener(this);
		quitMI.addActionListener(this);
		
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

		c.add(base);
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
		mb.setBackground(new Color(237,28,36));
		file.setBackground(new Color(237,28,36));
		file.setOpaque(false);
		search.setBorderPainted(false);

		//SETTING ALL PANELS TO FALSE
		createAccount.setVisible(false);
		login.setVisible(false);
		addMovie.setVisible(false);

		setSize(450,800);
		setVisible(true);
		setLocation(0,0);
		setResizable(false);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==searchMI)
		{
			homeSearch.setVisible(true);
			createAccount.setVisible(false);
			login.setVisible(false);
			addMovie.setVisible(false);
		}
		
		if(e.getSource()==loginMI)
		{
			login.setVisible(true);
			homeSearch.setVisible(false);
			createAccount.setVisible(false);
			addMovie.setVisible(false);
		}
		
		if(e.getSource()==createMI)
		{
			createAccount.setVisible(true);
			homeSearch.setVisible(false);
			login.setVisible(false);
			addMovie.setVisible(false);
		}
		
		if(e.getSource()==addMovieMI)
		{
			addMovie.setVisible(true);
			createAccount.setVisible(false);
			homeSearch.setVisible(false);
			login.setVisible(false);
		}
		
		if(e.getSource()==addFileBtn)
		{
			addMovie.add(pane);
		}
		
		else if(e.getSource()==quitMI)
		{
			System.exit(0);
		}
		
	}
}
