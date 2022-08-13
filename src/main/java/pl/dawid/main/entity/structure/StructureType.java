package pl.dawid.main.entity.structure;

public enum StructureType {
    HEADQUARTERS(Titles.HEADQUARTERS,"description",2),
    TIMBER_CAMP(Titles.TIMBER_CAMP,"description",2),
    CLAY_PIT(Titles.CLAY_PIT,"description",2),
    IRON_MINE(Titles.IRON_MINE,"description",2),
    FARM(Titles.FARM,"description",2);

    public final String name;
    public final String description;

    public final Integer levelMax;
    StructureType(String name, String description, Integer levelMax){
        this.name=name;
        this.description=description;
        this.levelMax=levelMax;
    }
    public static class Titles{
        public static final String HEADQUARTERS="headquarters";
        public static final String TIMBER_CAMP="timber camp";
        public static final String CLAY_PIT="clay pit";
        public static final String IRON_MINE="iron mine";
        public static final String FARM="farm";
    }
}
