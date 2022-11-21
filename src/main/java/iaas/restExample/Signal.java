package iaas.restExample;
public enum Signal {
	RED("stop",30),YELLOW("wait",5),GREEN("move",20);
	public String action;
	public int time;
	Signal(String action,int time){
		this.action=action;
		this.time=time;
	}
}
