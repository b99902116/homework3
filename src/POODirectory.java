/**
 * Behavior and contend of Directory
 */
class POODirectory{
    static final int MAX = 1024;
    final byte ITEM = 0;
    final byte BOARD = 1;
    final byte DIR = 2;
    final byte LINE = 3;
    private int[] item = new int [MAX];
    private int[] count = new int [3];	// ITEM,BOARD,DIR

    private POOBoard [] board = new POOBoard [MAX];
    private POODirectory [] dir = new POODirectory [MAX];
    
    String Dir_name;
    /**
     * create a directory with the name
     * @param name the name of directory which be created
     */
    public POODirectory(String name){
	Dir_name = name;
    }
    /**
     * get the title of directory
     * @return the name of directory
     */
    public String get_title(){
	return Dir_name;
    }
    
    /**
     * append the board to the directory
     * @param board the board that be added to the directory
     */
    public void add(POOBoard board){
	if ( count[ITEM] < MAX ) {
	    this.board[++count[BOARD]] = board;
	    item[++count[ITEM]] = BOARD;
	}
    }
    
    /**
     * append the directory to the directory
     * @param dir the directory that be added to the directory
     */
    public void add(POODirectory dir){
	if ( count[ITEM] < MAX ) {
	    this.dir[++count[DIR]] = dir;
	    item[++count[ITEM]] = DIR;
	}
    }
    
    /**
     * append a splitting line to the directory
     */
    public void add_split(){
	item[++count[ITEM]] = LINE;
    }
    
    /**
     * delete the board/directory/splitting line at position pos
     * @param pos a position of delete-item in the directory
     */
    public void del(int pos){
	if ( pos <= count[ITEM] ) {	// exist article at this position
	    if ( item[pos] == DIR ) {
		for (int i=pos; i<count[DIR]; i++) 
		    dir[i] = dir[i+1];    
		count[DIR]--;	// if pos equal to count[DIR], then dir[pos] will be hidden when count[DIR] decreased
	    }
	    else if ( item[pos] == BOARD ) {
		for (int i=pos; i<count[BOARD]; i++) 
		    board[i] = board[i+1];    
		count[BOARD]--;
	    }
	    
	 // if item[pos] is LINE, then item[pos] will be hidden when item[i] move backward one value
	    for (int i=pos; i<count[ITEM]; i++) 
		item[i] = item[i+1];    
	    count[ITEM]--;
	}
    }
    
    /**
     * Move the board/directory/splitting line at position src to position dest. <br/>
     * If dest > num_item, then dest is the last article (equal to num_item)
     * @param src a position of source-item in the directory
     * @param dest a position of destination-item in the directory
     */
    public void move(int src, int dest){
	if ( src > count[ITEM] ) {  return; 		}	    
	if ( dest > count[ITEM] ) { dest = count[ITEM]; }
	
	if ( item[src] == DIR ) {
	    int src_ID = 0, dest_ID = 0;
	    for (int i=1; i<=src; i++) 
		if ( item[i] == DIR ) {	src_ID++;  }
	    for (int i=1; i<=dest; i++) 
		if ( item[i] == DIR ) { dest_ID++; }
	    	    
    	    if ( src > dest) {	// jump back
    		if ( src_ID != dest_ID ) {    // must be change order of dir[]
    		    POODirectory tmp = dir[src_ID];
    		    for (int i=src_ID; i>dest_ID; i--) 
    			dir[i] = dir[i-1];    
    		    dir[dest_ID] = tmp;
    		}
    	    }   
    	    else if ( src < dest ) {	// jump former
    		if ( src_ID != dest_ID ) {    // must be change order of dir[]
    		    POODirectory tmp = dir[src_ID];
    		    for (int i=src_ID; i<dest_ID; i++) 
    			dir[i] = dir[i+1];    
    		    dir[dest_ID] = tmp;
    		}
    	    }
	}	
	else if ( item[src] == BOARD ) {
	    int src_ID = 0, dest_ID = 0;
	    for (int i=1; i<=src; i++) 
		if ( item[i] == BOARD ) {	src_ID++;  }
	    for (int i=1; i<=dest; i++) 
		if ( item[i] == BOARD ) { dest_ID++; }
	    
    	    if ( src > dest) {	// jump back
    		if ( src_ID != dest_ID ) {    // must be change order of dir[]
    		    POOBoard tmp = board[src_ID];
    		    for (int i=src_ID; i>dest_ID; i--) 
    			board[i] = board[i-1];    
    		    board[dest_ID] = tmp;
    		}
    	    }   
    	    else if ( src < dest ) {	// jump former
    		if ( src_ID != dest_ID ) {    // must be change order of dir[]
    		    POOBoard tmp = board[src_ID];
    		    for (int i=src_ID; i<dest_ID; i++) 
    			board[i] = board[i+1];    
    		    board[dest_ID] = tmp;
    		}
    	    }
	}
	int tmp_item = item[src] ;
	if ( src > dest) 	// jump back
	    for (int i=src; i>dest; i--) 
		item[i] = item[i-1];	// move forward	
	else if ( src < dest ) 	// jump former
	    for (int i=src; i<dest; i++) 
		item[i] = item[i+1];	// move backward
	item[dest] = tmp_item;
    }
    
    /**
     * get the current number of items in the directory
     * @return length of directory
     */
    public int length() {
      return count[ITEM];
    }
    
    /**
     * show the board/directory titles and splitting lines of the directory
     */
    public void show() {
	int count_board = 0, count_dir = 0;
	for (int i=1; i<=count[ITEM]; i++) {
	    switch (item[i]) {
	    	case DIR:
	    	    System.out.println(dir[++count_dir].get_title());
	    	    break;
	    	case BOARD:
	    	    System.out.println(board[++count_board].get_title());
	    	    break; 
	    	case LINE:
	    	    System.out.println("----------------------------");
	    	    break; 
	    }
	}
    }
}