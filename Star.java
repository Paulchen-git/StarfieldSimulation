import java.awt.*;

public class Star {

    private float x;
    private float y;
    private float xSpeed;
    private float ySpeed;
    private float prevX;
    private float prevY;
    

    public Star() {
        x = (float) StarfieldSimulation.WIDTH/2;
        y = (float) StarfieldSimulation.HEIGHT/2;
        while (x == StarfieldSimulation.WIDTH/2 && y == StarfieldSimulation.HEIGHT/2) {
            x = (float) (Math.random() * StarfieldSimulation.WIDTH/2 + StarfieldSimulation.WIDTH/4);
            y = (float) (Math.random() * StarfieldSimulation.HEIGHT/2 + StarfieldSimulation.HEIGHT/4);
        }
        setSpeed();
    }

    public void setSpeed() {
        // the speed direction is colinear to the vector from the center of the screen to the star
        float xCenter = StarfieldSimulation.WIDTH/2;
        float yCenter = StarfieldSimulation.HEIGHT/2;
        float dx = x - xCenter;
        float dy = y - yCenter;
        float norm = (float) Math.sqrt(dx*dx + dy*dy);
        xSpeed = dx/50 * StarfieldSimulation.SPEED;
        ySpeed = dy/50 * StarfieldSimulation.SPEED;
    }

    public void update() {
        setSpeed();
        prevX = x;
        prevY = y;
        x += xSpeed;
        y += ySpeed;
        //if the star is out of the screen
        if (x > StarfieldSimulation.WIDTH || x < 0 || y > StarfieldSimulation.HEIGHT || y < 0) {
            x = (float) (Math.random() * StarfieldSimulation.WIDTH/2 + StarfieldSimulation.WIDTH/4);
            y = (float) (Math.random() * StarfieldSimulation.HEIGHT/2 + StarfieldSimulation.HEIGHT/4);
            prevX = x;
            prevY = y;
            setSpeed();
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawLine((int) prevX, (int) prevY, (int) x, (int) y);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
