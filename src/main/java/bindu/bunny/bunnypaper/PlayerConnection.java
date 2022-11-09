package bindu.bunny.bunnypaper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.EnumWrappers;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.spigotmc.event.player.PlayerSpawnLocationEvent;

import java.lang.reflect.InvocationTargetException;


public class PlayerConnection implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerSpawnLocationEvent event) throws InvocationTargetException {
        Player player = event.getPlayer();
        ProtocolManager man = ProtocolLibrary.getProtocolManager();

        PacketContainer packet = man.createPacket(PacketType.Play.Server.INITIALIZE_BORDER);

        packet.getDoubles().
                write(0, 0d).
                write(1, 0d).
                write(2, 1000d).
                write(3, 20d);
        man.sendServerPacket(player, packet);

        packet = new PacketContainer(PacketType.Play.Server.LOGIN);
        packet.getGameModes().write(0, EnumWrappers.NativeGameMode.CREATIVE);
        man.sendServerPacket(player, packet);
    }
}
