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
   private static final String VERSION = "Version 1.0";
   private ArtPanel artpanel;
   private JButton newRandomButton, functionsButton;
   
   
    
    /**
     * Create the frame and its content.
     */
    public ArtFrame()
    {
        setTitle("RandomArt");
        setJMenuBar(makeMenuBar());
        Image icon = Toolkit.getDefaultToolkit().getImage("banner.png");
        setIconImage(icon);
       
        
        //set cursor icon
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = toolkit.getImage("cursor.png");
        Point hotSpot = new Point(0,0);
        Cursor cursor = toolkit.createCustomCursor(image, hotSpot, "cursor");  
        setCursor(cursor); 

        
        artpanel = new ArtPanel();
        
        //create panel for buttons
        JPanel button = new JPanel();
        button.setLayout(new FlowLayout());
        button.setBackground(new Color(255,254,180));
        
       
        
        
           
        //create new Random button
        newRandomButton = new JButton();
        newRandomButton.setIcon(new ImageIcon("rand.png"));
        newRandomButton.setBorderPainted(false);  
        newRandomButton.setFocusPainted(false);  
        newRandomButton.setContentAreaFilled(false);
         validate();
        
        newRandomButton.addActionListener(new ActionListener() {
                               public void actionPerformed(ActionEvent e) { 
                              artpanel.repaint();
                                
                                
                                }
                          }); 
        button.add(newRandomButton);
        
        
        
        //create functions button
        functionsButton = new JButton();
        functionsButton.setIcon(new ImageIcon("show.png"));
        functionsButton.setBorderPainted(false);  
        functionsButton.setFocusPainted(false);  
        functionsButton.setContentAreaFilled(false);
        functionsButton.addActionListener(new ActionListener() {
                               public void actionPerformed(ActionEvent e) { 
                              artpanel.showFunctions();
                                
                                
                                }
                          });
        button.add(functionsButton);
        
       
        
        
        
        //add south panel and artpanel into frame
        add(button, BorderLayout.SOUTH);
        add(artpanel, BorderLayout.CENTER);
        
       
        
        

        // building is done - arrange the components and show 
        pack();
        setVisible(true);  
        setLocationRelativeTo(null); //center the window
    }
    
    
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

        
        // create "Menu" menu
        menu = new JMenu("Menu");
        menubar.add(menu);
       
        //menu item in "Menu" menu
        JMenuItem quitItem = new JMenuItem("Quit");
            quitItem.addActionListener(new ActionListener() {
                               public void actionPerformed(ActionEvent e) { quit(); }
                           });
        menu.add(quitItem);
        
        // create "Help" menu
         menu = new JMenu("Help");
        menubar.add(menu);
        
        //menu item in "Help" menu
        item = new JMenuItem("About Random Art...");
            item.addActionListener(new ActionListener() {
                               public void actionPerformed(ActionEvent e) { showAbout(); }
                           });
        menu.add(item);
        
        item = new JMenuItem("About Math...");
            item.addActionListener(new ActionListener() {
                               public void actionPerformed(ActionEvent e) { showMath(); }
                           });
        menu.add(item);
        
        return menubar;
    }
    
    
    
     /**
     * showAbout function: show about the application.
     */
    private void showAbout()
    {
        ArtFrame frame;
       JOptionPane.showMessageDialog(artpanel, 
                    "Random Art\n" + VERSION,
                    "About Random Art", 
                    JOptionPane.INFORMATION_MESSAGE,new ImageIcon("aboutRA.png"));
    }
    
    /**
     * show functions
     */
    private void showMath()
    {
        ArtFrame frame;
       JOptionPane.showMessageDialog(artpanel, 
        " sin = Sine \n cos = Cosine \n tan = Tangent \n avg = Average \n sqr = Square root \n abs = Absolute" 
                    , "About Math", 
                    JOptionPane.INFORMATION_MESSAGE,new ImageIcon("aboutRA.png"));
    }
    
    /**
     * Quit function: quit the application.
     */
    private void quit()
    {
        System.exit(0);
    }
    
    
    
}

 class ArtPanel extends JPanel   {
    public static final int SIZE = 600;
    private Color color;
    private Functions functions;
    private String  []show = new String[3];
    
    public ArtPanel(){
        setPreferredSize(new Dimension(SIZE, SIZE));
       
    }
    
    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        
       Functions rand1 = new Functions();
       Functions rand2 = new Functions();
       Functions rand3 = new Functions();
       
        for (int j = 0; j < getHeight() ; j++) {
             for (int i = 0; i < getWidth()  ; i++) {
           //scale to between -1 and 1
            double x = ((((double) i) / getWidth()) * 2.0) - 1.0;
		    double y = ((((double) j) / getHeight()) * 2.0) - 1.0;
           
           //randon functons for red green and blue
           double r = rand1.getResult(x,y);
           double gr = rand2.getResult(x,y);
           double b = rand3.getResult(x,y);
           
           
	       
	        
            g2.setColor(new Color(convertDouble(r),convertDouble(gr),convertDouble(b)));
            
            g2.fillRect(i, j, 1, 1);
            
            
          

        }
         
       }
       //keep function in Array
       show[0] = rand1.toString();
       show[1] = rand2.toString();
       show[2] = rand3.toString();
    
    
    }
    
   
    /**
     * show the functions of RED GREEN and BLUE in Message Dialog .
     */
    public void showFunctions()
    {
      
       JOptionPane.showMessageDialog(new ArtPanel(), 
                    "Red: " +show[0] +"\nGreen: " +show[1] +"\nBlue: " +show[2],
                    "Functions", 
                    JOptionPane.INFORMATION_MESSAGE,new ImageIcon("information.png"));
    }
    
   /**
    * convert the value of functions to int type.
    */
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
	 
      }
     
    
    

  


  
   /**
    * create math functions by random.  
    * calculate that function.
    */
   class Functions {
    Random rand = new Random();
    int randomLevel = rand.nextInt((10 - 4) + 1) + 4;  //the depth levels is between 4 - 10 levels
    private String expression;
    private String shortFunction;
    
    public Functions(){
        expression = createFunction(randomLevel);
        shortFunction  = functionShorter(expression);
        }
    
     /**
    * create math functions by random.  
    * output: String 
    */
   public String createFunction (int levels){
         
        
        String[]normal = {"x","y","cos","sin","avg","sqr","tan","abs"};
        String[]complex = {"cos","sin","avg","abs"};
        char coordinate = (char) (new Random().nextInt(2) + 'x'); //random between x and y
        
        String result = "";
        
        
        if(levels ==1){
             String value1 = (normal[new Random().nextInt(normal.length)]);
             
             if (value1.equals("sin") ||value1.equals("cos" )||value1.equals("tan" )){
                 result = value1 + "(pi*" + coordinate + ")";
                }
             else if(value1.equals("avg" )){
                 result = value1 + "(" + coordinate + "," + coordinate + ")" ;
             }
             else if(value1.equals("sqr")||value1.equals("abs") ){
                 result = value1 + "(" + coordinate + ")";
                }
             
             else{
                 result = value1 ;
                }
        }else{
                String value = (complex[new Random().nextInt(complex.length)]);
                if((value.equals("sin") ||value.equals("cos") )&&levels!=0 ){
                    result = value + "(pi*" + createFunction(levels - 1) + ")";
                 
                }
                 else if((value.equals("avg"))&& levels >2  ){ 
                     result = value +"(" + createFunction  (levels-1) + "," + createFunction (levels-1) + ")" ;
                 
                }
                 else if(value.equals("abs") ){
                 result = value + "(" + createFunction  (levels-1) + ")";
                }
                else if((value.equals("avg"))&& levels ==2 ){
                    result = value + "(" + coordinate + "," + createFunction (levels - 1) + ")" ;
                 
                }
                else{
                 result = value ;
                }
        
            }
            
            
            return result; 
             
        }
        
        
    /**
    * output:  math functions.
    */
   public String toString(){
        return expression;
    }
    
 
     /**
    * input: infix math function.  
    * output: postfix short math function. 
    */
   public String functionShorter(String s){
        
        Stack<Character> operands = new Stack<Character>();
        String result = "" ;
        
        if(s.length()>2){
        
          for(int i = 0 ; i <s.length()-1;i++){
            char ch = s.charAt(i);
            char chNext = s.charAt(i+1);
            
            
            if(ch == 'x' ||ch == 'y' ) {
                operands.push(ch);
            }
            else if(ch == 's'&& chNext =='i') {
                operands.push('S');
            }else if(ch == 'c'&& chNext =='o') {
                operands.push('C');
            }else if(ch == 'a'&& chNext =='b') {
                operands.push('B');
             }else if(ch == 'a'&& chNext =='v') {
                operands.push('A');
            }else if(ch == 's'&& chNext =='q') {
                operands.push('Q');
            }else if(ch == 't'&& chNext =='a') {
                operands.push('T');
            
  
            }
            else if (ch == ')') {
               
                if (operands.peek()=='y'|| operands.peek()=='x'){
                   result = result + operands.pop() ;
                }
               
                result = result + operands.pop();
                

               }

                    
            }
  
           while(!operands.isEmpty()){
                result = result +  operands.pop();
           }

            return result ;
        }
         else {
           result = s;
           return result ;
        }
        } 
     
    
        
       /**
    * input: x value and y value  .
    * calculate postfix function. 
    * output: double result. 
    */
        public double getResult(double x, double y){
        Stack<Double> operands = new Stack<Double>();
        for(int i = 0; i < shortFunction.length(); i++){
            char ch = shortFunction.charAt(i);
            if(ch == 'x') 
                operands.push(x);
            else if(ch == 'y')
                operands.push(y);
            else{
                
                double op1 = operands.pop();
                if(ch == 'S')
                    operands.push(Math.sin(Math.PI * op1));
                else if(ch == 'C')
                    operands.push(Math.cos(Math.PI * op1));
                else if(ch == 'B')
                    operands.push(Math.abs(op1));
                else if( ch == 'Q')
                    operands.push(Math.sqrt(Math.abs(op1)));
                else if (ch == 'A')
                    operands.push(avg(op1, operands.pop()));
                
                else if (ch == 'T')
                    operands.push(Math.tan(Math.PI * op1));
                    
                
            }
        }
        assert operands.size() == 1 : operands.size();
        double result = operands.pop();
        result = (result < -1.0) ? -1.0 : (result > 1.0) ? 1.0 : result;
        assert -1.0 <= result && result <= 1.0 : result;
        return result;
    }
    
    /**
     * input : 2 operands
     * output: average by adding quantities together and then dividing the total by 2
     */public double avg(double x, double y){
        return (x + y) / 2.0;
    }
    
    
    
    
  }