package net.endplex.plexmod.sounds;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.endplex.plexmod.PlexMod;

public class ModSounds {
    public static SoundEvent SMALL_EXPLOSION = registerSoundEvent("small_explosion");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(PlexMod.MOD_ID, name);
        return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(id));
    }

    public static void registerSounds() {
        System.out.println("Registering ModSounds for " + PlexMod.MOD_ID);
    }
}
