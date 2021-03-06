package game.structures;

import game.Game;

public interface Collider {
  
  public default boolean collisionProperties(final Game INSTANCE, MapItem collision) {
    return true;
  }
  
  public default boolean collisionValid(final Game INSTANCE, MapItem collision) {
    return true;
  }

}
