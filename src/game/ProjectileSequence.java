package game;

import engine.Vec2;
import game.constants.Direction;
import game.structures.MapItem;
import game.structures.Projectile;

public interface ProjectileSequence {
  
  public default Projectile locate(Direction dir, Game instance, ProjectileData data) {
    PlayableCharacter player = instance.getRun().getPlayer();
    Projectile proj = new Projectile(new Vec2(), data, player.getStats(), player, dir, this);
    double x = player.pos().x() + (player.getCurrentSprite().getWidth() / 2) - (proj.getWidth() / 2);
    double y = player.pos().y() + (player.getCurrentSprite().getHeight() / 2) - (proj.getHeight() / 2);
    proj.move(new Vec2(x, y));
    return proj;
  }
  
  public default void generate(Projectile proj, Game instance) {
    instance.getRun().getPlayer().setWeaponCooldown(1);
    instance.getRun().getCurrentRoom().getItems().addProj(proj);
  }
  
  public default void behaviour(Projectile proj) {
    proj.move(MapItem.calculateVelocity(proj.dir(), 3));
  }

}
