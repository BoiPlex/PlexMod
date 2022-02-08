package net.endplex.plexmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.endplex.plexmod.screen.LightningChannelerScreen;
import net.endplex.plexmod.screen.ModScreenHandlers;
import net.endplex.plexmod.util.ModRenderHelper;

@Environment(EnvType.CLIENT)
public class TutorialClientMod implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModRenderHelper.setRenderLayers();
        ScreenRegistry.register(ModScreenHandlers.LIGHTNING_CHANNELER_SCREEN_HANDLER, LightningChannelerScreen::new);
    }
}
