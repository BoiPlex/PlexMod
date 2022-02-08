package net.endplex.plexmod.util;

import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.endplex.plexmod.command.ReturnHomeCommand;
import net.endplex.plexmod.command.SetHomeCommand;

public class ModCommandRegister {
    public static void registerCommands() {
        CommandRegistrationCallback.EVENT.register(SetHomeCommand::register);
        CommandRegistrationCallback.EVENT.register(ReturnHomeCommand::register);
    }
}
