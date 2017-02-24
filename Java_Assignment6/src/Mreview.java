import java.util.*;

public class Mreview extends java.lang.Object implements Comparable<Mreview>{

	//instance variables
	private String title;  //title of the movie
	private ArrayList<Integer> ratings; //list of ratings stored in a store object

	public Mreview(){
		title = "";
		ratings = new ArrayList<Integer>();
	}

	public Mreview(java.lang.String ttl){
		this.title = ttl;
		ratings = new ArrayList<Integer>();
	}

	public Mreview(java.lang.String ttl, int firstRating){
		this.title = ttl;
		ratings = new ArrayList<Integer>(1);
		ratings.add(firstRating);
	}

	public java.lang.String getTitle(){
		return title;
	}

	public void addRating(int r){
		ratings.add(r);
	}

	public double aveRating() throws ArithmeticException{

		int sum = 0;
		for(int r: ratings){
			sum +=r;
		}

		try{

			return (double)sum/numRatings();

		}catch(ArithmeticException e){

			System.out.println("Divide by zero error");
			e.printStackTrace();
		}
		return (double)sum/numRatings();
	}

	//returns the size of ratings list
	public int numRatings(){
		return ratings.size();		
	}

	@Override
	public int compareTo(Mreview obj) {

		int var1 = this.title.compareTo(obj.title); //Mreview implements comparable and defines the "compareTo" method

		if(var1<0){ 
			System.out.println("The parameter movie title is coming after the movie title. Number returned is: " +var1);
			return var1;
		}
		else if (var1>0){  
			System.out.println("The parameter movie title is coming before the movie title. Number returned is: " +var1);
			return var1;
		}
		else 
			System.out.println("The parameter movie title and the movie title are the same. Number returned is: " +var1);
		return var1;
	}

	@Override
	public boolean equals(java.lang.Object obj) throws ClassCastException{	

		try {
			Mreview mr = (Mreview) obj; //Casting obj to be Mreview object
			if(this.title.equals(mr.title)){
				return true; //if the two movies are the same
			}
			else {
				return false; //if the two movies are different
			}

		} catch (ClassCastException e) {
			System.out.println("Cast exception has occured");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public java.lang.String toString(){

		return (getTitle() +", average " +aveRating() +" out of " +numRatings() +" ratings");	

	}

	public static void main(String args[]){

		Mreview muv = new Mreview("The Jungle Book");
		muv.addRating(6);
		muv.addRating(8);
		muv.addRating(7);
		System.out.println(muv);  //6+8+7 = 21, 21/3 = 7
		System.out.println();

		Mreview muv2 = new Mreview("Batman",4);
		muv2.addRating(6);
		muv2.addRating(10);
		muv2.addRating(7);
		System.out.println(muv2); //4+6+10+7 = 27, 27/4 = 6.75
		System.out.println();

		muv.compareTo(muv2);  //The movie - Batman comes before The Jungle Book(lexicographically)
		muv2.compareTo(muv);  //The movie - The jungle Book comes after Batman
		muv.compareTo(muv);   //The two movies are the same
		System.out.println();

		Mreview muv3 = new Mreview("Batman");
		System.out.println("The two movies are the same: " +muv3.equals(muv2));  //The two movies are the same!
		Mreview muv4 = new Mreview("Passengers");
		System.out.println("The two movies are the same: " +muv.equals(muv4));  //The two movies are different (comparing The Jungle Book and Passengers)

		//Mreview muv5 = new Mreview();  //Checking divide by zero arithmetic exception
		//muv5.aveRating();
	}
}
