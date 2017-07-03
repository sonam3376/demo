import java.awt.*;
import java.awt.event.*;
public class game extends Frame
{
	Button btn1,btn2,btn3;
	Thread t1,t2;
	boolean left=true, up=true;
    public game()
    {
    	btn1=new Button();
    	btn1.setBounds(50,50,70,30);
    	btn1.setBackground(Color.red);
    	btn2=new Button();
    	btn2.setBounds(10,560,80,30);
    	btn2.setBackground(Color.blue);
    	btn3=new Button();
    	btn3.setBounds(40,542,20,20);
    	btn3.setBackground(Color.BLACK);
    	add(btn3);
    	setLayout(null);
    	add(btn1);
    	add(btn2);
    	setBounds(100,100,600,600);
    	
    	
    	t1=new Thread()
    	{
    		public void run()
    		{
				while(true)
				{
					try
						{
						Thread.sleep(10);
					}
					catch(Exception ex)
						{
					}
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
    		}	
    	};
    	t1.start();
    	
    	
    	
    	
    	
    		t2=new Thread()
    	{
    		public void run()
    		{
				while(true)
				{
					try{
						Thread.sleep(10);
					}
					catch(Exception ex){
					}
					if(up==true)
					{
						btn3.setLocation(btn3.getLocation().x,btn3.getLocation().y-4);
					}
					
					/*else if(btn3.getLocation().y==540)
					
					{
						up=false;
							btn3.setBounds(40,542,20,20);
						}*/ 
				
				
				}    			
    		
    		}	
    	};
    	
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
    				if (me.getKeyCode()==37)
    				{
    					btn3.setLocation(btn3.getLocation().x-4,btn3.getLocation().y);
    					}
    					
    						else if(me.getKeyCode()==39)
    					{
    						btn3.setLocation(btn3.getLocation().x+4,btn3.getLocation().y);
    						
    						}
    					else if(me.getKeyCode()==32)
    					{
    						t2.start();
    						
    						}
    			}
    			});
    			
    		
    			 setFocusable(true);
    		
    	setVisible(true);
    	    	
    }
    
    
}