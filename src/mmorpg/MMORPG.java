package mmorpg;

import java.util.ArrayList;
import mmorpg.debug.TimedMessage;
import mmorpg.map.Map;
import mmorpg.items.Treasure;
import mmorpg.player.Player;
import java.util.logging.Level;
import java.util.logging.Logger;
import mmorpg.camera.Camera;
import mmorpg.enemies.Enemy;
import mmorpg.enemies.SmartWallEnemy;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

/**
 *
 * @author Diego
 */
public class MMORPG extends BasicGame {

    private Map map;
    private Player player;

    public MMORPG() throws SlickException {
        super("MMORPG");
        AppGameContainer container = new AppGameContainer(this);
        container.setDisplayMode(800, 600, false);
        container.setShowFPS(false);
        container.start();
    }

    @Override
    public void init(GameContainer container) throws SlickException {
        Camera.createCamera(new Vector2f(0f, 0f), container.getWidth(), container.getHeight());
        Camera.getInstance().setPadding(1);
        map = new Map(3);
        player = new Player();
        map.placeObject(player, 6, 6);
    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {
        player.update(container, delta);
    }

    @Override
    public void render(GameContainer container, Graphics g) throws SlickException {
        map.render(container, g);
        player.render(container, g);
    }

    public static void main(String[] args) {
        try {
            new MMORPG();
        } catch (SlickException ex) {
            Logger.getLogger(MMORPG.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
