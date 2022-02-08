package net.endplex.plexmod.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.endplex.plexmod.PlexMod;

public class ModScreenHandlers {
    public static ScreenHandlerType<LightningChannelerScreenHandler> LIGHTNING_CHANNELER_SCREEN_HANDLER =
            ScreenHandlerRegistry.registerSimple(new Identifier(PlexMod.MOD_ID, "lightning_channeler"),
                    LightningChannelerScreenHandler::new);
}
