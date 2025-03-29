package br.com.design.patterns.structural.facade.computer;

public class ComputerApplication {
    public static void main(String[] args) {
        CPU cpu = new CPU();
        Memory memory = new Memory();
        HardDrive hardDrive = new HardDrive();

        ComputerFacade computer = new ComputerFacade(cpu, memory, hardDrive);
        computer.start();
    }
}

class CPU {
    public void freeze() { System.out.println("CPU freeze."); }
    public void jump(long position) { System.out.println("CPU jump to " + position + "."); }
    public void execute() { System.out.println("CPU execute."); }
}

class Memory {
    public void load(long position, byte[] data) {
        System.out.println("Memory loading data at position " + position + ".");
    }
}

class HardDrive {
    public byte[] read(long lba, int size) {
        System.out.println("HardDrive reading data from sector " + lba + " with size " + size + ".");
        return new byte[size];
    }
}

class ComputerFacade {
    private CPU cpu;
    private Memory memory;
    private HardDrive hardDrive;

    public ComputerFacade(CPU cpu, Memory memory, HardDrive hardDrive) {
        this.cpu = cpu;
        this.memory = memory;
        this.hardDrive = hardDrive;
    }

    public void start() {
        System.out.println("Starting the computer...");
        cpu.freeze();
        byte[] bootData = hardDrive.read(0, 1024);
        memory.load(0, bootData);
        cpu.jump(0);
        cpu.execute();
    }
}