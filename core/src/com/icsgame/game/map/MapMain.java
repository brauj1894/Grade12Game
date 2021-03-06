package com.icsgame.game.map;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.icsgame.screens.ScrGame;

import java.util.ArrayList;
import java.util.Random;

public class MapMain {

    ScrGame game;
    int nX, nY, nW, nH, nWTile, nHTile;

    // Map Parts
    Tile[][] tiles;
    ArrayList<Item> decorations;

    // Map Assets
    Random ranGen;
    Texture[] txtTiles, txtDecorations;
    MapGenerator mapGen;

    public MapMain(ScrGame _game){
        game = _game;
        ranGen = new Random();
        mapGen = new MapGenerator(this);
    }

    public void createMap(int _nX, int _nY, int _nW, int _nH, int _nTileSize, String sTheme){
        nX = _nX;
        nY = _nY;
        nW = _nW;
        nH = _nH;
        nWTile = _nTileSize;
        nHTile = _nTileSize;

        loadTileTextures(sTheme);
        tiles = new Tile[nW][nH];
        mapGen.generateMap(txtTiles, txtDecorations, nX, nY, nW, nH, nWTile);
        tiles = mapGen.getTiles();
        decorations = mapGen.getDecorations();
    }

    public void render(SpriteBatch batch){
        // Render Tiles
        for (int x = 0; x < tiles.length; x++){
            for (int y = 0; y < tiles[x].length; y++){
                tiles[x][y].render(batch);
            }
        }

        // Render Decorations
        for (int i = 0; i < decorations.size(); i++){
            decorations.get(i).render(batch);
        }
    }

    private void loadTileTextures(String sTheme){
        txtTiles = new Texture[17];
        txtDecorations = new Texture[2];

        // Load Tile Textures
        txtTiles[0] = new Texture("theme"+sTheme+"/tileBoundary.png");
        txtTiles[1] = new Texture("theme"+sTheme+"/tileFloor.png");
        txtTiles[2] = new Texture("theme"+sTheme+"/tileWallCenter.png");
        txtTiles[3] = new Texture("theme"+sTheme+"/tileWallTop.png");
        txtTiles[4] = new Texture("theme"+sTheme+"/tileWallRight.png");
        txtTiles[5] = new Texture("theme"+sTheme+"/tileWallBottom.png");
        txtTiles[6] = new Texture("theme"+sTheme+"/tileWallLeft.png");
        txtTiles[7] = new Texture("theme"+sTheme+"/tileWallTopLeft.png");
        txtTiles[8] = new Texture("theme"+sTheme+"/tileWallTopRight.png");
        txtTiles[9] = new Texture("theme"+sTheme+"/tileWallBottomRight.png");
        txtTiles[10] = new Texture("theme"+sTheme+"/tileWallBottomLeft.png");
        txtTiles[11] = new Texture("theme"+sTheme+"/tileWallCapTop.png");
        txtTiles[12] = new Texture("theme"+sTheme+"/tileWallCapBottom.png");
        txtTiles[13] = new Texture("theme"+sTheme+"/tileWallCapLeft.png");
        txtTiles[14] = new Texture("theme"+sTheme+"/tileWallCapRight.png");
        txtTiles[15] = new Texture("theme"+sTheme+"/tileWallTunnelVertical.png");
        txtTiles[16] = new Texture("theme"+sTheme+"/tileWallTunnelHorizontal.png");

        // Load Decoration Textures
        for (int i = 0; i < 2; i++) {
            txtDecorations[i] = new Texture("theme"+sTheme+"/decorationPlant"+i+".png");
        }
    }
}
