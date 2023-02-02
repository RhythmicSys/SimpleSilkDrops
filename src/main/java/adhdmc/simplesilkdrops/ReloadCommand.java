package adhdmc.simplesilkdrops;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ReloadCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!sender.hasPermission("silkdrops.reload")) {
            sender.sendRichMessage(SilkDropMessage.NO_PERMISSION.getMessage());
            return false;
        }
        SimpleSilkDrops.getInstance().reloadConfig();
        Util.reloadSilkBlocks();
        Util.reloadSilkTools();
        sender.sendRichMessage(SilkDropMessage.CONFIG_RELOADED.getMessage());
        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        return null;
    }
}
