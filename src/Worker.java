
public class Worker {
	
	private String workerName;
	private String password;
	
	public Worker (String workerName, String password) {
		this.workerName = workerName;
		this.password = password;
	}
	
	public String getWorkerName() {
		return this.workerName;
	}
	public void setWorkerName(String workerName) {
		this.workerName = workerName;
	}
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean equals(Worker other) {
		return this.workerName.equals(other.workerName) && this.password.equals(other.password);
	}
	public String toString() {
		return "{" + this.workerName + "," + this.password+"}";
	}
}





