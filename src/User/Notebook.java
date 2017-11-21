package User;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import life.dashyeah.Notebook.*;

public class Notebook {
	private Pack pack = new Pack();
	private static Boolean flag;
	
	private Notebook(){flag=true;}
	protected void finalize(){flag=false;}
	public static Notebook getNotebook(){return flag? null: new Notebook();}
	
	private static void showHello(){
		System.out.println(" +++ Welcome to Dash Note! +++ ");
	}
	private static int showMenu(){
		int sel=0;
		System.out.print("****************\n"
				       + "*  Main  Menu  *\n"
				       + "*--------------*\n"
				       + "* 1.show all   *\n"
				       + "* 2.new record *\n"
				       + "* 3.search     *\n"
				       + "* 4.delete     *\n"
				       + "* 5.clear      *\n"
				       + "*              *\n"
				       + "* 0.exit       *\n"
				       + "****************\n");
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		while(true){
			try{
				System.out.print("choice> ");
				sel = scan.nextInt();
			}catch(InputMismatchException e){
				scan.next();
				System.out.println(" [!]wrong choice. retry.");
				continue;
			}
			if(sel<0 || sel>5) continue;
			break;
		}
		
		return sel;
	}
	private void showAll(){
		List<Record> all = pack.getRecords();
		Iterator<Record> it = all.iterator();
		while(it.hasNext()){
			Record r = it.next();
			System.out.format("#%d: %s",r.getNo(),r.getText());
		}
	}
	private void newRecord(){
		StringBuilder s = new StringBuilder();
		System.out.print("Input text now. enter \"\\exit\" in a new line to finish.");
		String tmp = "";
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		while(!tmp.equals("\\exit")){
			System.out.print("Input>");
			tmp = scan.nextLine();
			s.append(tmp);
		}
		this.pack.addRecord(s.toString());
	}
	private void searchRecord(){
		String s;
		int sel;
		System.out.println("SN> ");
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		while(true){
			try{
				System.out.print("choice> ");
				sel = scan.nextInt();
			}catch(InputMismatchException e){
				scan.next();
				System.out.println(" [!]wrong choice. retry.");
				continue;
			}
			break;
		}
		s = pack.getRecord(sel);
		if(s != null){
			System.out.println("result>"+s);
		}
		else{
			System.out.println("msg>Not Found.");
		}
	}
	private void daleteRecord(){
		int sel;
		System.out.println("SN> ");
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		while(true){
			try{
				System.out.print("choice> ");
				sel = scan.nextInt();
			}catch(InputMismatchException e){
				scan.next();
				System.out.println(" [!]wrong choice. retry.");
				continue;
			}
			break;
		}
		
	}
	
	public static void main(String args[]){
		Notebook nb = Notebook.getNotebook();
		while(true){
			int sel;
			showHello();
			sel = showMenu();
			switch(sel){
			case 1:
				nb.showAll();
				break;
			case 2:
				nb.newRecord();
				break;
			case 3:
				nb.searchRecord();
				break;
			case 4:
				break;
			case 5:
				break;
			case 0:
			default:
				System.exit(0);
			}
		}
	}
}
