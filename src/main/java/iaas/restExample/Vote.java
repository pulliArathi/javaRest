package iaas.restExample;
public class Vote {
	public boolean canVote(int age) {
		if(age<18)
			return false;
		else
			return true;
	}
}


