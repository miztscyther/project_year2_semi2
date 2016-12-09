package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Screen;
import com.mygdx.game.Screens.PlayScreen;
import com.mygdx.game.Screens.PlayScreen;

public class MyGdxGame extends Game {
	public SpriteBatch batch;
	public static final int v_width = 800;
	public static final int v_hight = 480;
	public static final  float PPM =  100;
	public static final  float PPM_1 = 4;
	//Texture img;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new PlayScreen(this));
	}

//	public boolean isGetPlayer(){
//	return playerIsget;
//	}

	@Override
	public void render () {
		super.render();
	}
	

}
