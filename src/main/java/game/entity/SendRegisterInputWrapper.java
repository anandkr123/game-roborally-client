package game.entity;



/**
 * Holds the list of registers
 */
public class SendRegisterInputWrapper {
    private Cards[] registers;
    public SendRegisterInputWrapper() {
    }
    public SendRegisterInputWrapper(Cards[] registers) {
        this.registers = registers;
    }

    public Cards[] getRegisters() {
        return registers;
    }

    public void setRegisters(Cards[] registers) {
        this.registers = registers;
    }
}
