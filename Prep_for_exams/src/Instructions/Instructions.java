package Instructions;

sealed abstract class Instructions permits LoadConstant, Decrement, Multiply, JumpIfZero, Jump, Halt {}

final class LoadConstant extends Instructions {
	
	int r;
	int c;
	
	public LoadConstant(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

final class Decrement extends Instructions {
	
	int r;
	
	public Decrement(int r) {
		this.r = r;
	}
}

final class Multiply extends Instructions {
	 
	int r1;
	int r2;
	
	public Multiply(int r1, int r2) {
		this.r1 = r1;
		this.r2 = r2;
	}
}

final class JumpIfZero extends Instructions {
	
	int r;
	int a;
	
	public JumpIfZero(int r, int a) {
		this.r = r;
		this.a = a;
	}
}

final class Jump extends Instructions {
	
	int a;
	
	public Jump(int a) {
		this.a = a;
	}
}

final class Halt extends Instructions {}

class Machine {
	
	
	void execute(int[] registers, Instructions[] instructions) {
		int pc = 0;
		while(0 <= pc) {
			Instructions i = instructions[pc];
			switch(i) {
			case LoadConstant lc -> {
				registers[lc.r] = lc.c;
				pc++;
			}
			case Decrement d -> {
				registers[d.r]--;
				pc++;
			}
			case Multiply m -> {
				registers[m.r1] *= registers[m.r2];
				pc++;
			}
			case JumpIfZero jiz -> {
				if (registers[jiz.r] == 0) {
					pc = jiz.a;
				} else
					pc++;
			}
			case Jump j -> {
				pc = j.a;
			}
			case Halt h -> {
				pc = -1;
			}
				
			}

//			if (i instanceof LoadConstant lc) {
//				registers[lc.r] = lc.c;
//				pc++;
//			} else if (i instanceof Decrement d) {
//				registers[d.r]--;
//				pc++;
//			} else if (i instanceof Multiply m) {
//				registers[m.r1] *= registers[m.r2];
//				pc++;
//			} else if (i instanceof JumpIfZero jiz) {
//				if (registers[jiz.r] == 0) {
//					pc = jiz.a;
//				} else
//					pc++;
//			} else if (i instanceof Jump j) {
//				pc = j.a;
//			} else if (i instanceof Halt h) {
//				pc = -1;
//			}
				
		}
	}
}
