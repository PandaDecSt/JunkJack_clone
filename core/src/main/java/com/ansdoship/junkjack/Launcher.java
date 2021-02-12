package com.ansdoship.junkjack;

import com.ansdoship.junkjack.screen.GameScreen;
import com.ansdoship.junkjack.screen.SplashScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

public class Launcher extends Game {
    AssetManager aman;

    @Override
    public void create() {
        aman = new AssetManager();
        Assets.load();
//        SplashScreen splashScreen = new SplashScreen();
//        setScreen(splashScreen);
        changeScreen();
        Timer timer = new Timer();
        Task task = new Task() {
            @Override
            public void run() {
                //changeScreen();
            }
        };
        timer.scheduleTask(task, 3);
    }

    public void changeScreen() {
        GameScreen gameScreen = new GameScreen();
        setScreen(gameScreen);
    }

    @Override
    public void dispose() {
        aman.dispose();
    }
}
