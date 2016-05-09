import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class GUI {

	private JFrame frame;
	private ArrayList<JButton> allButtons = new ArrayList<JButton>();
	private JTextField txtTurn;
	private boolean buttonPressed = false;
	private int whichButton = -1;

	/**
	 * Launch the application.
	 */
	public  void launchGui() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public int getButtonNo(){
		System.out.println("ready to accept button num");
		while(buttonPressed==false){
			//System.out.println("waiting");
			try{
				Thread.sleep(1000);
			}catch(Exception e){
				
			}
		}
		buttonPressed = false;
		System.out.println("button pressed"+ whichButton);
		
		return whichButton;
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		System.out.println("inside init");
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0,0,0,0,0,0,0,0,0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0,0,0,0,0,0,0,0,0,0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0,0.0,0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,0.0};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JButton btnNewButton_0 = new JButton("0");
		GridBagConstraints gbc_btnNewButton_0 = new GridBagConstraints();
		//gbc_btnNewButton_0.insets = new Insets(0, 0, 5, 5);
		//gbc_btnNewButton_0.anchor = GridBagConstraints.WEST;
		//gbc_btnNewButton_0.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_0.gridx = 1;
		gbc_btnNewButton_0.gridy = 4;
		frame.getContentPane().add(btnNewButton_0, gbc_btnNewButton_0);
		allButtons.add(btnNewButton_0);
		btnNewButton_0.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                //btnNewButton_0.setText(String.format("Pressed"));
            	buttonPressed = true;
            	whichButton = 0;
            	System.out.println("0 has been pressed");
            }

        });
		
		
		txtTurn= new JTextField("turn");
		GridBagConstraints gbc_txt = new GridBagConstraints();
		//gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		//gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_txt.gridx = 6;
		gbc_txt.gridy = 16;
		frame.getContentPane().add(txtTurn, gbc_txt);
		
		
		JButton btnNewButton = new JButton("1");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		//gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		//gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 4;
		frame.getContentPane().add(btnNewButton, gbc_btnNewButton);
		allButtons.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                //btnNewButton_0.setText(String.format("Pressed"));
            	System.out.println("1 has been pressed");
            	buttonPressed = true;
            	whichButton = 1;
            }

        });
		
		JButton btnNewButton_1 = new JButton("2");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		//gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		//gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 3;
		gbc_btnNewButton_1.gridy = 4;
		frame.getContentPane().add(btnNewButton_1, gbc_btnNewButton_1);
		allButtons.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                //btnNewButton_0.setText(String.format("Pressed"));
            	System.out.println("2 has been pressed");
            	buttonPressed = true;
            	whichButton = 2;
            }

        });
		
		JButton btnNewButton_2 = new JButton("3");
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		//gbc_btnNewButton_2.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_2.gridx = 4;
		gbc_btnNewButton_2.gridy = 4;
		frame.getContentPane().add(btnNewButton_2, gbc_btnNewButton_2);
		allButtons.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                //btnNewButton_0.setText(String.format("Pressed"));
            	System.out.println("3 has been pressed");
            	buttonPressed = true;
            	whichButton = 3;
            }

        });
		
		JButton btnNewButton_3 = new JButton("4");
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		//gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 5;
		gbc_btnNewButton_3.gridy = 4;
		allButtons.add(btnNewButton_3);
	    frame.getContentPane().add(btnNewButton_3, gbc_btnNewButton_3);
	    btnNewButton_3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                //btnNewButton_0.setText(String.format("Pressed"));
            	System.out.println("4 has been pressed");
            	buttonPressed = true;
            	whichButton = 4;
            }

        });
		
		
		JButton btnNewButton_4 = new JButton("5");
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		//gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_4.gridx = 6;
		gbc_btnNewButton_4.gridy = 4;
		frame.getContentPane().add(btnNewButton_4, gbc_btnNewButton_4);
		allButtons.add(btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                //btnNewButton_0.setText(String.format("Pressed"));
            	System.out.println("5 has been pressed");
            	buttonPressed = true;
            	whichButton = 5;
            }

        });
		
		JButton btnNewButton_5 = new JButton("6");
		GridBagConstraints gbc_btnNewButton_5 =  new GridBagConstraints();
		//gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_5.gridx = 7;
		gbc_btnNewButton_5.gridy = 3;
		frame.getContentPane().add(btnNewButton_5, gbc_btnNewButton_5);
		allButtons.add(btnNewButton_5);
		btnNewButton_5.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                //btnNewButton_0.setText(String.format("Pressed"));
            	System.out.println("6 has been pressed");
            	buttonPressed = true;
            	whichButton = 6;
            }

        });
		
		JButton btnNewButton_6 = new JButton("7");
		GridBagConstraints gbc_btnNewButton_6 =  new GridBagConstraints();
		//gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_6.gridx = 6;
		gbc_btnNewButton_6.gridy = 2;
		frame.getContentPane().add(btnNewButton_6, gbc_btnNewButton_6);
		allButtons.add(btnNewButton_6);
		btnNewButton_6.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                //btnNewButton_0.setText(String.format("Pressed"));
            	System.out.println("7 has been pressed");
            	
            }

        });
		
		
		JButton btnNewButton_7 = new JButton("8");
		GridBagConstraints gbc_btnNewButton_7 =  new GridBagConstraints();
		//gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_7.gridx = 5;
		gbc_btnNewButton_7.gridy = 2;
		frame.getContentPane().add(btnNewButton_7, gbc_btnNewButton_7);
		allButtons.add(btnNewButton_7);
		btnNewButton_7.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                //btnNewButton_0.setText(String.format("Pressed"));
            	System.out.println("8 has been pressed");
            }

        });
		
		
		JButton btnNewButton_8 = new JButton("9");
		GridBagConstraints gbc_btnNewButton_8 =  new GridBagConstraints();
		//gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_8.gridx = 4;
		gbc_btnNewButton_8.gridy = 2;
		frame.getContentPane().add(btnNewButton_8, gbc_btnNewButton_8);
		allButtons.add(btnNewButton_8);
		btnNewButton_8.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                //btnNewButton_0.setText(String.format("Pressed"));
            	System.out.println("9 has been pressed");
            }

        });
		
		
		JButton btnNewButton_9 = new JButton("10");
		GridBagConstraints gbc_btnNewButton_9 =  new GridBagConstraints();
		//gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_9.gridx = 3;
		gbc_btnNewButton_9.gridy = 2;
		frame.getContentPane().add(btnNewButton_9, gbc_btnNewButton_9);
		allButtons.add(btnNewButton_9);
		btnNewButton_9.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                //btnNewButton_0.setText(String.format("Pressed"));
            	System.out.println("10 has been pressed");
            }

        });
		
		JButton btnNewButton_10 = new JButton("11");
		GridBagConstraints gbc_btnNewButton_10 =  new GridBagConstraints();
		//gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_10.gridx = 2;
		gbc_btnNewButton_10.gridy = 2;
		frame.getContentPane().add(btnNewButton_10, gbc_btnNewButton_10);
		allButtons.add(btnNewButton_10);
		btnNewButton_10.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                //btnNewButton_0.setText(String.format("Pressed"));
            	System.out.println("11 has been pressed");
            }

        });
		
		JButton btnNewButton_11 = new JButton("12");
		GridBagConstraints gbc_btnNewButton_11 =  new GridBagConstraints();
		//gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_11.gridx = 1;
		gbc_btnNewButton_11.gridy = 2;
		frame.getContentPane().add(btnNewButton_11, gbc_btnNewButton_11);
		allButtons.add(btnNewButton_11);
		btnNewButton_11.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                //btnNewButton_0.setText(String.format("Pressed"));
            	System.out.println("12 has been pressed");
            }

        });
		
		JButton btnNewButton_12 = new JButton("13");
		GridBagConstraints gbc_btnNewButton_12 =  new GridBagConstraints();
		//gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_12.gridx = 0;
		gbc_btnNewButton_12.gridy = 3;
		frame.getContentPane().add(btnNewButton_12, gbc_btnNewButton_12);
		allButtons.add(btnNewButton_12);
		btnNewButton_12.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                //btnNewButton_0.setText(String.format("Pressed"));
            	System.out.println("13 has been pressed");
            }

        });
		
		/*
		JButton btnNewButton_5 = new JButton("6");
		GridBagConstraints gbc_btnNewButton_5 =  new GridBagConstraints();
		//gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_5.gridx = 7;
		gbc_btnNewButton_5.gridy = 3;
		frame.getContentPane().add(btnNewButton_5, gbc_btnNewButton_5);
		allButtons.add(btnNewButton_5);
		
		
		
		JButton btnNewButton_5 = new JButton("6");
		GridBagConstraints gbc_btnNewButton_5 =  new GridBagConstraints();
		//gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_5.gridx = 7;
		gbc_btnNewButton_5.gridy = 3;
		frame.getContentPane().add(btnNewButton_5, gbc_btnNewButton_5);
		allButtons.add(btnNewButton_5);
		
		
		JButton btnNewButton_5 = new JButton("6");
		GridBagConstraints gbc_btnNewButton_5 =  new GridBagConstraints();
		//gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_5.gridx = 7;
		gbc_btnNewButton_5.gridy = 3;
		frame.getContentPane().add(btnNewButton_5, gbc_btnNewButton_5);
		allButtons.add(btnNewButton_5);
		
		
		
		
		*/
		
		
	}

	public void updateTurn(String msg) {
		// TODO Auto-generated method stub
		System.out.println("inside gui");
		txtTurn.setText(msg);
		
		
	}
	
	public void updateCount(int[] count){
		for(int i=0;i<allButtons.size();i++){
			JButton curButton = allButtons.get(i);
			curButton.setText(count[i]+"");
		}
	}

}
