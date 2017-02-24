public class Pet {

	private String petName;
	private String ownerName;
	private String color;
	protected int sexId;

	public final static int MALE = 1, FEMALE = 2, SPAYED = 3, NEUTERED = 4;

	public Pet(String petName,String ownerName,String color){
		this.petName = petName;
		this.ownerName = ownerName;
		this.color = color;
	}

	public String getPetName(){
		return petName;
	}

	public String getOwnerName(){
		return ownerName;
	}

	public String getColor(){
		return color;
	}

	public void setSex(int sexId){
		this.sexId = sexId;
	}

	public String getSex(){

		if(sexId==1){
			return "Male";
		}
		if(sexId==2){
			return "Female";
		}
		if(sexId==3){
			return "Spayed";
		}
		if(sexId==4){
			return "Neutered";
		}
		return "Not valid";

	}
	@Override
	public String toString(){

		return (getPetName() +" owned by " +getOwnerName() +"\n" +"Colour: " +getColor() 
		+"\n" +"Sex: "+getSex());

	}
	
	public static void main(String[] args){
		
		Pet pet = new Pet("Spot", "Mary", "Black and White");
		pet.setSex(1);
		System.out.println(pet);
	}
	
}

