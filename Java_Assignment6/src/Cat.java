import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Cat extends Pet implements Boardable{

	private String hairLength;
	private int monthStart, monthEnd, dayStart, dayEnd, yearStart, yearEnd;
	private Date startDate, endDate, boardingDate;
	
	SimpleDateFormat sdate = new SimpleDateFormat("mm-dd-yyyy");

	public Cat(String petName, String ownerName, String color, String hairLength) {
		super(petName, ownerName, color);
		this.hairLength = hairLength;
	}

	public String getHairLength(){
		return hairLength;
	}
	
	public String toString(){
		
		return(getClass().getName().toUpperCase() +":" +"\n" +super.toString() +"\n" +"Hair: " +getHairLength());
	}

	@Override
	public void setBoardStart(int month, int day, int year) {
		this.monthStart = month;
		this.dayStart = day;
		this.yearStart = year;
	}

	@Override
	public void setBoardEnd(int month, int day, int year) {
		this.monthEnd = month;
		this.dayEnd = day;
		this.yearEnd = year;
	}

	public Date getBoardStart(){
		try {
			startDate = sdate.parse(monthStart +"-" +dayStart +"-" +yearStart);
			return startDate;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return startDate;

	}

	public Date getBoardEnd(){
		try {
			endDate = sdate.parse(monthEnd +"-" +dayEnd +"-" +yearEnd);
			return endDate;
		} catch (ParseException e) {		
			e.printStackTrace();
		}		 
		return endDate;		
	}

	@Override
	public boolean boarding(int month, int day, int year){

		try {
			boardingDate = sdate.parse(month +"-" +day +"-" +year);
			
			if(boardingDate.after(getBoardStart()) && boardingDate.before(getBoardEnd())){
				System.out.println("The boarding date is in between start and end date");
				return true;
			}
			else if(boardingDate.equals(getBoardStart()) || boardingDate.equals(getBoardEnd())){
				System.out.println("The boarding date is equal to either start or end date");
				return true;
			}
			else {
				System.out.println("The boarding date is not in between or equal to start and end date");
				return false;
			}
		} catch (ParseException e) {
			System.out.println("The boarding date format is not correct");
			e.printStackTrace();
		}
		return false;				
	}
	
	public static void main(String[] args){
		
		Pet pet = new Cat("Kitty","Mary","Black and White","Long");
		Cat cat = (Cat)pet;	
		cat.setSex(FEMALE);
		System.out.println(pet);
		System.out.println();
				
		Cat cat1 = new Cat("Tom","Bob","Grey","Short");	
		cat1.setSex(3);
		System.out.println(cat1);
		System.out.println();
		
		cat.setBoardStart(8,12,2017);
		cat.setBoardEnd(8, 12, 2019);
		cat.boarding(8, 12, 2017); //Setting the date equal to start date
		
		cat1.setBoardStart(12, 25, 1990);
		cat1.setBoardEnd(12, 25, 1992);
		cat1.boarding(12, 26, 1991); //Setting the date in between start nad end dates
		
	}

}

