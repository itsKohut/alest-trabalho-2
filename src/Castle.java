public class Castle {

    private int castleNumber;
    private int initialKnights;

    private int remainingKnights;



    public Castle(int castleNumber, int initialKnights){
        this.castleNumber = castleNumber;
        this.initialKnights = initialKnights;
        this.remainingKnights = initialKnights;
    }

    public int getCastleNumber() {
        return castleNumber;
    }


    public int getInitialKnights() {
        return initialKnights;
    }

    public int getRemainingKnights() {
        return remainingKnights;
    }

    public void setRemainingKnights(int remainingKnights) {
        this.remainingKnights = remainingKnights;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("-------------------------").append("\n");
        sb.append("Castle: ");
        sb.append(this.getCastleNumber()).append("\n");
        sb.append("Remaining Knights: ");
        sb.append(this.getRemainingKnights()).append("\n");
        sb.append("-------------------------").append("\n");
        return  sb.toString();
    }

}
