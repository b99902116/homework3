import java.util.Scanner;

/**
 * @author b99902116 ¦ó¬fº~ <br/>
 * There is a Demo for TAs. <br/>
 * You should be input four String for push(x2), boo, arrow. <br/>
 * Everything else will be run as my design.
 */
public class Demo {
    static Scanner input_obj = new Scanner(System.in);
    public static void main(String[] argv) {	
	POODirectory dir1 = new POODirectory("dir1");
	POODirectory dir2 = new POODirectory("dir2");
	
	POOBoard board1 = new POOBoard("board1");
	POOBoard board2 = new POOBoard("board2");
	POOBoard board3 = new POOBoard("board3");
	
	POOArticle art1 = new POOArticle("art1", "user1", "I'm user1");
	POOArticle art2 = new POOArticle("art2", "user2", "I'm user2");
	POOArticle art3 = new POOArticle("art3", "user3", "I'm user3");
	POOArticle art4 = new POOArticle("art4", "user4", "I'm user4");
	
	// check for POOArticle
	// push, boo, arrow
	System.out.print("*input push: ");
	art1.push();
	System.out.print("*input boo: ");
	art1.boo();
	System.out.print("*input arrow: ");
	art1.arrow();
	System.out.print("*input push2: ");
	art1.push();
	
	// show
	System.out.println("***** Show art1 *****");
	art1.show();
	
	// list
	System.out.println("***** list of art1 *****");
	art1.list();
	
	/* check for POOBoard */
	// add
	System.out.println("***** Add art1,art2,art3,art4 to board1 *****");
	board1.add(art1);
	board1.add(art2);
	board1.add(art3);
	board1.add(art4);
	
	// show
	System.out.println("***** Show board1 *****");
	board1.show();
	
	// move
	System.out.print("*input src and des: ");
	int a = input_obj.nextInt();
	int b = input_obj.nextInt();
	board1.move(a,b);
	System.out.println("***** Show board1 after move("+a+","+b+") *****");
	board1.show();	
	
	// length
	System.out.println("length of board: " + board1.length());
	
	// delete article
	System.out.print("*input delete-pos: ");
	int de = input_obj.nextInt();
	board1.del(de);
	System.out.println("***** Show board1 after del("+de+") *****");
	board1.show();
	
	/* check for POODirectory  */
	// add item
	System.out.println("***** Add board1,dir2,line,board2 to dir1 *****");	
	dir1.add(board1);
	dir1.add(dir2);
	dir1.add_split();
	dir1.add(board2);
	System.out.println("***** Add board3 to dir2 *****");
	dir2.add(board3);
	
	// show
	System.out.println("***** Show dir2 *****");
	dir2.show();
	System.out.println("***** Show dir1 *****");
	dir1.show();
	
	// move
	System.out.print("*input src and des: ");
	int c = input_obj.nextInt();
	int d = input_obj.nextInt();
	dir1.move(c,d);
	System.out.println("***** Show dir1 after move("+c+","+d+") *****");	
	dir1.show();
	
	// delete item
	System.out.print("*input delete-pos: ");
	de = input_obj.nextInt();
	dir1.del(de);
	System.out.println("***** Show dir1 after del("+de+") *****");
	dir1.show();
	
	// show length
	System.out.println("length of board: " + dir1.length());	
    }
}