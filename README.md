# SimpleSilkDrops

A Minecraft plugin that allows players to break blocks with a tool enchanted with Silk Touch and receive drops from blocks that are not normally obtainable with Silk Touch.

### Permissions
- `silkdrops.reload`: Allows players to reload the plugin's configuration with the command /silkreload. Default permission is OP.
- `silkdrops.drop.all`: Allows all configured blocks to drop when broken with a tool enchanted with Silk Touch. Default permission is OP.
- `silkdrops.drop.<material>`: Allows players to drop a specific material when breaking a block of that material with a tool enchanted with Silk Touch.

### Configuration

The default configuration is as follows:
```yml
silk-blocks:
- REINFORCED_DEEPSLATE
- BUDDING_AMETHYST
- VINE
- FROGSPAWN
- CHORUS_PLANT
- FARMLAND
- TALL_GRASS
- LARGE_FERN
```
The silk-blocks listed must be from the Material enum from https://hub.spigotmc.org/javadocs/bukkit/org/bukkit/Material.html. The plugin will automatically add blocks to the silk-blocks list if they are found in the configuration file.

### Commands

- `/silkreload` : Reloads the plugin's configuration. Only users with the `silkdrops.reload` permission can execute this command.