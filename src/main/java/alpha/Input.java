package alpha;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "type",
    "name",
    "ppu",
    "batters",
    "topping"
})
public class Input {

    @JsonProperty("id")
    private String id;
    @JsonProperty("type")
    private String type;
    @JsonProperty("name")
    private String name;
    @JsonProperty("ppu")
    private Double ppu;
    @JsonProperty("batters")
    private Batters batters;
    @JsonProperty("topping")
    private List<Topping> topping = new ArrayList<Topping>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    public Input withId(String id) {
        this.id = id;
        return this;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    public Input withType(String type) {
        this.type = type;
        return this;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public Input withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("ppu")
    public Double getPpu() {
        return ppu;
    }

    @JsonProperty("ppu")
    public void setPpu(Double ppu) {
        this.ppu = ppu;
    }

    public Input withPpu(Double ppu) {
        this.ppu = ppu;
        return this;
    }

    @JsonProperty("batters")
    public Batters getBatters() {
        return batters;
    }

    @JsonProperty("batters")
    public void setBatters(Batters batters) {
        this.batters = batters;
    }

    public Input withBatters(Batters batters) {
        this.batters = batters;
        return this;
    }

    @JsonProperty("topping")
    public List<Topping> getTopping() {
        return topping;
    }

    @JsonProperty("topping")
    public void setTopping(List<Topping> topping) {
        this.topping = topping;
    }

    public Input withTopping(List<Topping> topping) {
        this.topping = topping;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Input withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("type", type).append("name", name).append("ppu", ppu).append("batters", batters).append("topping", topping).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(ppu).append(batters).append(name).append(id).append(additionalProperties).append(type).append(topping).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Input) == false) {
            return false;
        }
        Input rhs = ((Input) other);
        return new EqualsBuilder().append(ppu, rhs.ppu).append(batters, rhs.batters).append(name, rhs.name).append(id, rhs.id).append(additionalProperties, rhs.additionalProperties).append(type, rhs.type).append(topping, rhs.topping).isEquals();
    }

}
