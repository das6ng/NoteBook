package life.dashyeah.Notebook;

public class Record {
	private int no;
	private String text;
	
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
}