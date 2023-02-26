import java.util.HashMap;

public class Notebook {
    // ID нужен для "симуляции" БД, чтобы при дальнейше сортировке выводить только
    // id определенного ноутбука
    public final Integer id;
    protected String brand;
    protected Integer ram;
    protected Integer rom;
    protected String proc;
    protected double screenDiag;
    protected String os;
    protected String colour;
    public Integer price;
    public Boolean inStock;

    public static HashMap<Integer, String> criteriaMap;
    public static HashMap<String, String> characteristicsMap;

    // Создадим массивы вариантов характеристик (цену пропустим) для удобства
    // случайной генерации множества ноутбуков
    public static String[] brands = new String[] { "Lenovo", "HP", "Asus", "Acer", "Xiaomi", "Apple" };
    public static Integer[] rams = new Integer[] { 4, 8, 16, 32 };
    public static Integer[] roms = new Integer[] { 256, 512, 1024 };
    public static String[] procs = new String[] { "Intel", "AMD", "Apple" };
    public static Double[] screenDiags = new Double[] { 14d, 15.6d, 17d };
    public static String[] oss = new String[] { "Windows", "MacOS", "Linux", "DOS" };
    public static String[] colours = new String[] { "Black", "Blue", "White", "Gold" };
    public static Boolean[] inStocks = new Boolean[] { true, false };

    public static String[] criteria = new String[] { "Brand", "RAM", "ROM", "Processor", "Screen Diagonal",
            "OS", "Colour", "Price", "In Stock" };

    // Конструктор
    public Notebook(Integer id, String brand, Integer ram, Integer rom,
                    String proc, double screenDiag, String os, String colour, Boolean inStock, Integer price) {
        this.id = id;

    private String brand;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    private Integer ram;

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    private Integer rom;

    public Integer getRom() {
        return rom;
    }

    public void setRom(Integer rom) {
        this.rom = rom;
    }

    private String proc;

    public String getProc() {
        return proc;
    }

    public void setProc(String proc) {
        this.proc = proc;
    }

    private double screenDiag;

    public double getScreenDiag() {
        return screenDiag;
    }

    public void setScreenDiag(double screenDiag) {
        this.screenDiag = screenDiag;
    }

    private String os;

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    private String colour;

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    private Integer price;

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    private Boolean inStock;

    public Boolean getInStock() {
        return inStock;
    }

    public void setInStock(Boolean inStock) {
        this.inStock = inStock;
    }

    // Статические методы для получения набора критериев
    public static HashMap<Integer, String> criteriaMap;

    public static HashMap<Integer, String> getCriteriaMap() {
        return criteriaMap;
    }

    public static void setCriteriaMap() {
        HashMap<Integer, String> criteriaMap = new HashMap<>();
        for (int i = 0; i < Notebook.criteria.length; i++) {
            criteriaMap.put(i+1, Notebook.criteria[i]);
        for (int i = 0; i < CharSource.criteria.length; i++) {
            criteriaMap.put(i+1, CharSource.criteria[i]);
        }
        Notebook.criteriaMap = criteriaMap;
    }

    // Статические методы для получения набора характеристик
    public static HashMap<String, String> characteristicsMap;

    public static HashMap<String, String> getCharacteristicsMap() {
        return characteristicsMap;
    }

    public static void setCharacteristicsMap() {
        HashMap<String, String> characteristicsMap = new HashMap<>();
        for (int critKey : criteriaMap.keySet()) {
            switch (critKey) {
                case 1:
                    for (int j = brands.length; j > 0; j--) {
                        characteristicsMap.put(critKey + Integer.toString(j), brands[j-1]);
                    for (int j = CharSource.brands.length; j > 0; j--) {
                        characteristicsMap.put(critKey + Integer.toString(j),
                                CharSource.brands[j-1]);
                    }
                    break;
                case 2:
                    for (int j = rams.length; j > 0 ; j--) {
                        characteristicsMap.put(critKey + Integer.toString(j), String.valueOf(rams[j-1]));
                    for (int j = CharSource.rams.length; j > 0 ; j--) {
                        characteristicsMap.put(critKey + Integer.toString(j),
                                String.valueOf(CharSource.rams[j-1]));
                    }
                    break;
                case 3:
                    for (int j = roms.length; j > 0 ; j--) {
                        characteristicsMap.put(critKey + Integer.toString(j), String.valueOf(roms[j-1]));
                    for (int j = CharSource.roms.length; j > 0 ; j--) {
                        characteristicsMap.put(critKey + Integer.toString(j),
                                String.valueOf(CharSource.roms[j-1]));
                    }
                    break;
                case 4:
                    for (int j = procs.length; j > 0 ; j--) {
                        characteristicsMap.put(critKey + Integer.toString(j), procs[j-1]);
                    for (int j = CharSource.procs.length; j > 0 ; j--) {
                        characteristicsMap.put(critKey + Integer.toString(j),
                                CharSource.procs[j-1]);
                    }
                    break;
                case 5:
                    for (int j = screenDiags.length; j > 0 ; j--) {
                        characteristicsMap.put(critKey + Integer.toString(j), Double.toString(screenDiags[j-1]));
                    for (int j = CharSource.screenDiags.length; j > 0 ; j--) {
                        characteristicsMap.put(critKey + Integer.toString(j),
                                Double.toString(CharSource.screenDiags[j-1]));
                    }
                    break;
                case 6:
                    for (int j = oss.length; j > 0 ; j--) {
                        characteristicsMap.put(critKey + Integer.toString(j), oss[j-1]);
                    for (int j = CharSource.oss.length; j > 0 ; j--) {
                        characteristicsMap.put(critKey + Integer.toString(j),
                                CharSource.oss[j-1]);
                    }
                    break;
                case 7:
                    for (int j = colours.length; j > 0 ; j--) {
                        characteristicsMap.put(critKey + Integer.toString(j), colours[j-1]);
                    for (int j = CharSource.colours.length; j > 0 ; j--) {
                        characteristicsMap.put(critKey + Integer.toString(j),
                                CharSource.colours[j-1]);
                    }
                    break;
                case 9:
                    for (int j = inStocks.length; j > 0 ; j--) {
                        characteristicsMap.put(critKey + Integer.toString(j), String.valueOf(inStocks[j-1]));
                    for (int j = CharSource.inStocks.length; j > 0 ; j--) {
                        characteristicsMap.put(critKey + Integer.toString(j),
                                String.valueOf(CharSource.inStocks[j-1]));
                    }
                    break;
            }
        }
        Notebook.characteristicsMap = characteristicsMap;
    }

    // Конструктор
    public Notebook(Integer id, String brand, Integer ram, Integer rom,
            String proc, double screenDiag, String os, String colour, Boolean inStock, Integer price) {
        this.id = id;
        this.brand = brand;
        this.ram = ram;
        this.rom = rom;
        this.proc = proc;
        this.screenDiag = screenDiag;
        this.os = os;
        this.colour = colour;
        this.price = price;
        this.inStock = inStock;

    }

    // Красивый вывод характеристик
    public StringBuilder GetCharacteristics() {
        StringBuilder outStr = new StringBuilder();
        outStr.append("Notebook ").append(id).append(":\n");
        outStr.append("\t").append("Brand: ");
        outStr.append(brand).append("\n");

        outStr.append("\t").append("Ram: ");
        outStr.append(ram).append(" MB").append("\n");
        outStr.append(ram).append(" Gb").append("\n");

        outStr.append("\t").append("ROM: ");
        outStr.append(rom).append(" GB").append("\n");
        outStr.append(rom).append(" Gb").append("\n");

        outStr.append("\t").append("Processor Brand: ");
        outStr.append(proc).append("\n");

        outStr.append("\t").append("Screen Diagonal: ");
        outStr.append(screenDiag).append("\n");
        outStr.append(screenDiag).append("\"").append("\n");

        outStr.append("\t").append("Operating System: ");
        outStr.append(os).append("\n");
        outStr.append("\t").append("Colour: ");
        outStr.append(colour).append("\n");
        outStr.append("\t").append("Price: ");
        outStr.append(price).append("\n");
        outStr.append("\t").append("In Stock: ");
        outStr.append(inStock).append("\n");
        return outStr;
    }
}