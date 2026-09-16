package com.example.designpattern.Atm.ChainOfResponsibility;

public abstract class NoteDispenser implements DispenseChain{
    private DispenseChain dispenseChain;
    private final int noteValue;
    private int noteCount;

    public NoteDispenser(int noteValue, int noteCount){
        this.noteCount = noteCount;
        this.noteValue = noteValue;
    }
    @Override
    public boolean canDispense(int amount) {
        if(amount < 0) return false;    
        
        int countRequired = amount/noteValue;
        if(countRequired>noteCount) countRequired = noteCount;
        int remainingAmount = amount - countRequired*noteValue;

        if(remainingAmount == 0) return true;
        if(this.dispenseChain!=null) return this.dispenseChain.canDispense(remainingAmount);
        return false;
    }

    @Override
    public void dispense(int amount) {
        if(amount >= noteValue && noteCount>0){
            int countRequired = amount/noteValue;
            if(countRequired>noteCount) countRequired = noteCount;
            int remainingAmount = amount - countRequired*noteValue;

            System.out.println("Dispensing " + countRequired + " x $" + noteValue + " note(s)");
            this.noteCount -= countRequired;
            
            if(remainingAmount>0 && this.dispenseChain!=null){
                this.dispenseChain.dispense(remainingAmount);
            }
        }else if(this.dispenseChain!=null){
            this.dispenseChain.dispense(amount);
        }
        
    }

    @Override
    public void nextChain(DispenseChain nextChain) {
        // TODO Auto-generated method stub
        this.dispenseChain = nextChain;
    }
    
}
