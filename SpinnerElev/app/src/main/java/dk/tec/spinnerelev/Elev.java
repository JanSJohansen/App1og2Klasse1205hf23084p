package dk.tec.spinnerelev;

public class Elev
{
    String name;
    String skill;
    int sko;

    @Override
    public String toString() {
        return "Name='" + name ;
    }

    public Elev(String name, String skill, int sko) {
        this.name = name;
        this.skill = skill;
        this.sko = sko;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public int getSko() {
        return sko;
    }

    public void setSko(int sko) {
        this.sko = sko;
    }
}
