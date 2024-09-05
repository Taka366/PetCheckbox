//タスク当日管理用実施内容項目リストのEntityの作成

package model;

import java.io.Serializable;

public class ActionEntry implements Serializable {
	private String actionEntry;
	private int number;
	
	public ActionEntry(){}
	
	

	public ActionEntry(int number,String actionEntry){
		this.number = number;
		this.actionEntry = actionEntry;
	}

	public int getNumber() {
		return number;
	}
	
	public String getActionEntry() {
		return actionEntry;
	}
		
}