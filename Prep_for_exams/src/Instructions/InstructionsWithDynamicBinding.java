package Instructions;

sealed abstract class InstructionsWithDynamicBinding permits LoadConstant, Decrement, Multiply, JumpIfZero, Jump, Halt {
	
	abstract void execute(int[] registers, Machine machine);
}

final class LoadConstant extends InstructionsWithDynamicBinding {
	
	int r;
	int c;
	
	public LoadConstant(int r, int c) {
		this.r = r;
		this.c = c;
	}
	
	@Override
	void execute(int[] registers, Machine machine) {
		registers[r] = c;
		machine.pc++;
	}
	
}

final class Decrement extends InstructionsWithDynamicBinding {
	
	int r;
	
	public Decrement(int r) {
		this.r = r;
	}
	
	@Override
	void execute(int[] registers, Machine machine) {
		registers[r]--;
		machine.pc++;
		
	}
}

final class Multiply extends InstructionsWithDynamicBinding {
	 
	int r1;
	int r2;
	
	public Multiply(int r1, int r2) {
		this.r1 = r1;
		this.r2 = r2;
	}
	
	@Override
	void execute(int[] registers, Machine machine) {
		registers[r1] *= registers[r2];
		machine.pc++;
	}
}

final class JumpIfZero extends InstructionsWithDynamicBinding {
	
	int r;
	int a;
	
	public JumpIfZero(int r, int a) {
		this.r = r;
		this.a = a;
	}
	
	@Override
	void execute(int[] registers, Machine machine) {
		if (registers[r] == 0) {
			machine.pc = a;
		} else
			machine.pc++;
	}
}

final class Jump extends InstructionsWithDynamicBinding {
	
	int a;
	
	public Jump(int a) {
		this.a = a;
	}
	
	@Override
	void execute(int[] registers, Machine machine) {
		machine.pc = a;
		
	}
}

final class Halt extends InstructionsWithDynamicBinding {
	
	@Override
	void execute(int[] registers, Machine machine) {
		machine.pc = -1;
		
	}
}

class Machine {
	
	int pc = 0;
	
	void execute(int[] registers, InstructionsWithDynamicBinding[] instructions) {
		while (0 <= pc) {
			instructions[pc].execute(registers, this);
		}
	}
}
