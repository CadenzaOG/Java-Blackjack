import java.util.ArrayDeque;
import java.util.Queue;

public class AnimationManager {

    Queue<Animation> queue;
    Animation current;

    public AnimationManager() {
        this.queue = new ArrayDeque<>();
    }

    public void clear() {
        queue.clear();
    }

    public void add(Animation a) {
        queue.add(a);
    }

    public void update(double dt) {

        if (current == null) {
            current = queue.poll();
        }

        if (current == null) {
            return;
        }

        current.update(dt);

        if (current.isFinished()) {
            current = null;
        }
    }
}
