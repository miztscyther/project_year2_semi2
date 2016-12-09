package com.mygdx.game.Screens;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.Sprite.player;
import com.mygdx.game.scenes.Hud;
import com.mygdx.game.tools.Box2DWorldCreator;

import javazoom.jl.player.Player;

/**
 * Created by Miztscyther on 21/11/2559.
 */
public class PlayScreen implements Screen {
    private MyGdxGame game;

    //Texture texture;
    private OrthographicCamera gamecam;
    private Viewport gamePort;
    private Hud hud;
    //map
    private TmxMapLoader maploader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;

    //world
    private World world;
    private Box2DDebugRenderer b2dr;

    private player player1;

    public PlayScreen(MyGdxGame game) {
        this.game = game;
        //texture = new Texture("mh.jpg");
        gamecam = new OrthographicCamera();
        gamePort = new StretchViewport(MyGdxGame.v_width/*MyGdxGame.PPM */, MyGdxGame.v_width/*MyGdxGame.PPM*/,gamecam);
        hud = new Hud(game.batch);

        maploader = new TmxMapLoader();
        map = maploader.load("new_test.tmx");
        renderer = new OrthogonalTiledMapRenderer(map, 1/MyGdxGame.PPM_1 );

        gamecam.position.set(gamePort.getScreenWidth()/2,gamePort.getScreenHeight()/2,0);

        world = new World(new Vector2(0,0),true);
        b2dr = new Box2DDebugRenderer();

        new Box2DWorldCreator(world,map);
        player1 = new player(world);

    }

    @Override
    public void show() {

    }
    public void handleInput(float dt){
        if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)){
        player1.body.applyLinearImpulse(new Vector2(player1.getSpeed(),0),player1.body.getWorldCenter(),true);
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)){
        player1.body.applyLinearImpulse(new Vector2(-player1.getSpeed(),0),player1.body.getWorldCenter(),true);
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.UP)){
        player1.body.applyLinearImpulse(new Vector2(0,player1.getSpeed()),player1.body.getWorldCenter(),true);
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){
        player1.body.applyLinearImpulse(new Vector2(0,-player1.getSpeed()),player1.body.getWorldCenter(),true);
        }

    }

    public void update(float dt){
        handleInput(dt);

        world.step(1/60f, 6, 2);

        gamecam.update();
        renderer.setView(gamecam);

    }


    @Override
    public void render(float delta) {
        update(delta);

        Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.render();

        b2dr.render(world,gamecam.combined);

        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
        hud.stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        gamePort.update(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        map.dispose();
        renderer.dispose();
        world.dispose();
        b2dr.dispose();
        hud.dispose();

    }
}
