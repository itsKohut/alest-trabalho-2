public class Castle {

    int castle;
    int knights;

    public Castle(int castle, int knights){
        this.castle = castle;
        this.knights = knights;
    }

    public int getCastle() {
        return castle;
    }

    public int getKnights() {
        return knights;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Castle: ");
        sb.append(getCastle()).append(", ");
        sb.append("Knights: ");
        sb.append(getKnights());
        return  sb.toString();
    }

}
