package heranca;

public class Engenheiro extends Funcionario {
	private String numCrea;

	public Engenheiro() {
		System.out.println("Passou pelo Engenheiro");
	}
	
	public String getNumCrea() {
		return numCrea;
	}

	public void setNumCrea(String numCrea) {
		this.numCrea = numCrea;
	}
}