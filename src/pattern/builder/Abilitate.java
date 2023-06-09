package pattern.builder;

public class Abilitate {
    //clasa abilitate contine campurile necesare definirii unei abilitati, conform specificatiilor
    /*
    damage -int
    stun: boolean
    dodge: boolean
    cooldown:int
    folosim incapsulare + get-eri si set-eri
     */
    private int damage;
    private boolean stun;
    private boolean dodge;
    private int cooldown;

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public boolean isStun() {
        return stun;
    }

    public void setStun(boolean stun) {
        this.stun = stun;
    }

    public boolean isDodge() {
        return dodge;
    }

    public void setDodge(boolean dodge) {
        this.dodge = dodge;
    }

    public int getCooldown() {
        return cooldown;
    }

    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }
}
