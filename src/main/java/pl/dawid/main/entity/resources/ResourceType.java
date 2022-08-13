package pl.dawid.main.entity.resources;

public enum ResourceType {
    WOOD(Titles.WOOD,"description"),
    CLAY(Titles.CLAY,"description"),
    IRON(Titles.IRON,"description"),
    EMPLOYEE(Titles.EMPLOYEE,"description");

    public final String name;
    public final String description;
    ResourceType(String name,String description){
        this.name=name;
        this.description=description;
    }
    public static class Titles{
        public static final String WOOD="wood";
        public static final String CLAY="clay";
        public static final String IRON="iron";
        public static final String EMPLOYEE="employee";
    }
}
