package pattern.builder;

public class BuilderAbilitate {
    // in cele ce urmeaza vom folosi design pattern-ul builder, folosind clase separate pentru
    // a construi abilitati
    // vrem sa lasam libertatea de a alege exact ce trebuie pus
    private final Abilitate abilitate = new Abilitate();
    public BuilderAbilitate seteazaDamage(int dmg){
        abilitate.setDamage(dmg);
        return this;
    }
    public BuilderAbilitate seteazaStun(boolean stun){
        abilitate.setStun(stun);
        return this;
    }

    public BuilderAbilitate seteazaDodge(boolean dodge){
        abilitate.setDodge(dodge);
        return this;
    }

    public BuilderAbilitate seteazaCooldown(int cd){
        abilitate.setCooldown(cd);
        return this;
    }

    public Abilitate construieste(){
        return abilitate;
    }
}
