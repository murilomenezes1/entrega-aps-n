package br.pro.hashi.ensino.desagil.aps.model;

public class NorGate extends Gate {

    private final NandGate not_A;
    private final NandGate not_B;
    private final NandGate not_final;
    private final NandGate nand;



    public NorGate() {
        super("NOR", 2);

        not_A = new NandGate();
        not_B = new NandGate();
        nand = new NandGate();
        not_final = new NandGate();


        nand.connect(0, not_A);
        nand.connect(1, not_B);
        not_final.connect(0, nand);
        not_final.connect(1,nand);


    }

    @Override
    public boolean read() {
        return not_final.read();
    }


    @Override
    public void connect(int inputIndex, Emitter emitter) {
        if ((inputIndex != 0) && (inputIndex != 1)) {
            throw new IndexOutOfBoundsException(inputIndex);
        }
        switch (inputIndex) {
            case 0:
                not_A.connect(0, emitter);
                not_A.connect(1, emitter);
                break;
            case 1:
                not_B.connect(0, emitter);
                not_B.connect(1, emitter);
                break;

        }


    }
}


