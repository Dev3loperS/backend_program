package cybersoft.java20.dev3lopers.gear3sproject.dto;

public class ProdPropDescDTO {
    private String property;
    private String description;

    public ProdPropDescDTO() {
    }

    public ProdPropDescDTO(String property, String description) {
        this.property = property;
        this.description = description;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
