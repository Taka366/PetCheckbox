//タスク内容用のEntityの作成

package model;

import java.io.Serializable;
import java.util.List;

public class Pet implements Serializable {
	private String id;
	private String days;
	private String time;
	private String action;
	private List<String> actionList;
	private String timeframe;
	private List<String> timeframeList;
	private String name;
	private List<String> nameList;
	
	public Pet() {}
	
	public Pet(String id) {
		this.id = id;
	}
	
	public Pet (String days,String time,List<String> actionList,List<String> timeframeList,List<String> nameList) {
		this.days = days;
		this.time = time;
		this.actionList = actionList;
		this.timeframeList = timeframeList;
		this.nameList = nameList;
	}
	
	public Pet (String id,String days,String time,String action,String timeframe,String name) {
		this.id = id;
		this.days = days;
		this.time = time;
		this.action = action;
		this.timeframe = timeframe;
		this.name = name;
	}

	//ゲッター
	public String getId() {
		return id;
	}

	public String getDays() {
		return days;
	}

	public String getTime() {
		return time;
	}

	public String getAction() {
		return action;
	}

	public List<String> getActionList() {
		return actionList;
	}
	
	public String getTimeframe() {
		return timeframe;
	}

	public List<String> getTimeframeList() {
		return timeframeList;
	}
	
	public String getName() {
		return name;
	}

	public List<String> getNameList() {
		return nameList;
	}
	
}