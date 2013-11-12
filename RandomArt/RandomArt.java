import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;


public class RandomArt
{
    
    /**
     * Create an RandomArt show it on screen.
     */
    public RandomArt()
    {
        ArtFrame f = new ArtFrame();

    }
    
}
class ArtFrame extends JFrame {
   private JButton newRandomButton;
   private static final String VERSION = "Version 1.0";
   private RandomFunction random;
   private ArtPanel thePanel;
   private Frame frame;
   
   
    
    /**
     * Create the frame and its content.
     */
    public ArtFrame()
    {
        setTitle("RandomArt");
        setJMenuBar(makeMenuBar());

        //Container contentPane = frame.getContentPane();
     
        
        final Graphics graphics;
        thePanel = new ArtPanel();
        JPanel button = new JPanel();
        button.setLayout(new GridLayout());
        newRandomButton = new JButton("New Random");
        newRandomButton.addActionListener(new ActionListener() {
                               public void actionPerformed(ActionEvent e) {  }
                           }); 
        button.add(newRandomButton);
        
        
        
        
         // Add button into panel with flow layout for spacing
        JPanel flow = new JPanel();
        flow.add(button);
        
        add(flow, BorderLayout.SOUTH);
        add(thePanel, BorderLayout.CENTER);
        
       
        
        

        // building is done - arrange the components and show 
        pack();
        setVisible(true);  
    }
    
    //menu bar
    /**
     * Create the main frame's menu bar.
     * @param frame   The frame that the menu bar should be added to.
     */
    private JMenuBar makeMenuBar()
    {
        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);
        
        JMenu menu;
        JMenuItem item;

        
        // create the File menu
        JMenu fileMenu = new JMenu("Menu");
        menubar.add(fileMenu);
       

        JMenuItem quitItem = new JMenuItem("Quit");
            quitItem.addActionListener(new ActionListener() {
                               public void actionPerformed(ActionEvent e) { quit(); }
                           });
        fileMenu.add(quitItem);
        
        // create the Help menu
         menu = new JMenu("Help");
        menubar.add(menu);
        
        item = new JMenuItem("About Random Art...");
            item.addActionListener(new ActionListener() {
                               public void actionPerformed(ActionEvent e) { showAbout(); }
                           });
        menu.add(item);
        
        return menubar;
    }
    
    //menu item system
    private void showAbout()
    {
        ArtFrame frame;
       JOptionPane.showMessageDialog(thePanel, 
                    "Random Art\n" + VERSION,
                    "About Random Art", 
                    JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * Quit function: quit the application.
     */
    private void quit()
    {
        System.exit(0);
    }
    
    public Component newBox(){
        JPanel subbox = new JPanel();
        
        
        return subbox;
    }
    
}

  class ArtPanel extends JPanel   {
    public static final int SIZE = 600;
    private Color color;
    private RandomFunction randomFunction;
    
    public ArtPanel(){
        setPreferredSize(new Dimension(SIZE, SIZE));
    }
    
    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
         RandomFunction randomFunction;
         float pi = (float)3.14159265359;
        
        for (int j = 0; j < getHeight() ; j++) {
             for (int i = 0; i < getWidth()  ; i++) {
           //scale to between -1 and 1
            double x = ((((double) i) / getWidth()) * 2.0) - 1.0;
		    double y = ((((double) j) / getHeight()) * 2.0) - 1.0;
                 
 
           double r = sin(pi * avg((((cos(pi * (sin(pi * cos(pi * y)) * avg(avg(x, x), sin(pi * y)))) * avg(sin(pi * (sin(pi * y) * (y * x))), cos(pi * cos(pi * (y * y))))) * sin(pi * (sin(pi * (sin(pi * y) * sin(pi * y))) * cos(pi * ((y * y) * sin(pi * y)))))) * sin(pi * avg(cos(pi * avg(((y * x) * (x * x)), sin(pi * (y * x)))), sin(pi * avg(avg(sin(pi * x), avg(x, x)), sin(pi * avg(x, y))))))), cos(pi * cos(pi * avg(sin(pi * sin(pi * avg((x * x), (x * x)))), sin(pi * sin(pi * sin(pi * sin(pi * y)))))))));
		   double gr = sin(pi * ((avg(avg(cos(pi * (cos(pi * cos(pi * x)) * (cos(pi * x) * avg(y, x)))), ((cos(pi * cos(pi * y)) * (cos(pi * x) * (x * y))) * sin(pi * sin(pi * avg(y, y))))), cos(pi * (avg(sin(pi * sin(pi * x)), sin(pi * sin(pi * x))) * sin(pi * sin(pi * (x * y)))))) * avg((avg(cos(pi * sin(pi * cos(pi * x))), avg((sin(pi * x) * cos(pi * y)), avg(cos(pi * x), cos(pi * x)))) * avg(avg(sin(pi * cos(pi * x)), sin(pi * sin(pi * x))), (avg(cos(pi * x), avg(y, x)) * avg(sin(pi * y), sin(pi * x))))), (cos(pi * cos(pi * (avg(y, y) * (y * x)))) * cos(pi * cos(pi * sin(pi * avg(x, x))))))) * sin(pi * avg(avg(sin(pi * cos(pi * sin(pi * cos(pi * x)))), avg(sin(pi * cos(pi * cos(pi * y))), ((sin(pi * y) * (x * y)) * cos(pi * (y * y))))), cos(pi * avg(((cos(pi * y) * (y * y)) * avg(sin(pi * y), cos(pi * y))), (((x * x) * avg(y, x)) * cos(pi * sin(pi * x)))))))));
		   double b = avg(sin(pi * (avg(cos(pi * avg((cos(pi * (x * x)) * cos(pi * (x * y))), avg(avg((x * x), avg(y, y)), avg(cos(pi * y), cos(pi * x))))), avg(avg(avg((sin(pi * y) * (x * y)), sin(pi * (x * x))), avg(((x * x) * sin(pi * y)), (avg(x, x) * sin(pi * y)))), avg((cos(pi * sin(pi * y)) * cos(pi * avg(x, x))), sin(pi * avg(sin(pi * y), sin(pi * y)))))) * cos(pi * avg(avg(avg(sin(pi * (x * x)), avg(sin(pi * y), sin(pi * x))), cos(pi * avg(cos(pi * y), avg(y, x)))), (((avg(x, y) * cos(pi * x)) * cos(pi * avg(y, x))) * avg(cos(pi * (y * x)), ((x * x) * (y * x)))))))), avg(((((sin(pi * sin(pi * avg(x, x))) * avg(avg(sin(pi * y), sin(pi * y)), avg(avg(x, x), cos(pi * y)))) * sin(pi * sin(pi * sin(pi * (y * y))))) * avg(cos(pi * avg(avg(avg(x, y), (y * x)), cos(pi * sin(pi * x)))), (sin(pi * sin(pi * sin(pi * x))) * cos(pi * ((y * y) * cos(pi * x)))))) * avg(cos(pi * cos(pi * sin(pi * cos(pi * avg(x, y))))), (sin(pi * (cos(pi * avg(y, x)) * sin(pi * cos(pi * x)))) * ((sin(pi * cos(pi * y)) * avg(avg(x, x), cos(pi * x))) * avg((sin(pi * x) * avg(y, x)), sin(pi * sin(pi * x))))))), ((cos(pi * cos(pi * (sin(pi * (y * y)) * cos(pi * cos(pi * x))))) * avg(sin(pi * avg(cos(pi * sin(pi * y)), (cos(pi * x) * avg(x, x)))), cos(pi * cos(pi * cos(pi * avg(x, y)))))) * sin(pi * (avg((cos(pi * (y * y)) * cos(pi * sin(pi * y))), avg(((x * x) * sin(pi * x)), cos(pi * sin(pi * y)))) * avg(sin(pi * (avg(y, x) * avg(x, x))), cos(pi * avg((y * y), avg(y, y)))))))));
			
			
            
            g2.setColor(new Color(convertDouble(r),convertDouble(gr),convertDouble(b)));
            
            g2.fillRect(i, j, 1, 1);
            
            
          

        }
         
       }
    }
    
    
    private static int convertDouble(double value){
		value += 1.0;
		if (value < 0) {
			value *= -1;
		}
		value /= 2.0;
		int color = (int) (value * 255);
		if (color >= 255) {
			color = 255;
		}
		return color;
	 } 
	 
	  public static double avg(double x, double y){
        return (x + y) / 2;
    }
    public  static double sin(double value){
        return (Math.sin( value));
    }
    
    public  static double cos(double value){
        return (Math.cos(value));
    }
      }
     
    
    

  


  class RandomFunction {
    private static final int MAX_LEVEL = 8;
      
    
    
    public static double avg(double x, double y){
        return (x + y) / 2.0;
    }
    
    private static double mul(double x, double y){
        return (x *y);
    }
    
    private static double sin(double x, double y){
        return (x *y);
    }
    
    private static double sin(double value){
        return (Math.sin(Math.PI * value));
    }
    
    private static double cos(double value){
        return (Math.cos(Math.PI * value));
    }
   
  }

