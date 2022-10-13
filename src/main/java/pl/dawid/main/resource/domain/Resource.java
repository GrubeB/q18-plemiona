package pl.dawid.main.resource.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Resource {
    private Long id;
    private Long amount;
    private Long amountMax;
    private Double amountPerSecond;
    private ResourceType resourceType;

    /* CONSTRUCTORS */

    public Resource() {
    }

    private Resource(Long id, Long amount, Long amountMax, Double amountPerSecond, ResourceType resourceType) {
        this.id = id;
        this.amount = amount;
        this.amountMax = amountMax;
        this.amountPerSecond = amountPerSecond;
        this.resourceType = resourceType;
    }

    public static Resource resourceWithId(Long id, Long amount, Long amountMax, Double amountPerSecond, ResourceType resourceType) {
        return new Resource(id, amount, amountMax, amountPerSecond, resourceType);
    }

    public static Resource resourceWithoutId(Long amount, Long amountMax, Double amountPerSecond, ResourceType resourceType) {
        return new Resource(null, amount, amountMax, amountPerSecond, resourceType);
    }

    /* METHODS */
    public void addResource(Long amount) throws IllegalArgumentException {
        verifyIfPositive(amount);
        if (checkIfAdditionWillExceedLimit(amount)) {
            this.amount = amountMax; //TODO have to think about it in some cases
        } else {
            this.amount += amount;
        }
    }
    public void subtractResource(Long amount) throws IllegalArgumentException {
        verifyIfPositive(amount);
        verifyIfSubtractPossible(amount);
        this.amount -= amount;
    }

    // -----------------------------------------------------------------------------------------------

    public void autoUpdate(Long milliSeconds){
        double amountFromLastUpdate = milliSeconds * amountPerSecond / 1000;
        addResource(Math.round(amountFromLastUpdate));
    }
    // -----------------------------------------------------------------------------------------------
    public void verifyIfSubtractPossible(Long amount) throws IllegalArgumentException {
        if (checkIfSubtractPossible(amount)) {
            throw new IllegalArgumentException("Number is greater than current state");
        }
    }
    public void verifyIfPositive(Long number) throws IllegalArgumentException {
        if (number < 0) {
            throw new IllegalArgumentException("Number must be positive");
        }
    }

    public boolean checkIfSubtractPossible(Long amount) {
        return this.amount - amount < 0;
    }

    public boolean checkIfAdditionWillExceedLimit(Long addedNumber) {
        return amount + addedNumber > amountMax;
    }


}
