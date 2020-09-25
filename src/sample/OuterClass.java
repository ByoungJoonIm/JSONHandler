package sample;
import java.util.ArrayList;

public class OuterClass {
	private int intField;
	private boolean booleanField;
	private double doubleField;
	private char charField;
	private String stringField;
	private ArrayList<InnerClass> arrayField;
	
	@Override
	public String toString() {
		return "TempClass [intField=" + intField + ", booleanField=" + booleanField + ", doubleField=" + doubleField
				+ ", charField=" + charField + ", stringField=" + stringField + ", arrayField=" + arrayField + "]";
	}
	public double getDoubleField() {
		return doubleField;
	}
	public void setDoubleField(double doubleField) {
		this.doubleField = doubleField;
	}
	public boolean isBooleanField() {
		return booleanField;
	}
	public void setBooleanField(boolean booleanField) {
		this.booleanField = booleanField;
	}
	public char getCharField() {
		return charField;
	}
	public void setCharField(char charField) {
		this.charField = charField;
	}

	public int getIntField() {
		return intField;
	}
	public void setIntField(int intField) {
		this.intField = intField;
	}
	public String getStringField() {
		return stringField;
	}
	public void setStringField(String stringField) {
		this.stringField = stringField;
	}
	public ArrayList<InnerClass> getArrayField() {
		return arrayField;
	}
	public void setArrayField(ArrayList<InnerClass> arrayField) {
		this.arrayField = arrayField;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arrayField == null) ? 0 : arrayField.hashCode());
		result = prime * result + (booleanField ? 1231 : 1237);
		result = prime * result + charField;
		long temp;
		temp = Double.doubleToLongBits(doubleField);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + intField;
		result = prime * result + ((stringField == null) ? 0 : stringField.hashCode());
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
		OuterClass other = (OuterClass) obj;
		if (arrayField == null) {
			if (other.arrayField != null)
				return false;
		} else if (!arrayField.equals(other.arrayField))
			return false;
		if (booleanField != other.booleanField)
			return false;
		if (charField != other.charField)
			return false;
		if (Double.doubleToLongBits(doubleField) != Double.doubleToLongBits(other.doubleField))
			return false;
		if (intField != other.intField)
			return false;
		if (stringField == null) {
			if (other.stringField != null)
				return false;
		} else if (!stringField.equals(other.stringField))
			return false;
		return true;
	}
	
	
}
