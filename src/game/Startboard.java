package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class RuleDialog extends JDialog{
	
	private static final long serialVersionUID = 7935229810496439626L;
	ImageIcon ruletext = new ImageIcon("src/Image/rule.png");
	JLabel jl = new JLabel();
	
	public RuleDialog(){
		setTitle("1024游戏说明");
		jl.setIcon(ruletext);
		jl.setSize(ruletext.getIconWidth(), ruletext.getIconHeight());
		add(jl);
		pack();
		setModal(true);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
	}
	
}

public class Startboard extends JFrame{
	
	private static final long serialVersionUID = 5896723829886598118L;
	int i;
	int j;
	JPanel jp = new JPanel(null);
	JLabel info = new JLabel();
	JButton jb_0 = new JButton("开始游戏");
	JButton jb_1 = new JButton("游戏说明");
	JButton jb_2 = new JButton("退出");
	ImageIcon text = new ImageIcon("src/Image/title.png");
	Gameboard game = new Gameboard();
	
	public Startboard(){
		setLayout(new BorderLayout());
		info.setIcon(text);
		add(info,BorderLayout.NORTH);
		jb_0.setBounds(100, 60, 100, 30);
		jb_1.setBounds(100, 100, 100, 30);
		jb_2.setBounds(100, 140, 100, 30);
		jb_0.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();     
				//一定要在getContPane()中使用removeAll()  http://tieba.baidu.com/p/2004216123
				add(game,BorderLayout.CENTER);
				repaint();
			}
		});
		jb_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		      new RuleDialog();
			}
		});
		jb_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		jp.setBackground(Color.white);
		jp.add(jb_0);
		jp.add(jb_1);
		jp.add(jb_2);
		add(jp,BorderLayout.CENTER);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(0, 0, 300, 400);
		setResizable(false);
		setVisible(true);
	}
	
	public static void main(String arg[]){
		new Startboard();
	}

}
