package net.fabricmc.scmods.mixin;

import net.fabricmc.scmods.MFMUtils;
import net.minecraft.client.render.model.ModelLoader;
import net.minecraft.client.render.model.json.JsonUnbakedModel;
import net.minecraft.util.Identifier;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ModelLoader.class)
public class MFMUtilsMixin {
    @Inject(method = "loadModelFromJson", at = @At(value = "INVOKE", target = "Lnet/minecraft/resource/ResourceManager;getResource(Lnet/minecraft/util/Identifier;)Lnet/minecraft/resource/Resource;"), cancellable = true)
    public void loadModelFromJson(Identifier id, CallbackInfoReturnable<JsonUnbakedModel> cir) {
		String bid = id.getNamespace();
        if (!"mfm_utils".equals(bid)) return;
        String modelJson = "";
		Boolean stem = false;
		if (bid.contains("warped") || bid.contains("crimson")) stem = true;
		if (bid.endsWith("_table")) modelJson = MFMUtils.createWoodModelJson("table", bid.replace("_table", ""), stem);
        if ("".equals(modelJson)) return;
        JsonUnbakedModel model = JsonUnbakedModel.deserialize(modelJson);
        model.id = id.toString();
        cir.setReturnValue(model);
    }
}