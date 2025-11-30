package dave.rulesengine;

public class RuleMetadata {
    public final String name;
    public final int version;
    public final int priority;
    public final String group;


    public RuleMetadata(String name, int version, int priority, String group) {
        this.name = name;
        this.version = version;
        this.priority = priority;
        this.group = group;
    }

    public String getName() {return name;}
    public int getVersion() {return version;}
    public int getPriority() {return priority;}
    public String getGroup() {return group;}

    public String toString(){
        return "RuleMetadata: { "
                + "\n Name: " + this.name
                + ", \n Version: " + this.version
                + ", \n Priority: " + this.priority
                + ", \n Group: " + this.group
                + ", \n }" ;
    }
}
