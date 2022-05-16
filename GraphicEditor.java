import java.util.Scanner;

abstract class Shape {
	private Shape next;
	public Shape() {
		next = null; 
	}
	public void setNext(Shape obj) { 
		next = obj; 
	} // 링크 연결
	public Shape getNext() { 
		return next; 
	}
	public abstract void draw();
}

class Line extends Shape {
	public Line() {
		super();
	}
	public void draw() {
		System.out.println("Line");
	}
}

class Rect extends Shape {
	public Rect() {
		super();
	}
	public void draw() {
		System.out.println("Rect");
	}
}

class Circle extends Shape {
	public Circle() {
		super();
	}
	public void draw() {
		System.out.println("Circle");
	}
}

class GraphicEditor {
	int choice;
	Shape s;
	public Shape start=null, end=null;
	Scanner sc = new Scanner(System.in);
	public GraphicEditor() {
		sc=new Scanner(System.in);
	}
	
	public void exe() {
		System.out.println("그래픽 에디터 beauty을 실행합니다.");
		while(true) {
			
			System.out.print("삽입(1), 삭제(2), 모두 보기(3), 종료(4)>>");
			choice = sc.nextInt();
			switch(choice) {
			case 1:
				System.out.print("Line(1), Rect(2), Circle(3)>>");
				int option = sc.nextInt();
				insert(option);
				break;
			case 2:
				System.out.print("삭제할 도형의 위치>>");
				int select = sc.nextInt();
				delete(select);
				break;
			case 3:
				see();
				break;
			case 4:
				System.out.print("beauty을 종료합니다.>");
				return;
			default: 
				System.out.println("입력을 다시 하세요.");
				break;
			}
		}
	}


	void insert(int option) {
	      switch(option) {
	      case 1:
	         s = new Line();
	         break;
	      case 2:
	         s = new Rect();
	         break;
	      case 3:
	         s = new Circle();
	         break;
	      default:
	          System.out.println("입력을 다시 하세요.");
	          return;
	      }
	      if(start==null) {
	    	  start=end=s;
	      }
	      else {
	    	  end.setNext(s);
	    	  end = s;
	      }

	}
	
	void delete(int select) {
		int i;
		Shape save = start;
		Shape temp = start;
		if(select == 1) {
			if(start == end) {
				start = null;
				end = null;
				return;
			}
			else {
				start = start.getNext();
				return;
			}
		}
		else {
			for(i=1; i<select; i++) {
				temp = save;
				save=save.getNext();
				if(save==null) {
					System.out.println("삭제할 수 없습니다.");
					return;
				}
			}
			if(i==select) {
				temp.setNext(save.getNext());
				end = temp;
			}
			else
				temp.setNext(save.getNext());
		}
			
	}
		
	
	void see() {
		Shape s = start;
		while(s!=null) {
			s.draw();
			s=s.getNext();
		}

	}

}


public class Main {

	public static void main(String[] args) {
		GraphicEditor g = new GraphicEditor();
		g.exe();

	}

}
