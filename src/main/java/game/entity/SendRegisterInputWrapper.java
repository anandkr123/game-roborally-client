package game.entity;

import java.util.List;

/**
 * Holds the list of registers
 */
public class SendRegisterInputWrapper {
    private List<String> registers;
    public  SendRegisterInputWrapper(){
        //Empty constructor
    }
    public SendRegisterInputWrapper(List<String> registers) {
        this.registers = registers;
    }

    public List<String> getRegisters() {
        return registers;
    }

    public void setRegisters(List<String> registers) {
        this.registers = registers;
    }

}
