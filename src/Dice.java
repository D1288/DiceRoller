public class Dice {
    int dieSides;
    double xPosition;
    double yPosition;
    double xVelocity;
    double yVelocity;

    Dice(int sides, double xPosition, double yPosition, double xVelocity, double yVelocity){
        this.dieSides = sides;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
    }

    public double getXPosition(){
        return xPosition;
    }

    public double getYPosition(){
        return yPosition;
    }

    public void setYPosition(double yPosition){
        this.yPosition = yPosition;
    }

    public void setXPosition(double xPosition){
        this.xPosition = xPosition;
    }

    public void setXVelocity(double xVelocity){
        this.xVelocity = xVelocity;
    }

    public double getXVelocity(){
        return xVelocity;
    }

    public void setYVelocity(double yVelocity){
        this.yVelocity = yVelocity;
    }

    public double getYVelocity(){
        return yVelocity;
    }



    public int getDieSides(){
        return dieSides;
    }
}
