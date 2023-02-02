package adhdmc.simplesilkdrops;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public final class SimpleSilkDrops extends JavaPlugin {
    private static SimpleSilkDrops instance;

    @Override
    public void onEnable() {
        instance = this;
        this.getServer().getPluginManager().registerEvents(new BlockBreakListener(), this);
        this.getCommand("silkreload").setExecutor(new ReloadCommand());
        this.registerDefaults();
        this.saveDefaultConfig();
        Util.reloadSilkBlocks();
        Util.reloadSilkTools();


        // Plugin startup logic

    }
    private void registerDefaults(){
        this.getConfig().addDefault("silk-blocks",
                Arrays.asList("REINFORCED_DEEPSLATE", "BUDDING_AMETHYST",
                "FROGSPAWN", "GRASS", "TALL_GRASS", "FERN", "LARGE_FERN",
                "SMALL_DRIPLEAF", "VINE", "GLOW_LICHEN", "DEAD_BUSH",
                "CHORUS_PLANT", "FARMLAND", "DIRT_PATH"));
        this.getConfig().addDefault("allowed-tools", Arrays.asList("WOODEN_HOE",
                "STONE_HOE", "IRON_HOE", "GOLDEN_HOE", "DIAMOND_HOE", "NETHERITE_HOE",
                "WOODEN_AXE", "STONE_AXE", "IRON_AXE", "GOLDEN_AXE", "DIAMOND_AXE",
                "NETHERITE_AXE", "WOODEN_SHOVEL", "STONE_SHOVEL", "IRON_SHOVEL",
                "GOLDEN_SHOVEL", "DIAMOND_SHOVEL", "NETHERITE_SHOVEL", "WOODEN_PICKAXE",
                "STONE_PICKAXE", "IRON_PICKAXE", "GOLDEN_PICKAXE", "DIAMOND_PICKAXE",
                "NETHERITE_PICKAXE", "SHEARS"));
    }

    public static SimpleSilkDrops getInstance() {
        return instance;
    }
}
