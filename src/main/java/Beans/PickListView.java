package Beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.model.DualListModel;

@Named(value = "pickListView")
@ViewScoped
public class PickListView implements Serializable{

    private Map<String, Map<String, DualListModel<String>>> data = new HashMap<>();
    private String country;
    private String cityModel;
    private Map<String, String> countriesMap;
    private Map<String, DualListModel<String>> citiesMap;

    private DualListModel<String> citiesModelUsa;
    private DualListModel<String> citiesModelGer;

    @PostConstruct
    public void init() {
        //Cities
        List<String> citiesSourceUsa = new ArrayList<>();
        List<String> citiesTargetUsa = new ArrayList<>();

        List<String> citiesSourceGer = new ArrayList<>();
        List<String> citiesTargetGer = new ArrayList<>();
        
        
        citiesSourceUsa.add("San Francisco");
        citiesSourceUsa.add("New York");
        citiesSourceUsa.add("Washington");
        citiesTargetUsa.add("New Orleans");
        citiesTargetUsa.add("Orlando");
        citiesTargetUsa.add("Waco");
        
        citiesSourceGer.add("Berlin");
        citiesSourceGer.add("Hamburg");
        citiesSourceGer.add("Munich");
        citiesTargetGer.add("Cologne");
        citiesTargetGer.add("Frankfurt");
        citiesTargetGer.add("Essen");

        citiesModelUsa = new DualListModel<>(citiesSourceUsa, citiesTargetUsa);
        citiesModelGer = new DualListModel<>(citiesSourceGer, citiesTargetGer);

        countriesMap = new HashMap<>();
        countriesMap.put("USA", "USA");
        countriesMap.put("Germany", "Germany");

        Map<String, DualListModel<String>> map = new HashMap<>();
        map.put("USA", citiesModelUsa);
        data.put("USA", map);

        map = new HashMap<>();
        map.put("Germany", citiesModelGer);
        data.put("Germany", map);

    }

    public void onCountryChange() {
        if (country != null && !country.equals("")) {
            citiesMap = data.get(country);
        } else {
            citiesMap = new HashMap<>();
        }
    }

    public Map<String, Map<String, DualListModel<String>>> getData() {
        return data;
    }

    public void setData(Map<String, Map<String, DualListModel<String>>> data) {
        this.data = data;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCityModel() {
        return cityModel;
    }

    public void setCityModel(String cityModel) {
        this.cityModel = cityModel;
    }

    public Map<String, String> getCountriesMap() {
        return countriesMap;
    }

    public void setCountriesMap(Map<String, String> countriesMap) {
        this.countriesMap = countriesMap;
    }

    public Map<String, DualListModel<String>> getCitiesMap() {
        return citiesMap;
    }

    public void setCitiesMap(Map<String, DualListModel<String>> citiesMap) {
        this.citiesMap = citiesMap;
    }

    public DualListModel<String> getCitiesModelUsa() {
        return citiesModelUsa;
    }

    public void setCitiesModelUsa(DualListModel<String> citiesModelUsa) {
        this.citiesModelUsa = citiesModelUsa;
    }

    public DualListModel<String> getCitiesModelGer() {
        return citiesModelGer;
    }

    public void setCitiesModelGer(DualListModel<String> citiesModelGer) {
        this.citiesModelGer = citiesModelGer;
    }

}
