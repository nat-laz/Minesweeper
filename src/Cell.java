public final class Cell {

    private boolean isMine;
    private int minesAround;
    private boolean isHidden;
    private boolean markedAsMine;

    public Cell(int x, int y) {

        this.isMine = false;
        this.minesAround = 0;
        this.isHidden = true;
        this.markedAsMine = false;
    }

    public boolean isMine() {
        return isMine;
    }

    public void setMine(boolean isMine) {
        this.isMine = isMine;
    }

    public int getMinesAround() {
        return minesAround;
    }

    public void setMinesAround(int minesAround) {
        this.minesAround = minesAround;
    }

    public boolean isHidden() {
        return isHidden;
    }

    public void reveal() {
        this.isHidden = false;
    }

    public boolean isMarkedAsMine() {
        return markedAsMine;
    }

    public void setMarkedAsMine(boolean markedAsMine) {
        this.markedAsMine = markedAsMine;
    }
}