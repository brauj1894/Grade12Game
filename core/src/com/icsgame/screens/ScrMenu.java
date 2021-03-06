package com.icsgame.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.icsgame.Main;
import com.icsgame.objects.Button;

public class ScrMenu implements Screen {

    Main main;
    SpriteBatch batch;
    Texture txtBG;
    Sprite sprBG;
    Button btnStart, btnHighscores;

    public ScrMenu (Main _main){
        main = _main;
        batch = new SpriteBatch();
        txtBG = new Texture("backgroundBlackBoards.jpg");
        sprBG = new Sprite(txtBG, 0, 0, main.nWidth, main.nHeight);

        // Create Buttons
        btnStart = new Button(main.nWidth/2-300, 330, 600, 216, "btnStart.png", "btnStartPressed.png", "Blank.png");
        btnHighscores = new Button(main.nWidth/2-300, 60, 600, 216, "btnHighscores.png", "btnHighscoresPressed.png", "Blank.png");
    }

    @Override
    public void render(float delta){
        batch.begin();
        // Draw Background
        sprBG.draw(batch);

        // Draw Buttons
        btnStart.draw(batch);
        btnHighscores.draw(batch);

        batch.end();

        // Checks if buttons are pressed
        checkButtons();
    }

    private void checkButtons(){ // Checks if Buttons are pressed
        checkButtonTextures();
        if(btnStart.justClicked()){
            main.changeScreen(2);
        }
        if(btnHighscores.justClicked()){
            main.changeScreen(1);
        }
    }

    private void checkButtonTextures(){
        if(btnStart.isMousedOver()){
            btnStart.changeTexture(1);
        } else {
            btnStart.changeTexture(0);
        }
        if(btnHighscores.isMousedOver()){
            btnHighscores.changeTexture(1);
        } else {
            btnHighscores.changeTexture(0);
        }
    }

    @Override
    public void show() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void resize(int width, int height) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void pause() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void resume() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void hide() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void dispose() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
