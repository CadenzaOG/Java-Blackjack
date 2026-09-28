import java.lang.Math;

public class MoveAnimation implements Animation {

    private final double duration = 0.5;
    private double t;
    private int startX, startY, endX, endY;
    private final CardEntity card;
    private boolean isFinished = false;



    public MoveAnimation(CardEntity card,int startX, int startY, int endX, int endY) {
        this.t = 0;
        this.card = card;
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;

    }

    @Override
    public void update(double dt) {
        t += dt;
        t = Math.min(t,duration);
        double progress = -0.5*Math.cos((Math.PI / duration) * t) + 0.5;
        card.setX((int) (startX + progress * (endX - startX)));
        card.setY((int) (startY + progress * (endY - startY)));
        isFinished = t >= duration;
    }

    @Override
    public boolean isFinished() {
        return isFinished;
    }
}
