package sample;

public class InnerClass {
	private int val1;
	private String val2;
	
	public InnerClass(){
		
	}
	
	public InnerClass(int val1, String val2){
		this.val1 = val1;
		this.val2 = val2;
	}
	
	public int getVal1() {
		return val1;
	}
	public void setVal1(int val1) {
		this.val1 = val1;
	}
	public String getVal2() {
		return val2;
	}
	public void setVal2(String val2) {
		this.val2 = val2;
	}
	@Override
	public String toString() {
		return "InnerClass [val1=" + val1 + ", val2=" + val2 + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + val1;
		result = prime * result + ((val2 == null) ? 0 : val2.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InnerClass other = (InnerClass) obj;
		if (val1 != other.val1)
			return false;
		if (val2 == null) {
			if (other.val2 != null)
				return false;
		} else if (!val2.equals(other.val2))
			return false;
		return true;
	}
}
