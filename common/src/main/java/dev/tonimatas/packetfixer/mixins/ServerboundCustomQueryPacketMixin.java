package dev.tonimatas.packetfixer.mixins;

import dev.tonimatas.packetfixer.PacketFixer;
import dev.tonimatas.packetfixer.util.Config;
import net.minecraft.network.protocol.login.ServerboundCustomQueryPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = ServerboundCustomQueryPacket.class, priority = 9999)
public class ServerboundCustomQueryPacketMixin {
    @ModifyConstant(method = "<init>(Lnet/minecraft/network/FriendlyByteBuf;)V", constant = @Constant(intValue = 1048576))
    private int newSize(int value) {
        return Config.getPacketSize();
    }

    @ModifyConstant(method = "<init>(Lnet/minecraft/network/FriendlyByteBuf;)V", constant = @Constant(stringValue = "Payload may not be larger than 1048576 bytes"))
    private String newSize(String value) {
        return PacketFixer.getPayloadMessage();
    }
}
