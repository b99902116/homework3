import java.util.Scanner;

/**
 * Behavior and content of Article
 */
public class POOArticle {   
    static final int MAXEVAL = 100;
   // static final int MAXBOARD = 1000;
   // private static int[] num_ID = new int [MAXBOARD]; // number-ID for each board, at most have 1000 board
    private int ID; 	// the number of article in the board 
    private String title;
    private String author;
    private String content;
    private int count;	// 0 for push; 1 for boo
    private String [] messages = new String [MAXEVAL];
    
    /**
     * Create a Article with the title, author and content 
     * @param arg1 title of article
     * @param arg2 author of article
     * @param arg3 content of article
     */
    public POOArticle(String arg1, String arg2, String arg3){
	title = arg1;    
	author = arg2;   
	content = arg3;
    }
    
    private int num_msg;
    Scanner input_obj = new Scanner(System.in);
    
    /**
     * Adds a line to the evaluation messages, increases the evaluation count by 1
     */
    public void push(){
	count++;
	if ( num_msg < MAXEVAL )
	    messages[num_msg++] = "push: " + input_obj.nextLine();
	else
	    System.out.println("Evaluation messages are full.");
    }
    
    /**
     * Adds a line to the evaluation messages, decreases the evaluation count by 1
     */
    public void boo(){
	count--;
	if ( num_msg < MAXEVAL )
	    messages[num_msg++] = "boo: " + input_obj.nextLine();
	else
	    System.out.println("Evaluation messages are full.");
    }
    
    /**
     * Adds a line to the evaluation messages
     */
    public void arrow(){
	if ( num_msg < MAXEVAL )
	    messages[num_msg++] = "-> " + input_obj.nextLine();
	else
	    System.out.println("Evaluation messages are full.");
    }
    
    /**
     * Shows all the article information, the content, and the evaluation messages
     */
    public void show(){
	if (ID < 1000) {
	    String id_3digit = String.format("%03d", ID);
	    System.out.print( id_3digit + "\t");
	}
	else
	    System.out.println( ID + "\t"); // more than 3 digit
	System.out.print( title + "\t");
	System.out.println( author );
	System.out.println("evaluation count: " + count );
	System.out.println("content: " + content );
	System.out.println("-----evaluation messages-----");
	for (int i=0; i<num_msg; i++)
	    System.out.println(messages[i]);
    }
    
    /**
     * Shows the evaluation count, the ID, the title, and the author of the article
     */
    public void list(){
	if (ID < 1000) {
	    String id_3digit = String.format("%03d", ID);
	    System.out.print(id_3digit + "\t");
	}
	else
	    System.out.print(ID + "\t"); // more than 3 digit
	System.out.print(title + "\t");
	System.out.println(author );
	System.out.println("evaluation count: " + count );
    }
    
    /**
     * set a ID
     * @param num a new value of ID
     */
    public void set_ID(int num) {	ID = num;    }
    
    /**
     * ID decreases one value
     */
    public void ID_decreases(){		ID--;    }
    /**
     * ID increases one value
     */
    public void ID_increases(){		ID++;    }
    
    /**
     * get the title of article
     * @return the tile 
     */
    public String get_title(){
	return title;
    }
}
