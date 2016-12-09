package com.mygdx.game.Sprite;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.*;

/**
 * Created by Miztscyther on 21/11/2559.
 */
public class player extends Sprite {
    public World world;
    public Body body;
    String name;
    final int max_hp =100 ;
    int hp = max_hp;
    final int max_speed = 9;
    float speed = 6f;
    public String getname(){
        return name;
    }
    public int getHp(){
        return hp;
    }
    protected void setName(String n){
        this.name = n;
    }
    public float getSpeed(){
        return this.speed;
    }
    protected int chagehp(int chp){
        this.hp += chp;
        if (this.hp > max_hp){
            this.hp = max_hp ;
        }
        return this.getHp();
    }
    protected boolean checkmaxapd (float spd){
        if (spd > max_speed){
            return true;
        }
        else {
            return false;
        }
    }
    protected float chagespd (float chpd) {
        this.speed += chpd;
        if (checkmaxapd(this.speed)) {
            this.speed = max_speed;
        }
        return this.speed;
    }

    public player(World world){
        this.world = world;
        definePlayer();
    }
    public void definePlayer(){
        BodyDef bdef = new BodyDef();
        bdef.position.set(32 , 32);
        bdef.type = BodyDef.BodyType.DynamicBody;
        body = world.createBody(bdef);

        FixtureDef fdef = new FixtureDef();
        CircleShape shape = new CircleShape();

        shape.setRadius(5);
        fdef.shape =shape ;
        body.createFixture(fdef);

    }
}
