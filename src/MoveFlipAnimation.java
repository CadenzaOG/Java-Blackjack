import java.sql.Array;
import java.util.ArrayDeque;
import java.util.Queue;

public class MoveFlipAnimation implements Animation {

    int endX, endY;
    private Queue<Animation> animations;
    private Animation currentAnimation;
    private boolean isFinished;

    public MoveFlipAnimation(CardEntity card,int startX, int startY, int endX, int endY) {
        this.endX = endX;
        this.endY = endY;
        this.animations = new ArrayDeque<>();
        animations.add(new MoveAnimation(card, startX, startY,endX,endY));
        animations.add(new FlipAnimation(card,card.getWidth()));
        currentAnimation = animations.poll();

    }

    @Override
    public void update(double dt) {

        if (currentAnimation.isFinished()) {
            currentAnimation = animations.poll();
        }

        if (currentAnimation == null) {
            isFinished = true;
            return;
        }

        currentAnimation.update(dt);

    }

    @Override
    public boolean isFinished() {
        return isFinished;
    }
}
