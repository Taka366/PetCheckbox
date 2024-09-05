//タスク当日管理用実施時間帯項目リストのEntityの作成

package model;

import java.io.Serializable;

public class TimeframeEntry implements Serializable {
	private int number;
	private String timeframeEntry;
	
	public TimeframeEntry(){}
	
	public TimeframeEntry(int number,String timeframeEntry){
		this.number = number;
		this.timeframeEntry = timeframeEntry;
	}
	
	public int getNumber() {
		return number;
	}

	public String getTimeframeEntry() {
		return timeframeEntry;
	}
}