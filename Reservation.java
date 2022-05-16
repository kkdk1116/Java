import java.util.Scanner;


class Consert {
	Scanner sc = new Scanner(System.in);
	String Sseats[];
	String Aseats[];
	String Bseats[];
	String name;
	int num;
	int seat;
	
	public Consert() {
		Sseats = new String[10];
		Aseats = new String[10];
		Bseats = new String[10];
		for(int i=0;i<Sseats.length;i++) {
			Sseats[i]="---";
			Aseats[i]="---";
			Bseats[i]="---";
		}
	}
	
	public void printS() {
		System.out.print("S>>");
		for(int i=0; i<Sseats.length;i++) {
			System.out.print(" "+Sseats[i]);
		}
		System.out.println();
	}
	
	public void printA() {
		System.out.print("A>>");
		for(int i=0; i<Aseats.length;i++) {
			System.out.print(" "+Aseats[i]);
		}
		System.out.println();
	}
	
	public void printB() {
		System.out.print("B>>");
		for(int i=0; i<Bseats.length;i++) {
			System.out.print(" "+Bseats[i]);
		}
		System.out.println();
	}
	
	
	public void choice(String name, int num) {
		switch(seat) {
		case 1:
			if(Sseats[num-1] == "---")
				Sseats[num-1] = name;
			else
				System.out.println("이미 예약된 자리입니다.");
			break;
			
		case 2:
			if(Aseats[num-1] == "---")
				Aseats[num-1] = name;
			else
				System.out.println("이미 예약된 자리입니다.");
			break;
			
		case 3:
			if(Bseats[num-1] == "---")
				Bseats[num-1] = name;
			else
				System.out.println("이미 예약된 자리입니다.");
			break;
		}
	}
	
	public void reserve() {
		System.out.print("좌석 구분 S(1), A(2), B(3) >> ");	
		seat = sc.nextInt();	
		if(seat>3) {
			System.out.println("없는 번호입니다.");
			return;
		}
		System.out.print("이름>>");
		name = sc.next();
		System.out.print("번호>>");
		num = sc.nextInt();
	
		
		if(num>0 && num<11)
			choice(name, num);
		else
			System.out.println("없는 번호입니다.");
		
	}
	
	public void lookup() {
		printS();
		printA();
		printB();
		System.out.println("<<<조회를 완료하였습니다.>>>");
	}
	
	public void cancel() {
		System.out.print("좌석 S:1, A:2, B:3 >> ");
		seat = sc.nextInt();
		if(seat==1) {
			printS();
			System.out.print("이름>> ");
			name = sc.next();
			for(int i=0; i<Sseats.length;i++) {
				if(Sseats[i].equals(name)) {
					Sseats[i]="---";
					break;
				}
			}
		}

		else if(seat==2) {
			printA();
			System.out.print("이름>> ");
			name = sc.next();
			for(int i=0; i<Aseats.length;i++) {
				if(Aseats[i].equals(name)) {
					Aseats[i]="---";
					break;
				}
			}
		}
			
		
		else if(seat==3) {
			printB();
			System.out.print("이름>> ");
			name = sc.next();
			for(int i=0; i<Bseats.length;i++) {
				if(Bseats[i].equals(name)) {
					Bseats[i]="---";
					break;
				}
			}
			
		}
		else
			System.out.println("잘못된 입력입니다.");
			
	}
	
	public void show() {
		int option;
		
		while(true) {
			System.out.print("예약:1, 조회:2, 취소:3, 끝내기:4 >> ");
			option = sc.nextInt();
			
			switch(option) {
			
			case 1:
				reserve();
				break;
			case 2:
				lookup();
				break;
			case 3:
				cancel();
				break;
			case 4:
				return;
			default :
				System.out.println("잘못된 입력입니다.");
				break;
			
			}

		}
	}
}

public class Main {

	public static void main(String[] args) {
		System.out.println("명품콘서트홀 예약 시스템입니다.");
		Consert r = new Consert();
		r.show();
		
	}

}