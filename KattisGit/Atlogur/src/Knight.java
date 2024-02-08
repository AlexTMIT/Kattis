public class Knight {
    private int health;
    private final int strength;
    private final int index;
    private boolean alive;

    public Knight(int health, int strength, int index) {
        this.health = health;
        this.strength = strength;
        this.index = index;
        alive = true;
    }

    public void attack(Knight knight) {
        knight.takeDamage(strength);
    }

    public void takeDamage(int strength) {
        health -= strength;
        if (health <= 0) {
            die();
        }
    }

    public void die() {
        alive = false;
    }

    public int getIndex() {
        return index;
    }

    public boolean isAlive() {
        return alive;
    }
}
