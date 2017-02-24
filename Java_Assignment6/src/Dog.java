import java.util.Date;

public class Dog extends Pet implements Boardable{

	private String size;
	private Date startDate, endDate, boardDate;

	public Dog(String petName, String ownerName, String color, String size) {
		super(petName, ownerName, color);
		this.size = size;	
	}

	public String getSize(){
		return size;
	}
	
	public String toString(){

		return (getClass().getName().toUpperCase() +":" +"\n" +super.toString() +"\n" +"Size: " +getSize());
	}

	public void setBoardStart(int month, int day, int year){
		startDate = new Date(month,day,year);
	}

	public void setBoardEnd(int month, int day, int year){
		endDate = new Date(month,day,year);
	}

	public boolean boarding(int month, int day, int year){
		boardDate = new Date(month,day,year);

		int validStartDate = startDate.compareTo(boardDate); //ideal case this will be negative
		int validEndDate = endDate.compareTo(boardDate);  //ideal case this will be positive

		if(validStartDate==0 || validEndDate==0){
			System.out.println("The boarding date is equal to either the start date or end date");
			return true;
		}
		else if(validStartDate<0 && validEndDate>0){
			System.out.println("The boarding date is within start and end date");
			return true;
		}
		else if(validStartDate>0 || validEndDate<0){
			System.out.println("The boarding date is not within the start and end date");
			return false;
		}
		else{
			System.out.println("Invalid date");
			return false;
		}
	}

		public static void main(String[] args){

		Dog dog1 = new Dog("Puppy", "Sara", "White", "Small");
		dog1.setSex(3);
		System.out.println(dog1 +"\n");

		dog1.setBoardStart(12, 24, 1996);
		dog1.setBoardEnd(12, 25, 1998);
		dog1.boarding(12, 25, 1999); //Setting a date outside the start and end dates
		System.out.println();

		Dog dog2 = new Dog("Spot","Susan","Black","Medium");
		dog2.setSex(MALE);
		System.out.println(dog2 +"\n");

		dog2.setBoardStart(02,26,2017);
		dog2.setBoardEnd(02, 26, 2019);
		dog2.boarding(02, 26, 2019);  //Setting a date equal to end date

	}

}

