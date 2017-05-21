package game;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

public class Gameboard extends JPanel{
	
	private static final long serialVersionUID = -2448595148360348121L;
	final int left = 37;
	final int right = 39;
	final int down = 40;
	final int up = 38;
	int i;
	int j;
	boolean check;
	JDialog dialog = new JDialog();
	JPanel top = new JPanel();
	JLabel[][] jl = new JLabel[3][3];
	ImageIcon jl_2 = new ImageIcon("src/Image/2.png");
	ImageIcon jl_4 = new ImageIcon("src/Image/4.png");
	ImageIcon jl_8 = new ImageIcon("src/Image/8.png");
	ImageIcon jl_16 = new ImageIcon("src/Image/16.png");
	ImageIcon jl_32 = new ImageIcon("src/Image/32.png");
	ImageIcon jl_64 = new ImageIcon("src/Image/64.png");
	ImageIcon jl_128 = new ImageIcon("src/Image/128.png");
	ImageIcon jl_256 = new ImageIcon("src/Image/256.png");
	ImageIcon jl_512 = new ImageIcon("src/Image/512.png");
	ImageIcon jl_1024 = new ImageIcon("src/Image/1024.png");
	ImageIcon t = new ImageIcon();

	public Gameboard(){
		top.setLayout(new GridLayout(3,3));
		for(i=0; i<jl.length; i++){
			for(j=0; j<jl.length; j++){
			  jl[i][j] = new JLabel();
			  jl[i][j].setSize(jl_2.getIconWidth(), jl_2.getIconHeight());
			top.add(jl[i][j]);
		   }
		}
		top.setSize(300, 300);
		add(top,BorderLayout.CENTER);
		jl[(int)(Math.random()*3)][(int)(Math.random()*3)].setIcon(jl_2);
		addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}
			public void keyReleased(KeyEvent e) {
			}
			public void keyPressed(KeyEvent e) {
				Move(e.getKeyCode());
				for(i=0; i<jl.length; i++){
					for(j=0; j<jl.length; j++){
						if(jl[i][j].getIcon() == null)
							check = true;
						else check = false;
					}
				}
				if(check == true)
				    for(;;){
					   i = (int)(Math.random()*3);
					   j = (int)(Math.random()*3);
					   if(jl[i][j].getIcon() == null){
						   jl[i][j].setIcon(jl_2);
						   break;
						   }
					}
				
			}
		});
		addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO 自动生成的方法存根
				boolean status = requestFocusInWindow();
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
		});
		/*setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();*/
		setSize(top.getSize());
		setVisible(true);
	}
	
	void Move(int keycode){
		int x;
		int y;
		if(keycode==up || keycode==left)
		for(i=0; i<jl.length; i++)
			for(j=0; j<jl.length; j++){
				if(jl[i][j].getIcon() !=  null){
					x = i;y = j;
					switch(keycode){					
					case up:
						t = (ImageIcon) jl[x][y].getIcon();
						while(x > 0){
						  x-=1;
						if(jl[x][y].getIcon() != null){
							 if(Combine((ImageIcon)jl[x][y].getIcon(),t)!=null){
							jl[x][y].setIcon(new ImageIcon(Combine((ImageIcon)jl[x][y].getIcon(),t)));
							jl[x+1][y].setIcon(null);
							break;
							}else
							 break;
							}else{
								jl[x+1][y].setIcon(null);
								jl[x][y].setIcon(t);
							}
						}repaint();break;
					case left:
							t = (ImageIcon) jl[x][y].getIcon();
						while(y > 0){
							y-=1;
						   if(jl[x][y].getIcon() != null){
								if(Combine((ImageIcon)jl[x][y].getIcon(),t)!=null){
								jl[x][y].setIcon(new ImageIcon(Combine((ImageIcon)jl[x][y].getIcon(),t)));
								jl[x][y+1].setIcon(null);
								break;
								}else
							break;
						}else{
							jl[x][y+1].setIcon(null);
							jl[x][y].setIcon(t);
						}
					}repaint();break;
				}
			}
		  }
		if(keycode==down || keycode==right)
			for(i=jl.length-1; i>=0; i--)
				for(j=jl.length-1; j>=0; j--){
					if(jl[i][j].getIcon() !=  null){
						x = i;y = j;
						switch(keycode){
						case down:
							t = (ImageIcon) jl[x][y].getIcon();
							while(x < 2){
								x+=1;
								if(jl[x][y].getIcon() != null){
									if(Combine((ImageIcon)jl[x][y].getIcon(),t)!=null){
										jl[x][y].setIcon(new ImageIcon(Combine((ImageIcon)jl[x][y].getIcon(),t)));
										jl[x-1][y].setIcon(null);
										break;}
									else
									break;
									}else{
										jl[x-1][y].setIcon(null);
										jl[x][y].setIcon(t);
									}
								}repaint();break;
						case right:
							t = (ImageIcon) jl[x][y].getIcon();
							while(y < 2){
							        y+=1;
								if(jl[x][y].getIcon() != null){
									if(Combine((ImageIcon)jl[x][y].getIcon(),t)!=null){
									jl[x][y].setIcon(new ImageIcon(Combine((ImageIcon)jl[x][y].getIcon(),t)));
									jl[x][y-1].setIcon(null);
									break;}
								else
								break;
							}else{
								jl[x][y-1].setIcon(null);
								jl[x][y].setIcon(t);
							}
						}repaint();break;
					}
				}
			}
		}
	String Combine(ImageIcon i1, ImageIcon i2){
		String adr;
		adr = i1.getDescription();
		if(adr.equals(i2.getDescription())){
			if(adr.equals(jl_2.getDescription()))
				return jl_4.getDescription();
			if(adr.equals(jl_4.getDescription()))
				return jl_8.getDescription();
			if(adr.equals(jl_8.getDescription()))
				return jl_16.getDescription();
			if(adr.equals(jl_16.getDescription()))
				return jl_32.getDescription();
			if(adr.equals(jl_32.getDescription()))
				return jl_64.getDescription();
			if(adr.equals(jl_64.getDescription()))
				return jl_128.getDescription();
			if(adr.equals(jl_128.getDescription()))
				return jl_256.getDescription();
			if(adr.equals(jl_256.getDescription()))
				return jl_512.getDescription();
			if(adr.equals(jl_512.getDescription()))
				return jl_1024.getDescription();
		}
		return null;
	}

}
