package bigPackage;

import java.util.ArrayList;

public class DAO {
	private ArrayList<RegisterLogic> registers = new ArrayList();

	public ArrayList<RegisterLogic> returnRegister() {
		return registers;
    }
    
    public void addRegister(RegisterLogic register) {
		registers.add(register);
	}
}
