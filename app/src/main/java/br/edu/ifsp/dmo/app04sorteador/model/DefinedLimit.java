package br.edu.ifsp.dmo.app04sorteador.model;

public class DefinedLimit extends SorteioStrategy{
    private int mBorder;

    public DefinedLimit(int mBorder){
        this.mBorder = mBorder;
    }
    @Override
    public int nextNumber() {
        return mRandom.nextInt(mBorder) + 1;
    }

    @Override
    public int getLowBorder() {
        return 1;
    }

    @Override
    public int getHighBorder() {
        return mBorder;
    }
}