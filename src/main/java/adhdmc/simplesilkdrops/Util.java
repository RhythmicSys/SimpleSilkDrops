package adhdmc.simplesilkdrops;

import org.bukkit.Material;

import java.util.HashSet;
import java.util.List;

public class Util {
    private static final HashSet<Material> silkBlocks = new HashSet<>();
    private static final HashSet<Material> silkTools = new HashSet<>();

    public static void reloadSilkBlocks(){
        silkBlocks.clear();
        List<String> configuredBlocks = SimpleSilkDrops.getInstance().getConfig().getStringList("silk-blocks");
        for (String block : configuredBlocks) {
            if (block == null) continue;
            Material blockMaterial = Material.matchMaterial(block);
            silkBlocks.add(blockMaterial);
        }
    }

    public static void reloadSilkTools(){
        silkTools.clear();
        List<String> configuredTools = SimpleSilkDrops.getInstance().getConfig().getStringList("allowed-tools");
        for (String block : configuredTools) {
            if (block == null) continue;
            Material blockMaterial = Material.matchMaterial(block);
            silkTools.add(blockMaterial);
        }
    }

    public static HashSet<Material> getSilkBlocks() {
        return silkBlocks;
    }

    public static HashSet<Material> getSilkTools() {
        return silkTools;
    }
}
