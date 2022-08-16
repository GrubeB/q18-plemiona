package pl.dawid.main.resource.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Resource {
    private Long id;
    private Long amount;
    private ResourceType resourceType;

    /* CONSTRUCTORS */

    public Resource() {
    }

    private Resource(Long id, Long amount, ResourceType resourceType) {
        this.id = id;
        this.amount = amount;
        this.resourceType = resourceType;
    }

    public static Resource resourceWithId(Long id, Long amount, ResourceType resourceType) {
        return new Resource(id, amount, resourceType);
    }

    public static Resource resourceWithoutId(Long amount, ResourceType resourceType) {
        return new Resource(null, amount, resourceType);
    }

    /* PUBLIC METHODS */

    public void addResource(Long amount) {
        checkIfPositive(amount);
        this.amount += amount;
    }

    public void subtractResource(Long amount) {
        checkIfPositive(amount);
        checkIfSubtractPossible(amount);
        this.amount -= amount;
    }

    public void checkIfSubtractPossible(Long number) {
        if (this.amount - number < 0) {
            throw new IllegalStateException("Number is greater than current state");
        }
    }

    /* PRIVATE METHODS */

    private void checkIfPositive(Long number) {
        if (number < 0) {
            throw new IllegalStateException("Number must be positive");
        }
    }


}
