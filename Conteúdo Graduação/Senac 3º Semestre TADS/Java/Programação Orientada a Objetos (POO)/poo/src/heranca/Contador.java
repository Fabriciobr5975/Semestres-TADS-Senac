package heranca;

import java.util.Objects;

public class Contador extends Funcionario {
	private String numCrc;

	public Contador() {
		System.out.println("Passou pelo Contador");
	}
	
	public String getNumCrc() {
		return numCrc;
	}

	public void setNumCrc(String numCrc) {
		this.numCrc = numCrc;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(numCrc);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contador other = (Contador) obj;
		return Objects.equals(numCrc, other.numCrc);
	}
	
	@Override
	public String toString() {
		return this.getNome() + " " + " - CRC: " + this.getNumCrc();
	}
}