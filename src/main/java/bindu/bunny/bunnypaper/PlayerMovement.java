package bindu.bunny.bunnypaper;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import net.kyori.adventure.text.Component;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMovement implements Listener {
    @EventHandler
    public void onPlayerMovement(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        ProtocolManager man = ProtocolLibrary.getProtocolManager();

        Location position = player.getLocation();

        int x = ((int) (position.getX() * 1000)) % 10;
        int z = ((int) (position.getZ() * 1000)) % 10;

        if (x!=0 && z!=0) {
            player.kick(Component.text("§4Human Player Detected!\n§7Playing only allowed with bot movement\n------------------------------------------\n\n§fint x = ((int) (position.x * 1000)) % 10;\n§fint z = ((int) (position.z * 1000)) % 10;\nif(x!=0 && z!=0) player.kick();"));
        }
    }
}
