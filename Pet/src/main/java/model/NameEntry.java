//タスク当日管理用実施者項目リストのEntityの作成

package model;

import java.io.Serializable;

public class NameEntry implements Serializable {
	private int number;
	private String nameEntry;
	
	public NameEntry(){}
	
	public NameEntry(int number,String nameEntry){
		this.number = number;
		this.nameEntry = nameEntry;
	}
	
	public int getNumber() {
		return number;
	}

	public String getNameEntry() {
		return nameEntry;
	}
}