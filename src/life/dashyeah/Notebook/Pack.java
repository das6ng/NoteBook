package life.dashyeah.Notebook;

import java.util.*;

public class Pack {
	private List<Record> records = new ArrayList<Record>();
	
	public List<Record> getRecords(){
		return records;
		}
	public void removeRecords(){
		records.clear();
	}
	
	public String getRecord(int index){
		if(index>=records.size()){
			return null;
		}
		else return records.get(index).toString();
	}
	public void addRecord(String s){
		Record r = new Record(s,records.size()+1);
		records.add(r);
	}
	public void removeRecord(int index){
		if(index>0 && index<=records.size()){
			records.remove(index);
		}
	}
	
	public int length(){return records.size();}
	public Boolean equals(Pack p){return true;}
}
