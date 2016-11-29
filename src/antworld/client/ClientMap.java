package antworld.client;

import antworld.common.FoodType;

/**
 * Created by Forrest York on 11/29/16.
 *
 * Used to track what has been revealed in the Map for use in path finding
 */
public class ClientMap {

    private int mapWidth, mapHeight;
    private RevealedMapCell[][] mapData;

    public ClientMap(int width, int height)
    {
        this.mapWidth = width;
        this.mapHeight = height;
        this.mapData = new RevealedMapCell[width][height];
        for(int row = 0; row < width; row++)
        {
            for(int col = 0; col < height; col++)
            {
                this.mapData[row][col] = new RevealedMapCell();
            }
        }
    }

    public RevealedMapCell getCell(int row, int col)
    {
        return this.mapData[row][col];
    }

    public void resize(int resizeFactor)
    {
        int width = this.mapWidth + (this.mapWidth * resizeFactor);
        int height = this.mapHeight + (this.mapHeight * resizeFactor);
        RevealedMapCell[][] tempMap = new RevealedMapCell[width][height];
        for(int row = 0; row < width; row++)
        {
            for(int col = 0; col < height; col++)
            {
                if(row < this.mapWidth && col < this.mapHeight)
                {
                  tempMap[row][col] = this.mapData[row][col];
                }
                else
                {
                  tempMap[row][col] = new RevealedMapCell();
                }
            }
        }
        this.mapWidth = width;
        this.mapHeight = height;
        this.mapData = tempMap;
    }

    public class RevealedMapCell
    {
     public int movementCost = 1;
     public  boolean isNest = false;
     public boolean hasEnemy = false;
     public FoodType hasFood = null;

     public void setMovementCost(int newCost)
     {
         this.movementCost = newCost;
     }

     public void setAsNest()
     {
         this.isNest = true;
     }

     public void setFoodType(FoodType food)
     {
         this.hasFood = food;
     }

    }
}
