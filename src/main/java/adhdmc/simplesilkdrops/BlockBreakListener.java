package adhdmc.simplesilkdrops;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashSet;
import java.util.Locale;

public class BlockBreakListener implements Listener {

    HashSet<Material> silkBlocks = Util.getSilkBlocks();
    @EventHandler(ignoreCancelled = true, priority = EventPriority.NORMAL)
    public void onBlockBreak(BlockBreakEvent breakEvent){
        Player player = breakEvent.getPlayer();
        Block block = breakEvent.getBlock();
        Location blockLocation = block.getLocation();
        Material blockType = block.getType();
        //If the block isn't in the configured list, return and handle as usual
        if (!silkBlocks.contains(blockType)) return;
        //If the player doesn't have permission for that block, return and handle as usual
        if (!(player.hasPermission("silkdrops.drop." + blockType.toString().toLowerCase(Locale.ENGLISH)) ||
                player.hasPermission("silkdrops.drop.all"))) return;
        ItemStack usedTool = player.getInventory().getItemInMainHand();
        ItemMeta toolMeta = usedTool.getItemMeta();
        //If the toold doesn't have silk touch, return and handle as usual
        if (!toolMeta.hasEnchant(Enchantment.SILK_TOUCH)) return;
        //Set the item to drop, clear any normal drops, and drop the item
        ItemStack droppingItem = new ItemStack(blockType, 1);
        breakEvent.setDropItems(false);
        blockLocation.getWorld().dropItem(blockLocation, droppingItem);
    }
}
