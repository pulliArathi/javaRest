package iaas.restExample;

public enum Seasons {
	SUMMER("HEAT",45),WINTER("COLD",15),SPRING("RAIN",25);
	public String seasons;
	public int temp;
	
	Seasons(String seasons,int temp){
		this.seasons=seasons;
		this.temp=temp;	
}
}