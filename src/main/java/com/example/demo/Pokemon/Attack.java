package com.example.demo.Pokemon;

public class Attack {
    String name;
    int power;
    DamageClass damageClass;
    Type type;
    int accurancy;
    StatChange[] statChanges;
    Meta meta;

    public Attack() {
        this.name = "struggle";
        this.power = 50;
        this.type = new Type("normal", "https://pokeapi.co/api/v2/type/1/");
        this.damageClass = DamageClass.PHYSICAL;
        this.accurancy = 100;
        this.statChanges = new StatChange[0];
        this.meta = new Meta();
    }

    public boolean doesDamage() {
        return this.power > 0 || this.meta.category.substring(0, 3).equals("dam");
    }

    public Attack(String name, int power, DamageClass damageClass, Type type, int accurancy, StatChange[] statChanges,
            Meta meta) {
        this.name = name;
        this.power = power;
        this.damageClass = damageClass;
        this.type = type;
        this.accurancy = accurancy;
        this.statChanges = statChanges;
        this.meta = meta;
    }

    public Type getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    public String getCategory() {
        return this.meta.category;
    }
}
