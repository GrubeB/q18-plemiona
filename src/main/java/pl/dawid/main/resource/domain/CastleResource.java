package pl.dawid.main.resource.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.dawid.main.aaShare.core.domain.SetId;
import pl.dawid.main.castle.domain.Castle;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CastleResource implements SetId {

    private Long id;
    private LocalDateTime lastAutoUpdate;

    private Castle castle;
    private Map<ResourceType, Resource> resourceMap;

    /* CONSTRUCTORS */

    public static CastleResource resourceWithId(Long id, LocalDateTime lastAutoUpdate, Castle castle, Map<ResourceType, Resource> resourceMap) {
        return new CastleResource(id, lastAutoUpdate, castle, resourceMap);
    }

    public static CastleResource resourceWithoutId(LocalDateTime lastAutoUpdate, Castle castle, Map<ResourceType, Resource> resourceMap) {
        return new CastleResource(null, lastAutoUpdate, castle, resourceMap);
    }
    /* METHODS */

    // -----------------------------------------------------------------------------------------------

    public long getMilliSecondsFromLastUpdate() {
        LocalDateTime now = LocalDateTime.now();
        return -now.until(this.lastAutoUpdate, ChronoUnit.MILLIS);
    }

    public void autoUpdate() {
        resourceMap.values().forEach(resource -> resource.autoUpdate(getMilliSecondsFromLastUpdate()));
        this.lastAutoUpdate = LocalDateTime.now();
    }

    // -----------------------------------------------------------------------------------------------
    public void addResource(BaseResource materials) throws IllegalArgumentException {
        Optional.ofNullable(resourceMap.get(materials.getResourceType()))
                .ifPresent(resource -> resource.addResource(materials.getAmount()));
    }
    public void addResourceList(List<BaseResource> materialList) throws IllegalArgumentException {
        materialList.forEach(this::addResource);
    }

    public void subtractResourceList(List<BaseResource> materialList) throws IllegalArgumentException {
        materialList.forEach(this::subtractResource);
    }
    public void subtractResource(BaseResource materials) throws IllegalArgumentException {
        Optional.ofNullable(resourceMap.get(materials.getResourceType()))
                .ifPresent(resource -> resource.subtractResource(materials.getAmount()));
    }
    // -----------------------------------------------------------------------------------------------
    public void verifyIfIsEnoughResources(BaseResource materials) throws IllegalArgumentException {
        Resource castleResource = resourceMap.get(materials.getResourceType());
        if (castleResource == null) {
            throw new IllegalStateException("Nie ma takiego zasobu w zamku");
        }
        castleResource.verifyIfSubtractPossible(materials.getAmount());
    }

    public void verifyIfIsEnoughResourceList(List<BaseResource> materialList) throws IllegalArgumentException {
        materialList.forEach(this::verifyIfIsEnoughResources);
    }

    // -----------------------------------------------------------------------------------------------

    public void addResourceObject(Resource resource) {
        if (Objects.isNull(resourceMap.get(resource.getResourceType()))) {
            resourceMap.put(resource.getResourceType(), resource);
        }
        //throw TODO have to think about it
    }

    public void removeResourceObject(Resource resource) {
        resourceMap.remove(resource.getResourceType());
    }

    public Map<ResourceType, Resource> geResourceObjectList() {
        return Collections.unmodifiableMap(this.resourceMap);
    }

    public void setCastle(Castle newCastle) {
        if (castle == newCastle) return;
        castle.setCastleResource(null);
        newCastle.getCastleResource().setCastle(null);
        castle = newCastle;
        castle.setCastleResource(this);
    }

    // -----------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return "CastleResource{" +
                ResourceType.WOOD + " " + resourceMap.get(ResourceType.WOOD).getAmount() + " " +
                ResourceType.IRON + " " + resourceMap.get(ResourceType.IRON).getAmount() + " " +
                ResourceType.CLAY + " " + resourceMap.get(ResourceType.CLAY).getAmount() + " " +
                ResourceType.EMPLOYEE + " " + resourceMap.get(ResourceType.EMPLOYEE).getAmount() +
                '}';
    }

}
