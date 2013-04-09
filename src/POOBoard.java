/**
 * Behavior and contend of Board
 */
public class POOBoard {
    static final int MAXART = 1024;  
    private int num_article;
    private POOArticle [] art = new POOArticle [MAXART]; 
    
    String board_name;
    /**
     * create a board with the name
     * @param name name of the board
     */
    public POOBoard(String name){
	board_name = name;
    }
    /**
     * get the title of directory
     * @return the name of directory
     */
    public String get_title(){
	return board_name;
    }
    
    /**
     * append the article to the board
     * @param article the article that be added to the board
     */
    public void add(POOArticle article) {
	num_article++;
	if ( num_article < MAXART ) {
	    art[num_article] = article;
	    art[num_article].set_ID(num_article);
	}
    }
    
    /**
     * delete the article at position pos
     * @param pos the number of article in the board
     */
    public void del(int pos) {	
	if ( pos <= num_article ) {	// exist article at this position
	    for (int i=pos; i<num_article; i++) {
		art[i] = art[i+1];
		art[i].ID_decreases();
	    }
	    num_article--;
	}
	// if pos equal to num_article that mean it's the last article on the board
	// So, it will be hidden when num_article decreases one value.
    }
    
    /**
     * Move the article at position src to position dest <br/>
     * If dest > num_article, then dest is the last article (equal to num_article)
     * @param src a ID of source-article in the board
     * @param dest a ID of destination-article in the board
     */
    public void move(int src, int dest) {	
	if ( src > num_article )
	    return;
	if ( dest > num_article )
	    dest = num_article;
	
	POOArticle tmp = art[src];
	if ( src > dest) {	// jump back
	    for (int i=src; i>dest; i--) {
		art[i] = art[i-1];	// move forward
		art[i].ID_increases();
	    }
	    art[dest] = tmp;
	}
	else if ( src < dest ) {	// jump former
	    for (int i=src; i<dest; i++) {
		art[i] = art[i+1];	// move backward
		art[i].ID_decreases();
	    }
	    art[dest] = tmp;
	}
    }
    
    /**
     * get the current number of articles in the board
     * @return length of the board
     */
    public int length() {
        return num_article;
    }
    
    /**
     * show the article titles of the board
     */
    public void show() {
	for (int i=1; i<=num_article; i++)
	    System.out.println(art[i].get_title());
    }
    
}