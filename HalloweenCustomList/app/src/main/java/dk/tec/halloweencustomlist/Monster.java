package dk.tec.halloweencustomlist;

public class Monster
{
    private String name;
    private String desc;
    private int imgId;

    public Monster(String monsterName, String description, int imgId)
    {
        this.name = monsterName;
        this.desc = description;
        this.imgId = imgId;
    }

    public String getName()
    {
        return this.name;
    }
    public String getDesc()
    {
        return this.desc;
    }
    public int getImgId()
    {
        return this.imgId;
    }
}
