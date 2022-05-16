import java.util.Scanner;

abstract class Shape {
	private Shape next;
	public Shape() {
		next = null; 
	}
	public void setNext(Shape obj) { 
		next = obj; 
	} // ��ũ ����
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
		System.out.println("�׷��� ������ beauty�� �����մϴ�.");
		while(true) {
			
			System.out.print("����(1), ����(2), ��� ����(3), ����(4)>>");
			choice = sc.nextInt();
			switch(choice) {
			case 1:
				System.out.print("Line(1), Rect(2), Circle(3)>>");
				int option = sc.nextInt();
				insert(option);
				break;
			case 2:
				System.out.print("������ ������ ��ġ>>");
				int select = sc.nextInt();
				delete(select);
				break;
			case 3:
				see();
				break;
			case 4:
				System.out.print("beauty�� �����մϴ�.>");
				return;
			default: 
				System.out.println("�Է��� �ٽ� �ϼ���.");
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
	          System.out.println("�Է��� �ٽ� �ϼ���.");
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
					System.out.println("������ �� �����ϴ�.");
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
