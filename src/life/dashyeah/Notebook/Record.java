package life.dashyeah.Notebook;

public class Record {
	private int no;
	private String text;
	
	public Record(){}
	public Record(String s, int no){
		this.text = s;
		this.no = no;
	}
	
	public String getText(){
		return this.text;
	}
	public void setText(String text){
		this.text = text;
	}
	public int getNo(){
		return this.no;
	}
	public int setNo(int no){
		this.no = no;
		return this.no;
	}
	
	public String toString(){return this.text;}
	public int length(){return text.length();}
	public Boolean equals(Record r){return text == r.text;}
}