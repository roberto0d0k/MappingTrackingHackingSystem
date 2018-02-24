package sensors;

//Items which recognize IDs
public interface Gate extends IDable{

	 public String getName(); 
	 public boolean isMobileActivityGate();
	 public boolean isStaticActivityGate();
	 public boolean isTransferGate();
	
}
