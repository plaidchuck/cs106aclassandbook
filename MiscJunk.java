/* this program displays all 10 verses
* for the children's rhyme "This Old Man"
* using a "for loop" to increment each verse
* and uses a "switch statement" to plug in a word
* that rhymes with the specific verse number
*/
 
import acm.program.*;
 
 
public class MiscJunk extends ConsoleProgram {
     
    public void run () {
         
        /*"for loop" used to increment the verse numbering by using i*/
         
        for (int i = 1; i<= 10; i++) {
        	
        	 println("This old man, he played " + i + ".  ");             
             
                 
        /*"switch statement" used to plug in a rhyming word for each specific verse
          using i*/  
                    switch (i) {
                        case 1: println ("He played knick-knack on my thumb." );  break;
                        case 2: println ("He played knick-knack on my shoe." );  break;
                        case 3: println ("He played knick-knack on my knee." );  break;
                        case 4: println ("He played knick-knack on my door." ); break;
                        case 5: println ("He played knick-knack on my hive." ); break;
                        case 6: println ("He played knick-knack on my sticks." ); break;
                        case 7: println ("He played knick-knack on my heaven." );  break;
                        case 8: println ("He played knick-knack on my gate." ); break;
                        case 9: println ("He played knick-knack on my spine." ); break;
                        case 10: println ("He played knick-knack on my pen." ); break;
                    }
        /*the remaining lines of the rhyme*/   
                    println ("With a knick-knack, paddy-whack." );
                    println ("Give your dog a bone." );
                    println ("This old man came rolling home.");    
                    println ("  ");
       
        }
    }
}