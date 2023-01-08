package adhdmc.simplesilkdrops;

import org.bukkit.Material;

import java.util.HashSet;
import java.util.List;

public class Util {
    private static final HashSet<Material> silkBlocks = new HashSet<>();

    public static void reloadSilkBlocks(){
        silkBlocks.clear();
        List<String> configuredBlocks = SimpleSilkDrops.getInstance().getConfig().getStringList("silk-blocks");
        for (String block : configuredBlocks) {
            Material blockMaterial = Material.matchMaterial(block);
            silkBlocks.add(blockMaterial);
        }
    }

    public static HashSet<Material> getSilkBlocks() {
        return silkBlocks;
    }
}
