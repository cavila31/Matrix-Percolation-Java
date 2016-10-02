import java.util.Random;

public class Percolation {
	 	private int[][] id;
	   public Percolation(int n)               // create n-by-n grid, with all sites blocked
	   {
		   id = new int[n][n];
		   
		   for (int i=0; i<=n-1; i++){
			   for (int j=0; j<=n-1; j++){
				   id[i][j]=0;
			   }			   
		   }
	   }
	   public void open(int i, int j)          // open site (row i, column j) if it is not open already
	   {
		   if (id[i][j]==0){
			   id[i][j]=1; 
		   }
	   }
	   public boolean isOpen(int i, int j)     // is site (row i, column j) open?
	   {
		   if ((i>=0 && i<=id.length-1) && (j>=0 && j<=id.length-1)) {
		   if (id[i][j]==1){
			   return true;
		   }
		   else {
			   return false;
		   }
		   }
		   else {
			   return false;
		   }
	   }
	   public boolean isFull(int i, int j)     // is site (row i, column j) full
	   {   
		   boolean answer= false;

		   if ((i>=0 && i<=id.length-1) && (j>=0 && j<=id.length-1)) {
		   int a = id[i][j];
		   if (a==2){
			   answer = true;
		   }
		   else if (isOpen(i,j)){
			   if (i!=0 && j!=0 && i!=id.length-1 && j!=id.length-1){				   
				   if (isOpen(i-1,j) || isOpen(i+1, j) || isOpen(i, j-1) || isOpen(i, j+1) || id[i-1][j]==2 || id[i+1][j]==2 || id[i][j-1]==2 || id[i][j+1]==2){
					   id[i][j]=2;
					   answer= true;				   
				   }				   
			   }
			   else {				   
				   if (i==0 && j==0){
					   if (isOpen(i+1, j) || isOpen(i, j+1) || id[i+1][j]==2 || id[i][j+1]==2){
						   id[i][j]=2;
						   answer= true;				   
					   }
				   	}
				   if (i==0 && j==id.length-1){
					   if (isOpen(i+1, j) || isOpen(i, j-1) || id[i+1][j]==2 || id[i][j-1]==2){
						   id[i][j]=2;
						   answer= true;				   
					   }
				   	}
				   if (i==id.length-1 && j==0){
					   if (isOpen(i-1,j) || isOpen(i, j+1) || id[i-1][j]==2 || id[i][j+1]==2){
						   id[i][j]=2;
						   answer= true;				   
					   }
				   	}
				   if (i==id.length-1 && j==id.length-1){
					   if (isOpen(i-1,j) || isOpen(i, j-1) || id[i-1][j]==2 || id[i][j-1]==2){
						   id[i][j]=2;
						   answer= true;				   
					   }
				   	}
				   if (i==0 && j!=0 && j!=id.length-1){
					   if (isOpen(i+1, j) || isOpen(i, j-1) || isOpen(i, j+1) || id[i+1][j]==2 || id[i][j-1]==2 || id[i][j+1]==2){
						   id[i][j]=2;
						   answer= true;				   
					   }
				   	}
				   if (j==0 && i!=0 && i!=id.length-1){
					   if (isOpen(i-1,j) || isOpen(i+1, j) || isOpen(i, j+1) || id[i-1][j]==2 || id[i+1][j]==2 || id[i][j+1]==2){
						   id[i][j]=2;
						   answer= true;				   
					   }
				   	}
				   if (i==id.length-1 && j!=0 && j!=id.length-1){
					   if (isOpen(i-1, j) || isOpen(i, j-1) || isOpen(i, j+1) || id[i-1][j]==2 || id[i][j-1]==2 || id[i][j+1]==2){
						   id[i][j]=2;
						   answer= true;				   
					   }
				   	}
				   if (j==id.length-1 && i!=0 && i!=id.length-1){
					   if (isOpen(i-1,j) || isOpen(i+1, j) || isOpen(i, j-1) || id[i-1][j]==2 || id[i+1][j]==2 || id[i][j-1]==2){
						   id[i][j]=2;
						   answer= true;				   
					   }
				   	}
				   
				   }
			   }
		   }

		   return answer;
	   }
  
	   public boolean percolates()             // does the system percolate?	
	   {
		   boolean answer=false;
		   int a=0;
		   while (a< id.length && answer==false){
			   if (isFull(0,a)){
				   answer = percolating1(0, a);
			   }
		   a++;
		   }
		   return answer;
	   }
	   
	   private boolean percolating1(int i, int j){
		   
		   if ((i>=0 && i<=id.length-1) && (j>=0 && j<=id.length-1)) {
		   
			   if (i==id.length-1 && isOpen(i,j) && j>=0 && j<=id.length-1){
				   return true;
			   } 
			   else {
				   if (isFull(i,j)){
					   id[i][j]=3;
					  return percolating1(i+1,j) || percolating1(i,j-1) || percolating1(i,j+1);
				   }
				   else {
					   return false;					   
				   }
			   }
			   } 
		   else {
			   return false;
		   }		   		   	   
	   }
	   
	   public void printing (){
		   for (int i = 0; i < id.length; i++) {
			    for (int j = 0; j < id[i].length; j++) {
			        System.out.print(id[i][j] + " ");
			    }
			    System.out.println();
			}
		    System.out.println();
	   }
	   
	   public void llenarRandom (){
		    
			   for (int i = 0; i < id.length; i++) {
				    for (int j = 0; j < id[i].length; j++) {
					    Random rand= new Random();
				        id[i][j]= rand.nextInt((1 - 0) + 1) + 0;
				    }
				}	   
	   }
	   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Percolation perco = new Percolation(4); 
		perco.llenarRandom();
		perco.printing();
		System.out.println(perco.percolates());
		
	}
	

}


