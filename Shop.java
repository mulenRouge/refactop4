import java.util.*;
// Для различных методов по подбору критериев и сортировке по ним сделаем класс Shop - магазин ноутбуков
// и будем обращаться к этим методам через него

// Не буду усложнять доступом к полям, пусть все будут public :)
public class Shop {
    public HashSet<Notebook> notebooks;
    // Поле с названием магазина
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Shop(HashSet<Notebook> notebooks) {

    // Поле со всеми ноутбуками в магазине
    private HashSet<Notebook> notebooks;

    public HashSet<Notebook> getNotebooks() {
        return notebooks;
    }

    public void setNotebooks(HashSet<Notebook> notebooks) {
        this.notebooks = notebooks;
    }

    public boolean tryParseInt(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
    // Метод для печати всех ноутбуков в магазине
    public void printNotebooks() {
        for (Notebook notebook : this.notebooks) {
            System.out.println(notebook.GetCharacteristics());
        }
    }

    public boolean tryParseDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    // Базовый конструктор для магазина.
    public Shop(String name) {
        this.name = name;
    }

    public HashMap<Integer, String> newRequest() {
        HashMap<Integer, String> requestedCriteria = new HashMap<>();

        Scanner scan = new Scanner(System.in);
        System.out.println("Select the criteria that you want to make the request by.");

        for (int i = 1; i < Notebook.criteriaMap.size() + 1; i++) {
            String printCrit = Notebook.criteriaMap.get(i);
            System.out.println("Do you to take " + printCrit + " into account in your request?\nY/N: ");
            String n = scan.nextLine();
            while (true) {
                if (Objects.equals(n, "q") || Objects.equals(n, "Q")) {
                    System.exit(0);
                } else if (Objects.equals(n, "y") || Objects.equals(n, "Y")) {
                    if (Objects.equals("Price", Notebook.criteriaMap.get(i))) {
                        requestedCriteria.put(0, "Price");
                    } else {
                        requestedCriteria.put(i, Notebook.criteriaMap.get(i));
                    }
                    break;
                } else if (Objects.equals(n, "n") || Objects.equals(n, "N")) {
                    break;
                } else {
                    System.out.println("Wrong action! Try again!");
                    System.out.println("Do you to take " + printCrit + " into account in your request?\nY/N: ");
                    n = scan.nextLine();
                }
            }

    // У магазина будет поле request, являющееся отдельным классом, для обработки
    // запроса от пользователя.
    // В реальности, наверное, это должен быть список запросов (для хранения
    // истории),
    // но тут для примера пусть будет только один.
    private ShopRequest request;

    public void setRequest(HashMap<String, String> filter) {
        ShopRequest newRequest = new ShopRequest();
        newRequest.setUserRequest(filter);

        if (newRequest.getBrands().size() == 0) {
            newRequest.setBrands();
        }
        if (newRequest.getRams().size() == 0) {
            newRequest.setRams();
        }
        if (newRequest.getRoms().size() == 0) {
            newRequest.setRoms();
        }
        if (newRequest.getScreens().size() == 0) {
            newRequest.setScreens();
        }
        if (newRequest.getProcs().size() == 0) {
            newRequest.setProcs();
        }
        return requestedCriteria;
        if (newRequest.getOss().size() == 0) {
            newRequest.setOss();
        }
        if (newRequest.getColours().size() == 0) {
            newRequest.setColours();
        }
        if (newRequest.getInStocks().size() == 0) {
            newRequest.setInStocks();
        }
        this.request = newRequest;
    }

    public HashMap<String, String> newFilter(HashMap<Integer, String> reqCrit) {
        HashMap<String, String> reqChars = new HashMap<>();
        Scanner scan = new Scanner(System.in);
        System.out.println("Select the characteristics that you want to filter your request by.");
        for (int critKey : reqCrit.keySet()) {
            if (Objects.equals("Price", reqCrit.get(critKey))) {
                System.out.println("What maximum price of a Notebook do you want?");
                String n = scan.nextLine();
                while (!tryParseInt(n)) {
                    System.out.println("You didn't input a number! Try again!");
                    n = scan.nextLine();
                }
                reqChars.put("Price", n);
            } else {
                System.out.printf("""
                    What %s-s do you want to be used as a filter?
                    Input one number at a time.
                    Type 'f' to stop input the characteristics, 'q' to exit.
                    """, reqCrit.get(critKey));
                for (int charKey = 1; charKey < Notebook.characteristicsMap.size(); charKey++) {
                    if (!Notebook.characteristicsMap.containsKey(critKey + Integer.toString(charKey))) {
                        break;
                    }
                    System.out.printf(Notebook.characteristicsMap.get(critKey + Integer.toString(charKey))
                            + " - %d\n", charKey);
                }
                while (true) {
                    String n = scan.nextLine();
                    if (Objects.equals(n, "q") || Objects.equals(n, "Q")) {
                        System.exit(0);
                    } else if (Notebook.characteristicsMap.containsKey(critKey + n)) {
                        reqChars.put(critKey + n, Notebook.characteristicsMap.get((critKey + n)));
                    } else if (Objects.equals(n, "f") || Objects.equals(n, "F")) {
                        break;
                    } else {
                        System.out.println("No such characteristic! Try again!");
                    }
                }

    public void printRequest() {
        System.out.println();

        StringBuilder outStr = new StringBuilder();
        outStr.append("Brands:\n");
        if (request.getBrands().size() == CharSource.brands.length) {
            outStr.append("\t").append("Any").append("\n");
        } else {
            for (String brand : request.getBrands()) {
                outStr.append("\t").append(brand).append("\n");
            }
        }
        return reqChars;
    }

    public HashSet<Notebook> getFilteredNotes (HashMap<String, String> filter) {
        int maxPrice = 100_000_000;
        ArrayList<Integer> fRam = new ArrayList<>();
        ArrayList<Integer> fRom = new ArrayList<>();
        ArrayList<Double> fScreen = new ArrayList<>();
        ArrayList<Boolean> fInStock = new ArrayList<>();
        ArrayList<String> fBrand = new ArrayList<>();
        ArrayList<String> fProc = new ArrayList<>();
        ArrayList<String> fOS = new ArrayList<>();
        ArrayList<String> fColour = new ArrayList<>();

        HashSet<Notebook> filteredNotes = new HashSet<>();
        for (Map.Entry<String, String> entry : filter.entrySet()) {
            if (tryParseInt(entry.getValue())) {
                int intCharacteristic = Integer.parseInt(entry.getValue());
                if (Objects.equals(entry.getKey(), "Price")) {
                    maxPrice = intCharacteristic;
                } else if (Objects.equals(entry.getKey().charAt(0), '2')) {
                    fRam.add(intCharacteristic);
                } else if (Objects.equals(entry.getKey().charAt(0), '3')) {
                    fRom.add(intCharacteristic);
                }
            } else if (tryParseDouble(entry.getValue())) {
                double doubleCharacteristic = Double.parseDouble(entry.getValue());
                fScreen.add(doubleCharacteristic);
            } else if (Objects.equals(entry.getKey().charAt(0), '9')) {
                boolean boolCharacteristic = Boolean.parseBoolean(entry.getValue());
                fInStock.add(boolCharacteristic);
            } else {
                if (Objects.equals(entry.getKey().charAt(0), '1')) {
                    fBrand.add(entry.getValue());
                } else if (Objects.equals(entry.getKey().charAt(0), '4')) {
                    fProc.add(entry.getValue());
                } else if (Objects.equals(entry.getKey().charAt(0), '6')) {
                    fOS.add(entry.getValue());
                } else if (Objects.equals(entry.getKey().charAt(0), '7')) {
                    fColour.add(entry.getValue());
                }else {
                    fColour.add(entry.getValue());
                }
        outStr.append("Rams, Gb:\n");
        if (request.getRams().size() == CharSource.rams.length) {
            outStr.append("\t").append("Any").append("\n");
        } else {
            for (int ram : request.getRams()) {
                outStr.append("\t").append(ram).append("\n");
            }
        }

        System.out.println("Your characteristics filter list:");

        System.out.println(fBrand);
        System.out.println(fRam);
        System.out.println(fRom);
        System.out.println(fProc);
        System.out.println(fScreen);
        System.out.println(fOS);
        System.out.println(fColour);
        System.out.println(fInStock);
        System.out.printf("Max. Price %d\n", maxPrice);

        if (fBrand.size() == 0) {
            Collections.addAll(fBrand, Notebook.brands);
        }
        if (fRom.size() == 0) {
            Collections.addAll(fRom, Notebook.roms);
        outStr.append("Roms, Gb:\n");
        if (request.getRoms().size() == CharSource.roms.length) {
            outStr.append("\t").append("Any").append("\n");
        } else {
            for (int rom : request.getRoms()) {
                outStr.append("\t").append(rom).append("\n");
            }
        }
        if (fRam.size() == 0) {
            Collections.addAll(fRam, Notebook.rams);

        outStr.append("Processors:\n");
        if (request.getProcs().size() == CharSource.procs.length) {
            outStr.append("\t").append("Any").append("\n");
        } else {
            for (String proc : request.getProcs()) {
                outStr.append("\t").append(proc).append("\n");
            }
        }
        if (fScreen.size() == 0) {
            Collections.addAll(fScreen, Notebook.screenDiags);

        outStr.append("Screen sizes:\n");
        if (request.getScreens().size() == CharSource.screenDiags.length) {
            outStr.append("\t").append("Any").append("\n");
        } else {
            for (Double screen : request.getScreens()) {
                outStr.append("\t").append(screen).append("\"").append("\n");
            }
        }
        if (fProc.size() == 0) {
            Collections.addAll(fProc, Notebook.procs);

        outStr.append("OS:\n");
        if (request.getOss().size() == CharSource.oss.length) {
            outStr.append("\t").append("Any").append("\n");
        } else {
            for (String os : request.getOss()) {
                outStr.append("\t").append(os).append("\n");
            }
        }
        if (fOS.size() == 0) {
            Collections.addAll(fOS, Notebook.oss);

        outStr.append("Colours:\n");
        if (request.getColours().size() == CharSource.colours.length) {
            outStr.append("\t").append("Any").append("\n");
        } else {
            for (String colour : request.getColours()) {
                outStr.append("\t").append(colour).append("\n");
            }
        }
        if (fColour.size() == 0) {
            Collections.addAll(fColour, Notebook.colours);

        outStr.append("In Stock:\n");
        if (request.getInStocks().size() == CharSource.inStocks.length) {
            outStr.append("\t").append("Any").append("\n");
        } else {
            for (Boolean colour : request.getInStocks()) {
                if (colour) {
                    outStr.append("\t").append("Yes").append("\n");
                } else {
                    outStr.append("\t").append("No").append("\n");
                }
            }
        }
        if (fInStock.size() == 0) {
            Collections.addAll(fInStock, Notebook.inStocks);

        outStr.append("Max. price: ");
        if (request.getMaxPrice() == 100_000_000) {
            outStr.append("Any").append("\n");
        } else {
            outStr.append(request.getMaxPrice()).append(" RUB").append("\n");
        }

        for (String brand : fBrand){
            for (int ram : fRam){
                for (int rom : fRom){
                    for (String proc : fProc){
                        for (double screen : fScreen){
                            for (String os : fOS){
                                for (String colour : fColour){
                                    for (boolean inStock : fInStock){
        System.out.println(outStr);
    }

    public HashSet<Notebook> getFilteredNotes () {
        HashSet<Notebook> filteredNotes = new HashSet<>();
        for (String brand : request.getBrands()){
            for (int ram : request.getRams()){
                for (int rom : request.getRoms()){
                    for (String proc : request.getProcs()){
                        for (double screen : request.getScreens()){
                            for (String os : request.getOss()){
                                for (String colour : request.getColours()){
                                    for (boolean inStock : request.getInStocks()){
                                        for (Notebook note : notebooks) {
                                            if (note.brand.equals(brand) && note.ram == ram && note.rom == rom
                                                    && note.proc.equals(proc) && note.screenDiag == screen
                                                    && note.os.equals(os) && note.colour.equals(colour)
                                                    && note.inStock == inStock && note.price < maxPrice){
                                            if (note.getBrand().equals(brand) && note.getRam() == ram
                                                    && note.getRom() == rom
                                                    && note.getProc().equals(proc) && note.getScreenDiag() == screen
                                                    && note.getOs().equals(os) && note.getColour().equals(colour)
                                                    && note.getInStock() == inStock &&
                                                    note.getPrice() < request.getMaxPrice()){
                                                filteredNotes.add(note);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return filteredNotes;
    }

    public void printFilteredNotes() {
        System.out.println();
        if (getFilteredNotes().size() != 0) {
            System.out.println("List of notebooks that fit the filter: ");
            for (Notebook note : getFilteredNotes()) {
                System.out.println(note.GetCharacteristics());
            }
        } else {
            System.out.println("There are no notebooks that fit your criteria");
        }

    }
}