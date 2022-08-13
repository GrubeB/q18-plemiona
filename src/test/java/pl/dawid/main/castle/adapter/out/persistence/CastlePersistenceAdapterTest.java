package pl.dawid.main.castle.adapter.out.persistence;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import pl.dawid.main.castle.adapter.out.persistence.castle.CastleEntityCommand;
import pl.dawid.main.castle.adapter.out.persistence.resource.CastleResourceEntityCommand;
import pl.dawid.main.castle.domain.Castle;
import pl.dawid.main.castle.domain.CastleResource;

//
//@Import({CastlePersistenceAdapter.class})
class CastlePersistenceAdapterTest {

//
//    @Autowired
//    private CastleEntityCommand castleEntityCommand;
//    @Autowired
//    private CastleResourceEntityCommand castleResourceEntityCommand;
//    private CastlePersistenceAdapter castlePersistenceAdapter;
//    @BeforeEach
//    void setUp() {
//        castlePersistenceAdapter= new CastlePersistenceAdapter(castleEntityCommand, castleResourceEntityCommand);
//    }
//
//    @AfterEach
//    void tearDown() {
//    }
//    @Test
//    void createEntity() {
//        Castle newCastle = new Castle(null, "CastleName");
//        CastleResource wood = new CastleResource(0L, 1000L,newCastle, CastleResource.ResourceType.WOOD);
//        CastleResource clay = new CastleResource(0L, 1000L,newCastle, CastleResource.ResourceType.CLAY);
//        CastleResource iron = new CastleResource(0L, 1000L,newCastle, CastleResource.ResourceType.IRON);
//        CastleResource employee = new CastleResource(0L, 1000L,newCastle, CastleResource.ResourceType.EMPLOYEE);
//        newCastle.addCastleResource(wood);
//        newCastle.addCastleResource(clay);
//        newCastle.addCastleResource(iron);
//        newCastle.addCastleResource(employee);
//
//        castlePersistenceAdapter.createEntity(newCastle);
//    }
//
//    @Test
//    void findById() {
//    }
//
//    @Test
//    void findAll() {
//    }


}