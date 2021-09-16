package example.boundary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import example.controller.ClickNodeController;
import example.controller.SwapController;
import example.controller.UnselectAllController;
import example.entity.Model;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class PuzzleApp {
	
	Model model;
	public JFrame frame;
	public PuzzlePanel boardPanel;
	JLabel moveNumber;
	JLabel scoreNumber;
	

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					PuzzleApp window = new PuzzleApp();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	public PuzzlePanel getPuzzlePanel() { return boardPanel; }
	public JLabel getMoveLabel() { return moveNumber; }
	public JLabel getScoreLabel() { return scoreNumber; }
	public void showWinBoard()
	{
		System.out.println("Winningggggg!");
	}

	/**
	 * Create the application.
	 */
	public PuzzleApp(Model m) {
		this.model = m;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(400, 400, 646, 507);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		boardPanel = new PuzzlePanel(model);
		boardPanel.addMouseListener(new MouseAdapter() { 
			@Override
			public void mousePressed(MouseEvent me) {
				new ClickNodeController(model, PuzzleApp.this).process(me.getPoint());
			}
		});
		
		JLabel score = new JLabel("Score");
		score.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
		
		this.scoreNumber = new JLabel("" + model.getScore());
		scoreNumber.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
		scoreNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel move = new JLabel("Move");
		move.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
		
		this.moveNumber = new JLabel("" + model.getMoves());
		moveNumber.setFont(new Font("Arial Narrow", Font.PLAIN, 18));
		moveNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JButton resetButton = new JButton("Reset");
		
		JButton swapButton = new JButton("Swap");
		swapButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SwapController(model, PuzzleApp.this).swapEdge();
			}
		});
		
		JButton unselectAllButton = new JButton("Unselect All");
		unselectAllButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UnselectAllController(model, PuzzleApp.this).unselectAll();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(boardPanel, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(50)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(move, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
									.addComponent(moveNumber, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(score, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
									.addComponent(scoreNumber, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)))
							.addGap(50))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(unselectAllButton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(resetButton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(swapButton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
							.addGap(85))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(60, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(boardPanel, GroupLayout.PREFERRED_SIZE, 410, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(score, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(scoreNumber))
							.addGap(40)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(move)
								.addComponent(moveNumber))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(unselectAllButton, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(swapButton, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(resetButton, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
							.addGap(43))))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
