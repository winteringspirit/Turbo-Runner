package com.example.turbo_runner;

import android.support.v7.app.ActionBarActivity;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.andengine.audio.music.Music;
import org.andengine.audio.music.MusicFactory;
import org.andengine.audio.sound.Sound;
import org.andengine.audio.sound.SoundFactory;
import org.andengine.engine.Engine;
import org.andengine.engine.LimitedFPSEngine;
import org.andengine.engine.camera.Camera;
import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.FillResolutionPolicy;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.IEntity;
import org.andengine.entity.modifier.MoveModifier;
import org.andengine.entity.modifier.ScaleModifier;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.entity.text.TextOptions;
import org.andengine.entity.util.FPSLogger;
import org.andengine.entity.*;
import org.andengine.input.touch.TouchEvent;
import org.andengine.input.touch.controller.MultiTouch;
import org.andengine.opengl.font.Font;
import org.andengine.opengl.font.FontFactory;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.ui.activity.SimpleBaseGameActivity;
import org.andengine.util.HorizontalAlign;
import org.andengine.util.SAXUtils;
import org.andengine.util.debug.Debug;
import org.andengine.util.level.IEntityLoader;
import org.andengine.util.level.LevelLoader;
import org.andengine.util.level.constants.LevelConstants;
import org.xml.sax.Attributes;

import android.content.Context;
import android.os.SystemClock;
import android.view.KeyEvent;

public class MainGame extends SimpleBaseGameActivity {

	private static final int CAMERA_WIDTH = 800;
	private static final int CAMERA_HEIGHT = 480;

	public Engine onCreateEngine(final EngineOptions pEngineOptions) {
		//set frame limited
		Engine e = new LimitedFPSEngine(pEngineOptions, 60);
		return e;
	}

	//Initialize game options
	public EngineOptions onCreateEngineOptions() {
		//create camera for game
		Camera camera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);

		//set option for game: stretch solution, camera, 
		final EngineOptions engineOptions = new EngineOptions(true,
				ScreenOrientation.LANDSCAPE_FIXED, new FillResolutionPolicy(),
				camera);
		//set multitouch for this game
		engineOptions.getTouchOptions().setNeedsMultiTouch(true);

		//check if multi touch is supported for this device
		if (MultiTouch.isSupported(this)) {
			if (MultiTouch.isSupportedDistinct(this)) {
			} else {
			}
		} else {
		}
		
		//enable music and sound for this game
		engineOptions.getAudioOptions().setNeedsMusic(true);
		engineOptions.getAudioOptions().setNeedsSound(true);
		return engineOptions;
	}

	@Override
	public void onCreateResources() {
		//set assest path
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
		MusicFactory.setAssetBasePath("mfx/");
		SoundFactory.setAssetBasePath("mfx/");
	}

	//Clear this Scene
	public void clear(Scene scene) {
		scene.detachSelf();
		scene.detachChildren();
		scene.clearEntityModifiers();
		scene.clearTouchAreas();
	}

	//Read file from a path
	public String readFromFile(String filename) {
		String ret = "0";
		try {
			InputStream inputStream = openFileInput(filename);
			if (inputStream != null) {
				InputStreamReader inputStreamReader = new InputStreamReader(
						inputStream);
				BufferedReader bufferedReader = new BufferedReader(
						inputStreamReader);
				String receiveString = "";
				StringBuilder stringBuilder = new StringBuilder();
				while ((receiveString = bufferedReader.readLine()) != null) {
					stringBuilder.append(receiveString);
				}
				inputStream.close();
				ret = stringBuilder.toString();
			}
		} catch (FileNotFoundException e) {
			// Log.e(TAG, "File not found: " + e.toString());
		} catch (IOException e) {
			// Log.e(TAG, "Can not read file: " + e.toString());

		}
		return ret;
	}

	//Write date to a file with path
	private void writeToFile(String data, String filename) {
		try {
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
					openFileOutput(filename, Context.MODE_PRIVATE));
			outputStreamWriter.write(data);
			outputStreamWriter.close();
		} catch (IOException e) {
		}
	}

	//Create Scene()
	@Override
	public Scene onCreateScene() {
		this.mEngine.registerUpdateHandler(new FPSLogger());

		Scene scene = new Scene();

		//Register scene event
		scene.registerUpdateHandler(new IUpdateHandler() {
			
			//Reset Scene function
			@Override
			public void reset() {
			//do something
			}
			
			//Main Update for this Scene
			@Override
			public void onUpdate(final float pSecondsElapsed) {
				//do something
			}
		});
		return scene;
	}

	//Get Keys Event Press
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
		}
		switch (keyCode) {
		// key back is pressed
		case KeyEvent.KEYCODE_BACK: {
			//do something if this key press
			break;
		}
		}
		return false;
	}

}