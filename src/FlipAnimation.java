public class FlipAnimation implements Animation {


    private CardEntity card;

    private final double duration = 0.2; // length in frames
    private double t = 0;
    private boolean isFinished = false;
    private String currentSprite;
    private String cardSprite;
    private double scale;
    private boolean spriteSwitched;
    private double width;

    public FlipAnimation(CardEntity card,double width) {
        this.card = card;
        this.currentSprite = "BACK";
        this.cardSprite = card.getCardKey();
        this.spriteSwitched = false;
        this.width=width;

    }

    public void update(double dt) {

        t += dt;
        t = Math.min(t,duration);

        double halfDuration = duration / 2;

        if (t < halfDuration) {
            scale = (halfDuration - t) / halfDuration;
            card.setWidth((int) (scale * width));
        } else {
            if (!card.isFaceUp()) {
                card.reveal();
                spriteSwitched = true;
            }
            scale = (t - halfDuration) / halfDuration;
            card.setWidth((int) (scale * width));
        }

        isFinished = t >= duration;

//        double halfLength = length / 2;
//        currentSprite = currentFrame < halfLength ? spriteKeys[0] : spriteKeys[1];
//
//        if (currentFrame < halfLength) {
//            scale = (double) (halfLength - currentFrame) / (halfLength);
//        } else {
//            scale = (double) (currentFrame % (halfLength)) / (halfLength);
//        }
//        isFinished = currentFrame > length;
//
//        if (++currentFrame > length) {
//            currentFrame = 0;
//        }
    }

    public String getCurrentSprite() { return currentSprite; }


    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public double getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }
}
