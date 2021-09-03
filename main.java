package vb.$bedevents;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class PluginMain
extends JavaPlugin
implements Listener {
    private static PluginMain instance;
    private static Object localVariableScope;

    static {
        localVariableScope = new Object();
    }

    public void onEnable() {
        instance = this;
        this.getDataFolder().mkdir();
        this.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)((Object)this));
        Object localVariableScope = new Object();
        this.saveDefaultConfig();
    }

    public void onDisable() {
    }

    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] commandArgs) {
        return true;
    }

    public static void procedure(String procedure, List<?> procedureArgs) throws Exception {
    }

    public static Object function(String function, List<?> functionArgs) throws Exception {
        return null;
    }

    public static List<Object> createList(Object obj) {
        ArrayList list = new ArrayList();
        if (obj.getClass().isArray()) {
            int length = Array.getLength((Object)obj);
            for (int i = 0; i < length; ++i) {
                list.add(Array.get((Object)obj, (int)i));
            }
        } else if (obj instanceof Collection) {
            list.addAll((Collection)((Object)obj));
        } else {
            list.add(obj);
        }
        return list;
    }

    public static String color(String string) {
        return string != null ? ChatColor.translateAlternateColorCodes((char)'&', (String)string) : null;
    }

    public static PluginMain getInstance() {
        return instance;
    }

    @EventHandler(priority=EventPriority.NORMAL)
    public void onPlayerBedEnterEvent1(PlayerBedEnterEvent event) throws Exception {
        if (((Boolean)((Object)PluginMain.getInstance().getConfig().get("beddisabler"))).booleanValue()) {
            event.setCancelled(true);
            event.getPlayer().sendMessage(PluginMain.color("Beds are disabled in this server!"));
        }
    }

    @EventHandler(priority=EventPriority.NORMAL)
    public void onPlayerBedEnterEvent2(PlayerBedEnterEvent event) throws Exception {
        if (((Boolean)((Object)PluginMain.getInstance().getConfig().get("bedentermsg"))).booleanValue()) {
            event.getPlayer().sendMessage(PluginMain.color(String.valueOf((Object)PluginMain.getInstance().getConfig().get("bedentermessage"))));
        }
    }

    @EventHandler(priority=EventPriority.NORMAL)
    public void onPlayerBedLeaveEvent3(PlayerBedLeaveEvent event) throws Exception {
        if (((Boolean)((Object)PluginMain.getInstance().getConfig().get("bedleavemsg"))).booleanValue()) {
            event.getPlayer().sendMessage(PluginMain.color(String.valueOf((Object)PluginMain.getInstance().getConfig().get("bedleavemessage"))));
        }
    }
}
