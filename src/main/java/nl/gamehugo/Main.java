package nl.gamehugo;

import net.minestom.server.MinecraftServer;
import net.minestom.server.instance.InstanceContainer;
import net.minestom.server.instance.InstanceManager;
import net.minestom.server.instance.LightingChunk;
import net.minestom.server.instance.block.Block;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    public static void main(String[] args) {
        // Initialization
        Logger logger = LoggerFactory.getLogger(Main.class);
        logger.info("Starting server...");
        long startTime = System.currentTimeMillis();

        MinecraftServer minecraftServer = MinecraftServer.init();

        // Create the instance
        InstanceManager instanceManager = MinecraftServer.getInstanceManager();
        InstanceContainer instanceContainer = instanceManager.createInstanceContainer();

        // Set the ChunkGenerator
        instanceContainer.setGenerator(unit -> unit.modifier().fillHeight(0, 40, Block.GRASS_BLOCK));
        instanceContainer.setChunkSupplier(LightingChunk::new);

        // Start the server on port 25565
        minecraftServer.start("0.0.0.0", 25565);

        logger.info("Server started on port 25565 ({}ms)", System.currentTimeMillis() - startTime);
    }
}
