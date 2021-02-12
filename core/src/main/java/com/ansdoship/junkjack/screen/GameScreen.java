package com.ansdoship.junkjack.screen;

import com.ansdoship.junkjack.ui.ZoomRegulator;
import com.ansdoship.junkjack.util.Constant;
import com.ansdoship.junkjack.util.input.OrthoCamController;
import com.ansdoship.junkjack.world.Chunk;
import com.ansdoship.junkjack.world.Generator;
import com.ansdoship.junkjack.world.World;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.kotcrab.vis.ui.VisCHLoader;
import com.kotcrab.vis.ui.VisUI;

public class GameScreen extends ScreenAdapter {
    public World world;
    public Chunk chunk;
    
    OrthographicCamera camera;
	OrthoCamController cameraController;
    public InputMultiplexer inputMultiplexer;
    float zoom = 1;
    
    Stage uiStage;

    protected static Vector3 tmp_vector3 = new Vector3(0, 0, 0);

    public GameScreen() {
        VisCHLoader.load();

        camera = new OrthographicCamera(Constant.screenWidth, Constant.screenHeight);
		camera.update();
        cameraController = new OrthoCamController(camera);

        world = new World(0);
        world.createDefaultShader();        

        uiStage = new Stage(new ScreenViewport());
        uiStage.addActor(new ZoomRegulator(cameraController));

        inputMultiplexer = new InputMultiplexer();
        inputMultiplexer.addProcessor(uiStage);
        inputMultiplexer.addProcessor(cameraController);
		Gdx.input.setInputProcessor(inputMultiplexer);        

    }

    @Override
    public void render(float d) {
        Gdx.gl.glClearColor(0f, .6f, .6f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//        Gdx.gl.glEnable(GL20.GL_BLEND);
//        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		Gdx.app.log("Fps", "" + Gdx.graphics.getFramesPerSecond());

        camera.update();
        cameraController.animationUpdate();

        world.begin();
        world.draw(camera.combined);
        world.end();

        uiStage.draw();
        uiStage.act();

    }

    @Override
    public void dispose() {
        world.dispose();
        uiStage.dispose();
        VisCHLoader.dispose();
        VisUI.dispose();
	}

}
