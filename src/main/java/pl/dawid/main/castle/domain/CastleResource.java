package pl.dawid.main.castle.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class CastleResource {

    private Long id;
    private Long amount;
    private Long amountMax;
    private Castle castle;
    private ResourceType type;

    /* CONSTRUCTORS */

    public CastleResource() {
    }
    public CastleResource(Long id, Long amount, Long amountMax, Castle castle, ResourceType type) {
        this.id = id;
        this.amount = amount;
        this.amountMax = amountMax;
        this.castle = castle;
        this.type = type;
    }
    public CastleResource(Long amount, Long amountMax, Castle castle, ResourceType type) {
        this.id = null;
        this.amount = amount;
        this.amountMax = amountMax;
        this.castle = castle;
        this.type = type;
    }
    /* METHODS */
    public void addResource(Long addedNumber){
        if(checkIfPositive(addedNumber)){
            throw new IllegalStateException("Number must be positive");
        }
        if(checkIfAdditionPossible(addedNumber)){
            amount=amountMax; //TODO have to think about it in some cases
            return;
        }
        amount=amount+addedNumber;
    }
    public void subtractResource(Long subtractedNumber){
        if(checkIfPositive(subtractedNumber)){
            throw new IllegalStateException("Number must be positive");
        }
        if(checkIfSubtractionPossible(subtractedNumber)){
            throw new IllegalStateException("Subtraction is impossible");
        }
        amount=amount-subtractedNumber;
    }
    public boolean checkIfSubtractionPossible(Long subtractedNumber){
        return amount-subtractedNumber>=0;
    }
    public boolean checkIfAdditionPossible(Long addedNumber){
        return amount+addedNumber<=amountMax;
    }
    public boolean checkIfPositive(Long number){
        return number>=0;
    }

    /* TYPES */
    public enum ResourceType {
        WOOD, CLAY, IRON, EMPLOYEE
    }

}
