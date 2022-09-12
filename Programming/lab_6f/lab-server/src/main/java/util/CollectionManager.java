package util;

import content.City;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class CollectionManager {
    private TreeMap<String, City> cities;
    private FileManager file;
    private LocalDate date;

    public CollectionManager(FileManager fileManager) {
        this.file = fileManager;
        this.cities = file.read();
        this.date = LocalDate.now();
    }

    public void clear() {
        cities.clear();
    }

    @Override
    public String toString() {
        return cities
                .entrySet()
                .stream()
                .map((e) -> e.getKey() + ":\n" + e.getValue().toString() + "\n")
                .sorted(Comparator.comparingInt(String::length))
                .reduce((a, b) -> a + b)
                .orElse("Коллекция пуста\n")
                .trim();
    }

    public String getInfo() {
        return "type: " + cities.getClass() + "\n" + "date: " + date + "\nsize: " + cities.size();
    }

    public void save() {
        file.save();
    }

    public boolean contains(String key) {
        return cities.containsKey(key);
    }

    public boolean containsID(Integer id) {
        return cities.values().stream().anyMatch((v) -> Objects.equals(v.getId(), id));
    }

    public void insert(String key, City movie) {
        cities.put(key, movie);
    }

    public String getAscending() {
        return cities.entrySet().stream()
                .sorted((e1, e2) -> {
                    City v1 = e1.getValue();
                    City v2 = e2.getValue();
                    return v1.getId().compareTo(v2.getId());
                })
                .map((s) -> s + "\n")
                .sorted(Comparator.comparingInt(String::length))
                .reduce((a, b) -> a + b)
                .orElse("Коллекция пуста\n");
    }


    public int removeLower(String key) {
        int i = 0;
        cities = cities.entrySet().stream()
                .filter((e) -> e.getKey().compareTo(key) <= 0)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (r, l) -> l, TreeMap::new));
        return i;
    }

    public void removeKey(String key) {
        cities.remove(key);
    }

    public void update(Integer id, City city) {
        cities =cities.entrySet().stream()
                .peek((e) -> {
                    if (Objects.equals(e.getValue().getId(), id)) {
                        e.setValue(city);
                    }
                })
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (l, r) -> l, TreeMap::new));
    }


    public String replaceIfLow(String key, City movie) {
        cities = cities.entrySet().stream()
                .peek((e) -> {
                    if ((e.getKey().equals(key)) && (e.getValue().getId() < movie.getId())) {
                        e.setValue(movie);
                    }
                })
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (r, l) -> l, TreeMap::new));
        return "";
    }

    public int removeGreaterKey(String key) {
        int i = 0;
        cities = cities.entrySet().stream()
                .filter((e) -> e.getKey().compareTo(key) <= 0)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (l, r) -> l, TreeMap::new));
        return i;
    }


}
