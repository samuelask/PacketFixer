package dev.tonimatas.packetfixer.mixins;

import dev.tonimatas.packetfixer.util.Config;
import dev.tonimatas.packetfixer.util.Hooks;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;

public class MixinConfigPlugin implements IMixinConfigPlugin {

    @Override
    public void onLoad(String mixinPackage) {
        Config.runProperties();
    }

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        boolean connectivity = Hooks.isModLoaded("connectivity");
        boolean krypton = Hooks.isModLoaded("krypton") || Hooks.isModLoaded("pluto");

        if (mixinClassName.equalsIgnoreCase("dev.tonimatas.packetfixer.mixins.CompressionDecoderMixin")) return !connectivity;
        if (mixinClassName.equalsIgnoreCase("dev.tonimatas.packetfixer.mixins.compat.connectivity.CompressionDecoderMixin")) return connectivity;
        if (mixinClassName.equalsIgnoreCase("dev.tonimatas.packetfixer.mixins.SplitterHandlerMixin") || mixinClassName.equalsIgnoreCase("dev.tonimatas.packetfixer.mixins.SizePrependerMixin")) return !krypton;

        return true;
    }

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {

    }

    @Override
    public List<String> getMixins() {
        return null;
    }

    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {

    }

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {

    }
}
