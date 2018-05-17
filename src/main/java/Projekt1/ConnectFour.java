package projekt1;

public class ConnectFour {
	
	private int height = 6;
    private int width = 7;
    public char[][] board = new char[height][width]; 
    private int winner = 0;
    
    public int getWinner() {
    	return winner;
    }
    
    public int getHeight() {
    	return height;
    }
    
    public int getWidth() {
    	return width;
    }
    
    
    public void makeBoard() {
        for(int i=0; i<height; i++) {
            for(int j=0; j<width; j++) {
                board[i][j] = '-';                
            }
        }
    } 
    
    public void changeSize(int wid, int hei) {
        height = hei;
        width = wid;
        board = new char[height][width];
    } 
       
    
    public void printBoard() {
        for(int i=0; i<height; i++) {
            System.out.println();
            for(int j=0; j<width; j++) {
                System.out.print(" " + board[i][j]);
            }
        }
    }
    
   
    public void winTest(int pos_x, int pos_y, char disc, int player) {     	
    	
    	int hor = 0 ; //horizontal axle
    	int ver = 0; //vertical axle
    	int diag_r = 0; //  /
    	int diag_l = 0; //  \
    	
    	
    	//hor (->)
    	for(int i=pos_y; i<(width-1); i++) {
	    	if(i < (width-1) && board[pos_x][i + 1] == disc) {
	    		hor++;	    		
	    	} else 
	    		break;
    	}
    	//hor (<-)
    	for(int i=pos_y; i>0; i--) {
	    	if(i > 0 && board[pos_x][i - 1] == disc) {
	    		hor++;	    		
	    	} else 
	    		break;
    	}
    	
    	//ver (+)
    	for(int i=pos_x; i<(height-1); i++) {
	    	if(i < (height-1) && board[i + 1][pos_y] == disc) {
	    		ver++;	    		
	    	} else 
	    		break;
    	}
    	//ver (-)
    	for(int i=pos_x; i>0; i--) {
	    	if(i > 0 && board[i - 1][pos_y] == disc) {
	    		ver++;	    		
	    	} else 
	    		break;
    	}
    	
    	//diag ( / - )    	
    	int j = pos_y;    	
    	for(int i=pos_x; i<height; i++) {
	    	if(( i + 1) < height && ( j - 1) >= 0 && board[i + 1][j - 1] == disc) {
	    		diag_r++;	    		
	    	} else 
	    		break;	    	
	    	j--;
    	}
    	
    	//diag ( / + )    	
    	j = pos_y;    	
    	for(int i=pos_x; i>0; i--) {    
	    	if((i-1) > 0 && (j+1) < width && board[i - 1][j + 1] == disc) {
	    		diag_r++;	    		
	    	} else 
	    		break;	    	
	    	j++;
    	}
    	
    	//diag ( \ - )    	
    	j = pos_y;    	
    	for(int i=pos_x; i<height; i++) {       	
	    	if((i+1) < height && (j+1) < width && board[i + 1][j + 1] == disc) {
	    		diag_l++;	    		
	    	} else 
	    		break;	    	
	    	j++;
    	}
    	
    	//diag ( \ + )    	
    	j = pos_y;    	
    	for(int i=pos_x; i>0; i--) {      		
	    	if((i-1) > 0 && (j-1) > 0 && board[i - 1][j - 1] == disc) {
	    		diag_l++;	    		
	    	} else 
	    		break;	    	
	    	j--;
    	}
    	
    	
    	if(hor >= 3 || ver >=3 || diag_r >= 3 || diag_l >= 3) {    		
    		winner = player+1;    		
    	}    	
    	
    }   
   
    
    
    public boolean placeDisc(int pos, int player) throws Exception {
    	char disc;
    	
    	if ( pos < 0 || pos > width) {    		
    		throw new Exception("Zla pozycja. Krazek nie moze znajdowac sie w tym miejscu");
    	} else {	
    	
	    	if(player == 0)
	    		disc = 'o';
	    	else 
	    		disc = 'x'; 	  	
	    	
	    	for(int i=0; i < height; i++) { 
	    		
	    		//test full stack
	    		if(i == 0 && board[i][pos] != '-') {
	    			System.out.println("Stos pelny");	    			
	    			return false;
	    		}
	    		
			    if(i < (height-1) && board[i+1][pos] != '-' ) {
			    	board[i][pos] = disc;
			    	winTest(i,pos,disc,player);
			    	return true;
			    }	    
			    else if (i == (height-1)) {    			
		    		board[i][pos] = disc;
		    		winTest(i,pos,disc,player);
		    		return true;
		    	}   	
		      
	    	}  	    	
    	}
		return false;
        
    }	
	
    
    
	
}