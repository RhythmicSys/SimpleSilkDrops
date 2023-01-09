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


        // Plugin startup logic

    }
    private void registerDefaults(){
        this.getConfig().addDefault("silk-blocks",
                Arrays.asList("REINFORCED_DEEPSLATE", "BUDDING_AMETHYST",
                "VINE", "FROGSPAWN", "CHORUS_PLANT", "FARMLAND", "TALL_GRASS",
                "TALL_FERN"));
    }

    public static SimpleSilkDrops getInstance() {
        return instance;
    }
}
