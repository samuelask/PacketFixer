package dev.tonimatas.packetfixer.mixins;

import dev.tonimatas.packetfixer.util.Config;
import net.minecraft.network.FriendlyByteBuf;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = FriendlyByteBuf.class, priority = 9999)
public abstract class FriendlyByteBufMixin {
    @ModifyConstant(method = "readNbt()Lnet/minecraft/nbt/CompoundTag;", constant = @Constant(longValue = 2097152L))
    public long newSize(long value) {
        return Config.getNbtMaxSize();
    }
    
    @ModifyConstant(method = "readUtf()Ljava/lang/String;", constant = @Constant(intValue = 32767))
    public int newSize(int value) {
        return Config.getStringSize();
    }

    @ModifyConstant(method = "writeUtf(Ljava/lang/String;)Lnet/minecraft/network/FriendlyByteBuf;", constant = @Constant(intValue = 32767))
    public int newSize$1(int value) {
        return Config.getStringSize();
    }

    @ModifyConstant(method = "readResourceLocation", constant = @Constant(intValue = 32767))
    public int newSize$2(int value) {
        return Config.getStringSize();
    }
}
