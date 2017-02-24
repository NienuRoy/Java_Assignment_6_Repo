public interface Boardable {
	
	public abstract void setBoardStart(int month, int day, int year); //abstract keyword can either be used or not in an interface class method
	public void setBoardEnd(int month, int day, int year);
	public boolean boarding(int month, int day, int year);

}

