package bindu.bunny.bunnypaper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.PacketContainer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.lang.reflect.InvocationTargetException;


public class PlayerConnection implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) throws InvocationTargetException {
        Player player = event.getPlayer();
        ProtocolManager man = ProtocolLibrary.getProtocolManager();

        PacketContainer packet = man.createPacket(PacketType.Play.Server.INITIALIZE_BORDER);

        packet.getDoubles().
                write(0, player.getLocation().getX()).
                write(1, player.getLocation().getZ()).
                write(3, 10d);
        man.sendServerPacket(player, packet);
//
//        packet = new PacketContainer(PacketType.Play.Server.LOGIN);
//        packet.getGameModes().write(0, EnumWrappers.NativeGameMode.CREATIVE);
    }
}
