package pl.dawid.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Q14Application {

    private static final Logger logger = LoggerFactory.getLogger(Q14Application.class);
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Q14Application.class, args);


//        castleResource = CastleResourceFactory.createCastleResource(castle);
//        castleStructure = new CastleStructure(null,castle,new HashMap<>());
//
//        castle.setCastleResource(castleResource);
//        castle.setCastleStructure(castleStructure);
//
//
//        castleResource.addResource(new BaseResource(1000L, ResourceType.IRON));
//        castleResource.addResource(new BaseResource(1000L, ResourceType.CLAY));
//        castleResource.addResource(new BaseResource(1000L, ResourceType.WOOD));
//        castleResource.addResource(new BaseResource(1000L, ResourceType.EMPLOYEE));
//        castleResource.subtractResource(new BaseResource(200L, ResourceType.IRON));
//
//        castleStructure.getIfStructureExists(StructureType.IRON_MINE);
//        try {
//            castleStructure.levelUpStructure(StructureType.IRON_MINE,castleResource,structureBuildManager);
//        }catch (Exception e){
//            logger.error(e.getMessage());
//        }
//
//        try {
//            castleStructure.levelUpStructure(StructureType.IRON_MINE,castleResource,structureBuildManager);
//        }catch (Exception e){
//            logger.error(e.getMessage());
//        }
//
//        try {
//            castleStructure.levelUpStructure(StructureType.IRON_MINE,castleResource,structureBuildManager);
//        }catch (Exception e){
//            logger.error(e.getMessage());
//        }
    }

    //@Scheduled(initialDelay  = 100,fixedDelay = 1000)
//    private void castlesResourceAutoUpdate() {
//        logger.info("castlesResourceAutoUpdate");
//        logger.info(castleResource.toString());
//        castleResource.addResource(new BaseResource(100L, ResourceType.IRON));
//    }
//
//    @Scheduled(initialDelay  = 100,fixedDelay = 1000)
//    private void structureBuildManagerAutoUpdate() {
//        structureBuildManager.structureBuildManagerAutoUpdate();
//    }
}
