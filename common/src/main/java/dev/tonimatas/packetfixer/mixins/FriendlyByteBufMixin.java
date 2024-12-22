package dev.tonimatas.packetfixer.mixins;

import dev.tonimatas.packetfixer.util.Config;
import net.minecraft.network.FriendlyByteBuf;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = FriendlyByteBuf.class, priority = 9999)
public abstract class FriendlyByteBufMixin {
    @ModifyConstant(method = "readNbt()Lnet/minecraft/nbt/CompoundTag;", constant = @Constant(longValue = 2097152L))
    public long newSize(long constant) {
        return Config.getNbtMaxSize();
    }
    
    @ModifyConstant(method = "readUtf()Ljava/lang/String;", constant = @Constant(intValue = 32767))
    private int readUtf$newSize(int constant) {
        return Config.getUtf8Size();
    }
    
    @ModifyConstant(method = "writeUtf(Ljava/lang/String;)Lnet/minecraft/network/FriendlyByteBuf;", constant = @Constant(intValue = 32767))
    private int writeUtf$newSize(int constant) {
        return Config.getUtf8Size(); // It should work. The error is correct, with the Packet Fixer values. You can change the max in the config.
    }
    
    @ModifyConstant(method = "readResourceLocation", constant = @Constant(intValue = 32767))
    private int readResourceLocation$newSize(int constant) {
        return Config.getUtf8Size();
    }
}
