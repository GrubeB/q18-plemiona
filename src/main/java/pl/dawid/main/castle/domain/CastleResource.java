package pl.dawid.main.castle.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Getter
@Setter
public class CastleResource {

    private Long id;
    private Long amount;
    private Long amountMax;
    private Castle castle;
    private ResourceType type;
    private Double amountPerSecond;
    private LocalDateTime lastAutoUpdate;
    /* CONSTRUCTORS */

    public CastleResource() {
    }
    public CastleResource(Long id, Long amount, Long amountMax, Castle castle, ResourceType type, Double amountPerSecond) {
        this.id = id;
        this.amount = amount;
        this.amountMax = amountMax;
        this.castle = castle;
        this.type = type;

        this.amountPerSecond=amountPerSecond;
        this.lastAutoUpdate =LocalDateTime.now();
    }
    public CastleResource(Long amount, Long amountMax, Castle castle, ResourceType type, Double amountPerSecond) {
        this.id = null;
        this.amount = amount;
        this.amountMax = amountMax;
        this.castle = castle;
        this.type = type;
        this.amountPerSecond=amountPerSecond;
        this.lastAutoUpdate =LocalDateTime.now();
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
    public Double amountFromLastUpdate(){
        LocalDateTime now = LocalDateTime.now();
        long milliSeconds = now.until(this.lastAutoUpdate, ChronoUnit.MILLIS);
        return amountPerSecond*milliSeconds/1000;
    }
    public void autoUpdate(){
        Double amountFromLastUpdate = amountFromLastUpdate();
        addResource(Math.round(amountFromLastUpdate));
        this.lastAutoUpdate =LocalDateTime.now();
    }
    /* TYPES */
    public enum ResourceType {
        WOOD, CLAY, IRON, EMPLOYEE
    }

}
