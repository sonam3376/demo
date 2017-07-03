import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class game extends JFrame
{
	JButton btn1,btn2,btn3;
	Timer t1,t2;
	boolean left=true, up=true;
	Container c;
	int count=0;
    public game()
    {//comment
    	btn1=new JButton();
    	btn1.setBounds(50,50,70,30);
    	btn1.setBackground(Color.red);
    	btn2=new JButton();
    	btn2.setBounds(10,560,80,30);
    	btn2.setBackground(Color.blue);
    	btn3=new JButton();
    	btn3.setBounds(40,542,20,20);
    	btn3.setBackground(Color.BLACK);
    	c=getContentPane();
		c.setLayout(null);
    	c.add(btn3);
    	c.add(btn1);
    	c.add(btn2);
    	
    	
    	t1=new Timer(10,new ActionListener()
    	{
    		public void actionPerformed(ActionEvent ae)
    		{
				
					if(left==true)
					{
						btn1.setLocation(btn1.getLocation().x+1,btn1.getLocation().y);
						if(btn1.getLocation().x==530)
						{
							left=false;
						}
					}
					else
					{
						btn1.setLocation(btn1.getLocation().x-1,btn1.getLocation().y);
						if(btn1.getLocation().x==0)
						{
							left=true;
						}
					}
				    			
    		}	
    	});
    	t1.start();
    		
    	t2=new Timer(100,new ActionListener()
    	{
    		public void actionPerformed(ActionEvent ae)
    		{
				
					btn3.setLocation(btn3.getLocation().x,btn3.getLocation().y-4);
					setTitle(btn1.getLocation().x +"," + btn1.getLocation().y + " | " + btn3.getLocation().x +"," + btn3.getLocation().y);
					if((btn3.getLocation().y==btn1.getLocation().y-30))
					{	
						btn2.setForeground(Color.white);
						count++;
						btn2.setText(count+"");
						btn3.setLocation(btn2.getLocation().x+40,btn2.getLocation().y-16);
						t2.stop();
					
					}
					if(btn3.getLocation().y<=0)
					{
						btn3.setLocation(btn2.getLocation().x+40,btn2.getLocation().y-16);
						t2.stop();
					}
					
			
    		}	
    	});
    	
    		addKeyListener(new KeyAdapter()
    		{
    			public void keyPressed(KeyEvent me)
    			{
    				if (me.getKeyCode()==37)
    				{
    					btn2.setLocation(btn2.getLocation().x-4,btn2.getLocation().y);
    					}
    					
    						else if(me.getKeyCode()==39)
    					{
    						btn2.setLocation(btn2.getLocation().x+4,btn2.getLocation().y);
    						
    						}
    			}
    			});
    			
    			
    				addKeyListener(new KeyAdapter()
    		{
    			public void keyPressed(KeyEvent me)
    			{
    				if (me.getKeyCode()==37)   //aa gya
    				{
    					btn3.setLocation(btn3.getLocation().x-4,btn3.getLocation().y);
    					}//bolo..hmm..kr
    					
    						else if(me.getKeyCode()==39)  //space bar click krte hi t2 start ho gya..baar move krne lga..aa gya pura..suno
    					{
    						btn3.setLocation(btn3.getLocation().x+4,btn3.getLocation().y);
    						
    						}
    					else if(me.getKeyCode()==32)//ye space bar ka h..dekh
    					{
    						t2.start();
    						
    						}
    			}
    			});
    			
    		
    			 setFocusable(true);
				setBounds(100,100,600,670);
				setVisible(true);
    	    	
    }
    public static void main(String ar[])
	{
		new game();
	}
    
}