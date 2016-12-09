package com.mygdx.game.scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.MyGdxGame;

/**
 * Created by MumcomService on 23/11/2559.
 */
public class Hud implements Disposable {
    public Stage stage;
    private Viewport viewport;

    private  Integer player1_HP;
    //private  float timeCount;
    //private  Integer score;

    Label countdown_HP_Lable;
    Label player1_HP_Lable;
    //Label levelLable;
    //Label worldLable;
    Label player1Lable;

    public Hud(SpriteBatch sprite){
        player1_HP = 100;

        viewport = new StretchViewport(MyGdxGame.v_width,MyGdxGame.v_hight,new OrthographicCamera());
        stage = new Stage(viewport ,sprite);

        Table table = new Table();
        table.top();
        table.setFillParent(true);

        countdown_HP_Lable = new Label(String.format("%03d",player1_HP),new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        player1_HP_Lable = new Label(String.format("player1_HP"),new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        player1Lable = new Label(String.format("player1_HP"),new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        table.add(player1Lable).expandX().padTop(10);
        table.row();
        table.add(countdown_HP_Lable).expandX().padTop(10);
        table.add().expandX();


        stage.addActor(table);
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
